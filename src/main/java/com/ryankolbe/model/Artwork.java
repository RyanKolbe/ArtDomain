package com.ryankolbe.model;

import java.util.Objects;

public class Artwork implements Comparable<Artwork> {
    private String artworkId;
    private ArtForm artForm;
    private Dimension dimension;
    private Calendar calendar;

    private Artwork() {
    }

    private Artwork(Builder builder) {
        this.artworkId = builder.artworkId;
        this.artForm = builder.artForm;
        this.calendar = builder.calendar;
        this.dimension = builder.dimension;
    }

    public String getArtworkId() {
        return artworkId;
    }

    public ArtForm getArtForm() {
        return artForm;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artwork)) return false;
        Artwork artwork = (Artwork) o;
        return getArtworkId().equals(artwork.getArtworkId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArtworkId());
    }

    @Override
    public String toString() {
        return "Artwork{" +
                "artworkId='" + artworkId + '\'' +
                ", artForm=" + artForm +
                ", dimension=" + dimension +
                ", calendar=" + calendar +
                '}';
    }

    @Override
    public int compareTo(Artwork artwork) {
        return this.artworkId.compareToIgnoreCase(artwork.artworkId);
    }

    public static class Builder {
        private String artworkId;
        private ArtForm artForm;
        private Dimension dimension;
        private Calendar calendar;

        public Builder artworkId(String artworkId) {
            this.artworkId = artworkId;
            return this;
        }

        public Builder artForm(ArtForm artForm) {
            this.artForm = artForm;
            return this;
        }

        public Builder dimension(Dimension dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder calendar(Calendar calendar) {
            this.calendar = calendar;
            return this;
        }

        public Builder copy(Artwork artwork) {
            this.artworkId = artwork.artworkId;
            this.artForm = artwork.artForm;
            this.dimension = artwork.dimension;
            this.calendar = artwork.calendar;
            return this;
        }

        public Artwork build() {
            return new Artwork(this);
        }
    }
}