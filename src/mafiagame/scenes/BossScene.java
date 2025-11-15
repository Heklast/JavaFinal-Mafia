/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mafiagame.scenes;

import mafiagame.ui.ConsoleUI;
import mafiagame.model.characters.MafiaBoss;
import mafiagame.model.characters.MafiaMember;

/**
 *
 * Handles everything that happens at the bar.
 */
public class BossScene {

    private final ConsoleUI ui;

    public BossScene(ConsoleUI ui) {
        this.ui = ui;
    }
    
/**
 *
 * Plays out meeting the Boss when he finds you
 * uses a method from MafiaBoss where he decides whether he should kill you or not
 * the method is a 50/50
 * @param player, boss MafiaMember and MafiaBoss
 */
    public void play(MafiaMember player, MafiaBoss boss) {
        ui.println("A shadow appears behind you...");
        boss.introduce();
        player.plead();

        if (boss.decidesToKill(Math.random())) {
            ui.println("BANG. You're dead.");
            ui.println("GAME OVER");
            player.setGameOver(true);
        } else {
            ui.println("You are the first. He lets you live... this time");
        }
    }
}