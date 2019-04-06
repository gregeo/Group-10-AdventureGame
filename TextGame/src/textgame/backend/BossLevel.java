package textgame.backend;

import textgame.backend.Boss;
import textgame.backend.Player;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class used to run the boss fight stage of the game
 * Creates the map and runs the actions selected by the user for the battle
 * 
 */
public class BossLevel
{
	//declare class members 
	private String[][] enemyGird = new String[3][3];
	private String[][] playerGrid = new String[1][3];
	private int bossX;
	private int bossY;
	private int playerX = 0;
	private int playerY = 1;
	private Player player;
	private Boss boss;
	private ArrayList<String> actions = new ArrayList<String>();
	
	/**
	* Constructor to create the boss stage level method
	* Initializes the player and enemy's grid
	* 
	* @param player the player object for the game
	* @param boss the boss object representing the boss
	*
	* @return A new bossLevel object with two grids for the battle 
	*/
	public BossLevel(Player player, Boss boss)
	{
		//assign class members to parameters and generate a random x and y value on the grid for the boss
		this.boss =  new Boss(boss);
		this.player = new Player(player);
		this.setBossX();
		this.setBossY();
		
		//loop through enemyGird to put the boss marked as a "B" and a "-" for a normal square
		for(int i = 0; i < enemyGird.length; i++)
		{
			for(int j = 0; j < enemyGird[i].length; j++)
			{
				if(this.getBossX() == j && this.getBossY() == i)
				{
					enemyGird[i][j] = "B";
				}
				else
				{
					enemyGird[i][j] = "-";
				}
			}
		}
		
		//loop through playerGrid to put the player marked as a "P" and a "-" for a normal square
		for(int i = 0; i < playerGrid.length; i++)
		{
			for(int j = 0; j < playerGrid[i].length; j++)
			{
				if(i == 0 && j == 1)
				{
					playerGrid[i][j] = "P";
				}
				else
				{
					playerGrid[i][j] = "-";
				}
			}
		}
	}
	
	/**
	* method to generate a random x value for the boss's x position on the grid
	*
	*/
	public void setBossX()
	{
		double randomX = Math.random();
		randomX = randomX * 2 + 1;
		int x = (int)randomX;
		this.bossX = x;

	}
	
	/**
	* method to generate a random y value for the boss's y position on the grid
	*
	*/
	public void setBossY()
	{
		double randomY = Math.random();
		randomY = randomY * 2 + 1;
		int y = (int)randomY;
		this.bossY = y;

	}
	
	/**
	* method to get the boss's x position on the grid
	*
	* @return boss's x position
	*/
	public int getBossX()
	{
		int rBossX = this.bossX;
		return rBossX;
	}
	
	
	/**
	* method to get the boss's y position on the grid
	*
	* @return boss's y position
	*/
	public int getBossY()
	{
		int rBossY = this.bossY;
		return rBossY;
	}
	
	/**
	* setter method to set player's x position on the grid
	*
	*/
	public void setPlayerX(int x)
	{
		this.playerX = x;
	}
	
	/**
	* setter method to set player's y position on the grid
	*
	*/
	public void setPlayerY(int y)
	{
		this.playerY = y;
	}
	
	/**
	* method to get a players x position on the grid
	*
	* @return player's x position
	*/
	public int getPlayerX()
	{
		int rPlayerX = this.playerX;
		return rPlayerX;
	}
	
	/**
	* method to get a players y position on the grid
	*
	* @return player's y position
	*/
	public int getPlayerY()
	{
		int rPlayerY = this.playerY;
		return rPlayerY;
	}
	
	/**
	* method to update the 2d array representing the boss's grid with it's new position
	*
	*/
	public void updateEnemyGrid()
	{
		//generate a new position for the boss
		setBossX();
		setBossY();
		
		//loop through the array to move the boss("B") to it's new position
		for(int i = 0; i < enemyGird.length; i++)
		{
			for(int j = 0; j < enemyGird[i].length; j++)
			{
				if(this.getBossX() == j && this.getBossY() == i)
				{
					this.enemyGird[i][j] = "B";
				}
				else
				{
					this.enemyGird[i][j] = "-";
				}
				
			}
		}
	}
	
