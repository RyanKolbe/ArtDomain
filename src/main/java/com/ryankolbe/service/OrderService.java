package com.ryankolbe.service;

import com.ryankolbe.domain.Order;

import java.util.Set;

public interface OrderService extends IService<Order, String> {
    Set<Order> getAll();
}