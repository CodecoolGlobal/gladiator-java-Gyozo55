package com.codecool.gladiator.model;

import com.codecool.gladiator.model.gladiators.Gladiator;
import com.codecool.gladiator.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Combat class, used for simulating fights between pairs of gladiators
 */
public class Combat {

    private final Gladiator gladiator1;
    private final Gladiator gladiator2;

    private final List<String> combatLog;

    public Combat(Contestants contestants) {
        this.gladiator1 = contestants.gladiator1;
        this.gladiator2 = contestants.gladiator2;
        this.combatLog = new ArrayList<>();
    }

    public Gladiator simulate() {
        int firstAttacker = RandomUtils.getRandomNumber(1,2);
        while (gladiator1.isDead() || gladiator2.isDead()){
            if(firstAttacker==1){
                gladiator2.decreaseHpBy(gladiator1.getSp());
                gladiator1.decreaseHpBy(gladiator2.getSp());
            }
            if(firstAttacker==2){
                gladiator1.decreaseHpBy(gladiator2.getSp());
                gladiator2.decreaseHpBy(gladiator1.getSp());
            }
        }
        return gladiator1;
    }

    private int hitChance(double attackerDex, double defenderDex){
        int attackerDexInt = (int) attackerDex;
        int defenderDexInt = (int) defenderDex;
        if(attackerDexInt>100){
            attackerDexInt = 100;
        }
        if(defenderDexInt>100){
            defenderDexInt = 100;
        }
        return (attackerDexInt-defenderDexInt);
    }



    public Gladiator getGladiator1() {
        return gladiator1;
    }

    public Gladiator getGladiator2() {
        return gladiator2;
    }

    public String getCombatLog(String separator) {
        return String.join(separator, combatLog);
    }

}
