package com.codecool.gladiator.model.gladiators;

import com.codecool.gladiator.util.RandomUtils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class GladiatorFactory {

    private List<String> names;
    private final ArrayList<Gladiator> gladiatorArrayList = new ArrayList<>();

    public GladiatorFactory(String fileOfNames) {
        try {
            File file = new File(getClass().getClassLoader().getResource(fileOfNames).getFile());
            names = Files.readAllLines(file.toPath());
        } catch (IOException|NullPointerException e) {
            System.out.println("Names file not found or corrupted!");
            System.exit(1);
        }
    }

    private String getRandomName() {
        return names.get(RandomUtils.getRandomNumber(0, names.size()));
    }


    public Gladiator generateRandomGladiator() {
        gladiatorArrayList.add(
                new Brutal(getRandomName(), RandomUtils.getRandomNumber(25, 100), RandomUtils.getRandomNumber(25, 100), RandomUtils.getRandomNumber(25, 100), RandomUtils.getRandomNumber(1, 5), Gladiator.Types.Brutal));
        gladiatorArrayList.add(
                new Archer(getRandomName(), RandomUtils.getRandomNumber(25, 100), RandomUtils.getRandomNumber(25, 100), RandomUtils.getRandomNumber(25, 100), RandomUtils.getRandomNumber(1, 5), Gladiator.Types.Archer));
        gladiatorArrayList.add(
                new Assassin(getRandomName(), RandomUtils.getRandomNumber(25, 100), RandomUtils.getRandomNumber(25, 100), RandomUtils.getRandomNumber(25, 100), RandomUtils.getRandomNumber(1, 5), Gladiator.Types.Assassin));
        gladiatorArrayList.add(
                new Swordsman(getRandomName(), RandomUtils.getRandomNumber(25, 100), RandomUtils.getRandomNumber(25, 100), RandomUtils.getRandomNumber(25, 100), RandomUtils.getRandomNumber(1, 5), Gladiator.Types.Swordsman));
        gladiatorArrayList.add(
                new Swordsman(getRandomName(), RandomUtils.getRandomNumber(25, 100), RandomUtils.getRandomNumber(25, 100), RandomUtils.getRandomNumber(25, 100), RandomUtils.getRandomNumber(1, 5), Gladiator.Types.Swordsman));

        return gladiatorArrayList.get(RandomUtils.getRandomNumber(0, 4));
    }
}
