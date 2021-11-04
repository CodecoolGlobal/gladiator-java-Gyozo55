package com.codecool.gladiator.view;


import java.io.IOException;

public interface Viewable {
    /**
     * Displays given text into the View
     *
     * @param text the text to be displayed
     */
    void display(String text);

    /**
     * Asks the user for a number between min and max and returns it
     * @param min minimal value of the number accepted
     * @param max maximal value of the number accepted
     * @return
     */
    int getNumberBetween(int min, int max) throws IOException;
}
