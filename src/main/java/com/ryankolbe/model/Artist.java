package com.ryankolbe.model;

import java.util.Objects;

public class Artist {
    private String artistId;
    private Name name;
    private Address address;
    private Locality locality;
    private Contact contact;

    private Artist() {
    }

    private Artist(Builder builder) {
        this.artistId = builder.artistId;
        this.name = builder.name;
        this.address = builder.address;
        this.locality = builder.locality;
        this.contact = builder.contact;
    }

    public String getArtistId() {
        return artistId;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Locality getLocality() {
        return locality;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artist)) return false;
        Artist artist = (Artist) o;
        return getArtistId().equals(artist.getArtistId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArtistId());
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistId='" + artistId + '\'' +
                ", name=" + name +
                ", address=" + address +
                ", locality=" + locality +
                ", contact=" + contact +
                '}';
    }

    public static class Builder {
        private String artistId;
        private Name name;
        private Address address;
        private Locality locality;
        private Contact contact;

        public Builder artistId(String artistId) {
            this.artistId = artistId;
            return this;
        }

        public Builder name(Name name) {
            this.name = name;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }
        public Builder locality(Locality locality){
            this.locality = locality;
            return this;
        }

        public Builder contact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder copy(Artist artist) {
            this.artistId = artist.artistId;
            this.name = artist.name;
            this.address = artist.address;
            this.locality = artist.locality;
            this.contact = artist.contact;
            return this;
        }

        public Artist build() {
            return new Artist(this);
        }
    }
}