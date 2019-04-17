package com.ryankolbe.model;

import java.util.Objects;

public class User {
    private String id;
    private String userName;
    private String userEmail;
    private String userRole;
    private String dob;

    private User() {
    }

    private User(Builder builder) {
        this.id = builder.id;
        this.userName = builder.userName;
        this.userEmail = builder.userEmail;
        this.userRole = builder.userRole;
        this.dob = builder.dob;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserRole() {
        return userRole;
    }

    public String getDob() {
        return dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId()) &&
                getUserName().equals(user.getUserName()) &&
                getUserEmail().equals(user.getUserEmail()) &&
                getUserRole().equals(user.getUserRole()) &&
                getDob().equals(user.getDob());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getUserEmail(), getUserRole(), getDob());
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userRole='" + userRole + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String userName;
        private String userEmail;
        private String userRole;
        private String dob;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder userEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public Builder userRole(String userRole) {
            this.userRole = userRole;
            return this;
        }

        public Builder dob(String dob) {
            this.dob = dob;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
