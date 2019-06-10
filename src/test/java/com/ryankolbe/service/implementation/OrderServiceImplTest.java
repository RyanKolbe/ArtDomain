package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Order;
import com.ryankolbe.factory.OrderFactory;
import com.ryankolbe.service.OrderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceImplTest {
    @Autowired
    @Qualifier("OrderServiceImpl")
    private OrderService orderService;
    private Order order;
    private Set<Order> orders = new HashSet<>();

    @Before
    public void setUp() {
        order = orderService.create(OrderFactory.createOrder("0001", 2, 100.00));
        orders.add(order);
    }

    @Test
    public void create() {
        Order createOrder = orderService.create(OrderFactory.createOrder("0002", 3, 450.00));
        orders.add(createOrder);
        Assert.assertEquals(createOrder, orderService.read(createOrder.getOrderId()));
    }

    @Test
    public void read() {
        Order readOrder = orderService.read(order.getOrderId());
        Assert.assertEquals(readOrder, orderService.read(readOrder.getOrderId()));
    }

    @Test
    public void update() {
        int newOrderQty = 8;
        Order updateOrder = orderService.update(new Order.Builder().copy(order).orderQty(newOrderQty).build());
        orders.add(updateOrder);
        Assert.assertEquals(updateOrder, orderService.read(updateOrder.getOrderId()));
    }

    @Test
    public void delete() {
        orders.addAll(orderService.getAll());
        Order deleteOrder = orderService.create(OrderFactory.createOrder("0003", 2, 254.00));
        orders.add(deleteOrder);
        orders.remove(deleteOrder);
        orderService.delete(deleteOrder.getOrderId());
        Assert.assertEquals(orders.size(), orderService.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Order> orderSet = orderService.getAll();
        Assert.assertEquals(orderSet.size(), orderService.getAll().size());
    }
}