package com.ryankolbe.model;

import java.util.Objects;

public class Role {
    private String roleId;
    private String roleTitle;
    private String roleDescription;

    private Role() {
    }

    private Role(Builder builder) {
        this.roleId = builder.roleId;
        this.roleTitle = builder.roleTitle;
        this.roleDescription = builder.roleDescription;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return getRoleId().equals(role.getRoleId()) &&
                getRoleTitle().equals(role.getRoleTitle()) &&
                getRoleDescription().equals(role.getRoleDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoleId(), getRoleTitle(), getRoleDescription());
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", roleTitle='" + roleTitle + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                '}';
    }

    public static class Builder {
        private String roleId;
        private String roleTitle;
        private String roleDescription;


        public Builder roleId(String roleId) {
            this.roleId = roleId;
            return this;
        }

        public Builder roleTitle(String roleTitle) {
            this.roleTitle = roleTitle;
            return this;
        }

        public Builder roleDescription(String roleDescription) {
            this.roleDescription = roleDescription;
            return this;
        }

        public Role build() {
            return new Role(this);
        }
    }
}
