package com.ryankolbe.model;

import java.util.Objects;

public class Painting {
    private String id;
    private String style;
    private String type;

    private Painting() {
    }

    private Painting(Builder builder) {
        this.id = builder.id;
        this.style = builder.style;
        this.type = builder.type;
    }

    public String getId() {
        return id;
    }

    public String getStyle() {
        return style;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Painting)) return false;
        Painting painting = (Painting) o;
        return getId().equals(painting.getId()) &&
                getStyle().equals(painting.getStyle()) &&
                getType().equals(painting.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStyle(), getType());
    }

    @Override
    public String toString() {
        return "Painting{" +
                "id='" + id + '\'' +
                ", style='" + style + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String style;
        private String type;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder style(String style) {
            this.style = style;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Painting build() {
            return new Painting(this);
        }
    }
}
