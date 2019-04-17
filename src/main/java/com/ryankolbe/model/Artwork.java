package com.ryankolbe.model;

import java.util.Objects;

public class Artwork {
    private String id;
    private String year;
    private String date;

    private Artwork() {
    }

    private Artwork(Builder builder) {
        this.id = builder.id;
        this.year = builder.year;
        this.date = builder.date;
    }

    public String getId() {
        return id;
    }

    public String getYear() {
        return year;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artwork)) return false;
        Artwork artwork = (Artwork) o;
        return getId().equals(artwork.getId()) &&
                getYear().equals(artwork.getYear()) &&
                getDate().equals(artwork.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getYear(), getDate());
    }

    @Override
    public String toString() {
        return "Artwork{" +
                "id='" + id + '\'' +
                ", year='" + year + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String year;
        private String date;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder year(String year) {
            this.year = year;
            return this;
        }

        public Builder date(String date) {
            this.date = date;
            return this;
        }

        public Artwork build() {
            return new Artwork(this);
        }
    }
}