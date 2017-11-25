/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.belajarspringboot.dao;

import com.belajar.belajarspringboot.entity.Product;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author anggi
 */
public interface ProductDao extends PagingAndSortingRepository<Product, String> {

    public Product findByName(String name);

    public List<Product> findByNameContaining(String name);
}
