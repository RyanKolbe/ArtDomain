package com.ryankolbe.repository;

import com.ryankolbe.domain.Order;

import java.util.Set;

public interface OrderRepository extends IRepository<Order, String> {
    Set<Order> getAll();
}