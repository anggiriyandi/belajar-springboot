/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.belajarspringboot.contoller;

import com.belajar.belajarspringboot.entity.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author anggi
 */
@RestController
@RequestMapping("/api/product/")
public class ProductController {

    @GetMapping("all")
    public List<Product> getAll() {
        
        List<Product> products = new ArrayList<>();
                
        Product p1 = new Product();
        p1.setName("product 1");
        p1.setCode("p001");
        p1.setPrice(new BigDecimal(20000));
        p1.setStock(10);

        Product p2 = new Product();
        p2.setName("product 1");
        p2.setCode("p001");
        p2.setPrice(new BigDecimal(20000));
        p2.setStock(10);

        products.add(p1);
        products.add(p2);
        return products;
    }
}
