package com.fr.ojt.batch.reader;

import com.fr.ojt.batch.model.Order;
import com.fr.ojt.batch.repository.OrderRepository;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DbReader implements ItemReader {
    @Autowired
    OrderRepository orderRepository;
    int count = -1;
    List<Order> orders;

    @Override
    public Order read() {
        if (count == -1) {
            orders = orderRepository.getAll();
        }
        count++;
        if (count < orders.size()) {
            return orders.get(count);
        } else {
            return null;
        }
    }
}
