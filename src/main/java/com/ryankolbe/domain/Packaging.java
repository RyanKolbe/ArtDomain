package com.ryankolbe.domain;

import java.util.Objects;

public class Packaging implements Comparable<Packaging> {
    private String packagingId;
    private String packagingHeight;
    private String packagingWidth;
    private String packagingLength;

    private Packaging() {
    }

    private Packaging(Builder builder) {
        this.packagingId = builder.packagingId;
        this.packagingHeight = builder.packagingHeight;
        this.packagingWidth = builder.packagingWidth;
        this.packagingLength = builder.packagingLength;
    }

    public String getPackagingId() {
        return packagingId;
    }

    public String getPackagingHeight() {
        return packagingHeight;
    }

    public String getPackagingWidth() {
        return packagingWidth;
    }

    public String getPackagingLength() {
        return packagingLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Packaging)) return false;
        Packaging packaging = (Packaging) o;
        return getPackagingHeight().equals(packaging.getPackagingHeight()) &&
                getPackagingWidth().equals(packaging.getPackagingWidth()) &&
                getPackagingLength().equals(packaging.getPackagingLength());
    }

    @Override
    public int hashCode() {
        return Objects.hash(packagingId);
    }

    @Override
    public String toString() {
        return "Packaging{" +
                "packagingId='" + packagingId + '\'' +
                ", packagingHeight='" + packagingHeight + '\'' +
                ", packagingWidth='" + packagingWidth + '\'' +
                ", packagingLength='" + packagingLength + '\'' +
                '}';
    }

    @Override
    public int compareTo(Packaging packaging) {
        return this.packagingHeight.compareToIgnoreCase(packaging.packagingHeight);
    }

    public static class Builder {
        private String packagingId;
        private String packagingHeight;
        private String packagingWidth;
        private String packagingLength;

        public Builder packagingId(String packagingId) {
            this.packagingId = packagingId;
            return this;
        }

        public Builder packagingHeight(String packagingHeight) {
            this.packagingHeight = packagingHeight;
            return this;
        }

        public Builder packagingWidth(String packagingWidth) {
            this.packagingWidth = packagingWidth;
            return this;
        }

        public Builder packagingLength(String packagingLength) {
            this.packagingLength = packagingLength;
            return this;
        }

        public Builder copy(Packaging packaging) {
            this.packagingId = packaging.packagingId;
            this.packagingHeight = packaging.packagingHeight;
            this.packagingWidth = packaging.packagingWidth;
            this.packagingLength = packaging.packagingLength;
            return this;
        }

        public Packaging build() {
            return new Packaging(this);
        }
    }
}