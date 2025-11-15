/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mafiagame.model.characters;

/**
 *
 * @author hekla
 */
abstract public class Human {
    
    public enum Gender{FEMALE, MALE, UNDEFINED};
    public enum Drink{BEER, WATER, FANTA};
    
    
    private String name;
    private int age;
    private Gender gender;
    private Drink favoriteDrink;
    
    /**
     *
     * @param name
     * @param age
     * @param gender
     * @param favoriteDrink
     */
    public Human(
            String name, 
            int age, 
            Gender gender, 
            Drink favoriteDrink ){
        this.name=name;
        this.age=age;
        this.gender=gender;

        this.favoriteDrink=favoriteDrink;
    }
    public Human(){}
     public Human(String name, int age){
        this.name=name;
        this.age=age;}
    
    
    @Override
    public String toString(){
        return "Human{"+ 
                "name=" + name+
                ", age=" + age+
                ", gender=" + gender+
                ", favoriteDrink=" + favoriteDrink +"}";
    }
    
    //ALL THE METHODS ARE WRONG, I JUST WANTED TO WRITE THEM IN!
    
    public String getsKilled(){
        return "Game Over"; //this doesnt print obvi
    }
    public String chooseGender(){
        return "Game Over"; //this doesnt print obvi
    }
    
    abstract public void introduce();


    public Drink getFavoriteDrink() {
        return favoriteDrink;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public Gender getGender(){
        return this.gender;
    }
    
    public static boolean isAgeOkay(int age){
        return age>0 && age<100;
    }
}
