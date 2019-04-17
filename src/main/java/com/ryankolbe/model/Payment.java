package com.ryankolbe.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Payment {
    private String id;
    private String paymentType;
    private BigDecimal paymentValue;
    private String paymentDate;
    private String customerId;

    private Payment() {
    }

    private Payment(Builder builder) {
        this.id = builder.id;
        this.paymentType = builder.paymentType;
        this.paymentValue = builder.paymentValue;
        this.paymentDate = builder.paymentDate;
        this.customerId = builder.customerId;
    }

    public String getId() {
        return id;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public BigDecimal getPaymentValue() {
        return paymentValue;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return getId().equals(payment.getId()) &&
                getPaymentType().equals(payment.getPaymentType()) &&
                getPaymentValue().equals(payment.getPaymentValue()) &&
                getPaymentDate().equals(payment.getPaymentDate()) &&
                getCustomerId().equals(payment.getCustomerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPaymentType(), getPaymentValue(), getPaymentDate(), getCustomerId());
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", paymentValue=" + paymentValue +
                ", paymentDate='" + paymentDate + '\'' +
                ", customerId='" + customerId + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String paymentType;
        private BigDecimal paymentValue;
        private String paymentDate;
        private String customerId;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder paymentType(String paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public Builder paymentValue(BigDecimal paymentValue) {
            this.paymentValue = paymentValue;
            return this;
        }

        public Builder paymentDate(String paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}