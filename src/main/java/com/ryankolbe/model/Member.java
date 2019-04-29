package com.ryankolbe.model;

import java.util.Objects;

public class Member implements Comparable<Member> {
    private String memberId;
    private User user;
    private Address address;
    private Locality locality;

    private Member() {
    }

    private Member(Builder builder) {
        this.memberId = builder.memberId;
        this.user = builder.user;
        this.address = builder.address;
        this.locality = builder.locality;
    }

    public String getMemberId() {
        return memberId;
    }

    public User getUser() {
        return user;
    }

    public Address getAddress() {
        return address;
    }

    public Locality getLocality() {
        return locality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        Member member = (Member) o;
        return getMemberId().equals(member.getMemberId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMemberId());
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", user=" + user +
                ", address=" + address +
                ", locality=" + locality +
                '}';
    }

    @Override
    public int compareTo(Member member) {
        return this.user.getName().compareTo(member.user.getName());
    }

    public static class Builder {
        private String memberId;
        private User user;
        private Address address;
        private Locality locality;

        public Builder memberId(String memberId) {
            this.memberId = memberId;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Builder locality(Locality locality) {
            this.locality = locality;
            return this;
        }

        public Builder copy(Member member) {
            this.memberId = member.memberId;
            this.user = member.user;
            this.address = member.address;
            this.locality = member.locality;
            return this;
        }

        public Member build() {
            return new Member(this);
        }
    }
}