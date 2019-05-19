package com.ryankolbe.domain;

import java.util.Objects;

public class Admin implements Comparable<Admin> {
    private String adminId;
    private String adminLogin;
    private String adminPassword;

    private Admin() {
    }

    private Admin(Builder builder) {
        this.adminId = builder.adminId;
        this.adminLogin = builder.adminLogin;
        this.adminPassword = builder.adminPassword;
    }

    public String getAdminId() {
        return adminId;
    }

    public String getAdminLogin() {
        return adminLogin;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin)) return false;
        Admin admin = (Admin) o;
        return getAdminId().equals(admin.getAdminId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAdminId());
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", adminLogin='" + adminLogin + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }

    @Override
    public int compareTo(Admin admin) {
        return this.adminId.compareToIgnoreCase(admin.adminId);
    }

    public static class Builder {
        private String adminId;
        private String adminLogin;
        private String adminPassword;

        public Builder adminId(String adminId) {
            this.adminId = adminId;
            return this;
        }

        public Builder adminLogin(String adminLogin) {
            this.adminLogin = adminLogin;
            return this;
        }

        public Builder adminPassword(String adminPassword) {
            this.adminPassword = adminPassword;
            return this;
        }

        public Builder copy(Admin admin) {
            this.adminId = admin.adminId;
            this.adminLogin = admin.adminLogin;
            this.adminPassword = admin.adminPassword;
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }
}