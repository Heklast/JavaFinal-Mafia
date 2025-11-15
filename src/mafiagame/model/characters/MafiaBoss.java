/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mafiagame.model.characters;

/**
 *
 * @author hekla
 */
public class MafiaBoss extends MafiaMember{
    
    public enum Popularity{DEADMEAT, TOLERATED, FINE, LOVELY};
    
    private int yearsAsBoss;
    private Popularity popularity;
    
    public MafiaBoss(String name,
            int age, 
            Gender gender, 
            Drink favoriteDrink,
            int yearsInTheMafia,
            Color hairColor,
            Family belongsToFamily,
            int yearsAsBoss, 
            Popularity popularity, 
            int money
    ){
        super(name, age, gender, favoriteDrink, hairColor,belongsToFamily, money);
        this.popularity=popularity;
        this.yearsAsBoss=yearsAsBoss;
       
    }
    public MafiaBoss(String name, int age, Family belongsToFamily){super(name,age);
    this.belongsToFamily=belongsToFamily;}
    
    @Override
    public void introduce() {
        System.out.println("I am Mafia Boss " + this.getName() + " and I have heard you have been snitching to the cops about me !");
        System.out.println("\"You should’ve stayed loyal,\" he growls.");
        BossMan bossMan=new BossMan("Julio", 25);
        System.out.println();
        killHim(bossMan);
    }
    public int getYearsAsBoss() {
        return yearsAsBoss;
    }

    public Popularity getPopularity() {
        return popularity;
    }
    
    public void killHim(BossMan b){
        System.out.println("You betray Boss, you DIE");
        System.out.println("BAM");
    }

    
}
