package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Order;
import com.ryankolbe.factory.OrderFactory;
import com.ryankolbe.repository.OrderRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderRepositoryImplTest {
    private static OrderRepository orderRepository = OrderRepositoryImpl.getOrderRepository();
    private static Order order;
    private static Set<Order> orders = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        order = OrderFactory.createOrder("0001", 5, 125.00);
        orders.add(orderRepository.create(order));
    }

    @Test
    public void getOrderRepository() {
        Assert.assertNotNull(orderRepository);
    }

    @Test
    public void create() {
        Order createOrder = OrderFactory.createOrder("0002", 46, 215.35);
        orders.add(orderRepository.create(createOrder));
        Assert.assertEquals(createOrder, orderRepository.read(createOrder.getOrderId()));
    }

    @Test
    public void read() {
        Order readOrder = orderRepository.read(order.getOrderId());
        Assert.assertEquals(readOrder, orderRepository.read(readOrder.getOrderId()));
    }

    @Test
    public void update() {
        int newOrderQty = 12;
        Order updateOrder = new Order.Builder().copy(order).orderQty(newOrderQty).build();
        orders.add(orderRepository.update(updateOrder));
        Assert.assertEquals(updateOrder, orderRepository.read(updateOrder.getOrderId()));
    }

    @Test
    public void delete() {
        Order deleteOrder = OrderFactory.createOrder("0075", 16, 87.00);
        orders.add(orderRepository.create(deleteOrder));
        orders.remove(deleteOrder);
        orderRepository.delete(deleteOrder.getOrderId());
        Assert.assertEquals(orders.size(), orderRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Order> orderSet = orderRepository.getAll();
        Assert.assertEquals(orderSet.size(), orderRepository.getAll().size());
    }
}