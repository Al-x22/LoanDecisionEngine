package com.example.loandecisionengine.entity;

public class User {
    private long personalCode;
    private int segment;

    public User(long personalCode, int segment) {
        this.personalCode = personalCode;
        this.segment = segment;
    }

    public long getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(long personalCode) {
        this.personalCode = personalCode;
    }

    public int getSegment() {
        return segment;
    }

    public void setSegment(int segment) {
        this.segment = segment;
    }

    // TODO: Implement segment to credit modifier
}
