package com.ryankolbe.model;

import java.util.Objects;

public class Order {
    private String id;
    private String orderNumber;
    private String customerNumber;

    private Order() {
    }

    private Order(Builder builder) {
        this.id = builder.id;
        this.orderNumber = builder.orderNumber;
        this.customerNumber = builder.customerNumber;
    }

    public String getId() {
        return id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getId().equals(order.getId()) &&
                getOrderNumber().equals(order.getOrderNumber()) &&
                getCustomerNumber().equals(order.getCustomerNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOrderNumber(), getCustomerNumber());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String orderNumber;
        private String customerNumber;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder orderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
            return this;
        }

        public Builder customerNumber(String customerNumber) {
            this.customerNumber = customerNumber;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
