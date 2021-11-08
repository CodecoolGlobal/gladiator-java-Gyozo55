package com.codecool.gladiator.model.gladiators;

public abstract class Gladiator {

    private final String name;
    private final int baseHp;
    private final int baseSp;
    private final int baseDex;
    private int level;
    private Types type;

    /**
     * Constructor for Gladiators
     *
     * @param name the gladiator's name
     * @param baseHp the gladiator's base Health Points
     * @param baseSp the gladiator's base Strength Points
     * @param baseDex the gladiator's base Dexterity Points
     * @param level the gladiator's starting Level
     */
    public Gladiator(String name, int baseHp, int baseSp, int baseDex, int level, Types type) {
        this.name = name;
        this.baseHp = baseHp;
        this.baseSp = baseSp;
        this.baseDex = baseDex;
        this.level = level;
        setType(type);
    }

    /**
     * @return HP multiplier of the gladiator subclass
     */
    protected abstract Multiplier getHpMultiplier();

    /**
     * @return SP multiplier of the gladiator subclass
     */
    protected abstract Multiplier getSpMultiplier();

    /**
     * @return DEX multiplier of the gladiator subclass
     */
    protected abstract Multiplier getDexMultiplier();


    public double getMaximumHp() {
        return baseHp * getHpMultiplier().value * level;
    }

    public double getMaximumSp() {
        return baseSp * getSpMultiplier().value * level;
    }

    public double getMaximumDex() {
        return baseDex * getDexMultiplier().value * level;
    }

    public String getName() {
        return name;
    }

    /**
     * Returns the full name of the gladiator
     * assembled by the subtype and the name
     * (e.g. "Brutal Brutus" or "Archer Leo")
     *
     * @return the full name
     */
    public String getFullName() {
        String typeName = this.type.toString();
        return typeName+" "+name;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        for(Types typeEnum: Types.values()){
            if (typeEnum == type) {
                this.type = type;
                break;
            }
        }
    }

    public int getLevel() {
        return level;
    }

    public void levelUp(){
        this.level += 1;
    }

    public enum Multiplier {
        Low(0.75),
        Medium(1.0),
        High(1.25);

        private final double value;

        Multiplier(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }
    }

    public enum Types{
        Brutal,
        Swordsman,
        Archer,
        Assassin
    }
}
