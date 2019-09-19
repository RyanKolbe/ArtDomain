package com.ryankolbe.service;

import com.ryankolbe.domain.Order;

import java.util.List;

public interface OrderService extends IService<Order, String> {
    List<Order> getAll();
}