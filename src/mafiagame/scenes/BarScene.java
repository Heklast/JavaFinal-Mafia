package mafiagame.scenes;

import mafiagame.ui.ConsoleUI;
import mafiagame.model.characters.BadCop;
import mafiagame.model.characters.Bartender;
import mafiagame.model.characters.Cop;
import mafiagame.model.characters.Human.Drink;
import mafiagame.model.characters.Human.Gender;
import mafiagame.model.characters.MafiaMember;

/**
 * Handles everything that happens at the bar.
 */
public class BarScene {

    private final ConsoleUI ui;
    private final CopScene copScene;
    private static final int DRUG_SALE_AMOUNT = 50;

    public BarScene(ConsoleUI ui, CopScene copScene) {
        this.ui = ui;
        this.copScene = copScene;
    }

    public void play(MafiaMember player) {
        Bartender bartender = new Bartender(
                "Sam",
                45,
                Gender.MALE,
                Drink.BEER,
                Boolean.TRUE // friendly bartender
        );

        ui.println("You push open the door to your regular bar.");
        ui.println("The air is thick with smoke. Glasses clink, people mumble.");
        ui.waitForEnter();
        ui.println("You take a seat at the counter.");
        bartender.introduce();
        ui.println("You order a large " + player.getFavoriteDrink()
                + ", your favorite. The bartender nods without asking.");
        ui.waitForEnter();

        bartender.gossip();
        ui.waitForEnter();

        ui.println("You feel a presence behind you. Heavy footsteps. A shadow on the floor.");
        ui.waitForEnter();
        ui.println("You turn around...");
        ui.waitForEnter();
        ui.println("A cop. Wrong place, wrong time.");
        ui.waitForEnter();

        double random = Math.random();
        if (random < 0.5) {
            Cop cop = new Cop("David", 55, 30);
            copScene.play(player, cop);
        } else {
            BadCop badCop = new BadCop("Harold", 40);
            badCop.introduce();
            badCop.drugDealWith(player);
        }

        ui.waitForEnter();
    }
}
