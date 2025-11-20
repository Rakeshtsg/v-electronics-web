package com.velectronics.service;
import org.springframework.stereotype.Service;
import com.velectronics.repository.ProductRepository;
import com.velectronics.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@Service public class ProductService {
    @Autowired ProductRepository repo;
    public List<Product> all(){ return repo.findAll(); }
    public Product save(Product p){ return repo.save(p); }
}
