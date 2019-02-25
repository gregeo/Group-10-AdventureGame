/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package textgame;

import java.util.Scanner;
import textgame.Map;

/**
 *
 * a cmain method to run the game 
 * there will likly be a private print out method for ese of reading
 * 
 * @author George Smith
 */
public class TextGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		
		System.out.println("Dungeon Hero!");
		
		System.out.println("The king has scoured the land for help with a dark evil: The Shadow King.");
		System.out.println("The hero, 'The chosen one' has answered the call to save the princess and to receive large sum of wealth.");
		System.out.println(" Venturing far and wide, he has finally arrived at the nearby town, and begins searching for answers...");
		System.out.println("Upon leaving the town, he is assailed by goblins!");
		System.out.println("He must fight to find his way to the dungeon that the Shadow King inhabits.");
		System.out.println("There, he must get past traps, pick locks, and fight to progress, before arriving at the boss room where the 'Evil Shadow King' is waiting, and the princess needs to be saved!\n");
		System.out.println("Save the princess and the kingdom!");

        Map m = new Map(4,4);
        
        System.out.print(m.printMap());
        
		boolean gameRunning = true;
		
		while(gameRunning)
		{
			System.out.println(m.printMap());
			
			
			
		}
        
        
        /*
    }
        boolean gameRunning = true;
		Scanner prompt = new Scanner(System.in);
		Scanner choiceScan = new Scanner();
		
		Player player;
		Map map;
		Room room;
		Enemy enemy;
		
		
		System.out.println("Title");
	
		System.out.println("Back Story");
	
		System.out.println("Press enter to begin");
				
		String userInput = prompt.nextLine();
		
		player  = new Player(100, 0, 0);
		Room = new room();
		room.showRoom();
		
		while(gameRunning)
		{
			
			/*
				1. move x in room
				2. move y in room
				2. pickup item0
				3. attack enemy
				4. use item
			*/
			/*
			player.displayChoice();
			
			System.out.println("Select a choice");
			int choice = choiceScan.nextInt();
			
			
			switch(choice)
			{
				case 1:
				
					player.moveX();
					room.updateRoom();
					room.showRoom();
					break;
					
				case 2:
				
					player.moveY();
					room.updateRoom();
					room.showRoom();
					break;
				
				case 3:
				
					player.pickUpItem();
					room.updateRoom();
					room.showRoom();
					break;
					
				case 4:
				
					player.attack();
					room.updateRoom();
					room.showRoom();
					break;
				
				case 5:
					
					player.useItem()
					break;
			}
                        */
    }
    
}
