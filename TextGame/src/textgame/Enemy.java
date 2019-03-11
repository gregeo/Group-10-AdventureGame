/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textgame;

import java.lang.Math;

/**
 *a class to handle specific enemy
 *
 * 
 */
public class Enemy {
	
	//declare class members
    private int health;
    private int posX;
    private int posY;

	
	public Enemy(Enemy enemyToCopy)
	{
		this.health = enemyToCopy.health;
	}
	public Enemy(int health)
	{
		
		this.health = health;
	}
	public Enemy(int posX, int posY)
	{
		setHealth();
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
    public void setHealth() {
        double randomHealth = Math.random();
		randomHealth = randomHealth * 6 + 1;
		int health = (int)randomHealth;
		this.health = health;
    }
	
	public void setNonRandomHealth(int health)
	{
		this.health = health;
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
			
			if(tempHealth >= 0)
			{
				this.health = tempHealth;
			}
			else
			{
				this.health = 0;
			}
        }
    }

	
    public void attack(Player target) {
        double randomAttack = Math.random();
		randomAttack = randomAttack * 3 + 1;
		int attackStrength = (int)randomAttack;
		System.out.println("Enemies attack Strength: " + attackStrength);
		target.takeDamage(attackStrength);
    }
	
	/**
	* toString method for enemy's information
	*
	* @return methodReturn enemy's information (position and health)
	*/
    public String toString(){
		int tempHealth = this.health;
        int tempPosX = this.posX;
        int tempPosY = this.posY;
        String health = Integer.toString(tempHealth);
        String posX = Integer.toString(tempPosX);
        String posY = Integer.toString(tempPosY);
        String methodReturn = "Enemy information (health, x, y): (" + health + ";" + posX + ";" + posY + ")";
        return methodReturn;
    }
}
