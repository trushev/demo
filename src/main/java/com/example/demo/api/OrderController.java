package com.example.demo.api;

import com.example.demo.entity.Order;
import com.example.demo.method.DeleteMethod;
import com.example.demo.method.GetAllMethod;
import com.example.demo.method.GetMethod;
import com.example.demo.service.OrderService;
import com.example.demo.validate.OrderValidate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController implements GetAllMethod, GetMethod, DeleteMethod {

    private final OrderService service;

    OrderController(OrderService service) {
        this.service = service;
    }

    public OrderService getService() {
        return service;
    }

    @PostMapping
    public Order create(@RequestBody OrderValidate orderValidate) {
        return service.create(orderValidate);
    }
}