	/**
	* method to print the 2d array representing the boss's grid 
	*
	*/
	public void printEnemyGrid()
	{
		//algorithm to print the grid on diffrent lines 
		System.out.println("Enemy Position\n");
		for(int i = 0; i < enemyGird.length; i++)
		{
			for(int j = 0; j < enemyGird[i].length; j++)
			{
				if(j == 2)
				{
					System.out.println(enemyGird[i][j]);
				}
				else
				{
					System.out.print(enemyGird[i][j]);
				}
				
			}
		}
	}
	
	/**
	* method to update the 2d array representing the player's grid with it's new position
	*
	*/
	public void updatePlayerGrid()
	{
		for(int i = 0; i < playerGrid.length; i++)
		{
			for(int j = 0; j < playerGrid[i].length; j++)
			{
				//System.out.println(getPlayerX());
				if(this.getPlayerX() == j && this.getPlayerY() == 1)
				{
					this.playerGrid[i][j] = "P";
				}
				else
				{
					this.playerGrid[i][j] = "-";
				}
				
			}
		}
	}
	
	/**
	* method to print the 2d array representing the boss's grid 
	*
	*/
	public void printPlayerGrid()
	{
		//algorithm to print the grid on diffrent lines 
		System.out.println("\nPlayer Position\n");
		for(int i = 0; i < playerGrid.length; i++)
		{
			for(int j = 0; j < playerGrid[i].length; j++)
			{

				System.out.print(playerGrid[i][j]);
			
				
			}
		}
	}
	
	/**
	* method to get the arrayList of actions that the palyer can choose from while fighting the boss
	*
	* @return actions An arrayList of actions in the from of strings that represent the actions a player can choose from
	*/
	public ArrayList<String> getActions()
	{
		//checks to make sure only one type of action is added of each type
		if(player.getPouch().size() != 0 && !actions.contains("Use Item"))
		{
			actions.add("Use Item");
		}
		if(boss.getHealth() > 0 && !actions.contains("Attack") )
		{
			actions.add("Attack");
		}
		if(player.getPouch().size() == 0)
		{
			actions.remove("Use Item");
		}
		ArrayList<String> rActions = this.actions;
		return rActions;
	}
	
	/**
	* method to run the selected action by the player
	* 
	* @param action string representing the action the player has chosen
	*
	* @return a reference number for that action
	*/
	public int selectedAction(String action)
	{
		action = action.toLowerCase();
		
		if(action.contains("attack"))
		{
			return this.playerAttack();
		}
		if(action.contains("use item"))
		{
			System.out.println("here");
			this.useItem();
		}
		else
		{
			System.out.println("oops not a valid command");
            return -1;
        }
		return -1;
	}
	
