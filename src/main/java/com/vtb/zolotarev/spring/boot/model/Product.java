package com.vtb.zolotarev.spring.boot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Long price;

    @Override
    public String toString() {
        return String.format("Product [id = %d, title = %s, price=%d]", id, title, price);
    }

    public Product(String title, long price) {
        this.title = title;
        this.price = price;
    }
}
