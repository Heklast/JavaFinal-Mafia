package mafiagame.scenes;

import mafiagame.ConsoleUI;
import mafiagame.model.characters.DockWorker;
import mafiagame.model.characters.MafiaMember;

/**
 * Handles the dock / drug deal sequence.
 */
public class DockScene {

    private final ConsoleUI ui;
    private static final int BRIBE_AMOUNT = 70;
    private static final int DEAL_PROFIT = 50;

    public DockScene(ConsoleUI ui) {
        this.ui = ui;
    }

    public void play(MafiaMember player) {
        DockWorker dockWorker = new DockWorker();

        ui.println("You make your way down to the docks.");
        ui.println("It is cold and dark.");
        ui.waitForEnter();
        ui.println("You know the Dock Worker might see something he should not.");
        ui.println("You can try to buy his silence for 70 dollars.");
        ui.println("Right now, you have " + player.getMoney() + " dollars.");
        ui.println("");

        String bribeChoice;
        while (true) {
            bribeChoice = ui.ask("Do you try to bribe him or take your chances? (bribe/not bribe): ")
                    .trim().toLowerCase();

            if ("bribe".equals(bribeChoice) || "not bribe".equals(bribeChoice)) {
                break;
            }
            ui.println("Invalid choice. Type exactly 'bribe' or 'not bribe'.");
        }

        if ("bribe".equals(bribeChoice)) {
            if (player.canAfford(BRIBE_AMOUNT)) {
                bribeWorker(player, dockWorker);
                dockWorker.setBribed(true);
                ui.waitForEnter();
                ui.println("The Dock Worker pockets the cash and looks away, pretending not to see you.");
            } else {
                ui.println("He does not accept the Bribe, it is less than what he wants.");
                ui.println("You'll have to go through with the deal and hope he keeps quiet.");
                handleUnbribedDock(player, dockWorker);
            }
        } else {
            handleUnbribedDock(player, dockWorker);
        }
    }

    private void bribeWorker(MafiaMember player, DockWorker dockWorker) {
        player.introduce();
        dockWorker.introduce();
        ui.println("You pull the Dock Worker aside, away from prying eyes.");
        ui.println("\"You didn't see anything tonight,\" you whisper.");
        ui.println("You press a wad of cash into his hand.");
        player.spendMoney(BRIBE_AMOUNT);
        ui.println("He nods slowly. Fear does the rest.");
        ui.println("You now have " + player.getMoney() + " dollars left.");
    }

    private void handleUnbribedDock(MafiaMember player, DockWorker dockWorker) {
        ui.println("You leave to do the drug deal.");
        double random = Math.random();
        if (random > 0.5) {
            ui.println("The Dock Worker hesitates, then reaches for his phone...");
            dockWorker.callsCops(Boolean.TRUE, player);
        } else {
            ui.println("The Dock Worker shrugs and lights a cigarette. Maybe he doesn't care enough to call.");
            ui.waitForEnter();

            ui.println("The dock is almost empty. Just a hunched figure sitting alone on a bench.");
            ui.println("Exactly where he said he'd be.");
            ui.waitForEnter();
            ui.println("You walk over, hand him the package, and he slides 50 dollars into your pocket.");
            player.addMoney(DEAL_PROFIT);
            ui.waitForEnter();
            ui.println("Deal done. No shots. No sirens. Could've gone worse.");
            ui.waitForEnter();
            ui.println("You head home and collapse into bed.");
            ui.waitForEnter();
            ui.println("A new day begins. The city never sleeps, and neither does trouble.");
            ui.waitForEnter();
        }
    }
}
