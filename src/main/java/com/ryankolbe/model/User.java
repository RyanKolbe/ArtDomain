package com.ryankolbe.model;

import java.util.Objects;

public class User implements Comparable<User> {
    private String userId;
    private Name name;
    private Contact contact;

    private User() {
    }

    private User(Builder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.contact = builder.contact;
    }

    public String getUserId() {
        return userId;
    }

    public Name getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUserId().equals(user.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId());
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name=" + name +
                ", contact=" + contact +
                '}';
    }

    @Override
    public int compareTo(User user) {
        return this.name.compareTo(user.name);
    }

    public static class Builder {
        private String userId;
        private Name name;
        private Contact contact;

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder name(Name name) {
            this.name = name;
            return this;
        }

        public Builder contact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder copy(User user) {
            this.userId = user.userId;
            this.name = user.name;
            this.contact = user.contact;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}