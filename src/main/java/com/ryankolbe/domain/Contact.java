package com.ryankolbe.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Contact implements Comparable<Contact> {
    @Id
    private String contactId;
    private String contactEmail;
    private String contactCell;
    private String contactLandLine;

    private Contact() {
    }

    private Contact(Builder builder) {
        this.contactId = builder.contactId;
        this.contactEmail = builder.contactEmail;
        this.contactCell = builder.contactCell;
        this.contactLandLine = builder.contactLandLine;
    }

    public String getContactId() {
        return contactId;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactCell() {
        return contactCell;
    }

    public String getContactLandLine() {
        return contactLandLine;
    }

    @Override
    public int compareTo(Contact contact) {
        return this.contactId.compareToIgnoreCase(contact.contactId);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId='" + contactId + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactCell='" + contactCell + '\'' +
                ", contactLandLine='" + contactLandLine + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return getContactId().equals(contact.getContactId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContactId());
    }

    public static class Builder {
        private String contactId;
        private String contactEmail;
        private String contactCell;
        private String contactLandLine;

        public Builder contactId(String contactId) {
            this.contactId = contactId;
            return this;
        }

        public Builder contactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
            return this;
        }

        public Builder contactCell(String contactCell) {
            this.contactCell = contactCell;
            return this;
        }

        public Builder contactLandLine(String contactLandLine) {
            this.contactLandLine = contactLandLine;
            return this;
        }

        public Builder copy(Contact contact) {
            this.contactId = contact.contactId;
            this.contactEmail = contact.contactEmail;
            this.contactCell = contact.contactCell;
            this.contactLandLine = contact.contactLandLine;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }
}