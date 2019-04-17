package com.ryankolbe.model;

import java.util.Objects;

public class Artist {

    private String id;
    private String name;
    private int age;
    private String location;

    private Artist() {
    }

    private Artist(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.location = builder.location;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return age == artist.age &&
                id.equals(artist.id) &&
                name.equals(artist.name) &&
                location.equals(artist.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, location);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", location='" + location + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String name;
        private int age;
        private String location;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Artist build() {
            return new Artist(this);
        }
    }
}