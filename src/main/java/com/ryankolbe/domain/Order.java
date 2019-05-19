package com.ryankolbe.domain;

import java.util.Objects;

public class Order implements Comparable<Order> {
    private String orderId;
    private int orderQty;
    private double orderValue;

    private Order() {
    }

    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.orderQty = builder.orderQty;
        this.orderValue = builder.orderValue;
    }

    public String getOrderId() {
        return orderId;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public double getOrderValue() {
        return orderValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getOrderId().equals(order.getOrderId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId());
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderQty=" + orderQty +
                ", orderValue=" + orderValue +
                '}';
    }

    @Override
    public int compareTo(Order order) {
        return this.orderId.compareToIgnoreCase(order.orderId);
    }

    public static class Builder {
        private String orderId;
        private int orderQty;
        private double orderValue;

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder orderQty(int orderQty) {
            this.orderQty = orderQty;
            return this;
        }

        public Builder orderValue(double orderValue) {
            this.orderValue = orderValue;
            return this;
        }

        public Builder copy(Order order) {
            this.orderId = order.orderId;
            this.orderQty = order.orderQty;
            this.orderValue = order.orderValue;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
