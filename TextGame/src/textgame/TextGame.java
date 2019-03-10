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
 *
 * a cmain method to run the game 
 * there will likly be a private print out method for ese of reading
 */
public class TextGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        Player p = new Player(6, 0, 0);
		Enemy enemyRoomOne = new Enemy(0, 0);
		Enemy enemyRoomTwo = new Enemy(1, 0);
		Enemy enemyRoomThree = new Enemy(1, 1);
        boolean b1[] = {false, true, false, false};
        Room r1 = new Room(b1, enemyRoomOne, "heal potion", p, "A suspiciously quiet room, you look around the cold dark stone room and feel something brush up against your leg and hope it's just a rat. Then out of the darkness a skeleton knight is coming towards you!");
        boolean b2[] = {false, false, true, true};
        Room r2 = new Room(b2, enemyRoomTwo, "attack potion", p, "You enter a well it room with fire torches all the way down the the big long corridor. You see lots of chests to the side, hopefully with lots of items. However guarded by a group of goblins!");
        boolean b3[] = {true, false, false, false};
        Room r3 = new Room(b3, enemyRoomThree, "attack potion" , p, "You enter the armory of the dungeon, and see lots of weapons you could pick up. Then out of the darkness appears a roll warrior! ...");

        m.addRoom(r1, 0, 0);
		m.addRoom(r2, 1, 0);
        m.addRoom(r3, 1, 1);
        //System.out.println(m.toString(0, 0));
        //System.out.println(m.printMap());

        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;
		boolean roomsCleared = false;
		String action = "";
        while (gameRunning) {
			/*while(!roomsCleared)
			{
				System.out.println(m.printMap());
				System.out.println(m.getRoom(m.getPlayerX(), m.getPlayerY()).getText());
				System.out.println("you can: " + m.getRoom(m.getPlayerX(), m.getPlayerY()).getDoableActions());
				action = scanner.nextLine();
				if (action.equalsIgnoreCase("end")) {
					break;
				} else {
					//System.out.println(action);
					int i = m.runAction(action);
					if(i == 0)
					{
						break;
					}

				}
				roomsCleared = m.allRoomsCleared();
			}
			if (action.equalsIgnoreCase("end")) {
					break;
				} 
			if(m.allRoomsCleared())*/
			{
				System.out.println("You have cleared all of the rooms of the evil Shadow King's minions, he has grown tired of your presence and will now face you in a battle");
				BossLevel bossLevel = new BossLevel();
				bossLevel.printEnemyGrid();
			}
			break;
			
        }
		
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
    

