package com.velectronics.model;
import javax.persistence.*;
import lombok.*;
@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String name;
    @Column(length=1000) private String description;
    private double price;
    private String imageUrl;
}
