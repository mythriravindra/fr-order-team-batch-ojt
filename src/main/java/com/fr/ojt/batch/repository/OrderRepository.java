package com.fr.ojt.batch.repository;

import com.fr.ojt.batch.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderRepository {
    List<Order> getAll();

    Order getOrderById(Long id);

    List<Order> getOrderByCustomerId(Long customerId);

    void addOrder(Order order);

    void deleteOrder(Long id);
}
