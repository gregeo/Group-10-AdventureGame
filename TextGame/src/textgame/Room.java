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
        this(isDoor, enemyRef, player);
        this.item = item;

    }

    /**
     * for a room with only an item and doors
     *
     * @param isDoor
     * @param item
     * @param player
     */
    public Room(boolean[] isDoor, String item, Player player) {
        this(isDoor, player);
        this.item = item;
    }

    /**
     * for a room with only an enemy and doors
     *
     * @param isDoor
     * @param enemyRef
     * @param player
     */
    public Room(boolean[] isDoor, Enemy enemyRef, Player player) {
        this(isDoor, player);
        this.enemyRef = enemyRef;
        doableActions.add("attack enemy");

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
        if (isDoor[0]) {
            doableActions.add("move north");
        }
        if (isDoor[1]) {
            doableActions.add("move east");
        }
        if (isDoor[2]) {
            doableActions.add("move south");
        }
        if (isDoor[3]) {
            doableActions.add("move west");
        }
        this.player = player;
        doableActions.add("search room");

    }

    /**
     * 
     * @param input
     * @return 
     */
    public int doAction(String input) {
        input = input.toLowerCase();

        if (input.contains("move")) {
            this.move(input);
        } else if (input.contains("attack")) {
            this.attackEnemy();
        } else if (input.contains("search")) {
            this.search();
        } else if (input.contains("use")) {
            this.useItem();
        } else {
            System.out.println("oops not a valid command");
            return -1;
        }
        return 1;
    }

    private void attackEnemy() {

    }
/**
 * 
 * @param actionToDo
 * @return 
 */
    private int move(String actionToDo) {
        int dir = -1;
        if (actionToDo.contains("north")) {
            dir = 10;
        } else if (actionToDo.contains("east")) {
            dir = 11;
        } else if (actionToDo.contains("south")) {
            dir = 12;
        } else if (actionToDo.contains("west")) {
            dir = 13;
        } else {
            System.out.println("oopy not a valid direction");
        }
        
        return dir;
    }
    /**
     * 
     * @return 
     */

    private int useItem() {
        return player.useItem(item);
    }
    /**
     * 
     * @return 
     */

    private int search() {
        if (item != null) {
            player.pickUpItem(item);
            item = null;
            return 1;
        } else {
            System.out.println("no item found");
            return -1;
        }
    }

    public Enemy getEnemy() {
        return this.enemyRef;
    }

    public boolean[] getIsDoor() {
        return this.isDoor;
    }

    public String getItem() {
        return this.item;
    }

    public ArrayList<String> getDoableActions() {
        return this.doableActions;
    }
    public String toString(){
        String s = "";
        
        if (this.enemyRef != null){
            s =s + "enemy in room: \n \t";
            s = s + this.enemyRef.toString() + "\n";
        }else{
            s = s + "no enemy in room \n"; 
        }
        
        
        if (this.item != null){
            s =s + "enemy in room: \n \t" + this.item + "\n";
            
        }else{
            s = s + "no item in room \n"; 
        }
        s = s + "doable actions in room \n \t " ;
        //for(){
            
        //}
        
        
        
        return s;
    }

}
