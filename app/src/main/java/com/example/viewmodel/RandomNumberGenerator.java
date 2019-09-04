package com.example.viewmodel;


import java.util.Random;

public class RandomNumberGenerator{
    private Random random;

    public RandomNumberGenerator(){
        random = new Random();
    }

    public String getNumber(){
        String number =  String.valueOf(random.nextInt(100));
        return number;
    }
}
