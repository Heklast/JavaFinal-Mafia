package mafiagame.model.characters;

import mafiagame.behavior.IllegalActivity;
import mafiagame.model.Knowledge;

/**
 * Represents the playable mafia member controlled by the user.
 *
 * <p>A {@code MafiaMember} is a {@link Human} who is part of a mafia family,
 * can earn or spend money, hide by changing hair colour, reveal information
 * about the boss, and engage in illegal activities such as drug deals.</p>
 *
 * <p>This class stores all the important player stats:
 * money, death risk, hair colour, family affiliation, and collected knowledge.</p>
 */
public class MafiaMember extends Human implements IllegalActivity {

    /**
     * The current probability (0.0–1.0) that the mafia member will be killed.
     * Increases when snitching or performing risky actions.
     */
    private double deathChance = 0.0;

    /**
     * Money earned when selling drugs to a bad cop.
     */
    private static final int BADCOP_MONEY = 50;

    /**
     * Enumeration of the possible Mafia families the character can belong to.
     */
    public enum Family { CORVETTA, JULIO }

    /**
     * Possible hair colors for the mafia member, used for identity changing.
     */
    public enum Color { RED, BLUE, BLONDE, BRUNETTE }

    private Color hairColor;
    private Family belongsToFamily;

    private int money;
    private boolean bossFindsYou;
    private boolean gameOver;
    private Knowledge knowledge;

    /**
     * Constructs a {@code MafiaMember} with only name and age.
     * <p>Used when additional attributes are set later.</p>
     *
     * @param name the mafia member's name
     * @param age  the mafia member's age
     */
    public MafiaMember(String name, int age) {
        super(name, age);
    }

    /**
     * Constructs a fully initialized {@code MafiaMember}.
     *
     * @param name            the name of the mafia member
     * @param age             the age
     * @param gender          the gender
     * @param favoriteDrink   the preferred drink
     * @param hairColor       current hair colour
     * @param belongsToFamily the mafia family they belong to
     * @param money           starting money
     * @param bossFindsYou    starting bossFindsYou state
     * @param gameOver        starting gameOver state
     * @param knowledge       initial known secrets
     */
    public MafiaMember(String name,
                       int age,
                       Gender gender,
                       Drink favoriteDrink,
                       Color hairColor,
                       Family belongsToFamily,
                       int money,
                       boolean bossFindsYou,
                       boolean gameOver,
                       Knowledge knowledge) {

        super(name, age, gender, favoriteDrink);
        this.hairColor = hairColor;
        this.money = money;
        this.belongsToFamily = belongsToFamily;
        this.bossFindsYou= bossFindsYou;
        this.knowledge = knowledge;
        this.gameOver=gameOver;
    }

    /**
     * Prints an introduction describing the player's motivations and the goal
     * of escaping the mafia life.
     */
    @Override
    public void introduce() {
        System.out.println();
        System.out.println("My name is " + this.getName()
                + ". You remember it but don't repeat it anywhere. Got it?");
        System.out.println("I really want to get away from this dangerous life...");
        System.out.println("500 dollars and I will have enough to live in peace!");
        System.out.println("But I have to do it without dying or getting arrested in the process...");
        System.out.println();
    }

    /**
     * Prints a pleading message used when begging the mafia boss for mercy.
     */
    public void plead() {
        System.out.println("\"Please spare me\", I say.");
    }

    /**
     * Performs a drug deal with a partner involved in illegal activities.
     * <p>This implementation handles the case where the partner is a bad cop.
     * The player earns a fixed amount of money after the exchange.</p>
     *
     * @param partner the character participating in the illegal deal
     */
    @Override
    public void drugDealWith(IllegalActivity partner) {
        System.out.println("You don't want any problems and you desperately need the money to disappear.");
        System.out.println("You slide him the plastic bag and take the cash.");
        System.out.println("50 dollars. One step closer to freedom.");

        addMoney(BADCOP_MONEY);

        System.out.println("You now have " + this.getMoney() + " dollars.");
    }


    /** @return the current hair colour */
    public Color getHairColor() { return hairColor; }

    /**
     * Sets the character's hair colour.
     *
     * @param color the new hair colour
     */
    public void setHairColor(Color color) { this.hairColor = color; }

    /** @return the knowledge object containing secrets */
    public Knowledge getKnowledge() { return knowledge; }

    /**
     * Assigns a new knowledge list.
     *
     * @param k the knowledge instance
     */
    public void setKnowledge(Knowledge k) { this.knowledge = k; }

    /** @return current money balance */
    public int getMoney() { return money; }

    /** @return the mafia family this character belongs to */
    public Family getFamily() { return belongsToFamily; }

    /** @return whether the boss finds you */
    public boolean getBossFindsYou() { return bossFindsYou; }

    /**
     * Sets the boss finds you state.
     *
     * @param b true if boss found you
     */
    public void setBossFindsYou(boolean b) { this.bossFindsYou = b; }
    
     public boolean getGameOver() { return gameOver; }
    
     public void setGameOver(boolean b) { this.gameOver = b; }

    /** @return current probability of death */
    public double getDeathChance() { return deathChance; }

    /**
     * Increases the death chance by a specific amount, clamped between 0 and 1.
     *
     * @param amount the amount to add to deathChance
     */
    public void changeDeathChance(double amount) {
        this.deathChance += amount;
        if (this.deathChance > 1.0) this.deathChance = 1.0;
        if (this.deathChance < 0.0) this.deathChance = 0.0;
    }

    /**
     * Adds money to the player's wallet.
     *
     * @param amount amount to add
     */
    public void addMoney(int amount) {
        this.money += amount;
    }

    /**
     * Checks whether the player can afford a given cost.
     *
     * @param amount the required amount
     * @return true if the player has enough money
     */
    public boolean canAfford(int amount) {
        return this.money >= amount;
    }

    /**
     * Spends money if enough is available.
     *
     * @param amount amount to subtract
     * @throws IllegalStateException if player does not have enough
     */
    public void spendMoney(int amount) {
        if (!canAfford(amount)) {
            throw new IllegalStateException("Not enough money");
        }
        this.money -= amount;
    }

    /**
     * @return true if the player knows at least one secret
     */
    public boolean hasSecrets() {
        return knowledge != null && knowledge.hasSecrets();
    }

    /**
     * Peeks at the first secret without removing it.
     *
     * @return the first secret, or null if none exist
     */
    public String peekFirstSecret() {
        if (knowledge == null) return null;
        return knowledge.getFirstInfo();
    }

    /**
     * Reveals and removes the first secret from the knowledge list.
     *
     * @return the removed secret, or null if none exist
     */
    public String revealFirstSecret() {
        if (knowledge == null) return null;
        return knowledge.revealFirstSecret();
    }

    /**
     * Rolls a random chance to determine if the mafia boss finds the mafia member
     * if the random roll is smaller than the deathChange then he is found
     *
     * @param roll a random value between 0.0 and 1.0
     * @return true if the roll results in death, false otherwise
     */
    public boolean rollForFoundByBoss(double roll) {
        if (bossFindsYou) return true;
        if (roll < deathChance) {
            bossFindsYou = true;
        }
        return bossFindsYou;
    }
}
