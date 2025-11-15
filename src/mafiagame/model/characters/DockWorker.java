/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mafiagame.model.characters;

/**
 *
 * @author hekla
 */
public class DockWorker extends Human{
     private Boolean bribed;
    
    public DockWorker(String name, 
            int age, 
            Gender gender, 
            Drink favoriteDrink, Boolean bribed){
        
        super(name, age, gender, favoriteDrink);
        this.bribed=bribed;
    }
    
    public DockWorker(){}
    
    @Override
    public void introduce(){
        System.out.print("WHAT, I haven't done anything, please don't hurt me");
    }
    
    public void callsCops(Boolean bribed, MafiaMember mafiaMember){
        System.out.println("Wrong decision !");
        System.out.println("Dock worker " +this.getName() + " is a model citizen and calls the cops as soon as he sees a drug deal going on.");
        System.out.println("Blue lights... Have fun in prison...");
        System.out.println("GAME OVER");
        mafiaMember.setGameOver(true);
    }
    
}
