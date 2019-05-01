package com.ryankolbe.model;

import java.util.Objects;

public class Dimension implements Comparable<Dimension> {
    private String height;
    private String width;
    private String length;

    private Dimension() {
    }

    private Dimension(Builder builder) {
        this.height = builder.height;
        this.width = builder.width;
        this.length = builder.length;
    }

    public String getHeight() {
        return height;
    }

    public String getWidth() {
        return width;
    }

    public String getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dimension)) return false;
        Dimension dimension = (Dimension) o;
        return getHeight().equals(dimension.getHeight()) &&
                getWidth().equals(dimension.getWidth()) &&
                getLength().equals(dimension.getLength());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeight(), getWidth(), getLength());
    }

    @Override
    public String toString() {
        return "Dimension{" +
                "height='" + height + '\'' +
                ", width='" + width + '\'' +
                ", length='" + length + '\'' +
                '}';
    }

    @Override
    public int compareTo(Dimension dimension) {
        return this.height.compareToIgnoreCase(dimension.height);
    }

    public static class Builder {
        private String height;
        private String width;
        private String length;

        public Builder height(String height) {
            this.height = height;
            return this;
        }

        public Builder width(String width) {
            this.width = width;
            return this;
        }

        public Builder length(String length) {
            this.length = length;
            return this;
        }

        public Builder copy(Dimension dimension) {
            this.height = dimension.height;
            this.width = dimension.width;
            this.length = dimension.length;
            return this;
        }

        public Dimension build() {
            return new Dimension(this);
        }
    }
}
