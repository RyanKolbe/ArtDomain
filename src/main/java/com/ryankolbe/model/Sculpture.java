package com.ryankolbe.model;

import java.util.Objects;

public class Sculpture {
    private String id;
    private String material;
    private String height;
    private String weight;

    private Sculpture() {
    }

    private Sculpture(Builder builder) {
        this.id = builder.id;
        this.material = builder.material;
        this.height = builder.height;
        this.weight = builder.weight;
    }

    public String getId() {
        return id;
    }

    public String getMaterial() {
        return material;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sculpture)) return false;
        Sculpture sculpture = (Sculpture) o;
        return getId().equals(sculpture.getId()) &&
                getMaterial().equals(sculpture.getMaterial()) &&
                getHeight().equals(sculpture.getHeight()) &&
                getWeight().equals(sculpture.getWeight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMaterial(), getHeight(), getWeight());
    }

    @Override
    public String toString() {
        return "Sculpture{" +
                "id='" + id + '\'' +
                ", material='" + material + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String material;
        private String height;
        private String weight;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder material(String material) {
            this.material = material;
            return this;
        }

        public Builder height(String height) {
            this.height = height;
            return this;
        }

        public Builder weight(String weight) {
            this.weight = weight;
            return this;
        }

        public Sculpture build() {
            return new Sculpture(this);
        }
    }
}