/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mafiagame.model.characters;

/**
 *
 * @author hekla
 */
public class Detective extends Cop {
    private String partner;
    
    public Detective(String name, 
            int age, 
            Gender gender, 
            Drink favoriteDrink, 
            int noOfArrests, 
            int yearsOnTheJob,
    
            String partner
    ){
        super(name, age, gender, favoriteDrink, noOfArrests, yearsOnTheJob);
        this.partner=partner;
    }
    
    
    public String getPartner() {
        return partner;
    }
    
}
