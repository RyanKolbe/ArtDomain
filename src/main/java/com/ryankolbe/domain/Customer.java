package com.ryankolbe.domain;

import java.util.Objects;

public class Customer implements Comparable<Customer> {
    private String customerId;
    private String customerName;
    private String customerCell;

    private Customer() {
    }

    private Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.customerName = builder.customerName;
        this.customerCell = builder.customerCell;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerCell() {
        return customerCell;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getCustomerId().equals(customer.getCustomerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerCell='" + customerCell + '\'' +
                '}';
    }

    @Override
    public int compareTo(Customer customer) {
        return this.customerId.compareToIgnoreCase(customer.customerId);
    }

    public static class Builder {
        private String customerId;
        private String customerName;
        private String customerCell;

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder customerCell(String customerCell) {
            this.customerCell = customerCell;
            return this;
        }

        public Builder copy(Customer customer) {
            this.customerId = customer.customerId;
            this.customerName = customer.customerName;
            this.customerCell = customer.customerCell;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}