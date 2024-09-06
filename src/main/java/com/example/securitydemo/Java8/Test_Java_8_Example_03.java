package com.example.securitydemo.Java8;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class Test_Java_8_Example_03 {

    public static void main(String[] args){
        Consumer<String> consumer = System.out::println;
        Consumer<String> consumer2 = new PrintStream(System.out)::println;

        //create a method reference for add method of List interface

        BiConsumer<ArrayList, Integer> biConsumer = ArrayList::add;
        biConsumer.accept(new ArrayList<Integer>(),10);

    }

}
