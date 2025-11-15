package mafiagame.scenes;

import mafiagame.ui.ConsoleUI;
import mafiagame.model.characters.Cop;
import mafiagame.model.characters.MafiaMember;
import mafiagame.model.Knowledge;

/**
 * Handles the encounter with a regular cop.
 */
public class CopScene {

    private final ConsoleUI ui;
      private static final double SNITCH_DEATH_INCREASE = 0.2;

    public CopScene(ConsoleUI ui) {
        this.ui = ui;
    }

    public void play(MafiaMember player, Cop cop) {
        cop.introduce();

        Knowledge k = player.getKnowledge();
        boolean hasSecrets = (k != null) && k.hasSecrets();

        if (!hasSecrets) {
            ui.println("You rack your brain, but you don't really have anything new on the boss... yet.");
            ui.println("'I don't have any info for you, sorry'.");
        } else {
            try {
                ui.println("You remember the secrets you've picked up over time...");
                String firstSecret = player.peekFirstSecret();  // just peek, don't remove
                if (firstSecret != null) {
                    ui.println("You know at least one useful thing about the boss: " + firstSecret);
                } else {
                    ui.println("For a moment, your mind goes blank.");
                }
            } catch (Exception e) {
                ui.println("Your mind goes blank for a moment. You struggle to remember details.");
            }

            ui.waitForEnter();
            ui.println("The cop leans closer. \"You look like someone who's tired of taking orders,\" he says.");
            ui.println("If you talk, you could walk away with serious money...");
            ui.println("But if the boss finds out, you're as good as dead.");
            ui.println("");

            String valid;
            while (true) {
                valid = ui.ask("Snitch or stay loyal? (y/n): ").trim().toLowerCase();

                if ("y".equals(valid) || "n".equals(valid)) {
                    break;
                }
                ui.println("That's not an option. You either snitch (y) or you keep your mouth shut (n).");
            }

            boolean sn = valid.equals("y");
            handleSnitch(player, sn);
        }
    }

    private void handleSnitch(MafiaMember player, boolean snitch) {
        if (snitch) {
            try {
                if (player.hasSecrets()) {
                    String revealed = player.revealFirstSecret();  // reveal + remove
                    ui.println("");
                    ui.println("You take a deep breath and start talking about your mafia boss.");
                    ui.println("You tell him that " + revealed);
                    ui.waitForEnter();
                    ui.println("");
                } else {
                    ui.println("You open your mouth, but nothing useful comes out.");
                }
            } catch (Exception e) {
                ui.println("Your thoughts get tangled. You can't remember the details clearly.");
            }

            player.addMoney(100);
            Cop.copApplausesMM(player);

            player.increaseDeathChance(SNITCH_DEATH_INCREASE);

            ui.println("You snitched. Now only a matter of time Boss finds out about it");
            ui.println("But at least you are up to " + player.getMoney() + " dollars.");
        } else {
            ui.println("You stare at the cop, then look away.");
            ui.println("\"I don't know anything,\" you say.");
            ui.println("Loyalty might save you. Or doom you.");
        }
    }
}
