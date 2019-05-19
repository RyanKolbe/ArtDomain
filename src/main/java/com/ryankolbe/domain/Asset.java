package com.ryankolbe.domain;

import java.util.Objects;

public class Asset implements Comparable<Asset> {
    private String assetId;
    private String assetNumber;
    private String assetModel;
    private double assetValue;

    private Asset() {
    }

    private Asset(Builder builder) {
        this.assetId = builder.assetId;
        this.assetNumber = builder.assetNumber;
        this.assetModel = builder.assetModel;
        this.assetValue = builder.assetValue;
    }

    public String getAssetId() {
        return assetId;
    }

    public String getAssetNumber() {
        return assetNumber;
    }

    public String getAssetModel() {
        return assetModel;
    }

    public double getAssetValue() {
        return assetValue;
    }

    @Override
    public int compareTo(Asset asset) {
        return this.assetId.compareToIgnoreCase(asset.assetId);
    }

    @Override
    public String toString() {
        return "Asset{" +
                "assetId='" + assetId + '\'' +
                ", assetNumber='" + assetNumber + '\'' +
                ", assetModel='" + assetModel + '\'' +
                ", assetValue=" + assetValue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Asset)) return false;
        Asset asset = (Asset) o;
        return getAssetId().equals(asset.getAssetId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAssetId());
    }

    public static class Builder {
        private String assetId;
        private String assetNumber;
        private String assetModel;
        private double assetValue;

        public Builder assetId(String assetId) {
            this.assetId = assetId;
            return this;
        }

        public Builder assetNumber(String assetNumber) {
            this.assetNumber = assetNumber;
            return this;
        }

        public Builder assetModel(String assetModel) {
            this.assetModel = assetModel;
            return this;
        }

        public Builder assetValue(double assetValue) {
            this.assetValue = assetValue;
            return this;
        }

        public Builder copy(Asset asset) {
            this.assetId = asset.assetId;
            this.assetNumber = asset.assetNumber;
            this.assetModel = asset.assetModel;
            this.assetValue = asset.assetValue;
            return this;
        }

        public Asset build() {
            return new Asset(this);
        }
    }
}
