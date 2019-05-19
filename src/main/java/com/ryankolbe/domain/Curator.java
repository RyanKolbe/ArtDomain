package com.ryankolbe.domain;

import java.util.Objects;

public class Curator implements Comparable<Curator> {
    private String curatorId;
    private String curatorName;
    private String curatorSurname;

    private Curator() {
    }

    private Curator(Builder builder) {
        this.curatorId = builder.curatorId;
        this.curatorName = builder.curatorName;
        this.curatorSurname = builder.curatorSurname;
    }

    public String getCuratorId() {
        return curatorId;
    }

    public String getCuratorName() {
        return curatorName;
    }

    public String getCuratorSurname() {
        return curatorSurname;
    }

    @Override
    public int compareTo(Curator curator) {
        return this.curatorId.compareToIgnoreCase(curator.curatorId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curator)) return false;
        Curator curator = (Curator) o;
        return getCuratorId().equals(curator.getCuratorId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCuratorId());
    }

    @Override
    public String toString() {
        return "Curator{" +
                "curatorId='" + curatorId + '\'' +
                ", curatorName='" + curatorName + '\'' +
                ", curatorSurname='" + curatorSurname + '\'' +
                '}';
    }

    public static class Builder {
        private String curatorId;
        private String curatorName;
        private String curatorSurname;

        public Builder curatorId(String curatorId) {
            this.curatorId = curatorId;
            return this;
        }

        public Builder curatorName(String curatorName) {
            this.curatorName = curatorName;
            return this;
        }

        public Builder curatorSurname(String curatorSurname) {
            this.curatorSurname = curatorSurname;
            return this;
        }

        public Builder copy(Curator curator) {
            this.curatorId = curator.curatorId;
            this.curatorName = curator.curatorName;
            this.curatorSurname = curator.curatorSurname;
            return this;
        }

        public Curator build() {
            return new Curator(this);
        }
    }
}