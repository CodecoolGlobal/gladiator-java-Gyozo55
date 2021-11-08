package com.codecool.gladiator.model.gladiators;

public class Swordsman extends Gladiator{
    public Swordsman(String name, int baseHp, int baseSp, int baseDex, int level, Gladiator.Types type) {
        super(name, baseHp, baseSp, baseDex, level, type);
    }

    @Override
    protected Multiplier getHpMultiplier() {
        return Multiplier.Medium;
    }

    @Override
    protected Multiplier getSpMultiplier() {
        return Multiplier.Medium;
    }

    @Override
    protected Multiplier getDexMultiplier() {
        return Multiplier.Medium;
    }
}
