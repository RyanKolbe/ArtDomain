package com.ryankolbe.model;

import java.util.Objects;

public class Permission implements Comparable<Permission> {
    private String permissionId;
    private String permissionRole;
    private String permissionTitle;
    private String permissionModule;
    private String permissionDescription;

    private Permission() {
    }

    private Permission(Builder builder) {
        this.permissionId = builder.permissionId;
        this.permissionRole = builder.permissionRole;
        this.permissionTitle = builder.permissionTitle;
        this.permissionModule = builder.permissionModule;
        this.permissionDescription = builder.permissionDescription;
    }

    public String getPermissionId() {
        return permissionId;
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
        return getPermissionId().equals(that.getPermissionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPermissionId());
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId='" + permissionId + '\'' +
                ", permissionRole='" + permissionRole + '\'' +
                ", permissionTitle='" + permissionTitle + '\'' +
                ", permissionModule='" + permissionModule + '\'' +
                ", permissionDescription='" + permissionDescription + '\'' +
                '}';
    }

    @Override
    public int compareTo(Permission permission) {
        return this.permissionId.compareToIgnoreCase(permission.permissionId);
    }

    public static class Builder {
        private String permissionId;
        private String permissionRole;
        private String permissionTitle;
        private String permissionModule;
        private String permissionDescription;

        public Builder id(String permissionId) {
            this.permissionId = permissionId;
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

        public Builder copy(Permission permission) {
            this.permissionId = permission.permissionId;
            this.permissionRole = permission.permissionRole;
            this.permissionTitle = permission.permissionTitle;
            this.permissionModule = permission.permissionModule;
            this.permissionDescription = permission.permissionDescription;
            return this;
        }

        public Permission build() {
            return new Permission(this);
        }
    }
}