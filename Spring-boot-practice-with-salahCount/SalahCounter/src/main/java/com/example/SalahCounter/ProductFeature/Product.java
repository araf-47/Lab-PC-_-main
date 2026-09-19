package com.example.SalahCounter.ProductFeature;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "Identity")
    private Long id;
    
    @Column(name = "PRODUCT_NAME")
    private String productName;
    
    @Column(name = "PRICE")
    private Double price;

    public Product(){
    }

    public Product(Long id, String productName, Double price){
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    public String getProductName() {
        return productName;
    }

    // public void setProductName(String productName) {
    //     this.productName = productName;
    // }

    public Double getPrice() {
        return price;
    }

    // public void setPrice(Double price) {
    //     this.price = price;
    // }

}
