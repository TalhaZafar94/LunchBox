package com.example.lunchbox.controller.order;

import com.example.lunchbox.model.entity.Order;
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

    @RequestMapping(value = "/save-order" , method = RequestMethod.POST)
    public void addOrder(@RequestBody Order order){
        orderService.saveOrder(order);
    }

    @RequestMapping(value = "/get-order" , method = RequestMethod.GET)
    public Order getOrderById(@RequestParam Integer id){
        return orderService.getOrderById(id);
    }


    @RequestMapping(value = "/get-order-count" , method = RequestMethod.POST)
    public long countAllOrders(){
        return orderService.countAllOrders();
    }

    @RequestMapping(value = "/delete-dish" , method = RequestMethod.POST)
    public void deleteOrder(@RequestBody Order order){
        orderService.deleteOrder(order);
    }

    @RequestMapping(value = "/get-order-list" , method = RequestMethod.GET)
    public List<Order> getOrderList(){
        return orderService.findAllOrders();
    }


    @RequestMapping(value = "/order-view" ,method = RequestMethod.POST)
    public ModelAndView getOrderDetail(@RequestParam Integer orderId){
        Order order = orderService.getOrderById(orderId);
        ModelAndView modelAndView = new ModelAndView("order-detail");
        modelAndView.addObject("orderDetail", order);
        return modelAndView;
    }

    @RequestMapping(value = "/update-order-status" ,method = RequestMethod.GET)
    public void updateOrderStatus(@RequestParam Integer orderStatus,@RequestParam Integer orderId){
        orderService.updateOrderStatus(orderStatus,orderId);

    }
}
