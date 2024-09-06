package com.example.securitydemo.ProtectImmutableClass;

public class ImmutableStudent {

   final private int id;
   final private String studentName;

   //once u make the variables as final, then compiler will give an error that these variables are needed
    //to be initialised. Initialisation can be done using constructer
    //note : you can't write the default constructor here else it will give a compile time error


    public ImmutableStudent(int id, String studentName){
        this.id = id;
        this.studentName = studentName;
    }

    //when I wrote this parameterised constructor, the error is gone

    //so when u do the right click and search for getter and setter, u can only find
    //getter method . Setter option will not be there as once the variable is  initialized initially
    //via constructor, you can't change the variable's value. Therefore it is meaningless to have
    //a setter method inside a class


    public int getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public String toString() {
        return "ImmutableStudent{" +
                "id=" + id +
                ", studentName=" + studentName +
                '}';
    }
}
