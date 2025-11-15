package mafiagame.model.characters;

import mafiagame.behavior.IllegalActivity;
import mafiagame.model.Knowledge;

public class MafiaMember extends Human implements IllegalActivity {

    private double deathChance = 0.0;
    private final int BADCOP_MONEY=50;

    public enum Family { CORVETTA, JULIO }
    public enum Color { RED, BLUE, BLONDE, BRUNETTE }

    private Color hairColor;
    private Family belongsToFamily;

    private int money;
    private boolean gameOver;
    private Knowledge knowledge;

    public MafiaMember(String name, int age) {
        super(name, age);
    }

    public MafiaMember(String name,
                       int age,
                       Gender gender,
                       Drink favoriteDrink,
                       Color hairColor,
                       Family belongsToFamily,
                       int money,
                       boolean gameOver,
                       Knowledge knowledge) {
        super(name, age, gender, favoriteDrink);
        this.hairColor = hairColor;
        this.money = money;
        this.belongsToFamily = belongsToFamily;
        this.gameOver = gameOver;
        this.knowledge = knowledge;
    }

    @Override
    public void introduce() {
        System.out.println("My name is " + this.getName()
                + ". You remember it, you keep it quiet. Got it?");
        System.out.println("One last big score and I'm out of this life for good...");
        System.out.println();
    }

    public void plead() {
        System.out.println("\"Please spare me\", I say.");
    }

    @Override
    public void drugDealWith(IllegalActivity partner) {
            System.out.println("You don't want any problems and you desperately need the money to disappear.");
            System.out.println("You slide him the plastic bag and take the cash.");
            System.out.println("50 dollars. One step closer to freedom.");

            addMoney(BADCOP_MONEY);

            System.out.println("You now have " + this.getMoney() + " dollars.");
    }

    public Color getHairColor() { return hairColor; }
    public void setHairColor(Color color) { this.hairColor = color; }

    public Knowledge getKnowledge() { return knowledge; }
    public void setKnowledge(Knowledge k) { this.knowledge = k; }

    public int getMoney() { return money; }

    public Family getFamily() { return belongsToFamily; }

    public boolean getGameOver() { return gameOver; }
    public void setGameOver(boolean b) { this.gameOver = b; }

    public double getDeathChance() { return deathChance; }

    public void increaseDeathChance(double amount) {
        this.deathChance += amount;
        if (this.deathChance > 1.0) this.deathChance = 1.0;
        if (this.deathChance < 0.0) this.deathChance = 0.0;
    }

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

    public boolean hasSecrets() {
        return knowledge != null && knowledge.hasSecrets();
    }

    public String peekFirstSecret() {
        if (knowledge == null) return null;
        return knowledge.getFirstInfo();
    }

    public String revealFirstSecret() {
        if (knowledge == null) return null;
        return knowledge.revealFirstSecret();
    }

    public boolean rollForDeath(double roll) {
        if (gameOver) return true;
        if (roll < deathChance) {
            gameOver = true;
        }
        return gameOver;
    }
}
