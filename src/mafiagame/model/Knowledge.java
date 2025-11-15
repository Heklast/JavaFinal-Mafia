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
    private String info;
    
    public Knowledge(String info){
    this.info=info;
    this.addInfo(info);}
    
    private List<String> infoList=new ArrayList<>();
    
    public void addInfo(String info){
        infoList.add(info);
    }
    public List<String> getInfo(){
        return new ArrayList<>(infoList);
    }
    public int size(){
        return infoList.size();
    }
}
