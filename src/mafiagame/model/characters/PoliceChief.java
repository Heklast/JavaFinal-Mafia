/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mafiagame.model.characters;

import mafiagame.model.characters.Cop;
import mafiagame.model.characters.Detective;

/**
 *
 * @author hekla
 */
public class PoliceChief extends Cop{
    
    private String headOf;
    
    public PoliceChief(String name, 
            int age, 
            Gender gender, 
            Drink favoriteDrink, 
            int noOfArrests, 
            int yearsOnTheJob,
    
            String headOf
    ){
        super(name, age, gender, favoriteDrink, noOfArrests, yearsOnTheJob);
        this.headOf=headOf;
    }
    
    public void takesBadge(Cop cop){}
    
    public void makesPartners(Detective det1, Detective det2){
    
    }
    
}
