/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textgame.backend;

import java.util.ArrayList;

/**
 * A class that represents a room and handles all of the decision making in the
 * room
 *
 */
public class Room {

    //declare and initialize class members 
    private boolean[] isDoor;//denoted new
    private Enemy enemyRef;
    private String item;
    private ArrayList<String> doableActions;
    private Player player;
    private String text;

    /**
     * Constructor with all parameters specified
     *
     *
     * @param isDoor boolean array to show which dirrections have doors
     * @param enemyRef enemy object represetning the enemy in the room
     * @param item item represeted as a just a string
     * @param player The player object in that room
     * @param text the rooms text
     */
    public Room(boolean[] isDoor, Enemy enemyRef, String item, Player player, String text) {
        //call three parameter constructor
        this(isDoor, enemyRef, player, text);
        //initialize item
        this.item = item;

    }

    /**
     * constructor for a room with only an item and doors
     *
     * @param isDoor boolean array to show which directions have doors
     * @param item item represented as a just a string
     * @param player The player object in that room
     * @param text the rooms text
     */
    public Room(boolean[] isDoor, String item, Player player, String text) {
        //call two parameter constructor to set doable actions
        this(isDoor, player, text);
        //intialize item 
        this.item = item;
        //this.enemyRef = enemyRef;
    }

    /**
     * constructor for a room with only enemies and doors
     *
     * @param isDoor boolean array to show which directions have doors
     * @param enemyRef enemy object representing the enemy in the room
     * @param player The player object in that room
     * @param text the room text
     */
    public Room(boolean[] isDoor, Enemy enemyRef, Player player, String text) {
        //call two parameter constructor to set doable actions 
        this(isDoor, player, text);
        //initialize enemy in room 
        this.enemyRef = enemyRef;
        //add attacking enemy as an action
        doableActions.add("attack enemy");
    }

    /**
     * constructor for a room with only doors
     *
     * @param isDoor boolean array to show which directions have doors
     * @param player The player object in that room
     * @param text the rooms text
     */
    public Room(boolean[] isDoor, Player player, String text) {

        //create a new arrayList for doable actions
        doableActions = new ArrayList<>();

        //check if the number of doors is correct intialize the doors array 
        if (isDoor.length == 4) {
            this.isDoor = isDoor;
        } else {
            System.out.println("isDoor is the wrong sise :(  " + isDoor.length);
        }

        //add actions to doableActions based on if there is a door in that direction 
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
        //initialize player and add "search room" to doable actions because that is always an option
        this.player = player;
        this.text = text;
        doableActions.add("search room");

    }

    /**
     * Copy constructor to create a copy of a room
     *
     * @param toCopy room object to be copied
     */
    public Room(Room toCopy) {
        this.isDoor = toCopy.getIsDoor();
        this.enemyRef = toCopy.getEnemy();
        this.item = toCopy.getItem();
        this.doableActions = toCopy.getDoableActions();
        this.player = toCopy.getPlayer();
        this.text = toCopy.getText();
    }

    /**
     * Method to carry out the players chosen action in the room
     *
     * @param input users action choice
     *
     * @return a number used for testing if the method has completed the
     * intented task
     */
    public int doAction(String input) {
        input = input.toLowerCase();

        //call corresponding method for the user's action choice  
        if (input.contains("move")) {
            int rValue = this.move(input);
            return rValue;
        } else if (input.contains("attack e")) {
            int rValue = this.attackEnemy();
            return rValue;
        } else if (input.contains("search")) {
            this.search();
        } else if (input.contains("use")) {
            int rValue = this.useItem(input);
            return rValue;
        } else {
            System.out.println("oops not a valid command");
            return -1;
        }
        return 1;
    }

    private int useItem(String input) {
        if (input.contains("attack")) {
            this.player.useItem("attack potion");
            for (int i = 0; i < this.doableActions.size(); i++) {
                if (this.doableActions.get(i).equalsIgnoreCase("use attack potion")) {
                    this.doableActions.remove(i);
                    System.out.println("used attc pot");
                    break;
                } else {
                    System.out.println("error getting rid of attack item");
                }
            }
        } else if (input.contains("heal")) {
            this.player.useItem("heal potion");
            for (int i = 0; i < this.doableActions.size(); i++) {
                if (this.doableActions.get(i).equalsIgnoreCase("Use heal potion")) {
                    this.doableActions.remove(i);
                    System.out.println("used h pot");

                    break;
                } else {
                    System.out.println("error getting rid of heal item");
                }
            }
        }

        int reference = 15;
        return reference;
    }

    /**
     * Method to carry out combat
     *
     * Needs work
     */
    private int attackEnemy() {
        int reference = 0;
        if (this.enemyRef != null) {
            reference = 14;
        } else {
            reference = -1;
        }
        return reference;
    }

    /**
     * Method to carry out the movement action
     *
     * @param actionToDo User's movement direction
     *
     * @return dir the direction the user want's the player to go
     */
    private int move(String actionToDo) {
        int dir = -1;

        //check which direction the user wants the player to go and set dir value to coresponding integer value
        if (actionToDo.contains("north") && this.isDoor[0] == true) {
            dir = 10;
        } else if (actionToDo.contains("east") && this.isDoor[1] == true) {
            dir = 11;
        } else if (actionToDo.contains("south") && this.isDoor[2] == true) {
            dir = 12;
        } else if (actionToDo.contains("west") && this.isDoor[3] == true) {
            dir = 13;
        } else {
            System.out.println("oops not a valid direction");
        }

        return dir;
    }

