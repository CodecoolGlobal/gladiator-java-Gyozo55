package com.codecool.gladiator.model.gladiators;

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
        return names.get(getRandomNumber(0, names.size()));
    }

    private int getRandomNumber(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public Gladiator generateRandomGladiator() {
        gladiatorArrayList.add(
                new Brutal(getRandomName(), getRandomNumber(25, 100), getRandomNumber(25, 100), getRandomNumber(25, 100), getRandomNumber(1, 5), Gladiator.Types.Brutal));
        gladiatorArrayList.add(
                new Archer(getRandomName(), getRandomNumber(25, 100), getRandomNumber(25, 100), getRandomNumber(25, 100), getRandomNumber(1, 5), Gladiator.Types.Archer));
        gladiatorArrayList.add(
                new Assassin(getRandomName(), getRandomNumber(25, 100), getRandomNumber(25, 100), getRandomNumber(25, 100), getRandomNumber(1, 5), Gladiator.Types.Assassin));
        gladiatorArrayList.add(
                new Swordsman(getRandomName(), getRandomNumber(25, 100), getRandomNumber(25, 100), getRandomNumber(25, 100), getRandomNumber(1, 5), Gladiator.Types.Swordsman));
        gladiatorArrayList.add(
                new Swordsman(getRandomName(), getRandomNumber(25, 100), getRandomNumber(25, 100), getRandomNumber(25, 100), getRandomNumber(1, 5), Gladiator.Types.Swordsman));

        return gladiatorArrayList.get(getRandomNumber(0, 4));
    }
}
