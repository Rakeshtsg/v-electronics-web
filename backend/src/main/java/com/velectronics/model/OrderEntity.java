package com.velectronics.model;
import javax.persistence.*;
import lombok.*;
@Entity(name="orders") @Data @NoArgsConstructor @AllArgsConstructor
public class OrderEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String username;
    private double amount;
    private String status;
}
