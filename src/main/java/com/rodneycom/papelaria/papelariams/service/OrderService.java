package com.rodneycom.papelaria.papelariams.service;

import com.rodneycom.papelaria.papelariams.controller.dto.OrderResponse;
import com.rodneycom.papelaria.papelariams.entity.OrderEntity;
import com.rodneycom.papelaria.papelariams.entity.OrderItem;
import com.rodneycom.papelaria.papelariams.listener.dto.OrderCreatedEvent;
import com.rodneycom.papelaria.papelariams.repository.OrderRepository;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final MongoTemplate mongoTemplate;

    public OrderService(OrderRepository orderRepository, MongoTemplate mongoTemplate) {
        this.orderRepository = orderRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public BigDecimal findTotalOnOrdersByClientId(Long clienteId){
        var aggregations = newAggregation(
                match(Criteria.where("clienteId").is(clienteId)),
                        group().sum("total").as("total")
        );

        var response = mongoTemplate.aggregate(aggregations,"tb_orders", Document.class);
        return new BigDecimal(response.getUniqueMappedResult().get("total").toString());
    }
    public void save(OrderCreatedEvent event){
        var entity = new OrderEntity();
        entity.setOrderId((event.codigoPedido()));
        entity.setClienteId(event.codigoCliente());

        entity.setItens(event.itens().stream()
                .map(i -> new OrderItem(i.produto(), i.quantidade(), i.preco())).toList());
        
        entity.setTotal(getTotal(event));

        orderRepository.save(entity);
    }

    public Page<OrderResponse> findAllByClienteId(Long clienteId, PageRequest pageRequest){
        var orders = orderRepository.findAllByClienteId(clienteId, pageRequest);
        return orders.map(OrderResponse::fromEntity);
    }

    private BigDecimal getTotal(OrderCreatedEvent event) {
        return event.itens()
                .stream()
                .map(i -> i.preco().multiply(BigDecimal.valueOf(i.quantidade())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
