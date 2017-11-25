/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.belajarspringboot.contoller;

import com.belajar.belajarspringboot.dao.ProductDao;
import com.belajar.belajarspringboot.dto.ResponseDto;
import com.belajar.belajarspringboot.entity.Product;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductDao productDao;

    @Secured({"ROLE_VIEW_PRODUCT"})
    @GetMapping("all")
    public List<Product> getAll(Principal principal) {
        return (List<Product>) productDao.findAll();
    }
    
    @Secured({"ROLE_CREATE_PRODUCT"})
    @GetMapping("findById/{id}")
    public Product findById(@PathVariable("id") String id) {
        return productDao.findOne(id);
    }

    @GetMapping("findByName")
    public Product findByName(@RequestParam(name = "name") String name) {
        return productDao.findByName(name);
    }

    @GetMapping("findByNameLike")
    public List<Product> findByNameLike(@RequestParam(name = "name") String name) {
        return productDao.findByNameContaining(name);
    }

    @Secured({"ROLE_CREATE_PRODUCT"})
    @PostMapping("save")
    public ResponseDto save(@RequestBody Product p) {
        ResponseDto dto =  new  ResponseDto();
        try {
            logger.info("coba save data");
            productDao.save(p);
            dto.setResponseCode("00");
            dto.setResponseMessage("SUKSES");
            return dto;
       } catch (DataAccessException e) {
           dto.setResponseCode("500");
           dto.setResponseMessage(e.getMessage());
           logger.error("error save ke database ",e);
           return dto;
       }
    }
}
