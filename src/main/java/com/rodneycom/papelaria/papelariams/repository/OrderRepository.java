package com.rodneycom.papelaria.papelariams.repository;

import com.rodneycom.papelaria.papelariams.controller.dto.OrderResponse;
import com.rodneycom.papelaria.papelariams.entity.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEntity, Long> {
    Page<OrderEntity> findAllByClienteId(Long clienteId, PageRequest pageRequest);
}
