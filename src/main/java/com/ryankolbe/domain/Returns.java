package com.ryankolbe.domain;

import java.util.Objects;

public class Returns implements Comparable<Returns> {
    private String returnId;
    private String returnReason;
    private int returnQty;
    private double returnValue;

    private Returns() {
    }

    private Returns(Builder builder) {
        this.returnId = builder.returnId;
        this.returnReason = builder.returnReason;
        this.returnQty = builder.returnQty;
        this.returnValue = builder.returnValue;
    }

    public String getReturnId() {
        return returnId;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public int getReturnQty() {
        return returnQty;
    }

    public double getReturnValue() {
        return returnValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Returns)) return false;
        Returns returns = (Returns) o;
        return getReturnId().equals(returns.getReturnId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReturnId());
    }

    @Override
    public String toString() {
        return "Returns{" +
                "returnId='" + returnId + '\'' +
                ", returnReason='" + returnReason + '\'' +
                ", returnQty=" + returnQty +
                ", returnValue=" + returnValue +
                '}';
    }

    @Override
    public int compareTo(Returns returns) {
        return this.returnId.compareToIgnoreCase(returns.returnId);
    }

    public static class Builder {
        private String returnId;
        private String returnReason;
        private int returnQty;
        private double returnValue;

        public Builder returnId(String returnId) {
            this.returnId = returnId;
            return this;
        }

        public Builder returnReason(String returnReason) {
            this.returnReason = returnReason;
            return this;
        }

        public Builder returnQty(int returnQty) {
            this.returnQty = returnQty;
            return this;
        }

        public Builder returnValue(double returnValue) {
            this.returnValue = returnValue;
            return this;
        }

        public Builder copy(Returns returns) {
            this.returnId = returns.returnId;
            this.returnReason = returns.returnReason;
            this.returnQty = returns.returnQty;
            this.returnValue = returns.returnValue;
            return this;
        }

        public Returns build() {
            return new Returns(this);
        }
    }
}