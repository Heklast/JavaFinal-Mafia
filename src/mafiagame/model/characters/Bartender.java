/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mafiagame.model.characters;


public class Bartender extends Human {

    private final boolean friendly;

    public Bartender(String name,
                     int age,
                     Gender gender,
                     Drink favoriteDrink,
                     boolean friendly) {

        super(name, age, gender, favoriteDrink);
        this.friendly = friendly;
    }

    @Override
    public void introduce() {
        System.out.println("The bartender wipes down the counter and nods.");
        if(friendly){
        System.out.println("\"I'm " + this.getName() + ". What can I get you tonight?\"");}
        else{System.out.println("\"What do you want?\"");}
        System.out.println();
    }

    /**
     * The bartender chats a bit with the player 
     */
    public void gossip() {

            if (friendly) {
                System.out.println(this.getName() + " leans in slightly.");
                System.out.println("\"Slow night, huh? People been talking about a new barber down the street.\"");
                System.out.println("\"And I heard the docks smell worse than usual — must be the sea.\"");
            } else {
                System.out.println(this.getName() + " keeps polishing a glass quietly.");
                System.out.println("He doesn't seem in the mood for conversation.");
            }
    }
}
