package com.ryankolbe.domain;

import java.util.Objects;

public class Gallery implements Comparable<Gallery> {
    private String galleryId;
    private String galleryName;
    private String gallerySize;

    private Gallery() {
    }

    private Gallery(Builder builder) {
        this.galleryId = builder.galleryId;
        this.galleryName = builder.galleryName;
        this.gallerySize = builder.gallerySize;
    }

    public String getGalleryId() {
        return galleryId;
    }

    public String getGalleryName() {
        return galleryName;
    }

    public String getGallerySize() {
        return gallerySize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gallery)) return false;
        Gallery gallery = (Gallery) o;
        return getGalleryId().equals(gallery.getGalleryId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGalleryId());
    }

    @Override
    public String toString() {
        return "Gallery{" +
                "galleryId='" + galleryId + '\'' +
                ", galleryName='" + galleryName + '\'' +
                ", gallerySize='" + gallerySize + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gallery gallery) {
        return this.galleryId.compareToIgnoreCase(gallery.galleryId);
    }

    public static class Builder {
        private String galleryId;
        private String galleryName;
        private String gallerySize;

        public Builder galleryId(String galleryId) {
            this.galleryId = galleryId;
            return this;
        }

        public Builder galleryName(String galleryName) {
            this.galleryName = galleryName;
            return this;
        }

        public Builder gallerySize(String gallerySize) {
            this.gallerySize = gallerySize;
            return this;
        }

        public Builder copy(Gallery gallery) {
            this.galleryId = gallery.galleryId;
            this.galleryName = gallery.galleryName;
            this.gallerySize = gallery.gallerySize;
            return this;
        }

        public Gallery build() {
            return new Gallery(this);
        }
    }
}
