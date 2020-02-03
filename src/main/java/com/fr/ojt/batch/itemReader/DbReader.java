package com.fr.ojt.batch.itemReader;

import com.fr.ojt.batch.model.Order;
import com.fr.ojt.batch.repository.OrderRepository;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DbReader implements ItemReader {
    @Autowired
    OrderRepository orderRepository;
    @Override
    public List<Order> read() {
        return orderRepository.getAll();
    }
}
