package com.example.demo.method;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface DeleteMethod extends BaseMethod {
    @DeleteMapping("/{id}")
    default void delete(@PathVariable Long id) {
        getService().delete(id);
    }
}
