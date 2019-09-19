package com.ryankolbe.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Artist implements Comparable<Artist> {
    @Id
    private String artistId;
    private String artistName;
    private String artistSurname;

    private Artist() {
    }

    private Artist(Builder builder) {
        this.artistId = builder.artistId;
        this.artistName = builder.artistName;
        this.artistSurname = builder.artistSurname;
    }

    public String getArtistId() {
        return artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getArtistSurname() {
        return artistSurname;
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
                ", artistName='" + artistName + '\'' +
                ", artistSurname='" + artistSurname + '\'' +
                '}';
    }

    @Override
    public int compareTo(Artist artist) {
        return this.artistId.compareToIgnoreCase(artist.artistId);
    }

    public static class Builder {
        private String artistId;
        private String artistName;
        private String artistSurname;

        public Builder artistId(String artistId) {
            this.artistId = artistId;
            return this;
        }

        public Builder artistName(String artistName) {
            this.artistName = artistName;
            return this;
        }

        public Builder artistSurname(String artistSurname) {
            this.artistSurname = artistSurname;
            return this;
        }

        public Builder copy(Artist artist) {
            this.artistId = artist.artistId;
            this.artistName = artist.artistName;
            this.artistSurname = artist.artistSurname;
            return this;
        }

        public Artist build() {
            return new Artist(this);
        }
    }
}