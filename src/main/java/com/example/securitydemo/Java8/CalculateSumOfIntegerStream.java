package com.example.securitydemo.Java8;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CalculateSumOfIntegerStream {

    public static void main(String[] args){


        Stream<Integer> intStream = Stream.of(1,2,3,4,5,6,7,8,9);

        BinaryOperator<Integer> bo = new BinaryOperator<>(){
            @Override
            public Integer apply(Integer a, Integer b){
                System.out.println();
                return a + b;

            }
        };

        Predicate<Integer> greaterThan5 = new Predicate<>(){

            @Override
            public boolean test(Integer a){

                return a > 5 ? true : false;

            }
        };

        Function<Integer,Integer> multiplyEachWith10 = new Function<>(){
            @Override
            public Integer apply(Integer a){
                return a * 10;
            }
        };

        Optional<Integer> total = intStream.filter(greaterThan5)
                .map(multiplyEachWith10)
                .reduce(bo);

        System.out.println(total.get());
    }
}
