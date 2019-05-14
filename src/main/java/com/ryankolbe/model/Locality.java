package com.ryankolbe.model;

import java.util.Objects;

public class Locality implements Comparable<Locality> {
    private String localizationId;
    private String registeredName;
    private String province;
    private String country;
    private String postalCode;

    private Locality() {
    }

    public Locality(Builder builder) {
        this.localizationId = builder.localizationId;
        this.registeredName = builder.registeredName;
        this.province = builder.province;
        this.country = builder.country;
        this.postalCode = builder.postalCode;
    }

    public String getLocalizationId() {
        return localizationId;
    }

    public String getRegisteredName() {
        return registeredName;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Locality)) return false;
        Locality locality = (Locality) o;
        return getLocalizationId().equals(locality.getLocalizationId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocalizationId());
    }

    @Override
    public String toString() {
        return "LocalityRepository{" +
                "localizationId='" + localizationId + '\'' +
                ", registeredName='" + registeredName + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    @Override
    public int compareTo(Locality locality) {
        return this.localizationId.compareTo(locality.localizationId);
    }

    public static class Builder {
        private String localizationId;
        private String registeredName;
        private String province;
        private String country;
        private String postalCode;

        public Builder localizationId(String localizationId) {
            this.localizationId = localizationId;
            return this;
        }


        public Builder registeredName(String registeredName) {
            this.registeredName = registeredName;
            return this;
        }

        public Builder province(String province) {
            this.province = province;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder copy(Locality locality) {
            this.localizationId = locality.localizationId;
            this.province = locality.province;
            this.country = locality.country;
            this.postalCode = locality.postalCode;
            return this;
        }

        public Locality build() {
            return new Locality(this);
        }
    }
}
