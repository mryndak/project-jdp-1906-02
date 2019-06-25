package com.kodilla.ecommercee;

import org.hibernate.criterion.Order;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {
    private Long id;
    private List<ProductDto> products;
    private LocalDateTime date;
    private OrderStatus status;

    public OrderDto(Long id, List<ProductDto> products, LocalDateTime date, OrderStatus status) {
        this.id = id;
        this.products = products;
        this.date = date;
        this.status = status;
    }

    private OrderDto() {
    }

    public Long getId() {
        return id;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
