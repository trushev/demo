package com.example.demo.method;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface GetMethod extends BaseMethod {
    @GetMapping("/{id}")
    default Object get(@PathVariable Long id) {
        return getService().get(id);
    }
}
