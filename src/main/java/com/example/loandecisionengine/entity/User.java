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

    public double getCreditModifier(){
        if (segment == 1) return 100;
        else if (segment == 2) return 300;
        else if (segment == 3) return 1000;
        else return -1;
    }
}
