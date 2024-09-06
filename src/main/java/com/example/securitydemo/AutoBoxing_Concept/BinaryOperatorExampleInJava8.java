package com.example.securitydemo.AutoBoxing_Concept;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

//Program to calculate sum of all the even Integer numbers using reduce method
public class BinaryOperatorExampleInJava8 {

    public static void main(String[] args){
        Stream<Integer> numbers = Stream.of(1,2,3,4,5,6,7,8,9,10);
        //filter method accept implementation of Predicate functional Interface
        //by overriding the test method
        //filter elements which are even
        Predicate<Integer> filterEvenElements = new Predicate<Integer>(){
            @Override
            public boolean test(Integer a){
                return a % 2==0 ? true : false;
            }
        };
        //Create an implementation of Function Functional Interface by implementing
        // apply() method
        //Function functional interface takes 2 arguents i.e. T,R
        //after filtering convert the values by mulytiplying with 10
        Function<Integer, Integer> functionToMultiplyBy10 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer a) {
                return a * 10;
            }
        };

        //Last step here is to add all the elements which are even and multiplied by 10
        //Redude Method accepts the implementation of BinaryOperator<T>
        //BinaryOperator is a functional Interface which extends BiFunction<T,U,R> functional interface which has an abstract method
        // R apply(T,U) with 2 Argument, it will apply operation on T and U, and gives result R

        BinaryOperator<Integer> binaryOperatoryToSum = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                System.out.println("Integer 1: " + a + " Integer 2 :" + b + " = " + (a + b));
                return a + b;
            }
        };
        //1,2,3,4,5,6,7,8
        //3,3,4,5,6,7,8
        //6,4,5,6,7,8
        //10,5,6,7,8
        //15,6,7,8
        //21,7,8
        //28,8
        //36

        //Upon calling the reduce method it will return an Optional Object of Type T

        Optional<Integer> totalSum = numbers.filter(filterEvenElements)
                .map(functionToMultiplyBy10)
                .reduce(binaryOperatoryToSum);

        //check if the totalSum has value or not

        if(totalSum.isPresent()){
            System.out.println("Total Sum of the Stream of Integer is :"+totalSum.get());
        }

        //Also Note we shouldn't use the same stream object to perform filter, map, reduce , collect or any other operation
        //as after 1st operation the stream will be closed and IllegalStateException will be thrown be called the same stream object twice
    }
}
