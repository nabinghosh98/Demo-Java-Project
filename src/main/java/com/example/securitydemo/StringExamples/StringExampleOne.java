package com.example.securitydemo.StringExamples;

public class StringExampleOne {
    public static void main(String[] args){
            String str1 = new String("hello");
            String str2 = new String("hello");

            System.out.println(str1.equals(str2));

            StringBuffer sb1 = new StringBuffer("hello");
            StringBuffer sb2 = new StringBuffer("hello");

            System.out.println(sb1.equals(sb2));
            //false because equals method was not overiden that why it is comparing the
        // addresses and not the values

        //read hashcode and equals method overide concept



    }
}
