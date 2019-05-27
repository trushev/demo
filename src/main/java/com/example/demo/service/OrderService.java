package com.example.demo.service;


import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.repository.OrderRepository;
import com.example.demo.validate.OrderValidate;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseService<Order, OrderRepository> {
    private final UserService userService;
    private final ProductService productService;

    OrderService(OrderRepository repository, UserService userService, ProductService productService) {
        super(repository);
        this.userService = userService;
        this.productService = productService;
    }

    public Order create(OrderValidate orderValidate) {
        Product product = productService.get(orderValidate.getProductId());
        Long amount = orderValidate.getAmount();
        User user = userService.get(orderValidate.getUserId());
        Order order = new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setAmount(amount);
        product.buy(amount);
        return create(order);
    }
}
