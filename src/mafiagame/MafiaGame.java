/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mafiagame;

import java.util.Scanner;
import mafiagame.model.Knowledge;
import mafiagame.model.characters.Cop;
import mafiagame.model.characters.Human;
import mafiagame.model.characters.Human.Drink;
import mafiagame.model.characters.Human.Gender;
import mafiagame.model.characters.MafiaMember;
import mafiagame.model.characters.MafiaMember.Family;



/**
 *
 * @author hekla
 */
public class MafiaGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Welcome to Mafia City ! ");
        System.out.println("REMINDER: during the game you will have to press ENTER to keep on with the story)");
        System.out.println( "First, we need some information about you ! ");
        System.out.println("name, age, gender, favoriteDrink ! "); //we have to do one at a time
        
        Scanner keyboard= new Scanner (System.in);
        String name=keyboard.nextLine();
        int age=keyboard.nextInt();
        keyboard.nextLine();
         //put all of them here
        
        while(!Human.isAgeOkay(age)){
            System.out.println("It is not possible to be younger than 0 !");
            System.out.println("Choose another age");
            age=keyboard.nextInt();
            keyboard.nextLine();
        }
       
        System.out.println( "Do you want to run around doing bad things or do you want to catch those doing wrong ?");
        System.out.println( "For a mafia member, choose m. For a cop, choose c");
        System.out.print("Choose (m/c): ");
        String choice = keyboard.nextLine();   
        
        //mafiaMember
        
        if(choice.equals("m")){
             MafiaMember mafiaMember = new MafiaMember(name,age, Gender.MALE, Drink.BEER,"blue", Family.CORVETTA, 0, false, new Knowledge("he is 2 meters"));
             mafiaMember.whereToBegin();
            while(!mafiaMember.getGameOver()){
                mafiaMember.whereToGoNext();
                mafiaMember.doYouDie();
            }}
        else {
            
        }
    
}
        //cop
        //else
    
    
  
}

