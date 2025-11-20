package com.velectronics.service;
import org.springframework.stereotype.Service;
import com.velectronics.repository.UserRepository;
import com.velectronics.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
@Service
public class AuthService {
    @Autowired UserRepository userRepo;
    public User register(User u){ u.setRole("USER"); return userRepo.save(u); }
    public Optional<User> authenticate(String username, String password){ return userRepo.findByUsername(username).filter(x->x.getPassword().equals(password)); }
}
