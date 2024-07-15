package com.rodneycom.papelaria.papelariams.controller.dto;

import com.rodneycom.papelaria.papelariams.entity.OrderEntity;

import java.math.BigDecimal;

public record OrderResponse(Long orderId, Long clienteId, BigDecimal total) {
    public static OrderResponse fromEntity(OrderEntity entity){
        return new OrderResponse(entity.getOrderId(), entity.getClienteId(), entity.getTotal());
    }
}
