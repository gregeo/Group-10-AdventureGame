package textgame;

import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class BossLevel
{
	private String[][] enemyGird = new String[3][3];
	private String[][] playerGrid = new String[1][3];
	private int bossX;
	private int bossY;
	private int playerX = 0;
	private int playerY = 1;
	private Player player;
	private Boss boss;
	private ArrayList<String> actions = new ArrayList<String>();
	
	public BossLevel(Player player, Boss boss)
	{
		this.boss =  new Boss(boss);
		this.player = new Player(player);
		this.setBossX();
		this.setBossY();
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
	
	public void setBossX()
	{
		double randomX = Math.random();
		randomX = randomX * 2 + 1;
		int x = (int)randomX;
		this.bossX = x;

	}
	
	public void setBossY()
	{
		double randomY = Math.random();
		randomY = randomY * 2 + 1;
		int y = (int)randomY;
		this.bossY = y;

	}
	
	public int getBossX()
	{
		return this.bossX;
	}
	
	public int getBossY()
	{
		return this.bossY;
	}
	
	public void setPlayerX(int x)
	{
		this.playerX = x;
	}
	
	public void setPlayerY(int y)
	{
		this.playerY = y;
	}
	
	public int getPlayerX()
	{
		return this.playerX;
	}
	
	public int getPlayerY()
	{
		return this.playerY;
	}
	
	public void updateEnemyGrid()
	{
		setBossX();
		setBossY();
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
	}
	
	public void printEnemyGrid()
	{
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
	
	public void updatePlayerGrid()
	{
		for(int i = 0; i < playerGrid.length; i++)
		{
			for(int j = 0; j < playerGrid[i].length; j++)
			{
				if(this.getPlayerX() == j && this.getPlayerY() == i)
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
	
	public void printPlayerGrid()
	{
		System.out.println("\nPlayer Position\n");
		for(int i = 0; i < playerGrid.length; i++)
		{
			for(int j = 0; j < playerGrid[i].length; j++)
			{

				System.out.print(playerGrid[i][j]);
			
				
			}
		}
	}
	
	public ArrayList<String> getActions()
	{
		if(player.getPouch().size() != 0 && !actions.contains("Use Item"))
		{
			actions.add("Use Item");
		}
		if(boss.getHealth() > 0 && !actions.contains("Use Item") && !actions.contains("Attack") )
		{
			actions.add("Attack");
		}
		return actions;
	}
	
	public int selectedAction(String action)
	{
		action = action.toLowerCase();
		
		if(action.contains("attack"))
		{
			return this.attack();
		}
		if(actions.contains("use item"))
		{
			this.useItem();
		}
		return -1;
	}
	
	public int attack()
	{
		//this.updateEnemyGrid();
		Scanner xScan = new Scanner(System.in);
		Scanner yScan = new Scanner(System.in);
		System.out.println("Which x coordinate do you want to attack?");
		int x = xScan.nextInt();
		System.out.println("Which y coordinate do you want to attack?");
		int y = yScan.nextInt();
		boolean hit = false;
		if(x == this.getBossX() && y == this.getBossY())
		{
			player.attackEnemy(boss);
			System.out.println(player.toString());
			System.out.println(boss.toString());
		}
		if(boss.getHealth() <= 0)
		{
			return 0;
		}
		
		return 1;
		//System.out.println("Enemies attack Strength: " + boss.getAttackStrength());
		//target.takeDamage(boss.getAttackStrength());
    }
	
	public void useItem()
	{
		ArrayList<String> inventory = player.getPouch();
		int numItems = 1;
		for(String item: inventory)
		{
			System.out.println(numItems + ". " + item);
			numItems++;
		}
		Scanner itemScanner = new Scanner(System.in);
		String itemSelection = itemScanner.nextLine();
		
		int item = player.useItem(itemSelection);
	}
}
	