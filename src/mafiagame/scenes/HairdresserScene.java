package mafiagame.scenes;

import mafiagame.ui.ConsoleUI;
import mafiagame.model.characters.HairDresser;
import mafiagame.model.characters.Human.Drink;
import mafiagame.model.characters.Human.Gender;
import mafiagame.model.characters.MafiaMember;
import mafiagame.model.characters.MafiaMember.Color;

/**
 * Handles the hairdresser sequence where the mafia member can change appearance.
 */
public class HairdresserScene {

    private final ConsoleUI ui;
    private static final int COLOR_CHANGE_COST = 30;
    
    public HairdresserScene(ConsoleUI ui) {
        this.ui = ui;
    }

    public void play(MafiaMember player) {
        ui.println("You catch your reflection in a shop window and don't like what you see.");
        ui.println("Too recognizable. Too familiar. Too easy to find.");
        ui.waitForEnter();

        HairDresser hairDresser = new HairDresser("Klara", 25, Gender.FEMALE, Drink.FANTA,"Brad Pitt");

        ui.println("You step into the hair salon.");
        ui.waitForEnter();
        hairDresser.introduce();
        ui.println("Haircut or new hair color?");
        ui.waitForEnter();

        ui.println("Right now, your hair color is: " + player.getHairColor());
        ui.waitForEnter();

        ui.println("If you change it completely, it'll be harder for anyone to track you down.");
        ui.println("A full color change costs " + COLOR_CHANGE_COST + "dollars.");
        ui.println("You currently have " + player.getMoney() + " dollars.");
        ui.println("");

        if (player.getMoney() >= COLOR_CHANGE_COST) {
            ui.println("The hairdresser seems chatty. Chatty people hear things.");
            ui.println("Maybe you'll walk out with a new look… and some new gossip.");

            String colorChange;
            while (true) {
                colorChange = ui.ask("What do you want? Just a cut or a full color change? (cut/change): ")
                        .trim().toLowerCase();

                if ("cut".equals(colorChange) || "change".equals(colorChange)) {
                    break;
                }
                ui.println("Invalid choice. Type 'cut' or 'change'.");
            }

            if ("change".equals(colorChange)) {
                String newColor;
                while (true) {
                    ui.println("Choose your new hair color (blonde/brunette/red/blue): ");
                    newColor = ui.readLine().trim().toLowerCase();

                    switch (newColor) {
                        case "blonde":
                        case "brunette":
                        case "red":
                        case "blue":
                            // check if same as current
                            if (newColor.toUpperCase().equals(player.getHairColor().name())) {
                                ui.println("That's already your color. Pick something different if you want to hide.");
                                continue;
                            }
                            break;
                        default:
                            ui.println("That's not a color we do. Type blonde, brunette, red, or blue.");
                            continue;
                    }
                    break;
                }

                player.spendMoney(COLOR_CHANGE_COST);
                player.setHairColor(Color.valueOf(newColor.trim().toUpperCase()));
                hairDresser.talk();
                hairDresser.gossip(player);
                ui.waitForEnter();
                ui.println("You leave the salon looking like a different person.");
                ui.println("And you've got fresh gossip that the cops might pay for one day.");
                ui.println("'I could make some real money with this info,' you think.");

            } else {
                ui.println("You settle for a simple cut. Cleaner, sharper, but still you.");
                ui.waitForEnter();
                ui.println("The hairdresser spins the chair around. \"Looks good,\" they say.");
            }
        } else {
            ui.println("You check your pockets. Not enough cash for a color change.");
            ui.println("All you can afford is a basic cut.");
            ui.waitForEnter();
            ui.println("You sit down anyway. No new identity today, just shorter hair.");
            ui.waitForEnter();
            ui.println("The cut is done. \"Have a great day!\" the hairdresser says.");
        }
        ui.waitForEnter();
    }
}
