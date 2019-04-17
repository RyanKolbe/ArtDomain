package com.ryankolbe.model;

import java.util.Objects;

public class Exhibit {
    private String id;
    private String startDate;
    private String endDate;

    private Exhibit() {
    }

    private Exhibit(Builder builder) {
        this.id = builder.id;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    public String getId() {
        return id;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exhibit)) return false;
        Exhibit exhibit = (Exhibit) o;
        return getId().equals(exhibit.getId()) &&
                getStartDate().equals(exhibit.getStartDate()) &&
                getEndDate().equals(exhibit.getEndDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStartDate(), getEndDate());
    }

    @Override
    public String toString() {
        return "Exhibit{" +
                "id='" + id + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String startDate;
        private String endDate;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public Exhibit build() {
            return new Exhibit(this);
        }
    }
}