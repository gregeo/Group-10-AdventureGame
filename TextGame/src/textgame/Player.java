/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textgame;
import java.util.ArrayList;
/**
 *
 * @author Jarred Hilao
 */
public class Player {
    private int health;
    private int posX;
    private int posY;
    private ArrayList<String> pouch;

    public void setInitPos(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public int getPosX() {
        int returnX = this.posX;
        return returnX;
    }

    public int getPosY() {
        int returnY = this.posY;
        return returnY;
    }

    public int getHealth() {
        int returnHealth = this.health;
        return returnHealth;
    }

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

    public void attackEnemy(Enemy target) {
        int dmg = 2;
        target.takeDamage(dmg);
    }

    public void takeDamage(int dmgTaken) {
        this.health -= dmgTaken;
    }

    public void pickUpItem(String toTake) {
        this.pouch.add(toTake);
    }

    public void useItem(String itemToUse) {
        
        // to be redone with String items...
        
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
    }

    public String toString() {
        int tempHealth = this.health;
        int tempPosX = this.posX;
        int tempPosY = this.posY;
        String health = Integer.toString(tempHealth);
        String posX = Integer.toString(tempPosX);
        String posY = Integer.toString(tempPosY);
        String methodReturn = "'" + health + ";" + posX + ";" + posY + "''";
        return methodReturn;
    }

    public Player() {
        this.pouch = new ArrayList<String>();
    }

    public Player(int health, int x, int y) {
        this.health = health;
        this.posX = x;
        this.posY = y;
        this.pouch = new ArrayList<String>();
    }

}
