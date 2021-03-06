package com.example.lunchbox.service.Impl;

import com.example.lunchbox.model.entity.*;
import com.example.lunchbox.repository.*;
import com.example.lunchbox.service.CustomerService;
import com.example.lunchbox.service.OrderService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.json.JSONObject;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private FoodmakerRepository foodmakerRepository;
    private OrderDishesRepository orderDishesRepository;
    private DishRepository dishRepository;
    private RiderRequestRepository riderRequestRepository;

    private FoodmakerDishesRepository foodmakerDishesRepository;

    private RiderRepository riderRepository;

    private Orderdishes orderdishes;
    private EntityManager entityManager;
    private CustomerService customerService;
    private Order order;
    private RatingRepository ratingRepository;
    @Value("${foodmakerKey}")
    private String foodmakerServerKey;
    @Value("${customerKey}")
    private String customerServerKey;
    @Value("${riderKey}")
    private String riderServerKey;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderDishesRepository orderDishesRepository, CustomerRepository customerRepository, FoodmakerRepository foodmakerRepository, DishRepository dishRepository, FoodmakerDishesRepository foodmakerDishesRepository, RatingRepository ratingRepository, RiderRepository riderRepository,RiderRequestRepository riderRequestRepository) {
        this.orderRepository = orderRepository;
        this.orderDishesRepository = orderDishesRepository;
        this.customerRepository = customerRepository;
        this.foodmakerRepository = foodmakerRepository;
        this.dishRepository = dishRepository;
        this.foodmakerDishesRepository = foodmakerDishesRepository;
        this.ratingRepository = ratingRepository;
        this.riderRepository = riderRepository;
        this.riderRequestRepository = riderRequestRepository;
    }

    public OrderServiceImpl() {
    }

    @Override
    public void saveOrder(Order order) {
        try {
            Order response = orderRepository.save(order);
            for (Orderdishes orderdishe : order.getOrderdishes()) {
                orderdishe.setOrder(response);
                orderDishesRepository.save(orderdishe);
            }
            orderRepository.save(order);

            //sending notifcation to foodmaker for an order
            sendNottificationToFoodmaker(order);

        } catch (Exception e) {

        }

    }

    @Override
    public void editOrder(Order order) {

    }

    @Override
    public Order getOrderById(Integer id) {
        Order order = orderRepository.findOne(id);
        Integer customerId = order.getOrderCustomerId();
        Integer foodmakerId = order.getFoodmakerId();
        for (Orderdishes orderdishes : order.getOrderdishes()) {
            Integer foodmakerdishId = orderdishes.getDishId();
            FoodmakerDishes foodmakerDishes = foodmakerDishesRepository.findOne(foodmakerdishId);
            orderdishes.setDishes(foodmakerDishes);
            //  Dishes dish = foodmakerDishesRepository.findOne(foodmakerdishId);
            // orderdishes.setDishes(dish);
        }
        Customer customer = customerRepository.findByCustomerId(customerId);
        Foodmaker foodmaker = foodmakerRepository.findOne(foodmakerId);
        foodmaker.setAverageRatings(ratingRepository.getAverage(foodmakerId));
        order.setCustomer(customer);
        order.setFoodmaker(foodmaker);
        return order;
        //return orderRepository.findOne(id);
    }

    @Override
    public long countAllOrders() {
        return orderRepository.count();
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public List<Order> findAllOrders() {
        List<Order> returnList = new ArrayList<>();
        try {
            List<Order> orders = orderRepository.findAll();

            /***
             * retrive customer through for customer order id
             * retrive foodmaker through for foodmaker id
             * retrive orderdishes through for order id
             * */
            for (Order order : orders) {
                Integer customerId = order.getOrderCustomerId();
                Integer foodmakerId = order.getFoodmakerId();
                //List<Dishes> orderDishesList = new ArrayList<>();

                for (Orderdishes orderdishes : order.getOrderdishes()) {
                    Integer foodmakerdishId = orderdishes.getDishId();
                    FoodmakerDishes foodmakerDishes = foodmakerDishesRepository.findOne(foodmakerdishId);
                    orderdishes.setDishes(foodmakerDishes);
                }
                Customer customer = customerRepository.findByCustomerId(customerId);
                Foodmaker foodmaker = foodmakerRepository.findOne(foodmakerId);
                foodmaker.setAverageRatings(ratingRepository.getAverage(foodmakerId));
                order.setCustomer(customer);
                order.setFoodmaker(foodmaker);
                returnList.add(order);
            }

        } catch (Exception e) {

        }
        return returnList;
        //    return orderRepository.findAll();
    }

    @Async
    public ResponseEntity<String> sendNotification(String token, String androidFirebaseKey, String msg) {
        AndroidPushNotificationsService androidPushNotificationsService = new AndroidPushNotificationsService(androidFirebaseKey);

        JSONObject body = new JSONObject();
        body.put("to", token);
        body.put("priority", "high");

        JSONObject notification = new JSONObject();
        notification.put("title", "lunchbox Notification");
        notification.put("body", msg);

        JSONObject data = new JSONObject();
        data.put("Key-1", "order Data 1");
        data.put("Key-2", "order Data 2");

        body.put("notification", notification);
        body.put("data", data);

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
        CompletableFuture.allOf(pushNotification).join();

        try {
            String firebaseResponse = pushNotification.get();

            return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
    }

    @Async
    public void sendNottificationToCustomer(Order order) {
            Customer customer = customerRepository.findOne(order.getOrderCustomerId());
            sendNotification(customer.getCustomerRegToken(), customerServerKey, "your order is place");
    }

    @Async
    public void sendNottificationToFoodmaker(Order order) {
        Foodmaker foodmaker = foodmakerRepository.findOne(order.getFoodmakerId());
        sendNotification(foodmaker.getFoodmakerRegToken(), foodmakerServerKey, "you have an order!");
    }

    @Async
    public void sendNottificationToRider(Integer riderId,Integer foodmakerId) {

        Rider rider = riderRepository.findOne(riderId);
        Foodmaker foodmaker = foodmakerRepository.findOne(foodmakerId);
        sendNotification(rider.getRiderRegToken(),riderServerKey, "you have assigned a job to deliver an order!");
        sendNotification(foodmaker.getFoodmakerRegToken(), foodmakerServerKey, "your requested rider is assigned a job!");
    }

    @Override
    public void updateOrderStatus(Integer statusValue, Integer orderId) {
        if (orderId != 0) {
            orderRepository.updateOrderStatus(statusValue, orderId);

            Order order = orderRepository.findOne(orderId);
            if(statusValue != 4 ||statusValue != 3 ){
                sendNottificationToCustomer(order);
            }
        }
    }

    @Override
    public List<Order> getPendingOrders() {
        List<Order> allOrders = this.findAllOrders();
        List<Order> orderListbystatus_id = orderRepository.getAllByOrderStatus(1);

        if (orderListbystatus_id.size() > 0) {
            allOrders.retainAll(orderListbystatus_id);
            return allOrders;
        }

        return null;
    }

    @Override
    public List<Order> getAckOrders() {
        List<Order> allOrders = this.findAllOrders();
        List<Order> orderListbystatus_id = orderRepository.getAllByOrderStatus(2);

        if (orderListbystatus_id.size() > 0) {
            allOrders.retainAll(orderListbystatus_id);
            return allOrders;
        }

        return null;
    }

    @Override
    public List<Order> getDoneOrders() {
        List<Order> allOrders = this.findAllOrders();
        List<Order> orderListbystatus_id = orderRepository.getAllByOrderStatus(3);

        if (orderListbystatus_id.size() > 0) {
            allOrders.retainAll(orderListbystatus_id);
            return allOrders;
        }

        return null;

    }

    @Override
    public List<Order> getorderByStatus(Integer status) {
        if (status == 1) {
            return getPendingOrders();
        } else if (status == 2) {
            return getAckOrders();
        } else if (status == 3) {
            return getDoneOrders();
        }

        return null;
    }

    @Override
    public void updateOrderRating(Integer orderRating, Integer orderId) {
        if (orderId != 0) {
            orderRepository.updateOrderRating(orderRating, orderId);
        }
    }

    @Override
    public String assignRiderToOrder(Integer riderId, Integer orderId) {
        Order order = orderRepository.findOne(orderId);

            if (order.getRiderId() == null || order.getRiderId() == 0) {
                orderRepository.assignRiderToOrder(riderId, orderId);
                Order order1 = orderRepository.findOne(orderId);
                sendNottificationToRider(riderId,order.getFoodmakerId());

    //            Rider rider = riderRepository.findOne(riderId);
      //          Foodmaker foodmaker = foodmakerRepository.findOne(1);

             /*   sendNotification(rider.getRiderRegToken(),riderServerKey, "you have assigned a job to deliver an order!");
                sendNotification(foodmaker.getFoodmakerRegToken(), foodmakerServerKey, "your requested rider is assigned a job!");*/
                riderRequestRepository.updateRiderRequestStatus(2,riderId,orderId);
                return "{\"status\":\"true\"}";
            } else
            {
                Rider rider = riderRepository.findOne(riderId);
                sendNotification(rider.getRiderRegToken(),riderServerKey,"this job is already assigned");
            }
            return "{\"status\":\"false\"}";

    }
}
