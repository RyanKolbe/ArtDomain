package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Order;
import com.ryankolbe.repository.OrderRepository;
import com.ryankolbe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("OrderServiceImpl")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order create(Order order) {
        return this.orderRepository.save(order);
    }

    @Override
    public Order read(String orderId) {
        Optional<Order> byId = this.orderRepository.findById(orderId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Order update(Order order) {
        return this.orderRepository.save(order);
    }

    @Override
    public void delete(String orderId) {
        this.orderRepository.deleteById(orderId);
    }

    @Override
    public List<Order> getAll() {
        return this.orderRepository.findAll();
    }
}