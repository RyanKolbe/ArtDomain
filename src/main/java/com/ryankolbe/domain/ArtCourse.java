package com.ryankolbe.domain;

import java.util.Objects;

public class ArtCourse implements Comparable<ArtCourse> {
    private String artCourseId;
    private String artCourseName;
    private boolean artCourseAvailable;

    private ArtCourse() {
    }

    private ArtCourse(Builder builder) {
        this.artCourseId = builder.artCourseId;
        this.artCourseName = builder.artCourseName;
        this.artCourseAvailable = builder.artCourseAvailable;
    }

    public String getArtCourseId() {
        return artCourseId;
    }

    public String getArtCourseName() {
        return artCourseName;
    }

    public boolean isArtCourseAvailable() {
        return artCourseAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArtCourse)) return false;
        ArtCourse artCourse = (ArtCourse) o;
        return getArtCourseId().equals(artCourse.getArtCourseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArtCourseId());
    }

    @Override
    public String toString() {
        return "ArtCourse{" +
                "artCourseId='" + artCourseId + '\'' +
                ", artCourseName='" + artCourseName + '\'' +
                ", artCourseAvailable=" + artCourseAvailable +
                '}';
    }

    @Override
    public int compareTo(ArtCourse artCourse) {
        return this.artCourseId.compareToIgnoreCase(artCourse.artCourseId);
    }

    public static class Builder {
        private String artCourseId;
        private String artCourseName;
        private boolean artCourseAvailable;

        public Builder artCourseId(String artCourseId) {
            this.artCourseId = artCourseId;
            return this;
        }

        public Builder artCourseName(String artCourseName) {
            this.artCourseName = artCourseName;
            return this;
        }

        public Builder artCourseAvailable(boolean artCourseAvailable) {
            this.artCourseAvailable = artCourseAvailable;
            return this;
        }

        public Builder copy(ArtCourse artCourse) {
            this.artCourseId = artCourse.artCourseId;
            this.artCourseName = artCourse.artCourseName;
            this.artCourseAvailable = artCourse.artCourseAvailable;
            return this;
        }

        public ArtCourse build() {
            return new ArtCourse(this);
        }
    }
}