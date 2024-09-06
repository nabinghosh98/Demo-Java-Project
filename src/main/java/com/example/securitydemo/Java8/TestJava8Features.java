package com.example.securitydemo.Java8;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class TestJava8Features {
    public static void main(String[] args){
        
    //Annonymous Implementation of an Interface in Java without creating a seaprate class 
    //to override a method    
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "Hello Stream API";//String Kind of data
            }
        };
        Stream<String> streamOfStrings = Stream.generate(supplier);

        //Generate method will be used to generate infinite number of data

        Consumer<String> consumer = new Consumer<String>(){
            int i =0;
            @Override
            public void accept(String str){
                    System.out.println(str + " " + i++);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        streamOfStrings.forEach(consumer);

    }
}
