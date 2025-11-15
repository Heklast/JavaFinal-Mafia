package mafiagame.model.characters;

import java.util.Scanner;

/**
 * Represents a regular police officer in the game.
 * 
 * <p>A {@code Cop} interacts with the {@link MafiaMember} primarily during
 * bar scenes. The cop attempts to gather information about the mafia boss
 * and may reward the player for snitching. Unlike {@code BadCop}, this class
 * represents a lawful officer, though one who is willing to negotiate with
 * criminals for information.</p>
 * 
 * <p>The cop can:</p>
 * <ul>
 *   <li>Introduce themselves with some background information</li>
 *   <li>React to information given by the player</li>
 *   <li>Arrest the player, causing an immediate game over</li>
 * </ul>
 */
public class Cop extends Human {

    /**
     * Number of years the cop has worked in law enforcement.
     */
    private int yearsOnTheJob;

    /**
     * Creates a fully initialized {@code Cop} with name, age, and years of experience.
     *
     * @param name          the cop's name
     * @param age           the cop's age
     * @param yearsOnTheJob how long the cop has been working as a detective
     */
    public Cop(String name, int age, int yearsOnTheJob) {
        super(name, age);
        this.yearsOnTheJob = yearsOnTheJob;
    }

    /**
     * Introduces the cop to the player.
     *
     * <p>This method prints several lines of dialogue describing the cop's
     * background and motivations, including their desire to catch the mafia boss
     * before retiring.</p>
     */
    @Override
    public void introduce() {
        System.out.println("Hi, I am detective " + this.getName());
        System.out.println("I know who you are but don't worry. I am not after you, I'm after your boss");
        System.out.println("I have been at this job for " + this.getYearsOnTheJob() + " years");
        System.out.println("I want to retire but I want to catch the Boss first !");
        System.out.println("Give me some info about him and I'll pay you.");
    }

    /**
     * Prints a short message praising the mafia member for cooperating.
     *
     * <p>This method is static because it does not depend on the cop's state.
     * It simply outputs a narrative reaction after the player chooses to snitch.</p>
     *
     * @param m the {@link MafiaMember} who shared information
     */
    public static void copApplausesMM(MafiaMember m) {
        System.out.println("Thank you for thinking of the greater good !");
        System.out.println();
    }

    /**
     * Arrests the mafia member, resulting in an immediate game over.
     *
     * <p>This method sets the mafia member's {@code gameOver} flag to {@code true}
     * and prints a small arrest sequence.</p>
     *
     * @param mafiaMember the character being arrested
     */
    public void arrest(MafiaMember mafiaMember) {
        System.out.println();
        System.out.println("'" + mafiaMember.getName() + ", you are under arrest!', the cop says");
        System.out.println("GAME OVER");
        mafiaMember.setGameOver(true);
    }

    /**
     * Returns the number of years the cop has been on duty.
     *
     * @return years of experience
     */
    public int getYearsOnTheJob() {
        return yearsOnTheJob;
    }
}
