package com.example.securitydemo;

import java.util.HashMap;
import java.util.Map;

public class MapExampleToCountTheOccurenceOfKeys {

    public static void main(String[] args){
        Map<Character, Integer> map = new HashMap<>();

        String str = "aabbaabbccdd";

        for(char ch : str.toCharArray()){

            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        for(Map.Entry<Character,Integer> entry:map.entrySet()){
                System.out.println(entry.getKey()+"  "+ entry.getValue());
        }

        System.out.println("Program to print the Map Size and get the default value of key");

        System.out.println("Size of the map is :" + map.size());
    }
}
