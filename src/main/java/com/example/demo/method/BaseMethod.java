package com.example.demo.method;

import com.example.demo.service.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseMethod <T, S extends BaseService<T, ? extends JpaRepository<T, Long>>> {
    S getService();
}
