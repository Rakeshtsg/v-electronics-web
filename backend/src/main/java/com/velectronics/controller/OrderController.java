package com.velectronics.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.velectronics.repository.ProductRepository;
import com.velectronics.repository.OrderRepository;
import com.velectronics.model.CartItem;
import com.velectronics.model.OrderEntity;
import java.util.List;
@RestController @RequestMapping("/api/orders")
public class OrderController {
    @Autowired ProductRepository productRepo;
    @Autowired OrderRepository orderRepo;
    @PostMapping("/place") public OrderEntity place(@RequestBody List<CartItem> items, @RequestHeader(value="Authorization", required=false) String auth){
        double total=0; for(var ci: items){ total += productRepo.findById(ci.getProductId()).map(p->p.getPrice()*ci.getQuantity()).orElse(0.0); }
        var o = new OrderEntity(); o.setUsername("guest"); o.setAmount(total); o.setStatus("PLACED"); return orderRepo.save(o);
    }
}
