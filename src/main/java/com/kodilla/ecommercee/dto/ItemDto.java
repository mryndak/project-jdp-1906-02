package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemDto {
    private Long id;
    private int quantity;
    private BigDecimal total;
    private Long productId;

    public ItemDto(int quantity, Long productId) {
        this.quantity = quantity;
        this.productId = productId;
        this.total = new BigDecimal(0);
    }
}
