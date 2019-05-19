package com.ryankolbe.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Exhibition implements Comparable<Exhibition> {
    private String exhibitionId;
    private String exhibitionName;
    private LocalDate exhibitionStartDate;
    private LocalDate exhibitionEndDate;

    private Exhibition() {
    }

    private Exhibition(Builder builder) {
        this.exhibitionId = builder.exhibitionId;
        this.exhibitionName = builder.exhibitionName;
        this.exhibitionStartDate = builder.exhibitionStartDate;
        this.exhibitionEndDate = builder.exhibitionEndDate;
    }

    public String getExhibitionId() {
        return exhibitionId;
    }

    public String getExhibitionName() {
        return exhibitionName;
    }

    public LocalDate getExhibitionStartDate() {
        return exhibitionStartDate;
    }

    public LocalDate getExhibitionEndDate() {
        return exhibitionEndDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exhibition)) return false;
        Exhibition that = (Exhibition) o;
        return getExhibitionId().equals(that.getExhibitionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExhibitionId());
    }

    @Override
    public String toString() {
        return "Exhibition{" +
                "exhibitionId='" + exhibitionId + '\'' +
                ", exhibitionName='" + exhibitionName + '\'' +
                ", exhibitionStartDate=" + exhibitionStartDate +
                ", exhibitionEndDate=" + exhibitionEndDate +
                '}';
    }

    @Override
    public int compareTo(Exhibition exhibition) {
        return this.exhibitionId.compareToIgnoreCase(exhibition.exhibitionId);
    }

    public static class Builder {
        private String exhibitionId;
        private String exhibitionName;
        private LocalDate exhibitionStartDate;
        private LocalDate exhibitionEndDate;

        public Builder exhibitionId(String exhibitionId) {
            this.exhibitionId = exhibitionId;
            return this;
        }

        public Builder exhibitionName(String exhibitionName) {
            this.exhibitionName = exhibitionName;
            return this;
        }

        public Builder exhibitionStartDate(LocalDate exhibitionStartDate) {
            this.exhibitionStartDate = exhibitionStartDate;
            return this;
        }

        public Builder exhibitionEndDate(LocalDate exhibitionEndDate) {
            this.exhibitionEndDate = exhibitionEndDate;
            return this;
        }

        public Builder copy(Exhibition exhibition) {
            this.exhibitionId = exhibition.exhibitionId;
            this.exhibitionName = exhibition.exhibitionName;
            this.exhibitionStartDate = exhibition.exhibitionStartDate;
            this.exhibitionEndDate = exhibition.exhibitionEndDate;
            return this;
        }

        public Exhibition build() {
            return new Exhibition(this);
        }
    }
}