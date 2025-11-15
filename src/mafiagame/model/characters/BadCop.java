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
        System.out.println("'Relax. I am a cop only on paper.'");
        System.out.println("'I just want some drugs,' he says");
        System.out.println();
    }

    /**
     * The bad cop initiates the drug deal.
     */
    @Override
    public void drugDealWith(IllegalActivity partner) {
        introduce();
            partner.drugDealWith(this);
    }
}
