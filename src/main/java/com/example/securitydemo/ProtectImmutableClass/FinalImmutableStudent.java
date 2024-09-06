package com.example.securitydemo.ProtectImmutableClass;

final public class FinalImmutableStudent {

    //I have declared this class as final so that no other class can inherit this class
    //or override or make changes in the field property
    final private int id;
    final private String studentName;

    final private Address address;

    public FinalImmutableStudent(int id, String studentName, Address address) {
        this.id = id;
        this.studentName = studentName;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "FinalImmutableStudent{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", address=" + address +
                '}';
    }
}
