/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mafiagame.model.characters;

import mafiagame.behavior.IllegalActivity;

/**
 *
 * @author hekla
 */
public class BadCop extends Human implements IllegalActivity{
    
   // public BadCop(String name, 
     //       int age, 
       //     Gender gender, 
         //   Drink favoriteDrink, 
           // int noOfArrests, 
           // int yearsOnTheJob,
    
            //String partner){
         //super(name, age, gender, favoriteDrink, noOfArrests, yearsOnTheJob, partner);
    //}
    
    public BadCop(String name, int age){
        super(name,age);
    }
    
    @Override
    public void drugDeal(MafiaMember mafiaMember){
        introduce();
        mafiaMember.sellDrugs(this); //make this one in mafiamember
    }
    
    @Override
    public void introduce(){
        System.out.println("He flashes a badge… then hides it again.");
        System.out.println("Relax. I am a cop only on paper.");
        System.out.println("You got something for sale? I pay fast, and I pay cash.");
            }
    
}
