package com.velectronics.service;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
@Service public class PaymentService {
    // Placeholder for Razorpay integration. Here we mock responses.
    public Map<String,String> charge(double amount, String currency){ Map<String,String> r=new HashMap<>(); r.put("status","success"); r.put("transactionId","txn_"+System.currentTimeMillis()); return r; }
}
