package com.ryankolbe.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Sculpture implements Comparable<Sculpture> {
    @Id
    private String sculptureId;
    private String sculptureName;
    private String sculptureType;

    private Sculpture() {
    }

    private Sculpture(Builder builder) {
        this.sculptureId = builder.sculptureId;
        this.sculptureName = builder.sculptureName;
        this.sculptureType = builder.sculptureType;
    }

    public String getSculptureId() {
        return sculptureId;
    }

    public String getSculptureName() {
        return sculptureName;
    }

    public String getSculptureType() {
        return sculptureType;
    }

    @Override
    public String toString() {
        return "Sculpture{" +
                "sculptureId='" + sculptureId + '\'' +
                ", sculptureName='" + sculptureName + '\'' +
                ", sculptureType='" + sculptureType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sculpture)) return false;
        Sculpture sculpture = (Sculpture) o;
        return getSculptureId().equals(sculpture.getSculptureId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSculptureId());
    }

    @Override
    public int compareTo(Sculpture sculpture) {
        return this.sculptureId.compareToIgnoreCase(sculpture.sculptureId);
    }

    public static class Builder {
        private String sculptureId;
        private String sculptureName;
        private String sculptureType;

        public Builder sculptureId(String sculptureId) {
            this.sculptureId = sculptureId;
            return this;
        }

        public Builder sculptureName(String sculptureName) {
            this.sculptureName = sculptureName;
            return this;
        }

        public Builder sculpureType(String sculptureType) {
            this.sculptureType = sculptureType;
            return this;
        }

        public Builder copy(Sculpture sculpture) {
            this.sculptureId = sculpture.sculptureId;
            this.sculptureName = sculpture.sculptureName;
            this.sculptureType = sculpture.sculptureType;
            return this;
        }

        public Sculpture build() {
            return new Sculpture(this);
        }
    }
}