    /**
     * Method for player to use item from their inventory
     *
     *
     * @return
     */
    /*
    private int useItem() {
        //return player.useItem(item);
        int reference = 15;
        return reference;
    }
     */
    /**
     * Method to search the room for any items
     *
     *
     * @return an int value used for testing to check if intended result was
     * done
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

    /**
     * Method to return the enemy in the room
     *
     * @return the enemy in the room
     */
    public Enemy getEnemy() {
        Enemy rEnemyRef = this.enemyRef;
        return rEnemyRef;
    }

    /**
     * Method to return the doors in the room
     *
     * @return all of the doors in the room
     */
    public boolean[] getIsDoor() {
        boolean[] rIsDoor = this.isDoor;
        return rIsDoor;
    }

    /**
     * Method to get the item in the room if there is one
     *
     * @return the item in the room or null if there is no item
     */
    public String getItem() {
        String rItem = this.item;
        return rItem;
    }

    /**
     * Method to get all of the doable actions in the room
     *
     * @return the arrayList corresponding to all of the actions possible in the
     * room
     */
    public ArrayList<String> getDoableActions() {
        for (int i = 0; i < this.doableActions.size(); i++) {
            if (this.doableActions.get(i).equalsIgnoreCase("use attack potion")) {
                this.doableActions.remove(i);
            }
        }
        for (int i = 0; i < this.doableActions.size(); i++) {
            if (this.doableActions.get(i).equalsIgnoreCase("Use heal potion")) {
                this.doableActions.remove(i);
            }
        }
        //if the player's pouch is not empty and "use item" isn't already in the list add it
        if (!player.getPouch().isEmpty()) {
            // doableActions.add("Use Item");
            for (String item : player.getPouch()) {
                doableActions.add("Use " + item);
            }
        }

        //if the enemy isn't dead 
        //removing all instances of duplication of moves 
        if (enemyRef != null) {
            for (String s : doableActions) {
                if (s.contains("move")) {
                    doableActions.remove(s);
                    ArrayList<String> rDoableActions = this.doableActions;
                    return rDoableActions;
                }
            }

        }

        //if enemy is dead
        //add all possible directions to move based on door boolean array
        if (enemyRef == null) {
            if (isDoor[0]) {
                if (!doableActions.contains("move north")) {
                    doableActions.add("move north");
                }
            }
            if (isDoor[1]) {

                if (!doableActions.contains("move east")) {
                    doableActions.add("move east");
                }
            }
            if (isDoor[2]) {
                if (!doableActions.contains("move south")) {
                    doableActions.add("move south");
                }
            }
            if (isDoor[3]) {
                if (!doableActions.contains("move west")) {
                    doableActions.add("move west");
                }
            }
        }

        ArrayList<String> rDoableActions = this.doableActions;
        return rDoableActions;
    }

    /**
     * Method to get the room description
     *
     * @return the current room object's description
     */
    public String getText() {
        String rText = this.text;
        return rText;
    }

    /**
     * toString method to print all of the information about the room
     *
     * @return a printout of all of the information about the room
     */
    @Override
    public String toString() {
        String s = "";

        //check for enemy in room 
        if (this.enemyRef != null) {
            s = s + "enemy in room: \n \t";
            s = s + this.enemyRef.toString() + "\n";
        } else {
            s = s + "No enemy in room \n";
        }

        //check if item in room
        if (this.item != null) {
            s = s + "Item in room: \n \t" + this.item + "\n";

        } else {
            s = s + "No item in room \n";
        }

        //return all actions possible in the room
        s = s + "Doable actions in room \n \t ";
        for (String a : doableActions) {
            s = s + a + "\n";
        }

        //check for player in room
        if (this.player != null) {
            s = s + "Contains player : \n\t" + this.player.toString();
        }

        //check for all of the doors in the room and which direction they are in
        s = s + " door arr: ";
        for (boolean b : this.isDoor) {
            s = s + b + " ";
        }
        s = s + "\n";
        s = s + "Meaning there is a door on the: ";
        if (this.isDoor[0]) {
            s = s + "north ";
        }
        if (this.isDoor[1]) {
            s = s + "east ";
        }
        if (this.isDoor[2]) {
            s = s + "south ";
        }
        if (this.isDoor[3]) {
            s = s + "west ";
        }

        return s;
    }

    /**
     * Method to remove a player from this room object
     *
     * @return a player object in this room object that is equal to null
     */
    public Player removePlayer() {
        Player p = this.player;
        this.player = null;
        return p;

    }

    /**
     * Method to get the current player object from the room
     *
     * @return a player object in this room
     */
    public Player getPlayer() {
        Player rPlayer = this.player;
        return rPlayer;
    }

    /**
     * Method to remove the enemy object from the room
     *
     * @return a reference to the enemy equaling null
     */
    public Enemy removeEnemy() {
        Enemy e = this.enemyRef;
        this.enemyRef = null;
        doableActions.remove("attack enemy");
        return enemyRef;

    }

    /**
     * Method to add a player to this room object
     *
     * @param p the current player object to be added to the room
     */
    public void addPlayer(Player p) {
        this.player = p;
    }

}
