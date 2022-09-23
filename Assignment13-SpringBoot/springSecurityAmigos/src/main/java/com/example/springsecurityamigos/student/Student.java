package com.example.springsecurityamigos.student;

public class Student {
    private final Integer sId;
    private final String sName;

    public Student(Integer sId, String sName) {
        this.sId = sId;
        this.sName = sName;
    }

    public Integer getsId() {
        return sId;
    }

    public String getsName() {
        return sName;
    }
}
