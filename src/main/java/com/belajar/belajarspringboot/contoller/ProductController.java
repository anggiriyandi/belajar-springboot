/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.belajarspringboot.contoller;

import com.belajar.belajarspringboot.dao.ProductDao;
import com.belajar.belajarspringboot.entity.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author anggi
 */
@RestController
@RequestMapping("/api/product/")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping("all")
    public List<Product> getAll() {
        return (List<Product>) productDao.findAll();
    }
    
    @GetMapping("findById/{id}")
    public Product findById(@PathVariable("id") String id){
        return productDao.findOne(id);
    }
    
    @GetMapping("findByName")
    public Product findByName(@RequestParam(name = "name") String name){
        return productDao.findByName(name);
    }
    
    @GetMapping("findByNameLike")
    public List<Product> findByNameLike(@RequestParam(name = "name") String name){
        return productDao.findByNameContaining(name);
    }
}
