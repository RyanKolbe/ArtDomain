package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Order;
import com.ryankolbe.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("OrderRepository")
public class OrderRepositoryImpl implements OrderRepository {
    private static OrderRepositoryImpl orderRepository = null;
    private Set<Order> orders;


    private OrderRepositoryImpl() {
        this.orders = new HashSet<>();
    }

    public static OrderRepositoryImpl getOrderRepository() {
        if (orderRepository == null) orderRepository = new OrderRepositoryImpl();
        return orderRepository;
    }

    @Override
    public Order create(Order order) {
        this.orders.add(order);
        return order;
    }

    @Override
    public Order read(String orderId) {
        return search(orderId);
    }

    @Override
    public Order update(Order order) {
        Order orderTemp = search(order.getOrderId());
        if (orderTemp != null) {
            return create(new Order.Builder()
                    .copy(orderTemp)
                    .build());
        }
        return null;
    }

    @Override
    public void delete(String orderId) {
        Order orderDelete = search(orderId);
        if (orderDelete != null) this.orders.remove(orderDelete);
    }

    private Order search(final String orderId) {
        for (Order orderSearch : this.orders) {
            if (orderSearch.getOrderId().equals(orderId))
                return orderSearch;
        }
        return null;
    }

    @Override
    public Set<Order> getAll() {
        return this.orders;
    }
}