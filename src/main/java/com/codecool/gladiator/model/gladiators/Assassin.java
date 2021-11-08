package com.codecool.gladiator.model.gladiators;

public class Assassin extends Gladiator{
    public Assassin(String name, int baseHp, int baseSp, int baseDex, int level, Gladiator.Types type) {
        super(name, baseHp, baseSp, baseDex, level, type);
    }

    @Override
    protected Multiplier getHpMultiplier() {
        return null;
    }

    @Override
    protected Multiplier getSpMultiplier() {
        return null;
    }

    @Override
    protected Multiplier getDexMultiplier() {
        return null;
    }
}
