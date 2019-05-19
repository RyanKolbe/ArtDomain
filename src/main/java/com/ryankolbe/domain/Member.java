package com.ryankolbe.domain;

import java.util.Objects;

public class Member implements Comparable<Member> {
    private String memberId;
    private String memberName;
    private String memberClass;

    private Member() {
    }

    private Member(Builder builder) {
        this.memberId = builder.memberId;
        this.memberName = builder.memberName;
        this.memberClass = builder.memberClass;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberClass() {
        return memberClass;
    }


    @Override
    public int compareTo(Member member) {
        return this.memberId.compareToIgnoreCase(member.memberId);
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
                ", memberName='" + memberName + '\'' +
                ", memberClass='" + memberClass + '\'' +
                '}';
    }

    public static class Builder {
        private String memberId;
        private String memberName;
        private String memberClass;

        public Builder memberId(String memberId) {
            this.memberId = memberId;
            return this;
        }

        public Builder memberName(String memberName) {
            this.memberName = memberName;
            return this;
        }

        public Builder memberClass(String memberClass) {
            this.memberClass = memberClass;
            return this;
        }

        public Builder copy(Member member) {
            this.memberId = member.memberId;
            this.memberName = member.memberName;
            this.memberClass = member.memberClass;
            return this;
        }

        public Member build() {
            return new Member(this);
        }
    }
}