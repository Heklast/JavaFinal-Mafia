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
 * @author hekla
 */
public class BossScene {

    private final ConsoleUI ui;

    public BossScene(ConsoleUI ui) {
        this.ui = ui;
    }

    public void play(MafiaMember player, MafiaBoss boss) {
        ui.println("A shadow appears behind you...");
        boss.introduce();
        player.plead();

        if (boss.decidesToKill(Math.random())) {
            ui.println("BANG. You're dead.");
            player.setGameOver(true);
        } else {
            ui.println("You are the first. He lets you live... this time");
        }
    }
}