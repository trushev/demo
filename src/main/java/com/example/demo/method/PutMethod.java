package com.example.demo.method;

import com.example.demo.service.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PutMethod <T, S extends BaseService<T, ? extends JpaRepository<T, Long>>> {
    S getService();
    @PutMapping("/{id}")
    default T update(@RequestBody T entity, @PathVariable Long id) {
        return getService().update(entity, id);
    }
}
