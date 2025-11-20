package com.velectronics.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.velectronics.service.AuthService;
import com.velectronics.security.JwtUtil;
import com.velectronics.model.User;
import java.util.HashMap;
@RestController @RequestMapping("/api/auth")
public class AuthController {
    @Autowired AuthService authService;
    @Autowired JwtUtil jwtUtil;
    @PostMapping("/register") public User register(@RequestBody User u){ return authService.register(u); }
    @PostMapping("/login") public HashMap<String,String> login(@RequestBody User u){
        var res = new HashMap<String,String>();
        var opt = authService.authenticate(u.getUsername(), u.getPassword());
        if(opt.isPresent()){ res.put("token", jwtUtil.generateToken(u.getUsername())); } else { res.put("error","invalid credentials"); }
        return res;
    }
}
