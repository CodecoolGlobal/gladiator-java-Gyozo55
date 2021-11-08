package com.codecool.gladiator.model;

import com.codecool.gladiator.model.gladiators.Gladiator;
import com.codecool.gladiator.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

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
                fight(gladiator1, gladiator2);
                fight(gladiator2, gladiator1);
            }
            if(firstAttacker==2){
                fight(gladiator2, gladiator1);
                fight(gladiator1, gladiator2);
            }
        }
        if(gladiator1.isDead()){
            combatLog.add(gladiator1.getFullName()+ "has died, " + gladiator2.getFullName()+" wins!");
            return gladiator2;
        }
        else if(gladiator2.isDead()){
            combatLog.add(gladiator2.getFullName()+ "has died, " + gladiator1.getFullName()+" wins!");
            return gladiator1;
        }
        return null;
    }

    private void fight(Gladiator gladiator1, Gladiator gladiator2) {
        if(validHit(hitChance(gladiator2.getDex(), gladiator1.getDex()))){
            double currentHit = gladiator1.getSp() * RandomUtils.getRandomDouble(0.1, 0.5);
            gladiator2.decreaseHpBy(currentHit);
            combatLog.add(gladiator1.getFullName()+ " deals " + currentHit + " damage");
        }
        else {
            combatLog.add(gladiator1.getFullName()+ " missed");
        }
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

    private boolean validHit(int hitChance){
        int absolutHitChance = Math.abs(hitChance);
        if(absolutHitChance<30){
            return false;
        }
        if(absolutHitChance>30 && absolutHitChance<70){
            int chance = RandomUtils.getRandomNumber(0, 1);
            if (chance==0){
                return false;
            }
            return chance == 1;
        }
        else{
            return absolutHitChance > 70;
        }
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
