package com.ryankolbe.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Services implements Comparable<Services> {
    @Id
    private String serviceId;
    private String serviceName;
    private String serviceType;
    private double serviceCost;

    private Services() {
    }

    private Services(Builder builder) {
        this.serviceId = builder.serviceId;
        this.serviceName = builder.serviceName;
        this.serviceType = builder.serviceType;
        this.serviceCost = builder.serviceCost;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Services)) return false;
        Services services = (Services) o;
        return getServiceId().equals(services.getServiceId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getServiceId());
    }

    @Override
    public int compareTo(Services services) {
        return this.serviceId.compareToIgnoreCase(services.serviceId);
    }

    @Override
    public String toString() {
        return "Services{" +
                "serviceId='" + serviceId + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", serviceCost=" + serviceCost +
                '}';
    }

    public static class Builder {
        private String serviceId;
        private String serviceName;
        private String serviceType;
        private double serviceCost;

        public Builder serviceId(String serviceId) {
            this.serviceId = serviceId;
            return this;
        }

        public Builder serviceName(String serviceName) {
            this.serviceName = serviceName;
            return this;
        }

        public Builder serviceType(String serviceType) {
            this.serviceType = serviceType;
            return this;
        }

        public Builder serviceCost(double serviceCost) {
            this.serviceCost = serviceCost;
            return this;
        }

        public Builder copy(Services services) {
            this.serviceId = services.serviceId;
            this.serviceName = services.serviceName;
            this.serviceType = services.serviceType;
            this.serviceCost = services.serviceCost;
            return this;
        }

        public Services build() {
            return new Services(this);
        }
    }
}
