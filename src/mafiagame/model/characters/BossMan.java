/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mafiagame.model.characters;

import mafiagame.behavior.IllegalActivity;
import mafiagame.model.Money;

/**
 *
 * @author hekla
 */
public class BossMan extends MafiaMember {
    
    private int noOfKills;
    //int amountOfDrugsSold, skip because we have money? goal to get an x amount of money and kills
    
    public BossMan(
            String name, 
            int age, 
            Gender gender, 
            Drink favoriteDrink,
            Color hairColor,
            int noOfKills, 
            Family belongsToFamily,
            //int amountOfDrugsSold, skip because we have money? goal to get an x amount of money and kills
            int money
){
        
        super(name, age, gender, favoriteDrink, hairColor, belongsToFamily, money);
        this.noOfKills=noOfKills;
    }
    
    public BossMan(String name, int age){super(name, age);}
    

    public int getNoOfKills() {
        return noOfKills;
    }
    

    
}
