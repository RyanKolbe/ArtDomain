package com.ryankolbe.model;

import java.util.Objects;

public class Address {
    private String addressId;
    private String postalCode;
    private String suburb;

    private Address() {
    }

    private Address(Builder builder) {
        this.addressId = builder.addressId;
        this.postalCode = builder.postalCode;
        this.suburb = builder.suburb;
    }

    public String getAddressId() {
        return addressId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getSuburb() {
        return suburb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Builder)) return false;
        Builder builder = (Builder) o;
        return addressId.equals(builder.addressId) &&
                postalCode.equals(builder.postalCode) &&
                suburb.equals(builder.suburb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, postalCode, suburb);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId='" + addressId + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", suburb='" + suburb + '\'' +
                '}';
    }

    public static class Builder {
        private String addressId;
        private String postalCode;
        private String suburb;

        public Builder addressId(String addressId) {
            this.addressId = addressId;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder suburb(String suburb) {
            this.suburb = suburb;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}