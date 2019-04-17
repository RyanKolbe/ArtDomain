package com.ryankolbe.model;

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

    public static class Builder {
        private String addressId;
        private String postalCode;
        private String suburb;

        public Builder addressId(String addressId) {
            this.addressId = addressId;
            return this;
        }


    }
}
