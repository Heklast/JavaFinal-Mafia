/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mafiagame.model.characters;

import mafiagame.model.Knowledge;

/**
 * Represents a playable Mafia member in the game.
 *
 * A {@code MafiaMember} is a {@link Human} who belongs to a Mafia family,
 * can earn and spend money, hold and reveal knowledge about the boss,
 * change hair color to hide, and interact with other characters like cops,
 * bartenders and dock workers.
 *
 * In this refactored version, MafiaMember focuses on game state and rules,
 * while story text and input/output are handled elsewhere (scenes/UI).
 *
 * @author hekla
 */
public class MafiaMember extends Human {

    /**
     * Probability that this mafia member will be killed by the boss.
     *
     * Value is between {@code 0.0} and {@code 1.0}. It increases when the
     * character snitches on the boss.
     */
    private double deathChance = 0.0;

    public enum Family {
        CORVETTA, JULIO
    }

    public enum Color {
        RED, BLUE, BLONDE, BRUNETTE
    }

    private Color hairColor;

    public Family belongsToFamily;

    private int money;

    private boolean gameOver;

    private Knowledge knowledge;

    /**
     * Creates a {@code MafiaMember} with only a name and age.
     *
     * Used when other attributes will be set later.
     *
     * @param name the name of the mafia member
     * @param age  the age of the mafia member
     */
    public MafiaMember(String name, int age) {
        super(name, age);
    }

    /**
     * Creates a fully initialized {@code MafiaMember}.
     */
    public MafiaMember(String name,
                       int age,
                       Gender gender,
                       Drink favoriteDrink,
                       Color hairColor,
                       Family belongsToFamily,
                       int money, boolean gameOver, Knowledge knowledge
    ) {
        super(name, age, gender, favoriteDrink);
        this.hairColor = hairColor;
        this.money = money;
        this.belongsToFamily = belongsToFamily;
        this.knowledge = knowledge;
        this.gameOver = gameOver;
        introduce();
    }

    /**
     * Creates a {@code MafiaMember} without knowledge and explicit game-over state.
     */
    public MafiaMember(String name,
                       int age,
                       Gender gender,
                       Drink favoriteDrink,
                       Color hairColor,
                       Family belongsToFamily,
                       int money) {
        super(name, age, gender, favoriteDrink);
        this.hairColor = hairColor;
        this.money = money;
        this.belongsToFamily = belongsToFamily;
    }

    /**
     * Introduces the mafia member to the player.
     *
     * Still prints a short introduction (story-related), but all heavy story
     * flow is handled in scene classes.
     */
    @Override
    public void introduce() {
        System.out.println("My name is " + this.getName()
                + ". You remember it, you keep it quiet. Got it?");
        System.out.println("One last big score and I'm out of this life for good...");
        System.out.println();
    }

    // ----- Simple getters / setters -----

    public Color getHairColor() {
        return this.hairColor;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public Knowledge getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(Knowledge knowledge) {
        this.knowledge = knowledge;
    }

    public int getMoney() {
        return this.money;
    }

    public Family getFamily() {
        return this.belongsToFamily;
    }

    public boolean getGameOver() {
        return this.gameOver;
    }

    public void setGameOver(boolean bool) {
        this.gameOver = bool;
    }

    public double getDeathChance() {
        return deathChance;
    }

    public void increaseDeathChance(double amount) {
        this.deathChance += amount;
        if (this.deathChance > 1.0) {
            this.deathChance = 1.0;
        }
        if (this.deathChance < 0.0) {
            this.deathChance = 0.0;
        }
    }

    // ----- Money helpers -----

    public void addMoney(int amount) {
        this.money += amount;
    }

    public boolean canAfford(int amount) {
        return this.money >= amount;
    }

    public void spendMoney(int amount) {
        if (!canAfford(amount)) {
            throw new IllegalStateException("Not enough money");
        }
        this.money -= amount;
    }

    // ----- Knowledge helpers -----

    public boolean hasSecrets() {
        return knowledge != null && knowledge.hasSecrets();
    }

    /**
     * Just peek at the first secret without removing it.
     */
    public String peekFirstSecret() {
        if (knowledge == null) return null;
        return knowledge.getFirstInfo();
    }

    /**
     * Reveal and remove the first secret.
     */
    public String revealFirstSecret() {
        if (knowledge == null) return null;
        return knowledge.revealFirstSecret();
    }

    // ----- Death roll -----

    /**
     * Apply a death roll using an already generated random value.
     * Does NOT print anything – scenes are responsible for narration.
     *
     * @param roll a random double between 0.0 and 1.0
     * @return true if character dies (game over), false otherwise
     */
    public boolean rollForDeath(double roll) {
        if (gameOver) {
            return true;
        }
        if (roll < deathChance) {
            gameOver = true;
        }
        return gameOver;
    }
}
