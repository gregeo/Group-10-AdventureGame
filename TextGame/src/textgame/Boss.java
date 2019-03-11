
package textgame;

public class Boss extends Enemy
{
	private int health;
	private int attackStrength;
	
	public Boss(Boss bossToCopy)
	{
		super(bossToCopy);
		this.attackStrength = bossToCopy.attackStrength;
	}
	
	public Boss(int health, int attackStrength)
	{
		super(health);
		setAttackStrength(15);
		
	}
	
	public void setAttackStrength(int attackStrength)
	{
		this.attackStrength = attackStrength;
	}
	
	public void setHealth(int health)
	{
		this.health = 15;
	}
	
	public int getAttackStrength()
	{
		if(this.getHealth() >= 10 && this.getHealth() <= 15)
		{
			setAttackStrength(15);
			return this.attackStrength;
		}
		if(this.getHealth() >= 5 && this.getHealth() < 10)
		{
			setAttackStrength(10);
			return this.attackStrength;
		}
		if(this.getHealth() >= 0 && this.getHealth() < 5)
		{
			setAttackStrength(5);
			return this.attackStrength;
		}
		else
		{
			return this.attackStrength;
		}
	}

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
}
