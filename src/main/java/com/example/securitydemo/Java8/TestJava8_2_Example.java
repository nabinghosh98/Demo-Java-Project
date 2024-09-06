package com.example.securitydemo.Java8;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class TestJava8_2_Example {

    public  static  void  main(String[] args){

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //write a consumer to process the integer

        Consumer<Integer> consumer = new Consumer<Integer>() {
            int i=0;
            @Override
            public void accept(Integer integer) {
                    System.out.println(integer + " "+i++ + "second");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        integerStream.forEach(consumer);//here forEach is a terminal operation

        //Stream API does nothing but processes the data through a pipeline

        //now let's reduce the code length by directly passing the Consumer annonymous implementation in the forEach method

        System.out.println("New way to code the above program as below");

        integerStream.forEach( new Consumer<Integer>(){

            @Override
            public void accept(Integer integer) {
                if(integer>5){
                    System.out.println("Number"+ integer +"is greater than 5");
                }
            }
        });

        //Please note the above stream is already operated or closed, so we can't operate on the same stream


    }

}