	/**
	* method to carry out the player's attack against the boss 
	*
	* @return a reference index number to determine the result
	*/
	public int playerAttack()
	{
		//update the enemy's grid to put the boss into a new position
		this.updateEnemyGrid();
		
		//ask the user for the cell they would like to attack
		//using do while loops to ensure correct input
		Scanner xScan = new Scanner(System.in);
		Scanner yScan = new Scanner(System.in);
		Scanner dScan = new Scanner(System.in);
		int x = 0;
		int y = 0;
		boolean validInputX = false;
		boolean validInputY = false;
		do 
		{
			System.out.println("Which x coordinate do you want to attack? (Please enter a number between 1 and 3)");
			while (!xScan.hasNextInt()) 
			{
				System.out.println("Invalid , please try again.");
				xScan.next(); 
			}
			
			x = xScan.nextInt();
			x = x - 1;
			validInputX = true;
			
		} while (validInputX == false);
		
		do 
		{
			System.out.println("Which y coordinate do you want to attack? (Please enter a number between 1 and 3)");
			while (!yScan.hasNextInt()) 
			{
				System.out.println("Invalid , please try again.");
				yScan.next(); 
			}
			
			y = yScan.nextInt();
			y = y - 1;
			validInputY = true;
			
		} while (validInputY == false);
		
		
		
	
		boolean hit = false;
		
		//if the player has guessed the cell the boss is in player will deal damage to the boss
		if(x == this.getBossX() && y == this.getBossY())
		{
			System.out.println("Hit!");
			player.attack(boss);
			System.out.println(player.toString());
			System.out.println(boss.toString());
		}
		//else the player has missed and the boss now get's to attack the player
		else
		{
			//ask the player which way they want to pivot to defend
			if(x > 2 || y > 2)
			{
				System.out.println("Your attack was outside of the grid. Make sure to enter a number between 1 and 3! The Shadow King will now take advantage of your error!\n");
			}
			else
			{
				System.out.println("You have missed, The Shadow King can now attack you! You must now try and dodge his attack\n");
			}
			
			boolean validDirection = false;
			String direction = "";
			System.out.println("Would you like to go to the left, the middle, or to the right");
	
			while(!validDirection)
			{
				direction = dScan.nextLine();
				while(!((direction.equals ("left")) || (direction.equals("right")) || (direction.equals("middle"))))
				{
					System.out.println("Invalid choice. Please try again, entering 'left', 'middle' or 'right'");
					direction = dScan.next();
					
				}
				validDirection = true;
			}
			
		
			
			//move the player to the position on the grid corresponding to their choice of direction
			if(direction.equals("left"))
			{
				this.setPlayerX(0);
			}
			if(direction.equals("right"))
			{
				this.setPlayerX(2);
			
			}
			if(direction.equals("middle"))
			{
				this.setPlayerX(1);
			}
	

			//run the boss's attack on the player
			this.bossAttack();
			System.out.println(player.toString());
			System.out.println(boss.toString());

		}
		
		//if the boss is dead return a reference number of 2
		if(boss.getHealth() <= 0)
		{
			return 2;
		}
		
		//if the plyaer is dead return a reference number of 3
		if(player.getHealth() <= 0)
		{
			return 3;
		}
		
		return 1;
		//System.out.println("Enemies attack Strength: " + boss.getAttackStrength());
		//target.takeDamage(boss.getAttackStrength());
		
	}
	
	/**
	* method to carry out the boss's attack against the player 
	*
	*/
	public void bossAttack()
	{
		//generate a random number between 0 and 2 representing a position on the player's grid
		double randomAttackPosition = Math.random();
		randomAttackPosition = randomAttackPosition * 2 + 1;
		int attackLocation = (int)randomAttackPosition;
		System.out.println("attack " + attackLocation);
		
		//update the palyer's grid to account for the defense pivot they have done
		this.updatePlayerGrid();
		
		//if the boss has hit deal the damage to the player
		if(attackLocation == this.getPlayerX())
		{
			System.out.println("You have been hit!");
			boss.attack(player);
		}
		//else the boss has missed and nothing happens
		else
		{
			System.out.println("The Shadow King has missed!");
		}
	}
	
	/**
	* method to allow the player to use an item
	*
	* @return a reference index number to determine the result
	*/
	public void useItem()
	{
		//get the player's inventory
		ArrayList<String> inventory = player.getPouch();
		int numItems = 1;
		
		//print the items in the inventory
		for(String item: inventory)
		{
			System.out.println(numItems + ". " + item);
			numItems++;
		}
		
		//ask the user which item they want to use
		Scanner itemScanner = new Scanner(System.in);
		int itemSelection = itemScanner.nextInt();
		
		//call the useItem method in the player class to carry out the specific action of the item
		int item = player.useItem(itemSelection);
	}
	
	/*public String playerToString()
	{
		int tempPosX = this.posX;
        int tempPosY = this.posY;
		int tempHealth = this.health();
		
		if(this.health < 0)
		{
			tempHealth = 0;
		}
      
        String health = Integer.toString(tempHealth);
        String posX = Integer.toString(tempPosX);
        String posY = Integer.toString(tempPosY);
        String methodReturn = "Your information (health, x, y): (" + health + ";" + posX + ";" + posY + ")";
        return methodReturn;
	}*/
	
}
	