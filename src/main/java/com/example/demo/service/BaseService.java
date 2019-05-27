package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class BaseService <T, R extends JpaRepository<T, Long>> {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final R repository;
    private final Class<?> repositoryType;
    private String entityType;

    BaseService(R repository) {
        this.repository = repository;
        this.repositoryType = repository.getClass().getInterfaces()[0];
    }

    Logger getLogger() {
        return logger;
    }

    public List<T> get() {
        logger.info("Getting all entities from " + repositoryType);
        return repository.findAll();
    }

    public T get(Long id) {
        logger.info("Getting an entity from " + repositoryType);
        return repository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public T create(T entity) {
        logger.info("Creating an entity " + getEntityType(entity));
        return repository.save(entity);
    }

    public T update(T entity, Long id) {
        logger.info("Updating is not allowed for entity " + getEntityType(entity));
        throw new UnsupportedOperationException();
    }

    public void delete(Long id) {
        logger.info("Deleting an entity from " + repositoryType);
        repository.deleteById(id);
    }

    private String getEntityType(T entity) {
        if (entityType == null)
            entityType = entity.getClass().getName();
        return entityType;
    }
}
