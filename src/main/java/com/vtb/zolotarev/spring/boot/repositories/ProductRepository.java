package com.vtb.zolotarev.spring.boot.repositories;

import com.vtb.zolotarev.spring.boot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
