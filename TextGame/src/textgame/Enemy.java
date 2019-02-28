/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textgame;

/**
 *a class to handle spesific enemys
 *
 * 
 * @author Jarred Hilao
 */
public class Enemy {
	
	//declare class members
    private int health;
    private int posX;
    private int posY;

	
	public Enemy(int health, int posX, int posY)
	{
		setHealth(health);
		setInitPos(posX, posY);
		
	}
	
	/**
	* method to set an enemys intial postion
	*
	* @param x The enemy's x position
	* @param x The enemy's y position 
	*/
    public void setInitPos(int x, int y) {
        this.posX = x;
        this.posY = y;
    }
	/**
	* method to set an enemy's intial health
	*
	* @param health enemy's health
	*/
    public void setHealth(int initHealth) {
        this.health = initHealth;
    }

	/**
	* method to get an enemy's x postion
	*
	* @return enemy's x position
	*/
    public int getPosX() {
        int tempPosX = this.posX;
        return tempPosX;
    }

	/**
	* method to get an enemy's y postion
	*
	* @return enemy's x position
	*/
    public int getPosY() {
        int tempPosY = this.posY;
        return tempPosY;
    }

	/**
	* method to get an enemy's health
	*
	* @return enemy's health 
	*/
    public int getHealth() {
        int tempHealth = this.health;
        return tempHealth;
    }

	/**
	* method to assign damage to enemy
	*
	* @param dmg amount of health to subtract from the enemy's health
	*/
    public void takeDamage(int dmg) {
        if (dmg >= 0) {
            int tempHealth = this.health - dmg;
            this.health = tempHealth;
        }
    }

	/**
	* toString method for enemy's information
	*
	* @return methodReturn enemy's information (position and health)
	*/
    public void attack(Player target) {
        int dmg = 10;
        target.takeDamage(dmg);
    }
    public String toString(){
        String s = "";
        
        
        return s;
    }
}
