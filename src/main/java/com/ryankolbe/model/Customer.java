package com.ryankolbe.model;

import java.util.Objects;

public class Customer {
    private String id;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerPassword;
    private String customerUsername;

    private Customer() {
    }

    private Customer(Builder builder) {
        this.id = builder.id;
        this.customerName = builder.customerName;
        this.customerAddress = builder.customerAddress;
        this.customerEmail = builder.customerEmail;
        this.customerPassword = builder.customerPassword;
        this.customerUsername = builder.customerUsername;
    }

    public String getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getId().equals(customer.getId()) &&
                getCustomerName().equals(customer.getCustomerName()) &&
                getCustomerAddress().equals(customer.getCustomerAddress()) &&
                getCustomerEmail().equals(customer.getCustomerEmail()) &&
                getCustomerPassword().equals(customer.getCustomerPassword()) &&
                getCustomerUsername().equals(customer.getCustomerUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomerName(), getCustomerAddress(), getCustomerEmail(), getCustomerPassword(), getCustomerUsername());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPassword='" + customerPassword + '\'' +
                ", customerUsername='" + customerUsername + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String customerName;
        private String customerAddress;
        private String customerEmail;
        private String customerPassword;
        private String customerUsername;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder customerAddress(String customerAddress) {
            this.customerAddress = customerAddress;
            return this;
        }

        public Builder customerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
            return this;
        }

        public Builder customerPassword(String customerPassword) {
            this.customerPassword = customerPassword;
            return this;
        }

        public Builder customerUsername(String customerUsername) {
            this.customerUsername = customerUsername;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
