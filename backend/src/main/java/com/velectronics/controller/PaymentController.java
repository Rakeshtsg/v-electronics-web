package com.velectronics.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.velectronics.service.PaymentService;
import java.util.Map;
@RestController @RequestMapping("/api/payment")
public class PaymentController {
    @Autowired PaymentService paymentService;
    @PostMapping("/charge") public Map<String,String> charge(@RequestBody Map<String,Object> p){ double amount = Double.parseDouble(p.getOrDefault("amount","0").toString()); return paymentService.charge(amount, "INR"); }
}
