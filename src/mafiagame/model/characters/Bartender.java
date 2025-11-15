/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mafiagame.model.characters;

/**
 *
 * @author hekla
 */
public class Bartender extends Human {
    
   private Boolean friendly;
    
    public Bartender(String name, 
            int age, 
            Gender gender, 
            Drink favoriteDrink, Boolean friendly){
        
        super(name, age, gender, favoriteDrink);
        this.friendly=friendly;
    }
    
    @Override
    public void introduce(){
        System.out.print("Hi, I am detective "+ this.getName());
    }
    
    public void gossip(){
        System.out.print("You are under arrest !");
    }
    public void changeHairColor(Human human){
        System.out.print("You are under arrest !");
    }
}
