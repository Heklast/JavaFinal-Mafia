/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mafiagame.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hekla
 */

public class Knowledge {
    private List<String> infoList = new ArrayList<>();

    public Knowledge(String info){
        addInfo(info);
    }

    public void addInfo(String info){
        infoList.add(info);
    }

    public List<String> getInfo(){
        return new ArrayList<>(infoList);
    }

    public String getFirstInfo() {
        return infoList.isEmpty() ? null : infoList.get(0);
    }

    public void removeFirstInfo() {
        if (!infoList.isEmpty()) {
            infoList.remove(0);
        }
    }

    public int size(){
        return infoList.size();
    }

    public boolean hasSecrets() {
        return !infoList.isEmpty();
    }

    public String revealFirstSecret() {
        if (infoList.isEmpty()) {
            return null;
        }
        return infoList.remove(0);
    }
}
