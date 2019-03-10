/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textgame;
import java.util.ArrayList;
/**
 *
 */
public class Player {
	
	//declare class members 
    private int health;
    private int posX;
    private int posY;
	private int attackStrength = 2;
    private ArrayList<String> pouch;
	
	/**
	* constructor to create a player's inventory and no position 
	*
	* @return new player object with an inventory list
	*/
	public Player() {
        this.pouch = new ArrayList<String>();
    }

	/**
	* constructor for a player with health and x and y position specified 
	*
	* @param health player's health
	* @param x The player's x position
	* @param x The player's y position

	* @return a player object with health and postion on map specified 
	*/
    public Player(int health, int x, int y) {
        this.health = health;
        this.posX = x;
        this.posY = y;
        this.pouch = new ArrayList<String>();
    }

	/**
	* method to set a players intial postion on the 
	*
	* @param x The player's x position
	* @param x The player's y position 
	*/
    public void setInitPos(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

	/**
	* method to set a players health
	*
	* @param health player's health
	*/
    public void setHealth(int health) {
        this.health = health;
    }
    
	/**
	* method to get a players x postion
	*
	* @return player's x position
	*/
    public int getPosX() {
        int returnX = this.posX;
        return returnX;
    }

	/**
	* method to get a players x postion
	*
	* @return player's y position
	*/
    public int getPosY() {
        int returnY = this.posY;
        return returnY;
    }
	
	/**
	* method to get a players health 
	*
	* @return player's health
	*/
    public int getHealth() {
        int returnHealth = this.health;
        return returnHealth;
    }

	/**
	* method to move player horizontally
	*
	* @param x distance to move
	*/
    public void moveX(int x) {
        if (x >= 1) {
            this.posX += 1;
        }
        else if (x <= 0) {
            this.posX -= 1;
        }
        else {
            System.out.println("INVALID VALUE");
        }
    }
	
	public void setX(int x)
	{
		this.posX = x;
	}
	
	public void setY(int y)
	{
		this.posY = y;
	}

	
	/**
	* method to move player vertically
	*
	* @param y distance to move
	*/
    public void moveY(int y) {
        if (y >= 1) {
            this.posY += 1;
        }
        else if (y <= 0) {
            this.posY -= 1;
        }
        else {
            System.out.println("INVALID VALUE");
        }
    }

	/**
	* method to attack an enemy
	*
	* needs work
	*
	* @param current enemy in the room
	*/
    public void attackEnemy(Enemy target) {
		System.out.println("Player's attack Strength: " + attackStrength);
        target.takeDamage(attackStrength);
    }
	
	/**
	* method to assign damage to player
	*
	* @param dmgTaken amount of health to subtract from the player's health
	*/
    public void takeDamage(int dmgTaken) {
        this.health -= dmgTaken;
    }

	/**
	* method for player to pick up item and add to their inventory
	*
	* @param toTake name of item 
	*/
    public void pickUpItem(String toTake) {
        System.out.println("you found: " + toTake + ". It's added to your inventory");
        this.pouch.add(toTake);
    }

	/**
	* method for player to use an item from their inventory
	*
	* @param itemToUse the item they wish to use
	*
	* @return int value used for testing
	*/
    public int useItem(String itemToUse) {
    /*
        for (int i = 0; i <= this.pouch.size(); i++) {
            String itemReference = this.pouch.get(i);
            if (itemReference.isEqauals(itemToUse)){
                this.pouch.remove(i);
                return 1;
            }
        }
        return -1;
        // to be redone with String items...
        */
        /*
        Item item = new Item();
        for (int i = 0; i <= pouch.size(); i++) {
            Item tempItem = this.pouch.get(i);
            if (tempItem.getName() == itemToUse) {
                item = tempItem;
                this.pouch.remove(i);
            }
        }
        item.use();
     */
		//find the item they would like to use and remove it from their inventory 
        for (int i = 0; i < this.pouch.size(); i++) {
            String tempItem = this.pouch.get(i);
            if (itemToUse.equals(tempItem)) {
                this.pouch.remove(i);
                break;
            }
        }
		
		if(itemToUse.equals("heal potion"))
		{
			this.setHealth(this.getHealth() + 2);
		}
		if(itemToUse.equals("attack potion"))
		{
			this.attackStrength += 2;
		}
		/*more logic required but will be used to find the item and to carry out the correct action 
		for (int i = 0; i <= this.pouch.size(); i++) {
			String tempItem = this.pouch.get(i);
			if (tempItem.equals(itemToUse)) {
				return 1;
        }*/
    
        return -1;
    }

	
	public ArrayList<String> getPouch()
	{
		return this.pouch;
	}	
	/**
	* toString method for player's information
	*
	* @return methodReturn player's information (position and health)
	*/
    public String toString() {
		int tempPosX = this.posX;
        int tempPosY = this.posY;
		int tempHealth = this.health;
		
		if(this.health < 0)
		{
			tempHealth = 0;
		}
      
        String health = Integer.toString(tempHealth);
        String posX = Integer.toString(tempPosX);
        String posY = Integer.toString(tempPosY);
        String methodReturn = "Your information (health, x, y): (" + health + ";" + posX + ";" + posY + ")";
        return methodReturn;
    }

   
}
