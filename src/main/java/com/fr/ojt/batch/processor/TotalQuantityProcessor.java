package com.fr.ojt.batch.processor;

import com.fr.ojt.batch.model.Order;
import org.springframework.batch.item.ItemProcessor;

public class TotalQuantityProcessor implements ItemProcessor {
    static int count = 0;

    @Override
    public Object process(Object o) {
        Order order = (Order)o;
        int quantity = order.getQuantity();
        count += quantity;
        return count;
    }
}
