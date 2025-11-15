/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mafiagame.model.characters;

/**
 *
 * @author hekla THIS ONE SHOULD MAYBE NOT BE A THING? 
 * OR WE HAVE TO AT LEAST FIND SOMETHING TO DIFFERENTIATE FROM HUMAN
 */
public class DrugBuyer extends Human{
    
    public DrugBuyer(String name, 
            int age, 
            Gender gender, 
            Drink favoriteDrink){
        
        super(name, age, gender, favoriteDrink);
    }
    
    @Override
    public void introduce(){
        System.out.print("Hi, I am detective "+ this.getName() );
    }
    
    public void buyDrugsFrom(MafiaMember mafiaMember){
        System.out.print("You are under arrest !");
    }
}
