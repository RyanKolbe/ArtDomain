package com.ryankolbe.domain;

import java.util.Objects;

public class Permission implements Comparable<Permission> {
    private String permissionId;
    private String permissionRole;
    private String permissionTitle;

    private Permission() {
    }

    private Permission(Builder builder) {
        this.permissionId = builder.permissionId;
        this.permissionRole = builder.permissionRole;
        this.permissionTitle = builder.permissionTitle;
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

        public Builder permissionId(String permissionId) {
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

        public Builder copy(Permission permission) {
            this.permissionId = permission.permissionId;
            this.permissionRole = permission.permissionRole;
            this.permissionTitle = permission.permissionTitle;
            return this;
        }

        public Permission build() {
            return new Permission(this);
        }
    }
}