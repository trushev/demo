package com.example.demo.api;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController extends BaseController<Product, ProductService> {

    ProductController(ProductService service) {
        super(service);
    }
}
