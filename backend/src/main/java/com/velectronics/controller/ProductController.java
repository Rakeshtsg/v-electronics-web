package com.velectronics.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.velectronics.service.ProductService;
import com.velectronics.model.Product;
import java.util.List;
@RestController @RequestMapping("/api/public/products")
public class ProductController {
    @Autowired ProductService service;
    @GetMapping public List<Product> all(){ return service.all(); }
    @PostMapping("/seed") public String seed(){
        service.save(new Product(null,"Arduino Uno","Microcontroller board",499.0,""));
        service.save(new Product(null,"Raspberry Pi 4","Mini computer",3500.0,""));
        service.save(new Product(null,"Robotic Arm Kit","DIY kit",4500.0,""));
        return "seeded";
    }
}
