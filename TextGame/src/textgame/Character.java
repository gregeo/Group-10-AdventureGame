package textgame;

public abstract class Character
{
	private int posX; 
	private int posY;
	
	public Character()
	{
		
	}
	public Character(int x, int y)
	{
		this.posX = x;
		this.posY = y;
	}
	public abstract int getHealth();
	
	public abstract int getPosX();
	
	public abstract int getPosY();
	
	public abstract void takeDamage(int dmg);
	
	public abstract void attack(Character chr1);
	
	public void setInitPos(int x, int y)
	{
		this.posY = y;
		this.posX = x;
	}
}