/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mafiagame;

import java.util.InputMismatchException;
import java.util.Scanner;
import mafiagame.model.Knowledge;
import mafiagame.model.characters.Cop;
import mafiagame.model.characters.Human;
import mafiagame.model.characters.Human.Drink;
import mafiagame.model.characters.Human.Gender;
import mafiagame.model.characters.MafiaMember;
import mafiagame.model.characters.MafiaMember.Family;

/**
 *
 * @author hekla
 */
public class MafiaGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to Mafia City ! ");
        System.out.println("REMINDER: during the game you will have to press ENTER to keep on with the story)");
        System.out.println();

        System.out.println("First, we need some information about you ! ");
        System.out.println();

        System.out.println("What is your name ?");

        String name = keyboard.nextLine();

        System.out.println("how old are you ?");
        int age = -1;

        while (!Human.isAgeOkay(age)) {
            try {
                age = keyboard.nextInt();
                keyboard.nextLine(); // clear leftover newline

                if (!Human.isAgeOkay(age)) {
                    System.out.println("You have to be at least 1 year old and not older than a 100 years old!");
                    System.out.println("Choose another age");
                }

            } catch (InputMismatchException e) {
                System.out.println("It has to be a number. Try again:");
                keyboard.nextLine(); // clear invalid input
            }
        }

        Gender gender = askForGender(keyboard);
        Drink drink = askForFavoriteDrink(keyboard);
        Family family = askForFamily(keyboard);

        System.out.println("What haircolor do you want to have ?");

        String hair = keyboard.nextLine();

        //put all of them here
        while (!Human.isAgeOkay(age)) {
            System.out.println("You have to be at least 1 year old !");
            System.out.println("Choose another age");
            age = keyboard.nextInt();
            keyboard.nextLine();
        }

        //mafiaMember
        MafiaMember mafiaMember = new MafiaMember(name, age, gender, drink, hair, family, 0, false, new Knowledge("he is 2 meters"));
        mafiaMember.whereToBegin();
        while (!mafiaMember.getGameOver()) {
            mafiaMember.whereToGoNext();
            mafiaMember.doYouDie();

        }

        /**
         *
         * @param s
         */
    }

    public static Gender askForGender(Scanner s) {
        while (true) {
            System.out.println("What gender do you want to be ?");
            System.out.println("Male (m), female (f), undefined (u)?");
            String input = s.nextLine().trim().toUpperCase();

            switch (input) {
                case "MALE", "M" -> {
                    return Gender.MALE;
                }
                case "FEMALE", "F" -> {
                    return Gender.FEMALE;
                }
                case "UNDEFINED", "U", "NONE" -> {
                    return Gender.UNDEFINED;
                }
                default -> {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
    
    public static Family askForFamily(Scanner s) {
        while (true) {
            System.out.println("What Mafia Family do you want to be a part of ?");
            System.out.println("Corvetta (C) or Julio (J)?");
            String input = s.nextLine().trim().toUpperCase();

            switch (input) {
                case "CORVETTA", "C" -> {
                    return Family.CORVETTA;
                }
                case "JULIO", "J" -> {
                    return Family.JULIO;
                }
                default -> {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    public static Drink askForFavoriteDrink(Scanner s) {
        while (true) {
            System.out.println("What is your favorite drink ?");
            System.out.println("Beer (b), water (w), fanta (f)?");
            String input = s.nextLine().trim().toUpperCase();

            switch (input) {
                case "BEER", "B" -> {
                    return Drink.BEER;
                }
                case "WATER", "W" -> {
                    return Drink.WATER;
                }
                case "FANTA", "F" -> {
                    return Drink.FANTA;
                }
                default -> {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
