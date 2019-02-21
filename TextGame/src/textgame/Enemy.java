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

    private int health;
    private int posX;
    private int posY;

    public void setInitPos(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    public void setHealth(int initHealth) {
        this.health = initHealth;
    }

    public int getPosX() {
        int tempPosX = this.posX;
        return tempPosX;
    }

    public int getPosY() {
        int tempPosY = this.posY;
        return tempPosY;
    }

    public int getHealth() {
        int tempHealth = this.health;
        return tempHealth;
    }

    public void takeDamage(int dmg) {
        if (dmg >= 0) {
            int tempHealth = this.health - dmg;
            this.health = tempHealth;
        }
    }

    public void attack(Player target) {
        int dmg = 10;
        target.takeDamage(dmg);
    }
    public String toString(){
        String s = "";
        
        
        return s;
    }
}
