/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textgame;
import java.util.ArrayList;

/**
 * A class representing the main character in the game
 * 
 */
public class Player extends Character 
{
	
	//declare class members 
    private int health;
    private int posX;
    private int posY;
	private int attackStrength = 2;
    private ArrayList<String> pouch;
	
	/**
	* Copy constructor to create a copy object of another player 
	*
	* @param playerToCopy player object to make a copy of
	*
	* @return A copy of a player object
	*/
	public Player(Player playerToCopy)
	{
		this.health = playerToCopy.health;
		this.pouch = playerToCopy.pouch;
		this.attackStrength = playerToCopy.attackStrength;
	}
	/**
	* constructor to create a player's inventory and no position 
	*
	* @return new player object with an inventory list
	*/
	public Player() 
	{
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
    public Player(int health, int x, int y)
	{
		super(x, y);
        this.health = health;
        //this.posX = x;
        //this.posY = y;
        this.pouch = new ArrayList<String>();
    }
	
	/**
	* constructor for a player with a specified x and y position as a arguments and a pre set health 
	*
	* @param x The player's x position
	* @param x The player's y position
	*
	* @return a player object with health and postion on map specified 
	*/
	public Player(int x, int y)
	{
		this(30, x, y);
	}

	/**
	* method to set a players intial postion on the 
	*
	* @param x The player's x position
	* @param x The player's y position 
	*/
    public void setInitPos(int x, int y)
	{
        this.posX = x;
        this.posY = y;
    }

	/**
	* method to set a players health
	*
	* @param health player's health
	*/
    public void setHealth(int health) 
	{
        this.health = health;
    }
    
	/**
	* method to get a players x postion
	*
	* @return player's x position
	*/
    public int getPosX()
	{
        int returnX = this.posX;
        return returnX;
    }

	/**
	* method to get a players x position
	*
	* @return player's y position
	*/
    public int getPosY() 
	{
        int returnY = this.posY;
        return returnY;
    }
	
	/**
	* method to get a players health 
	*
	* @return player's health
	*/
    public int getHealth() 
	{
        int returnHealth = this.health;
        return returnHealth;
    }

	/**
	* method to move player horizontally
	*
	* @param x distance to move
	*/
    public void moveX(int x)
	{
		//checks to make sure move is legal
        if (x >= 1)
		{
            this.posX += 1;
        }
        else if (x <= 0) 
		{
            this.posX -= 1;
        }
        else
		{
            System.out.println("INVALID VALUE");
        }
    }
	
	
	/**
	* setter method to set player's x position on the map
	*
	*/
	public void setX(int x)
	{
		this.posX = x;
	}
	
	/**
	* setter method to set player's y position on the map
	*
	*/
	public void setY(int y)
	{
		this.posY = y;
	}

	
	/**
	* method to move player vertically
	*
	* @param y distance to move
	*/
    public void moveY(int y) 
	{
		//checks to make sure move is legal
        if (y >= 1) 
		{
            this.posY += 1;
        }
        else if (y <= 0) 
		{
            this.posY -= 1;
        }
        else
		{
            System.out.println("INVALID VALUE");
        }
    }

	/**
	* method to attack an enemy
	*
	* @param target enemy in the room
	*/
    public void attack(Character target) 
	{
		//call the takeDamage method in the enemy class and send the player's attackStrength as an argument 
		System.out.println("Player's attack Strength: " + this.attackStrength);
		System.out.println(target.toString());
        target.takeDamage(attackStrength);
    }
	
	/**
	* method to assign damage to player
	*
	* @param dmgTaken amount of health to subtract from the player's health
	*/
    public void takeDamage(int dmgTaken) 
	{
        this.health -= dmgTaken;
    }

	/**
	* method for player to pick up item and add to their inventory
	*
	* @param toTake name of item 
	*/
    public void pickUpItem(String toTake) 
	{
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
    public int useItem(String itemToUse)
	{
  
		//find the item they would like to use and loop through the arraylist and remove the that item from the inventory 
        for (int i = 0; i < this.pouch.size(); i++) 
		{
            String tempItem = this.pouch.get(i);
            if (itemToUse.equals(tempItem)) 
			{
                this.pouch.remove(i);
                break;
            }
        }
		
		//if the item is a heal potion add 2 points to the player's health
		if(itemToUse.equals("heal potion"))
		{
			this.setHealth(this.getHealth() + 2);
		}
		//if the item is an attack potion add 2 points to the player's attack strength 
		if(itemToUse.equals("attack potion"))
		{
			this.attackStrength += 2;
		}
    
        return -1;
    }

	/**
	* method to get a player's inventory
	*
	* @return array list of a player's inventory 
	*/
	public ArrayList<String> getPouch()
	{
		return this.pouch;
	}	
	
	/**
	* toString method for player's information
	*
	* @return methodReturn player's information (position and health)
	*/
    public String toString() 
	{
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
