package mafiagame.model.characters;

import mafiagame.behavior.IllegalActivity;

/**
 * A corrupt cop who buys drugs and participates in illegal activity.
 */
public class BadCop extends Human implements IllegalActivity {

    public BadCop(String name, int age) {
        super(name, age);
    }

    @Override
    public void introduce() {
        System.out.println("Relax. I am a cop only on paper.");
        System.out.println("I just want some drugs.");
    }

    /**
     * The bad cop initiates the drug deal.
     */
    @Override
    public void drugDealWith(IllegalActivity partner) {
        introduce();

        if (partner instanceof MafiaMember mafia) {
            // Mafia handles the transaction from their side
            mafia.drugDealWith(this);
        } else {
            System.out.println("This cop only does business with mafia members.");
        }
    }
}
