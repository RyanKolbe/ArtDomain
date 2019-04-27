package com.ryankolbe.model;

import java.util.Objects;

public class Address implements Comparable<Address> {
    private String addressId;
    private String streetNumber;
    private String streetName;
    private String streetType;

    private Address() {
    }

    private Address(Builder builder) {
        this.addressId = builder.addressId;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.streetType = builder.streetType;
    }

    public String getAddressId() {
        return addressId;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetType() {
        return streetType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return getAddressId().equals(address.getAddressId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddressId());
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId='" + addressId + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetType='" + streetType + '\'' +
                '}';
    }

    @Override
    public int compareTo(Address address) {
        return this.addressId.compareTo(address.addressId);
    }

    public static class Builder {
        private String addressId;
        private String streetNumber;
        private String streetName;
        private String streetType;

        public Builder addressId(String addressId) {
            this.addressId = addressId;
            return this;
        }

        public Builder streetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder streetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder streetType(String streetType) {
            this.streetType = streetType;
            return this;
        }

        public Builder copy(Address address) {
            this.addressId = address.addressId;
            this.streetNumber = address.streetNumber;
            this.streetName = address.streetName;
            this.streetType = address.streetType;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
