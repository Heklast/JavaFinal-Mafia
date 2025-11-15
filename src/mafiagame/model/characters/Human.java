package mafiagame.model.characters;

/**
 * Represents any human character in the Mafia game.
 *
 * <p>The {@code Human} class is an abstract base class that provides the
 * common attributes and behaviour shared by all human characters such as
 * name, age, gender, and favorite drink. Subclasses such as
 * {@link MafiaMember}, {@link Cop}, {@link HairDresser}, and
 * {@link BadCop} extend this class and implement their own version of
 * the {@link #introduce()} method.</p>
 *
 * <p>This class also provides utility methods such as {@link #isAgeOkay(int)}
 * for validating a character's age.</p>
 */
public abstract class Human {

    /**
     * Enumeration representing a person's gender.
     */
    public enum Gender { FEMALE, MALE, UNDEFINED }

    /**
     * Enumeration representing available favorite drinks.
     */
    public enum Drink { BEER, WATER, FANTA }

    private String name;
    private int age;
    private Gender gender;
    private Drink favoriteDrink;

    /**
     * Constructs a fully initialized {@code Human} instance.
     *
     * @param name           the character's name
     * @param age            the character's age (should be validated with {@link #isAgeOkay(int)})
     * @param gender         the gender of the character
     * @param favoriteDrink  the character's preferred drink
     */
    public Human(String name,
                 int age,
                 Gender gender,
                 Drink favoriteDrink) {

        this.name = name;
        this.age = age;
        this.gender = gender;
        this.favoriteDrink = favoriteDrink;
    }

    /**
     * Default no-argument constructor.
     * <p>
     * Provided for flexibility (mainly used by subclasses when they wish to assign
     * fields individually later).
     * </p>
     */
    public Human() {}

    /**
     * Creates a {@code Human} with only a name and age.
     * <p>
     * Gender and favorite drink can be set later by subclasses.
     * </p>
     *
     * @param name  the character's name
     * @param age   the character's age
     */
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Returns a readable string representation of the human character.
     *
     * @return a formatted string showing name, age, gender, and favorite drink
     */
    @Override
    public String toString() {
        return "Human{"
                + "name=" + name
                + ", age=" + age
                + ", gender=" + gender
                + ", favoriteDrink=" + favoriteDrink
                + "}";
    }

    /**
     * Each subclass must provide its own introduction dialogue.
     * <p>
     * This method is invoked when the character first meets the player.
     * </p>
     */
    public abstract void introduce();

    /**
     * Returns the character's favourite drink.
     *
     * @return the favourite drink
     */
    public Drink getFavoriteDrink() {
        return favoriteDrink;
    }

    /**
     * Returns the character's name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the character's age.
     *
     * @return the age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Returns the character's gender.
     *
     * @return the gender
     */
    public Gender getGender() {
        return this.gender;
    }

    /**
     * Validates whether a given age is acceptable for a human character.
     *
     * <p>Age must be greater than 0 and less than 100.</p>
     *
     * @param age the age to validate
     * @return {@code true} if the age is valid, {@code false} otherwise
     */
    public static boolean isAgeOkay(int age) {
        return age > 0 && age < 100;
    }
}
