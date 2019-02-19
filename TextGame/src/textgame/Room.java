/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textgame;

/**
 *
 * a calss that will run a room and its dissision making 
 * 
 * @author George Smith
 */
public class Room {
    private boolean[] isDoor;//denoted nesw
    Enemy enemyRef;
    String item;
    
    
    /**
     * 
     * @param isDoor
     * @param enemyRef
     * @param item 
     */
    public Room(boolean[] isDoor, Enemy enemyRef, String item){
        if(isDoor.length == 4){
            this.isDoor = isDoor;
        }else{
            System.out.println("isDoor is the wrong sise :(  "+ isDoor.length);
        }
        this.enemyRef = enemyRef;
        this.item = item;
    }
    /**
     * 
     * @param isDoor
     * @param item 
     */
        public Room(boolean[] isDoor, String item){
        if(isDoor.length == 4){
            this.isDoor = isDoor;
        }else{
            System.out.println("isDoor is the wrong sise :(  "+ isDoor.length);
        }
        this.item = item;
    }
        /**
         * 
         * @param isDoor
         * @param enemyRef 
         */
        public Room(boolean[] isDoor, Enemy enemyRef){
        if(isDoor.length == 4){
            this.isDoor = isDoor;
        }else{
            System.out.println("isDoor is the wrong sise :(  "+ isDoor.length);
        }
        this.item = item;
    }/**
     * 
     * @param isDoor 
     */
        public Room(boolean[] isDoor){
        if(isDoor.length == 4){
            this.isDoor = isDoor;
        }else{
            System.out.println("isDoor is the wrong sise :(  "+ isDoor.length);
        }
    }
}
