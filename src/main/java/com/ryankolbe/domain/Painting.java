package com.ryankolbe.domain;

import java.util.Objects;

public class Painting implements Comparable<Painting> {
    private String paintingId;
    private String paintingName;
    private String paintingType;

    private Painting() {
    }

    private Painting(Builder builder) {
        this.paintingId = builder.paintingId;
        this.paintingName = builder.paintingName;
        this.paintingType = builder.paintingType;
    }

    public String getPaintingId() {
        return paintingId;
    }

    public String getPaintingName() {
        return paintingName;
    }

    public String getPaintingType() {
        return paintingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Painting)) return false;
        Painting artform = (Painting) o;
        return getPaintingId().equals(artform.getPaintingId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaintingId());
    }

    @Override
    public String toString() {
        return "Painting{" +
                "paintingId='" + paintingId + '\'' +
                ", paintingName='" + paintingName + '\'' +
                ", paintingType='" + paintingType + '\'' +
                '}';
    }

    @Override
    public int compareTo(Painting painting) {
        return this.paintingName.compareToIgnoreCase(painting.paintingName);
    }

    public static class Builder {
        private String paintingId;
        private String paintingName;
        private String paintingType;

        public Builder paintingId(String paintingId) {
            this.paintingId = paintingId;
            return this;
        }

        public Builder paintingName(String paintingName) {
            this.paintingName = paintingName;
            return this;
        }

        public Builder paintingType(String paintingType) {
            this.paintingType = paintingType;
            return this;
        }

        public Builder copy(Painting painting) {
            this.paintingId = painting.paintingId;
            this.paintingName = painting.paintingName;
            this.paintingType = painting.paintingType;
            return this;
        }

        public Painting build() {
            return new Painting(this);
        }
    }
}