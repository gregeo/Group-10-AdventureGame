/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textgame;

import java.util.ArrayList;

/** 
 * a class that will run a room and its dissision making
 *
 * @author George Smith
 */
public class Room {

    private boolean[] isDoor;//denoted nesw
    private Enemy enemyRef;
    private String item;
    private ArrayList<String> doableActions;
    /*
    table for doableActions:
    0 = north
    1 = east
    
    */
    private Player player;
    

    /**
     * for a room with all fetures
     *
     * 
     * @param isDoor
     * @param enemyRef
     * @param item
     * @param player
     */
    public Room(boolean[] isDoor, Enemy enemyRef, String item, Player player) {
        
        if (isDoor.length == 4) {
            this.isDoor = isDoor;
        } else {
            System.out.println("isDoor is the wrong sise :(  " + isDoor.length);
        }
        
        this.enemyRef = enemyRef;
        this.item = item;
        this.player = player;
        for(int i = 0;i < isDoor.length; i++){
            if(isDoor[i]){
                String s = "m" + i;
                doableActions.add(s);
            }
        }
     {
            
        }
    }

    /**
     * for a room with only an item and doors
     *
     * @param isDoor
     * @param item
     * @param player
     */
    public Room(boolean[] isDoor, String item, Player player) {
        if (isDoor.length == 4) {
            this.isDoor = isDoor;
        } else {
            System.out.println("isDoor is the wrong sise :(  " + isDoor.length);
        }
        this.item = item;
        this.player = player;

    }

    /**
     * for a room with only an enemy and doors
     *
     * @param isDoor
     * @param enemyRef
     * @param player
     */
    public Room(boolean[] isDoor, Enemy enemyRef, Player player) {
        if (isDoor.length == 4) {
            this.isDoor = isDoor;
        } else {
            System.out.println("isDoor is the wrong sise :(  " + isDoor.length);
        }
        this.item = item;
        this.player = player;

    }

    /**
     * for a room with only doors
     *
     * @param isDoor
     * @param player
     */
    public Room(boolean[] isDoor, Player player) {
        if (isDoor.length == 4) {
            this.isDoor = isDoor;
        } else {
            System.out.println("isDoor is the wrong sise :(  " + isDoor.length);
        }
        this.player = player;

    }

    public void attackEnemy(Player p) {

    }

    public Enemy getEnemy() {
        return this.enemyRef;
    }

}
