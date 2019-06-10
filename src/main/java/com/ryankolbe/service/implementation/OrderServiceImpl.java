package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Order;
import com.ryankolbe.repository.OrderRepository;
import com.ryankolbe.repository.implementation.OrderRepositoryImpl;
import com.ryankolbe.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("OrderServiceImpl")
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    private OrderServiceImpl() {
        this.orderRepository = OrderRepositoryImpl.getOrderRepository();
    }

    @Override
    public Order create(Order order) {
        return this.orderRepository.create(order);
    }

    @Override
    public Order read(String orderId) {
        return this.orderRepository.read(orderId);
    }

    @Override
    public Order update(Order order) {
        return this.orderRepository.update(order);
    }

    @Override
    public void delete(String orderId) {
        this.orderRepository.delete(orderId);
    }

    @Override
    public Set<Order> getAll() {
        return this.orderRepository.getAll();
    }
}