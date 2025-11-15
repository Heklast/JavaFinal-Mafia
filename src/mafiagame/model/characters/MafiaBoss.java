/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mafiagame.model.characters;

/**
 *
 * @author hekla
 */
public class MafiaBoss extends MafiaMember {

    private static final int DEFAULT_AGE = 72;
    private int yearsAsBoss;

    public MafiaBoss(String name) {
        super(name, DEFAULT_AGE);
        this.yearsAsBoss = 10;
    }
    
    @Override
    public void introduce(){
        System.out.println("\"Well well, you have not been a very good member of my mafia\" the boss growls.");
        System.out.println("\"I have been the boss for " + DEFAULT_AGE + " years and never have I let betrayers live");
        System.out.println("\"Will you be the first ?\" the boss asks.");
    }

    public boolean decidesToKill(double random) {
        return random < 0.5;
    }
}

