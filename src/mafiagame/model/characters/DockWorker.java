/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mafiagame.model.characters;

/**
 * DockWorker represents the worker at the docks who may either look away
 * if he has been bribed, or call the cops when he witnesses a drug deal.
 */
public class DockWorker extends Human {

    private boolean bribed;

    /**
     * Default constructor, used when MafiaMember simply creates a dock worker
     * for the current scene.
     */
    public DockWorker() {
        // some reasonable default values
        super("Earl", 50, Gender.MALE, Drink.BEER);
        this.bribed = false;
    }

    public DockWorker(String name,
                      int age,
                      Gender gender,
                      Drink favoriteDrink,
                      Boolean bribed) {

        super(name, age, gender, favoriteDrink);
        // if the Boolean is null, treat it as false
        this.bribed = (bribed != null && bribed);
    }

    @Override
    public void introduce() {
        System.out.println("Dock worker " + this.getName()
                + " looks up from his clipboard, startled.");
    }

    public boolean isBribed() {
        return bribed;
    }

    public void setBribed(boolean bribed) {
        this.bribed = bribed;
    }

    /**
     * Called when the dock worker sees (or could see) a drug deal.
     * If he is not bribed, he calls the cops and the game ends.
     * If he has been bribed, he chooses to stay quiet.
     *
     * @param sawDeal      true if he clearly saw the deal
     * @param mafiaMember  the main character, used to end the game
     */
    public void callsCops(Boolean sawDeal, MafiaMember mafiaMember) {
        // safety: only act if we actually saw something
        if (!Boolean.TRUE.equals(sawDeal)) {
            return;
        }

        if (this.bribed) {
            System.out.println(this.getName()
                    + " reaches for his phone, then feels the money in his pocket.");
            System.out.println("He sighs, looks away and pretends he saw nothing.");
            return;
        }
        System.out.println("Dock worker " + this.getName()
                + " is a model citizen and calls the cops as soon as he sees a drug deal going on.");
        System.out.println("Blue lights flash across the water… sirens scream closer.");
        System.out.println("You are surrounded before you can run.");   
        Cop cop = new Cop("David", 55, 30);
        cop.arrest(mafiaMember);
        
    }

}
