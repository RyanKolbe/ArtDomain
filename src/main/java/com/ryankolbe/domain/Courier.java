package com.ryankolbe.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Courier implements Comparable<Courier> {
    @Id
    private String courierId;
    private String courierName;
    private String courierContact;

    private Courier() {
    }

    private Courier(Builder builder) {
        this.courierId = builder.courierId;
        this.courierName = builder.courierName;
        this.courierContact = builder.courierContact;
    }

    public String getCourierId() {
        return courierId;
    }

    public String getCourierName() {
        return courierName;
    }

    public String getCourierContact() {
        return courierContact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Courier)) return false;
        Courier courier = (Courier) o;
        return getCourierId().equals(courier.getCourierId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourierId());
    }

    @Override
    public String toString() {
        return "Courier{" +
                "courierId='" + courierId + '\'' +
                ", courierName='" + courierName + '\'' +
                ", courierContact='" + courierContact + '\'' +
                '}';
    }

    @Override
    public int compareTo(Courier courier) {
        return this.courierId.compareToIgnoreCase(courier.courierId);
    }

    public static class Builder {
        private String courierId;
        private String courierName;
        private String courierContact;

        public Builder courierId(String courierId) {
            this.courierId = courierId;
            return this;
        }

        public Builder courierName(String courierName) {
            this.courierName = courierName;
            return this;
        }

        public Builder courierContact(String courierContact) {
            this.courierContact = courierContact;
            return this;
        }

        public Builder copy(Courier courier) {
            this.courierId = courier.courierId;
            this.courierName = courier.courierName;
            this.courierContact = courierContact;
            return this;
        }

        public Courier build() {
            return new Courier(this);
        }
    }
}
