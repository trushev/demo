package com.example.demo.method;

import com.example.demo.service.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PostMethod <T, S extends BaseService<T, ? extends JpaRepository<T, Long>>> {
    S getService();
    @PostMapping
    default T create(@RequestBody T entity) {
        return getService().create(entity);
    }
}
