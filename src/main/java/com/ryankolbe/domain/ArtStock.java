package com.ryankolbe.domain;

import java.util.Objects;

public class ArtStock implements Comparable<ArtStock> {
    private String artStockId;
    private String artStockName;
    private int artStockQty;
    private String artStockType;

    private ArtStock() {
    }

    private ArtStock(Builder builder) {
        this.artStockId = builder.artStockId;
        this.artStockName = builder.artStockName;
        this.artStockQty = builder.artStockQty;
        this.artStockType = builder.artStockType;
    }

    public String getArtStockId() {
        return artStockId;
    }

    public String getArtStockName() {
        return artStockName;
    }

    public int getArtStockQty() {
        return artStockQty;
    }

    public String getArtStockType() {
        return artStockType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArtStock)) return false;
        ArtStock artStock = (ArtStock) o;
        return getArtStockId().equals(artStock.getArtStockId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArtStockId());
    }

    @Override
    public String toString() {
        return "ArtStock{" +
                "artStockId='" + artStockId + '\'' +
                ", artStockName='" + artStockName + '\'' +
                ", artStockQty=" + artStockQty +
                ", artStockType='" + artStockType + '\'' +
                '}';
    }

    @Override
    public int compareTo(ArtStock artStock) {
        return this.artStockId.compareToIgnoreCase(artStock.artStockId);
    }

    public static class Builder {
        private String artStockId;
        private String artStockName;
        private int artStockQty;
        private String artStockType;

        public Builder artStockId(String artStockId) {
            this.artStockId = artStockId;
            return this;
        }

        public Builder artStockName(String artStockName) {
            this.artStockName = artStockName;
            return this;
        }

        public Builder artStockQty(int artStockQty) {
            this.artStockQty = artStockQty;
            return this;
        }

        public Builder artStockType(String artStockType) {
            this.artStockType = artStockType;
            return this;
        }

        public Builder copy(ArtStock artStock) {
            this.artStockId = artStock.artStockId;
            this.artStockName = artStock.artStockName;
            this.artStockQty = artStock.artStockQty;
            this.artStockType = artStock.artStockType;
            return this;
        }

        public ArtStock build() {
            return new ArtStock(this);
        }
    }
}
