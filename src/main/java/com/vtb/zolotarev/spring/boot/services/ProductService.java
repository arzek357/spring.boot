package com.vtb.zolotarev.spring.boot.services;


import com.vtb.zolotarev.spring.boot.exceptions.ObjectNotFoundException;
import com.vtb.zolotarev.spring.boot.model.Product;
import com.vtb.zolotarev.spring.boot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product findProductById(long id) {
        return productRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }
}
