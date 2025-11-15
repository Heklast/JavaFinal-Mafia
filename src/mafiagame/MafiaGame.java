/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mafiagame;

import java.util.InputMismatchException;
import java.util.Scanner;
import mafiagame.model.Knowledge;
import mafiagame.model.characters.Human;
import mafiagame.model.characters.Human.Drink;
import mafiagame.model.characters.Human.Gender;
import mafiagame.model.characters.MafiaBoss;
import mafiagame.model.characters.MafiaMember;
import mafiagame.model.characters.MafiaMember.Color;
import mafiagame.model.characters.MafiaMember.Family;
import mafiagame.scenes.BarScene;
import mafiagame.scenes.BossScene;
import mafiagame.scenes.CopScene;
import mafiagame.scenes.DockScene;
import mafiagame.scenes.HairdresserScene;
import mafiagame.ui.ConsoleUI;

/**
 *
 * @author hekla
 */
public class MafiaGame {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ConsoleUI ui = new ConsoleUI(keyboard);

        ui.println("Welcome to Mafia City ! ");
        ui.println("REMINDER: during the game you will have to press ENTER to keep on with the game");
        ui.println("The goal of the game is to get to 500 dollars without dying or getting arrested");
        ui.println("");

        ui.println("First, we need some information about you ! ");
        ui.println("");
        ui.waitForEnter();

        String name;
        while (true) {
            ui.println("What is your name ? (type it and then press enter)");
            name = keyboard.nextLine().trim();

            if (name.matches("[A-Za-z]+")) {
                break;
            }

            ui.println("Invalid name. No numbers or special characters.");
        }

        ui.println("how old are you ?");
        int age = -1;
        
        // Checking whether age is okay with a static method in Human class
        // and error handling
        while (!Human.isAgeOkay(age)) {
            try {
                age = keyboard.nextInt();
                keyboard.nextLine(); 

                if (!Human.isAgeOkay(age)) {
                    ui.println("You have to be at least 1 year old and not older than a 100 years old!");
                    ui.println("Choose another age");
                }

            } catch (InputMismatchException e) {
                ui.println("It has to be a number. Try again:");
                keyboard.nextLine(); // clear invalid input
            }
        }

        Gender gender = askForGender(keyboard);
        Drink drink = askForFavoriteDrink(keyboard);
        Family family = askForFamily(keyboard);
        Color color = askForHairColor(keyboard);

        // You start with one knowledge under your belt
        MafiaMember mafiaMember = new MafiaMember(
                name, age, gender, drink, color, family,
                0, false, false, new Knowledge("he is 2 meters")
        );

        mafiaMember.introduce();
        ui.waitForEnter();

        CopScene copScene = new CopScene(ui);
        BarScene barScene = new BarScene(ui, copScene);
        DockScene dockScene = new DockScene(ui);
        HairdresserScene hairdresserScene = new HairdresserScene(ui);
        BossScene bossScene = new BossScene(ui);

        ui.println("Night falls over the city. The streets smell like rain and trouble.");
        ui.waitForEnter();
        ui.println("You need cash if you ever want to walk away from the family.");
        ui.println("Where do you start your evening?");
        ui.println("Head to the bar for a drink and maybe some gossip (b)");
        ui.println("or go down to the docks to handle a drug deal (d).");
        ui.println("");

        // First action, only bar or dock to begin
        while (true) {
            String where = ui.ask("Choose (b/d): ").trim().toLowerCase();
            ui.println("");
            switch (where) {
                case "b" -> {
                    barScene.play(mafiaMember);
                    break;
                }
                case "d" -> {
                    dockScene.play(mafiaMember);
                    break;
                }
                
                default -> {
                    ui.println("Invalid choice. Type 'b' for bar or 'd' for docks.");
                    continue;
                }
            }
            break;
        }

        // The main game loop
        while (mafiaMember.getMoney()< 20 && !mafiaMember.getGameOver() ) {
            ui.println("You still need more money if you want to get out alive.");
            ui.println("What's your next move?");
            ui.println("  (b) Hit the bar");
            ui.println("  (d) To the docks for a drug deal");
            ui.println("  (h) Visit the hairdresser");
            ui.println("");

            while (true) {
                String where = ui.ask("Choose (b/d/h): ").trim().toLowerCase();

                switch (where) {
                    case "b" -> {
                        barScene.play(mafiaMember);
                        break;
                    }
                    case "d" -> {
                        dockScene.play(mafiaMember);
                        break;
                    }
                    case "h" -> {
                        hairdresserScene.play(mafiaMember);
                        break;
                    }
                    default -> {
                        ui.println("Invalid choice. Type 'b', 'd' or 'h'.");
                        continue;
                    }
                }
                break;
            }

            //After every action, we roll a dice whether the mafia boss finds him or not for snitching      
            if (!mafiaMember.getBossFindsYou()) {
                double roll = Math.random();

                boolean found = mafiaMember.rollForFoundByBoss(roll);
                if (found) {
                    String bossName = "Don " + mafiaMember.getFamily();
                    MafiaBoss mafiaBoss = new MafiaBoss(bossName);
                    bossScene.play(mafiaMember, mafiaBoss);
                    ui.println("");
                }
            }
            if(mafiaMember.getMoney()>=300){
            System.out.println("You are free from the Mafia ! CONGRATULATIONS !");
            System.out.println("Enjoy your life !!!!");
        }
        }

    }

    // helper methods for initial character creation, make sure we have the right input
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

    public static Color askForHairColor(Scanner s) {
        while (true) {
            System.out.println("What hair color do you want to have ?");
            System.out.println("Red (r), blue (b), blonde (bl), brunette (br) ?");
            String input = s.nextLine().trim().toUpperCase();

            switch (input) {
                case "RED", "R" -> {
                    return Color.RED;
                }
                case "BLUE", "B" -> {
                    return Color.BLUE;
                }
                case "BLONDE", "BL" -> {
                    return Color.BLONDE;
                }
                case "BRUNETTE", "BR" -> {
                    return Color.BRUNETTE;
                }
                default -> {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
