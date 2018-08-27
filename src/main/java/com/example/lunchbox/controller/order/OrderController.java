package com.example.lunchbox.controller.order;

import com.example.lunchbox.model.entity.Order;
import com.example.lunchbox.service.Impl.OrderServiceImpl;
import com.example.lunchbox.service.OrderService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/save-order", method = RequestMethod.POST)
    public String addOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
        OrderServiceImpl orderService = new OrderServiceImpl();
        return "{\"status\":\"true\"}";
    }

    @RequestMapping(value = "/assign-order", method = RequestMethod.POST)
    public String assignOrderToRider(@RequestParam Integer riderId, @RequestParam Integer orderId) {
        return orderService.assignRiderToOrder(riderId, orderId);
    }

    @RequestMapping(value = "/get-order", method = RequestMethod.GET)
    public Order getOrderById(@RequestParam Integer id) {
        return orderService.getOrderById(id);
    }

    @RequestMapping(value = "/get-pending-order", method = RequestMethod.GET)
    public List<Order> getPendingOrders() {
        return orderService.getPendingOrders();
    }

    @RequestMapping(value = "/get-ack-order", method = RequestMethod.GET)
    public List<Order> getAcknowOrders() {
        return orderService.getAckOrders();
    }

    @RequestMapping(value = "/get-done-order", method = RequestMethod.GET)
    public List<Order> getDoneOrders() {
        return orderService.getDoneOrders();
    }

    @RequestMapping(value = "/get-orderByStatus", method = RequestMethod.GET)
    public List<Order> getOrdersbyStatus(@RequestParam Integer status) {
        return orderService.getorderByStatus(status);
    }

    @RequestMapping(value = "/get-order-count", method = RequestMethod.POST)
    public long countAllOrders() {
        return orderService.countAllOrders();
    }

    @RequestMapping(value = "/delete-dish", method = RequestMethod.POST)
    public void deleteOrder(@RequestBody Order order) {
        orderService.deleteOrder(order);
    }

    @RequestMapping(value = "/get-order-list", method = RequestMethod.GET)
    public List<Order> getOrderList() {
        return orderService.findAllOrders();
    }


    @RequestMapping(value = "/order-view", method = RequestMethod.POST)
    public ModelAndView getOrderDetail(@RequestParam Integer orderId) {
        Order order = orderService.getOrderById(orderId);
        ModelAndView modelAndView = new ModelAndView("order-detail");
        modelAndView.addObject("orderDetail", order);
        return modelAndView;
    }

    @RequestMapping(value = "/update-order-status", method = RequestMethod.GET)
    public void updateOrderStatus(@RequestParam Integer orderStatus, @RequestParam Integer orderId) {
        orderService.updateOrderStatus(orderStatus, orderId);
    }

    @RequestMapping(value = "/update-order-rating", method = RequestMethod.GET)
    public void updateOrderRating(@RequestParam Integer orderRating, @RequestParam Integer orderId) {
        orderService.updateOrderRating(orderRating, orderId);
    }
}
