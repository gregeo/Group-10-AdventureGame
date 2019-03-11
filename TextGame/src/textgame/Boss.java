
package textgame;

public class Boss extends Enemy
{
	//private int health;
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
            int tempHealth = this.getHealth() - dmg;
			if(tempHealth >= 0)
			{
				this.setNonRandomHealth(tempHealth);
			}
			else
			{
				this.setNonRandomHealth(0);
			}
        }
    }

	public String toString(){
		int tempHealth = this.getHealth();
		int tempAttackStrength = getAttackStrength();
        String health = Integer.toString(tempHealth);
        String attackStrength = Integer.toString(tempAttackStrength);
        String methodReturn = "Boss information (health, attackStrength): (" + health + ";" + attackStrength + ")";
        return methodReturn;
    }
}
