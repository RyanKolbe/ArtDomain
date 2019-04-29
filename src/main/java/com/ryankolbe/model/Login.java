package com.ryankolbe.model;

import sun.security.util.Password;

import java.util.Objects;

public class Login implements Comparable<Login> {
    private String loginId;
    private String loginName;
    private String password;

    private Login() {
    }

    private Login(Builder builder) {
        this.loginId = builder.loginId;
        this.loginName = builder.loginName;
        this.password = builder.password;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Login)) return false;
        Login login = (Login) o;
        return getLoginId().equals(login.getLoginId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLoginId());
    }

    @Override
    public String toString() {
        return "Login{" +
                "loginId='" + loginId + '\'' +
                ", loginName=" + loginName +
                ", password=" + password +
                '}';
    }

    @Override
    public int compareTo(Login login) {
        return this.loginName.compareToIgnoreCase(login.loginName);
    }

    public static class Builder {
        private String loginId;
        private String loginName;
        private String password;

        public Builder loginId(String loginId) {
            this.loginId = loginId;
            return this;
        }

        public Builder loginName(String loginName) {
            this.loginName = loginName;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder copy(Login login) {
            this.loginId = login.loginId;
            this.loginName = login.loginName;
            this.password = login.password;
            return this;
        }

        public Login build() {
            return new Login(this);
        }
    }
}