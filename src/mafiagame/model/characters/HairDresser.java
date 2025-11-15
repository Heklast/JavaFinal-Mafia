package mafiagame.model.characters;

import java.util.Random;

/**
 * Represents a hairdresser character the player can interact with.
 *
 * <p>The {@code HairDresser} provides small talk, gossip, and occasionally
 * valuable information related to the mafia boss. When the player chooses
 * a full hair color change, this character may reveal a random secret that
 * gets added to the player's {@link mafiagame.model.Knowledge}.</p>
 *
 * <p>This character also has a favorite actor and some preset gossip lines
 * that can be used to give the player clues about the story.</p>
 */
public class HairDresser extends Human {

    /**
     * The hairdresser's favorite actor, mentioned during gossip.
     */
    private final String favActor;

    /**
     * A list of possible gossip lines about the mafia boss.
     * One of these is selected at random each time the player
     * performs a full hair color change.
     */
    private static final String[] GOSSIP = {
        "he is going to the docks tomorrow at 4",
        "next time he wants to change his hair to green",
        "he is going to a birthday party on the 14th",
        "he has a secret hideout at 5th Boult Avenue"
    };

    /**
     * Creates a new {@code HairDresser} with all attributes initialized.
     *
     * @param name          the hairdresser's name
     * @param age           the hairdresser's age
     * @param gender        the hairdresser's gender
     * @param favoriteDrink the hairdresser's favorite drink
     * @param favActor      the hairdresser's favorite actor
     */
    public HairDresser(String name,
                       int age,
                       Gender gender,
                       Drink favoriteDrink,
                       String favActor) {

        super(name, age, gender, favoriteDrink);
        this.favActor = favActor;
    }

    /**
     * Introduces the hairdresser to the player.
     *
     * <p>This method prints a friendly introduction and begins the small talk
     * that sets the tone for the hairdressing scene.</p>
     */
    @Override
    public void introduce() {
        System.out.println("Hi, " + "my name is " + this.getName());
        System.out.println("I am your hairdresser today, soo nice to meet you.");
        System.out.println("I am so looking forward to getting to know you !");
        System.out.println("Would you like just a haircut or a fun color change as well ?");
    }

    /**
     * Shares random gossip with the player and adds the selected information
     * to the mafia member's knowledge list.
     *
     * <p>This simulates the hairdresser accidentally revealing something the
     * mafia boss said earlier during a haircut.</p>
     *
     * @param mafiaMember the player character who will receive the secret
     */
    public void gossip(MafiaMember mafiaMember) {
        Random r = new Random();
        String info = GOSSIP[r.nextInt(GOSSIP.length)];
        System.out.println("Yeah so my favorite actor is " + this.getFavActor() + " and I actually just");
        System.out.println("did the " + mafiaMember.getFamily() + " mafia Boss' hair earlier today and he told me " + info);
        mafiaMember.getKnowledge().addInfo(info);
    }

    /**
     * Prints casual conversation from the hairdresser when starting a color change.
     *
     * <p>This method adds flavor text before the gossip is revealed.</p>
     */
    public void talk() {
        System.out.println("'Ahhh how fun you decided to get a hair color change.");
        System.out.println("It was for sure the right decision, your hair is looking so boring right now !");
        System.out.println("Well let's start, did you know my favorite drink is " + this.getFavoriteDrink() + "'");
        System.out.println();
        System.out.println("Rohh this is going to be a treat listening to her...");
        System.out.println();
    }

    /**
     * Returns the hairdresser's favourite actor.
     *
     * @return the favourite actor
     */
    public String getFavActor() {
        return this.favActor;
    }
}
