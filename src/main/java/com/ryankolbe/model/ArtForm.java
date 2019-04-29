package com.ryankolbe.model;

import java.util.Objects;

public class ArtForm {
    private String artFormId;
    private String artFormType;
    private String artFormStyle;

    private ArtForm() {
    }

    private ArtForm(Builder builder) {
        this.artFormId = builder.artFormId;
        this.artFormType = builder.artFormType;
        this.artFormStyle = builder.artFormStyle;
    }

    public String getArtFormId() {
        return artFormId;
    }

    public String getArtFormType() {
        return artFormType;
    }

    public String getArtFormStyle() {
        return artFormStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArtForm)) return false;
        ArtForm artform = (ArtForm) o;
        return getArtFormId().equals(artform.getArtFormId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArtFormId());
    }

    @Override
    public String toString() {
        return "ArtForm{" +
                "artFormId='" + artFormId + '\'' +
                ", artFormType='" + artFormType + '\'' +
                ", artFormStyle='" + artFormStyle + '\'' +
                '}';
    }

    public static class Builder {
        private String artFormId;
        private String artFormType;
        private String artFormStyle;

        public Builder artFormId(String artFormId) {
            this.artFormId = artFormId;
            return this;
        }

        public Builder artFormType(String artFormType) {
            this.artFormType = artFormType;
            return this;
        }

        public Builder artFormStyle(String artFormStyle) {
            this.artFormStyle = artFormStyle;
            return this;
        }

        public Builder copy(ArtForm artform) {
            this.artFormId = artform.artFormId;
            this.artFormType = artform.artFormType;
            this.artFormStyle = artform.artFormStyle;
            return this;
        }

        public ArtForm build() {
            return new ArtForm(this);
        }
    }
}
