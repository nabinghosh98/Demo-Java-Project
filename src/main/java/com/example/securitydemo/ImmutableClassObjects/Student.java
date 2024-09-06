package com.example.securitydemo.ImmutableClassObjects;

public class Student {

    final private int id ; //making it as final so that once it is initialized, noone can reinitialize the same object's field

    final private String studentName;

    //now as these fields are marked as final, there is no need of setter method as after initializing the
    //fields, we can't reinitize the instance variables

    public Student(int id , String studentName){
        this.id = id;
        this.studentName = studentName;
    }

    public int getId() {
        return id;
    }

    //no need for setter as the variable is marked as final
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getStudentName() {
        return studentName;
    }

// no need of setter as the variable is marked as final
//    public void setStudentName(String studentName) {
//        this.studentName = studentName;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                '}';
    }

    public static void main(String[] args){
            Student s = new Student(1, "nabin");

            Student s2 = new Student(2, "kumar");

            //note both these s and s2 objects are immutable
        //Immutable objects once created, we can't change its
        //state i.e. variables values can't be changed after
        //initialization.
    }
}
