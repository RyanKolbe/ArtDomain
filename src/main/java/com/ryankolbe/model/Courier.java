package com.ryankolbe.model;

import java.util.Objects;

public class Courier {
    private String id;
    private String courierName;

    private Courier() {
    }

    private Courier(Builder builder) {
        this.id = builder.id;
        this.courierName = builder.courierName;
    }

    public String getId() {
        return id;
    }

    public String getCourierName() {
        return courierName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Courier)) return false;
        Courier courier = (Courier) o;
        return getId().equals(courier.getId()) &&
                getCourierName().equals(courier.getCourierName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCourierName());
    }

    @Override
    public String toString() {
        return "Courier{" +
                "id='" + id + '\'' +
                ", courierName='" + courierName + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String courierName;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder courierName(String courierName) {
            this.courierName = courierName;
            return this;
        }

        public Courier build() {
            return new Courier(this);
        }
    }
}
