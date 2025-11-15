/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mafiagame.model.characters;

import java.util.Scanner;
//import static mafiagame.model.characters.MafiaMember.waitForEnter;

/**
 *
 * @author hekla
 */
public class Cop extends Human {
    private int noOfArrests;
    private int yearsOnTheJob;
    
    public Cop(String name, int age){}
    
    public Cop(String name, 
            int age, 
            Gender gender, 
            Drink favoriteDrink, int noOfArrests, int yearsOnTheJob){
        
        super(name, age, gender, favoriteDrink);
        this.noOfArrests=noOfArrests;
        this.yearsOnTheJob=yearsOnTheJob;
    }
    
    @Override
    public void introduce(){
        System.out.println("Hi, I am detective "+ this.getName());
        System.out.println("I know who you are but don't worry. I am not after you, I'm after your boss");
        System.out.println("Give me some info about him and I'll pay you."); 
    }
    
    public static void copApplausesMM(MafiaMember m){
        Scanner keyboard=new Scanner(System.in);
        System.out.println("Thank you for thinking of the greater good !");
        System.out.println();
        ////waitForEnter(keyboard);
    }

    public void arrest(){
        System.out.print("You are under arrest !");
    }
    
    public int getNoOfArrests() {
        return noOfArrests;
    }

    public int getYearsOnTheJob() {
        return yearsOnTheJob;
    }
    
    
    
    
}
