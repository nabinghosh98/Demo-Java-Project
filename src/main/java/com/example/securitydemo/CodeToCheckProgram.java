package com.example.securitydemo;

public class CodeToCheckProgram {

    public static int cal(){
        int x = 1;
        x++;
        return x;
    }
    public static void main(String[] args){
             int x,y;
             x = cal();
             y = cal() + x;
             System.out.println(x+y);

    }
}
