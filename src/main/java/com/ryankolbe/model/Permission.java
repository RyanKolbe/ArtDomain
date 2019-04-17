package com.ryankolbe.model;

import java.util.Objects;

public class Permission {
    private String id;
    private String permissionRole;
    private String permissionTitle;
    private String permissionModule;
    private String permissionDescription;

    private Permission() {
    }

    private Permission(Builder builder) {
        this.id = builder.id;
        this.permissionRole = builder.permissionRole;
        this.permissionTitle = builder.permissionTitle;
        this.permissionModule = builder.permissionModule;
        this.permissionDescription = builder.permissionDescription;
    }

    public String getId() {
        return id;
    }

    public String getPermissionRole() {
        return permissionRole;
    }

    public String getPermissionTitle() {
        return permissionTitle;
    }

    public String getPermissionModule() {
        return permissionModule;
    }

    public String getPermissionDescription() {
        return permissionDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permission)) return false;
        Permission that = (Permission) o;
        return getId().equals(that.getId()) &&
                getPermissionRole().equals(that.getPermissionRole()) &&
                getPermissionTitle().equals(that.getPermissionTitle()) &&
                getPermissionModule().equals(that.getPermissionModule()) &&
                getPermissionDescription().equals(that.getPermissionDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPermissionRole(), getPermissionTitle(), getPermissionModule(), getPermissionDescription());
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", permissionRole='" + permissionRole + '\'' +
                ", permissionTitle='" + permissionTitle + '\'' +
                ", permissionModule='" + permissionModule + '\'' +
                ", permissionDescription='" + permissionDescription + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String permissionRole;
        private String permissionTitle;
        private String permissionModule;
        private String permissionDescription;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder permissionRole(String permissionRole) {
            this.permissionRole = permissionRole;
            return this;
        }

        public Builder permissionTitle(String permissionTitle) {
            this.permissionTitle = permissionTitle;
            return this;
        }

        public Builder permissionModule(String permissionModule) {
            this.permissionModule = permissionModule;
            return this;
        }

        public Builder permissionDescription(String permissionDescription) {
            this.permissionDescription = permissionDescription;
            return this;
        }

        public Permission build() {
            return new Permission(this);
        }
    }
}
