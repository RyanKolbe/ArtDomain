package com.ryankolbe.model;

import java.util.Objects;

public class City {
    private String id;
    private String postalCode;
    private String city;

    private City() {
    }

    private City(Builder builder) {
        this.id = builder.id;
        this.postalCode = builder.postalCode;
        this.city = builder.city;
    }

    public String getId() {
        return id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city1 = (City) o;
        return getId().equals(city1.getId()) &&
                getPostalCode().equals(city1.getPostalCode()) &&
                getCity().equals(city1.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPostalCode(), getCity());
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String postalCode;
        private String city;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public City build() {
            return new City(this);
        }
    }
}
