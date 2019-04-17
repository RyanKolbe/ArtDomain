package com.ryankolbe.model;

import java.util.Objects;

public class Contact {
    private String id;
    private String contactMethod;
    private String contactDetails;

    private Contact() {
    }

    private Contact(Builder builder) {
        this.id = builder.id;
        this.contactMethod = builder.contactMethod;
        this.contactDetails = builder.contactDetails;
    }

    public String getId() {
        return id;
    }

    public String getContactMethod() {
        return contactMethod;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return getId().equals(contact.getId()) &&
                getContactMethod().equals(contact.getContactMethod()) &&
                getContactDetails().equals(contact.getContactDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getContactMethod(), getContactDetails());
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", contactMethod='" + contactMethod + '\'' +
                ", contactDetails='" + contactDetails + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String contactMethod;
        private String contactDetails;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder contactMethod(String contactMethod) {
            this.contactMethod = contactMethod;
            return this;
        }

        public Builder contactDetails(String contactDetails) {
            this.contactDetails = contactDetails;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }
}
