package com.codecool.gladiator.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleView implements Viewable {

    @Override
    public void display(String text) {
        System.out.println(text);
    }

    @Override
    public int getNumberBetween(int min, int max) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int inputNumber = Integer.parseInt(reader.readLine());
            if(inputNumber>min && inputNumber<max){return inputNumber;}
        }catch (NumberFormatException e){
            System.out.println("Please give me valid number!");
            return getNumberBetween(min, max);
        }
        System.out.println("Please give me valid number!");
        return getNumberBetween(min, max);
    }
}
