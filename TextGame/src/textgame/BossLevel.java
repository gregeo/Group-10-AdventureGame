package textgame;

import java.util.Random;
import java.util.Arrays;

public class BossLevel
{
	private String[][] enemyGird = new String[3][3];
	private String[][] playerGrid = new String[1][3];
	private int bossX;
	private int bossY;
	private int playerX;
	private int playerY;
	private Player player;
	private Boss boss;
	
	public BossLevel()
	{
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
				enemyGird[i][j] = "-";
			}
		}
	}
	
	public void setBossX()
	{
		double randomX = Math.random();
		randomX = randomX * 2 + 1;
		int x = (int)randomX;
		System.out.println(x);
		this.bossX = x;

	}
	
	public void setBossY()
	{
		double randomY = Math.random();
		randomY = randomY * 2 + 1;
		int y = (int)randomY;
		System.out.println(y);
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
}
	