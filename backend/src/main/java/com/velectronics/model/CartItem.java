package com.velectronics.model;
import lombok.*;
@Data @NoArgsConstructor @AllArgsConstructor
public class CartItem {
    private Long productId;
    private int quantity;
}
