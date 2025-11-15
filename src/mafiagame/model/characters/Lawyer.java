/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mafiagame.model.characters;

import mafiagame.model.characters.Human;

/**
 *
 * @author hekla
 */
 public class Lawyer extends Human {
    
     private int noOfWins;
     private int noOfLosses;
     private int yearsAsALawyer;
    
    public Lawyer(String name, 
            int age, 
            Gender gender, 
            Drink favoriteDrink, int noOfWins, int noOfLosses, int yearsAsALawyer){
        
        super(name, age, gender, favoriteDrink);
        this.noOfLosses=noOfLosses;
        this.noOfWins=noOfWins;
        this.yearsAsALawyer=yearsAsALawyer;
    }
    
    @Override
    public void introduce(){
        System.out.print("Hi, I am detective "+ this.getName());
    }
    
    public void defends(MafiaMember mafiaMember){
        System.out.print("You are under arrest !");
    }
    public void prosecutes(MafiaMember mafiaMember){
        System.out.print("You are under arrest !");
    }
    
    
}
