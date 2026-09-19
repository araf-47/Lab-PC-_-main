package com.example.SalahCounter.ProductFeature;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestData implements CommandLineRunner {
    
    private final ProductReop productReop;
    
    public TestData(ProductReop productReop) {
        this.productReop = productReop;
    }
    
    @Override
    public void run(String... args) throws Exception {
        Product product = new Product(420L, "LK John Doe", 44.0);
        productReop.save(product);
    }
}
