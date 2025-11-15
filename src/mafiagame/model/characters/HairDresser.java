/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mafiagame.model.characters;

import java.util.Random;

/**
 *
 * @author hekla
 */
public class HairDresser extends Human{
    private final String favActor;
    private static final String[] gossip={
        "he is going to the docks tomorrow at 4",
        "next time he wants to change his hair to green",
        "he is going to a birthday party on the 14th",
        "he has a secret hideout at 5th Boult Avenue"
    };
    
    public HairDresser(String name, 
            int age, 
            Gender gender, 
            Drink favoriteDrink, String favActor){
        
        super(name, age, gender, favoriteDrink);
        this.favActor=favActor;
    }
    
    public HairDresser(String favActor){
        this.favActor=favActor;}
    
    @Override
    public void introduce(){
        System.out.print("Hi, I am your hairdresser today, soo nice to meet you. ");
        System.out.println("I am so looking forward to getting to know you !");
        System.out.println("Would you like just a haircut or a fun color change as well ?");
    }
    
    public void gossip(MafiaMember mafiaMember){
        Random r=new Random();
        String info=gossip[r.nextInt(gossip.length)];
        System.out.println("Yeah so my favorite actor is " + this.getFavActor() + "and I actually just");
        System.out.println(" did the " + mafiaMember.getFamily()+" mafia Boss' hair earlier today and he told me " + info);
        mafiaMember.getKnowledge().addInfo(info);
    }
    
    public void talk(){
        System.out.println("'Ahhh how fun you decided to get a hair color change.");
        System.out.println("It was for sure the right decision, your hair is looking so boring right now !");
        System.out.println("Well let's start, did you know my favorite actor is " + this.getFavActor() +"'");
        System.out.println();
        System.out.println("Rohh this is going to be a treat listening to her... ");
        System.out.println();
    }
       
    public String getFavActor(){
        return this.favActor;
    }
      
    
    
    public void changeHairColor(Human human){
        System.out.print("You are under arrest !");
    }
    
}
