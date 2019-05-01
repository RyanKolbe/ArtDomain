package com.ryankolbe.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.util.Objects;

public class Calendar implements Comparable<Calendar> {
    private LocalDate date;
    private LocalTime time;
    private Year year;

    private Calendar() {
    }

    private Calendar(Builder builder) {
        this.date = builder.date;
        this.time = builder.time;
        this.year = builder.year;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public Year getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "date=" + date +
                ", time=" + time +
                ", year=" + year +
                '}';
    }

    @Override
    public int compareTo(Calendar calendar) {
        return this.date.compareTo(calendar.date);
    }

    public static class Builder {
        private LocalDate date;
        private LocalTime time;
        private Year year;

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder time(LocalTime time) {
            this.time = time;
            return this;
        }

        public Builder year(Year year) {
            this.year = year;
            return this;
        }

        public Builder copy(Calendar calendar) {
            this.date = calendar.date;
            this.time = calendar.time;
            this.year = calendar.year;
            return this;
        }

        public Calendar build() {
            return new Calendar(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Builder)) return false;
            Builder builder = (Builder) o;
            return date.equals(builder.date) &&
                    time.equals(builder.time) &&
                    year.equals(builder.year);
        }

        @Override
        public int hashCode() {
            return Objects.hash(date, time, year);
        }
    }
}
