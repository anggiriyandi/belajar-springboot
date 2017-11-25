/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.belajarspringboot.contoller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author anggi
 */

@RestController
public class HalloController {
    
    @GetMapping("/")
    public String root(){
        return "ini halaman root";
    }
    
    @GetMapping("/hallo")
    public String halloWorld(){
        return "hallo anggi";
    }
    
}
