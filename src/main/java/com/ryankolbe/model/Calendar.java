package com.ryankolbe.model;

import java.util.Objects;

public class Calendar {
    private String date;
    private String year;

    private Calendar() {
    }

    private Calendar(Builder builder) {
        this.date = builder.date;
        this.year = builder.year;
    }

    public String getDate() {
        return date;
    }

    public String getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Calendar)) return false;
        Calendar calendar = (Calendar) o;
        return getDate().equals(calendar.getDate()) &&
                getYear().equals(calendar.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getYear());
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "date='" + date + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    public static class Builder {
        private String date;
        private String year;

        public Builder date(String date) {
            this.date = date;
            return this;
        }

        public Builder year(String year) {
            this.year = year;
            return this;
        }

        public Calendar build() {
            return new Calendar(this);
        }
    }
}