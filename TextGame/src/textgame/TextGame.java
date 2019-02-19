/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

package textgame;

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
    }
    
}
