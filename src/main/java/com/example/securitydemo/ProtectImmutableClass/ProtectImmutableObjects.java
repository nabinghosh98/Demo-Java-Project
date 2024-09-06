package com.example.securitydemo.ProtectImmutableClass;

public class ProtectImmutableObjects {

    public static void main(String[] args){
        Student nabin = new Student();

        nabin.setId(1);
        nabin.setStudentName("nabin ghosh");

        System.out.println(nabin);

        //you can change the state of the object if the class is not final

        nabin.setId(2);
        nabin.setStudentName("nabin kumar ghosh");

        System.out.println(nabin);//instance state got changed
        //Therefore this student class is mutable in nature
        //Its state is changed

        //how to convert this class to Immutable. you can't changed its state

        //if we remove the setter method from the class therefore noone would be able to change the id and name
        // once it is initialised

        //## Now lets create an Object of an Immutable class

        ImmutableStudent student = new ImmutableStudent(1,"nabin kumar ghosh");

        System.out.println("Immutable Student Object"+student);

        FinalImmutableStudent fis = new FinalImmutableStudent(1,"Nabin",new Address("Sambalpur","Odisha"));
        System.out.println("Immutable Final Class fis"+fis);

        Address addressFis = fis.getAddress();
        addressFis.setCity("BLR");
        addressFis.setState("Karnataka");

        System.out.println(addressFis);






    }
}




