package com.example.demo.method;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface GetAllMethod extends BaseMethod {
    @GetMapping
    default List get() {
        return getService().get();
    }
}
