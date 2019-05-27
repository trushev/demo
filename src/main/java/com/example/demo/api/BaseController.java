package com.example.demo.api;

import com.example.demo.method.*;
import com.example.demo.service.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;

public class BaseController<T, S extends BaseService<T, ? extends JpaRepository<T, Long>>>
        implements GetMethod, GetAllMethod, DeleteMethod, PostMethod, PutMethod {
    private final S service;

    BaseController(S service) {
        this.service = service;
    }

    public S getService() {
        return service;
    }
}
