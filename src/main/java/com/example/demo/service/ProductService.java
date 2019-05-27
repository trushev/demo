package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseService<Product, ProductRepository> {
    ProductService(ProductRepository repository) {
        super(repository);
    }

    @Override
    public Product update(Product newProduct, Long id) {
        getLogger().info("Updating an entity " + Product.class.getName());
        Product oldProduct = get(id);
        oldProduct.setName(newProduct.getName());
        oldProduct.setPrice(newProduct.getPrice());
        oldProduct.setInStock(newProduct.getInStock());
        return oldProduct;
    }
}
