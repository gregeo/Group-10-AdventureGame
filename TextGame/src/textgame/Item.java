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

public class Item {
    boolean toBeFound;
    String showName;
    int type;
    /*
        type 1: health potion
        type 2: seeing orb
    */

    public void use(Player player)
    {
        
        /*
        Not sure if this is what we are thining but I thought I would do it and just leave it as a comment
        if(showName == "Health Potion")
        {
            player.heal(2);
        }
        if(showName == "Weapon")
        {
            player.attackEnemy(2);
        }
        */
    }

    public String getName() {
        String tempName = this.showName;
        return tempName;
    }

    public Item() {
        this.toBeFound = false;
    }
    public Item(Item oldItem) {
        this.toBeFound = oldItem.toBeFound;
        this.showName = oldItem.showName;
    }
}
