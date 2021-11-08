package com.codecool.gladiator.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static int getRandomNumber(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    public static double getRandomDouble(double min, double max){return ThreadLocalRandom.current().nextDouble(min, max);}
}
