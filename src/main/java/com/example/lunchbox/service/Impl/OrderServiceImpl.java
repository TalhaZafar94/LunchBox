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

    private FoodmakerDishesRepository foodmakerDishesRepository;


    private Orderdishes orderdishes;
    private EntityManager entityManager;
    private CustomerService customerService;
    private Order order;
    @Value("${foodmakerKey}")
    private String foodmakerServerKey;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderDishesRepository orderDishesRepository,CustomerRepository customerRepository,FoodmakerRepository foodmakerRepository,DishRepository dishRepository,FoodmakerDishesRepository foodmakerDishesRepository) {
        this.orderRepository = orderRepository;
        this.orderDishesRepository = orderDishesRepository;
        this.customerRepository = customerRepository;
        this.foodmakerRepository = foodmakerRepository;
        this.dishRepository = dishRepository;
        this.foodmakerDishesRepository = foodmakerDishesRepository;
    }

    public OrderServiceImpl() {
    }

    @Override
    public void saveOrder(Order order) {
        try {
            Order response = orderRepository.save(order);
            for(Orderdishes orderdishe: order.getOrderdishes()){
                orderdishe.setOrder(response);
                orderDishesRepository.save(orderdishe);
            }
            orderRepository.save(order);
            Foodmaker foodmaker =  foodmakerRepository.findOne(order.getFoodmakerId());
            sendNotification(foodmaker.getFoodmakerRegToken());
        }catch (Exception e){

        }

    }

    @Override
    public void editOrder(Order order) {

    }

    @Override
    public Order getOrderById(Integer id) {
        Order order  = orderRepository.findOne(id);
        Integer customerId = order.getOrderCustomerId();
        Integer foodmakerId = order.getFoodmakerId();
        for (Orderdishes orderdishes : order.getOrderdishes()){
            Integer foodmakerdishId = orderdishes.getDishId();
            FoodmakerDishes foodmakerDishes = foodmakerDishesRepository.findOne(foodmakerdishId);
            orderdishes.setDishes(foodmakerDishes);
            //  Dishes dish = foodmakerDishesRepository.findOne(foodmakerdishId);
            // orderdishes.setDishes(dish);
        }
        Customer customer = customerRepository.findByCustomerId(customerId);
        Foodmaker foodmaker = foodmakerRepository.findOne(foodmakerId);
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
            List<Order> orders  = orderRepository.findAll();

            /***
             * retrive customer through for customer order id
             * retrive foodmaker through for foodmaker id
             * retrive orderdishes through for order id
             * */
            for(Order order: orders){
                Integer customerId = order.getOrderCustomerId();
                Integer foodmakerId = order.getFoodmakerId();
                //List<Dishes> orderDishesList = new ArrayList<>();

                for (Orderdishes orderdishes : order.getOrderdishes()){
                    Integer foodmakerdishId = orderdishes.getDishId();
                    FoodmakerDishes foodmakerDishes = foodmakerDishesRepository.findOne(foodmakerdishId);
                    orderdishes.setDishes(foodmakerDishes);
                }
                Customer customer = customerRepository.findByCustomerId(customerId);
                Foodmaker foodmaker = foodmakerRepository.findOne(foodmakerId);
                order.setCustomer(customer);
                order.setFoodmaker(foodmaker);
                returnList.add(order);
            }

        }catch (Exception e){

        }
        return returnList;
        //    return orderRepository.findAll();
    }

    public ResponseEntity<String> sendNotification(String token)
    {
        AndroidPushNotificationsService androidPushNotificationsService = new AndroidPushNotificationsService(foodmakerServerKey);

        JSONObject body = new JSONObject();
        body.put("to", token);
        body.put("priority", "high");

        JSONObject notification = new JSONObject();
        notification.put("title", "lunchbox Notification");
        notification.put("body", "you have an order!");

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
    public void updateOrderStatus(Integer statusValue,Integer orderId){
        if(orderId != 0){
             orderRepository.updateOrderStatus(statusValue,orderId);

        }

    }

}
