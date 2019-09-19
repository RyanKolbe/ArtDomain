package com.ryankolbe.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Event implements Comparable<Event> {
    @Id
    private String eventId;
    private String eventName;
    private LocalDate eventDate;
    private LocalTime eventTime;

    private Event() {
    }

    private Event(Builder builder) {
        this.eventId = builder.eventId;
        this.eventName = builder.eventName;
        this.eventDate = builder.eventDate;
        this.eventTime = builder.eventTime;
    }

    public String getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    @Override
    public int compareTo(Event event) {
        return this.eventId.compareToIgnoreCase(event.eventId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return getEventId().equals(event.getEventId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEventId());
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + eventId + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventDate=" + eventDate +
                ", eventTime=" + eventTime +
                '}';
    }

    public static class Builder {
        private String eventId;
        private String eventName;
        private LocalDate eventDate;
        private LocalTime eventTime;

        public Builder eventId(String eventId) {
            this.eventId = eventId;
            return this;
        }

        public Builder eventName(String eventName) {
            this.eventName = eventName;
            return this;
        }

        public Builder eventDate(LocalDate eventDate) {
            this.eventDate = eventDate;
            return this;
        }

        public Builder eventTime(LocalTime eventTime) {
            this.eventTime = eventTime;
            return this;
        }

        public Builder copy(Event event) {
            this.eventId = event.eventId;
            this.eventName = event.eventName;
            this.eventDate = event.eventDate;
            this.eventTime = event.eventTime;
            return this;
        }

        public Event build() {
            return new Event(this);
        }
    }
}
