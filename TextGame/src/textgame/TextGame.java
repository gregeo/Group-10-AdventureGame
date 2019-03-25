/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package textgame;

import java.util.ArrayList;
import java.util.Scanner;
import textgame.Map;

/**
 * The client code for running the text version of the game
 * 
 */
public class TextGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
        
        //hard coded testing commands for this class
		System.out.println("Dungeon Hero!");
		
		System.out.println("The king has scoured the land for help with a dark evil: The Shadow King.");
		System.out.println("The hero, 'The chosen one' has answered the call to save the princess and to receive large sum of wealth.");
		System.out.println(" Venturing far and wide, he has finally arrived at the nearby town, and begins searching for answers...");
		System.out.println("Upon leaving the town, he is assailed by goblins!");
		System.out.println("He must fight to find his way to the dungeon that the Shadow King inhabits.");
		System.out.println("There, he must get past traps, pick locks, and fight to progress, before arriving at the boss room where the 'Evil Shadow King' is waiting, and the princess needs to be saved!\n");
		System.out.println("Save the princess and the kingdom!");

        Map m = new Map(3, 3);
        System.out.print(m.printMap());
        Player p = new Player(30, 0, 0);
		Enemy enemyRoomOne = new Enemy(0, 0);
		Enemy enemyRoomTwo = new Enemy(1, 0);
		Enemy enemyRoomThree = new Enemy(1, 1);
        boolean b1[] = {false, true, false, false};
        Room r1 = new Room(b1, enemyRoomOne, "heal potion", p, "A suspiciously quiet room, you look around the cold dark stone room and feel something brush up against your leg and hope it's just a rat. Then out of the darkness a skeleton knight is coming towards you!");
        boolean b2[] = {false, false, true, true};
        Room r2 = new Room(b2, enemyRoomTwo, "attack potion", p, "You enter a well it room with fire torches all the way down the the big long corridor. You see lots of chests to the side, hopefully with lots of items. However guarded by a group of goblins!");
        boolean b3[] = {true, false, false, false};
        Room r3 = new Room(b3, enemyRoomThree, "attack potion" , p, "You enter the armory of the dungeon, and see lots of weapons you could pick up. Then out of the darkness appears a troll warrior! ...");

        m.addRoom(r1, 0, 0);
		m.addRoom(r2, 1, 0);
        m.addRoom(r3, 1, 1);
        //System.out.println(m.toString(0, 0));
        //System.out.println(m.printMap());

		//declare and initialize variables for the game loop
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;
		boolean roomsCleared = false;
		String action = "";
		int actionResult = 0;
		int displayCount = 0;
		
		//create boss and boss map objects
		Boss boss = new Boss(15, 15);
		BossLevel bossLevel = new BossLevel(p, boss);
		
		//game loop for both the room and boss stage
        while (gameRunning) 
		{	
			//loop until all the enemies are cleared in the rooms
			while(!roomsCleared)
			{
				//print map and information about room for the player 
				System.out.println(m.printMap());
				System.out.println(m.getRoom(m.getPlayerX(), m.getPlayerY()).getText());
				System.out.println("you can: " + m.getRoom(m.getPlayerX(), m.getPlayerY()).getDoableActions());
				action = scanner.nextLine();
				
				//check user input for the action they have chosen
				if (action.equalsIgnoreCase("end")) {
					break;
				} else {
					//System.out.println(action);
					int i = m.runAction(action);
					
					//if run actions returns 0 the player has died
					if(i == 0)
					{
						break;
					}

				}
				//check if the room's have been cleared 
				roomsCleared = m.allRoomsCleared();
			}
			if (action.equalsIgnoreCase("end")) {
					break;
				} 
				
			//if all of the rooms have been cleared start the boss level
			if(m.allRoomsCleared())
			{
				//print the instructions for the level
				if(displayCount == 0)
				{
					System.out.println("You have cleared all of the rooms of the evil Shadow King's minions, he has grown tired of your presence and will now face you in a battle");
					displayCount++;
				}
				
				//print the player and enemy grid out for the player
				System.out.println("The evil shadow king moves in the shadows meaning you never know where he is. When attacking him you must use your best guess to strike your attack and hope he is in that position.");
				bossLevel.printEnemyGrid();
				bossLevel.printPlayerGrid();
				
				//print the actions available to the player for the level
				System.out.println("\n \nYou can: " + bossLevel.getActions());
				action = scanner.nextLine();
				actionResult = bossLevel.selectedAction(action);
				
				//check action result to see if the player has won or lost to break out of the loop
				if(actionResult == 2)
				{
					System.out.println("You have slain the evil shadow king and are victorious!");
					gameRunning = false;
				}
				if(actionResult == 3)
				{
					System.out.println("You have been defeated by the evil shadow king and are defeated!");
					gameRunning = false;
				}
				
			}
			//break;
			
        }
		
    }
}
    

