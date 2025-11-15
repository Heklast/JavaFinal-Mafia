/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mafiagame.model.characters;


public class Bartender extends Human {

    private Boolean friendly;

    public Bartender(String name,
                     int age,
                     Gender gender,
                     Drink favoriteDrink,
                     Boolean friendly) {

        super(name, age, gender, favoriteDrink);
        this.friendly = friendly;
    }

    @Override
    public void introduce() {
        System.out.println("The bartender wipes down the counter and nods.");
        System.out.println("\"I'm " + this.getName() + ". What can I get you tonight?\"");
        System.out.println();
    }

    public void gossip() {
        try {
            boolean isFriendly = (friendly != null && friendly);

            if (isFriendly) {
                System.out.println(this.getName() + " leans in slightly.");
                System.out.println("\"Slow night, huh? People been talking about a new barber down the street.\"");
                System.out.println("\"And I heard the docks smell worse than usual — must be the sea.\"");
            } else {
                System.out.println(this.getName() + " keeps polishing a glass quietly.");
                System.out.println("He doesn't seem in the mood for conversation.");
            }

        } catch (Exception e) {
            System.out.println("The bartender seems distracted and says nothing useful.");
        }
    }

    /**
     * Bartender cannot change hair color. He will politely redirect you.
     */
    public void changeHairColor(Human human) {
        try {
            if (human == null) {
                throw new IllegalArgumentException("No one is here asking for a haircut.");
            }

            System.out.println(this.getName() + " chuckles softly.");
            System.out.println("\"Sorry, friend. I serve drinks, not haircuts.\"");
            System.out.println("\"If you want a new look, try the salon two blocks down.\"");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("The bartender looks confused and returns to wiping the counter.");
        }
    }
}
