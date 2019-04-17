package com.ryankolbe.model;

import java.util.Objects;

public class Gallery {
    private String galleryId;
    private String galleryName;
    private String galleryStreetNumber;
    private String galleryStreetName;
    private String galleryPostalCode;

    private Gallery() {
    }

    private Gallery(Builder builder) {
        this.galleryId = builder.galleryId;
        this.galleryName = builder.galleryName;
        this.galleryStreetNumber = builder.galleryStreetNumber;
        this.galleryStreetName = builder.galleryStreetName;
        this.galleryPostalCode = builder.galleryPostalCode;
    }

    public String getGalleryId() {
        return galleryId;
    }

    public String getGalleryName() {
        return galleryName;
    }

    public String getGalleryStreetNumber() {
        return galleryStreetNumber;
    }

    public String getGalleryStreetName() {
        return galleryStreetName;
    }

    public String getGalleryPostalCode() {
        return galleryPostalCode;
    }

    public static class Builder {
        private String galleryId;
        private String galleryName;
        private String galleryStreetNumber;
        private String galleryStreetName;
        private String galleryPostalCode;

        public Builder galleryId(String galleryId) {
            this.galleryId = galleryId;
            return this;
        }

        public Builder galleryName(String galleryName) {
            this.galleryName = galleryName;
            return this;
        }

        public Builder galleryAddress(String galleryStreetNumber) {
            this.galleryStreetNumber = galleryStreetNumber;
            return this;
        }

        public Builder galleryStreetName(String galleryStreetName) {
            this.galleryStreetName = galleryStreetName;
            return this;
        }

        public Builder galleryPostalCode(String galleryPostalCode) {
            this.galleryPostalCode = galleryPostalCode;
            return this;
        }

        public Gallery build() {
            return new Gallery(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Builder)) return false;
            Builder builder = (Builder) o;
            return galleryId.equals(builder.galleryId) &&
                    galleryName.equals(builder.galleryName) &&
                    galleryStreetNumber.equals(builder.galleryStreetNumber) &&
                    galleryPostalCode.equals(builder.galleryPostalCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(galleryId, galleryName, galleryStreetNumber, galleryPostalCode);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "galleryId='" + galleryId + '\'' +
                    ", galleryName='" + galleryName + '\'' +
                    ", galleryStreetNumber='" + galleryStreetNumber + '\'' +
                    ", galleryPostalCode='" + galleryPostalCode + '\'' +
                    '}';
        }
    }
}
