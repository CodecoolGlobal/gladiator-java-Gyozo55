package com.codecool.gladiator;

import com.codecool.gladiator.controller.Colosseum;
import com.codecool.gladiator.model.gladiators.GladiatorFactory;
import com.codecool.gladiator.view.ConsoleView;
import com.codecool.gladiator.view.Viewable;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Colosseum colosseum = new Colosseum(new ConsoleView(), new GladiatorFactory("Names.txt"));
        colosseum.welcomeAndAskForStages();
        colosseum.runSimulation();
    }

}
