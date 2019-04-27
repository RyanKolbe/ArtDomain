package com.ryankolbe.model;

import java.util.Objects;

public class Contact {
    private String contactId;
    private String contactNumber;
    private String contactNumberType;
    private String emailAddress;

    private Contact() {
    }

    private Contact(Builder builder) {
        this.contactId = builder.contactId;
        this.contactNumber = builder.contactNumber;
        this.contactNumberType = builder.contactNumberType;
        this.emailAddress = builder.emailAddress;
    }

    public String getContactId() {
        return contactId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getContactNumberType() {
        return contactNumberType;
    }

    public String getEmailAddress() {
        return emailAddress;
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

    @Override
    public String toString() {
        return "Contact{" +
                "contactId='" + contactId + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", contactNumberType='" + contactNumberType + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    public static class Builder {
        private String contactId;
        private String contactNumber;
        private String contactNumberType;
        private String emailAddress;

        public Builder contactId(String contactId) {
            this.contactId = contactId;
            return this;
        }

        public Builder contactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder contactNumberType(String contactNumberType) {
            this.contactNumberType = contactNumberType;
            return this;
        }

        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder copy(Contact contact) {
            this.contactId = contact.contactId;
            this.contactNumber = contact.contactNumber;
            this.contactNumberType = contact.contactNumberType;
            this.emailAddress = contact.emailAddress;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }
}
