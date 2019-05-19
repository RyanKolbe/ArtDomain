package com.ryankolbe.domain;

import java.util.Objects;

public class Account implements Comparable<Account> {
    private String accountId;
    private String accountNumber;
    private String accountName;
    private String accountCategory;

    private Account() {
    }

    private Account(Builder builder) {
        this.accountId = builder.accountId;
        this.accountNumber = builder.accountNumber;
        this.accountName = builder.accountName;
        this.accountCategory = builder.accountCategory;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountCategory() {
        return accountCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return getAccountId().equals(account.getAccountId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountId());
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountCategory='" + accountCategory + '\'' +
                '}';
    }

    @Override
    public int compareTo(Account account) {
        return this.accountId.compareToIgnoreCase(account.accountId);
    }

    public static class Builder {
        private String accountId;
        private String accountNumber;
        private String accountName;
        private String accountCategory;

        public Builder accountId(String accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder acccountName(String accountName) {
            this.accountName = accountName;
            return this;
        }

        public Builder accountCategory(String accountCategory) {
            this.accountCategory = accountCategory;
            return this;
        }

        public Builder copy(Account account) {
            this.accountId = account.accountId;
            this.accountNumber = account.accountNumber;
            this.accountName = account.accountName;
            this.accountCategory = account.accountCategory;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}