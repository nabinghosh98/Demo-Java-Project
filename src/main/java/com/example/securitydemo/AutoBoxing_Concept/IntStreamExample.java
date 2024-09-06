package com.example.securitydemo.AutoBoxing_Concept;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamExample {

    public static void main(String[] args){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7);
        //here compiler automatically converts the primitive integer to Integer Wrapper class
        //This is called auto boxing
        //when the programmer does the conversion of primitive integer to Wrapper class Integer is known as Boxing

        int i =10;//it will occupy only 4bytes of memory
        Integer a = i; //compiler will internally convert the primitive integer to Object (Wrapper class), this conversion will take some time
        //This is known as AutoBoxing
        System.out.println(a);

        Integer b = Integer.valueOf(i); //here programmer is doing the convertion of primitive integer to Wrapper class Integer Object
        System.out.println(b);

        //Now we IntStream Interface in Stream API

        //Lambda expression way to override the apply method of BiFunction<T,T,T>
        Optional<Integer> result = integerStream.reduce((Integer integer1, Integer integer2)-> {
            System.out.println("Integer 1 : "+integer1+" Integer 2 : "+integer2+" ="+ (integer1+integer2));
                return integer1 + integer2;
            }
        );
        //here reduce is a terminal operation where it takes the implementation of BinaryOperator
        if(result.isPresent()){
            System.out.println(result.get());
        }
        
        //Implementation of BinaryOperator functional interface anonymous implementation of BinaryOperator functional interface
        //Executing the same stream will give IllegalThreadStateException as the stream is already closed
//        Optional<Integer> total = integerStream.reduce(new BinaryOperator<Integer>() {
//            @Override
//            public Integer apply(Integer integer1, Integer integer2) {
//                return integer1 + integer2;
//            }
//        });

        Stream<Integer> evenNumbers = Stream.of(2, 4, 6, 8, 10, 12, 14, 16, 18, 20);
        BinaryOperator<Integer> binaryop = new BinaryOperator<Integer>(){
            @Override
            public Integer apply(Integer integer1, Integer integer2){
                return integer1 + integer2;
            }
        };
        Optional<Integer> reducedTotal = evenNumbers.reduce(binaryop);

        if(reducedTotal.isPresent()){
            System.out.println("Total sum of the even numbers are in Optional format : "+reducedTotal);
            System.out.println("Total sum without Optional format : "+reducedTotal.get());
        }

        //filter the Integer stream with value greater than 4 and get the sum
        Predicate<Integer> testEvenNumberGreaterThan4 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 4 ? true : false;
            }
        };
        Function<Integer,Integer> multipleEachWith2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer*2;
            }
        };
        BinaryOperator<Integer> binaryOperatorToCalculateSum = new BinaryOperator<Integer>(){
            @Override
            public Integer apply(Integer a, Integer b){
                return a + b;
            }
        };

        Stream<Integer> newEvenNumbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);

        Optional<Integer> totalEvenNumbersGreaterthan4 = newEvenNumbers.filter(testEvenNumberGreaterThan4)
                .map(multipleEachWith2)
                .reduce(binaryOperatorToCalculateSum);

        if (totalEvenNumbersGreaterthan4.isPresent()){
            System.out.println("Total value is : "+totalEvenNumbersGreaterthan4.get());
        }

        ////Reducing the code lines using Java 8 Lambda Expression

        Stream.of(1,3,5,7,9,11,13);


    }
}

//How reduce method works

// (1 + 2) 3 4 5  6 7
// (3 + 3) 4 5 6 7
// (6 + 4) 5 6 7
// (10 + 5) 6 7
// (15 + 6) 7
//(21 + 7)
//28

