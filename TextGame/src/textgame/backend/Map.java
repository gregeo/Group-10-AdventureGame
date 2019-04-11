/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textgame.backend;

import java.io.FileReader;
import textgame.backend.Enemy;
import textgame.backend.Room;
import textgame.backend.Player;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * A class to contain a room[][] array and methods to work a game map
 *
 */
public class Map {

    //declare and initialize class members
    private Room rooms[][];
    private int playerX;
    private int playerY;
    private ArrayList<Room> roomList = new ArrayList<Room>();
    private String combatPrintOut;

    /**
     * This constructor creates a new map object that represents a map with a
     * specified length and height and sends a default player x and y coordinate
     *
     * @param length the length of the map
     * @param height the height of the map
     *
     * @return a new map with a specified length and height
     */
    public Map(int length, int height) {
        this(length, height, 0, 0);
    }

    /**
     * This constructor creates a new map object that represents a map with a
     * specified length, height, players x and players y position A new room is
     * added to the map by creating a new room object
     *
     * @param length the length of the map
     * @param height the height of the map
     * @param playerx the players x position on the map
     * @param playery the players y position on the map
     *
     * @return a new map with a specified length and height
     */
    public Map(int length, int height, int playerX, int playerY) {
        rooms = new Room[length][height];
        this.playerX = playerX;
        this.playerY = playerY;
        this.combatPrintOut = "";
    }

    /**
     * This constructor creates a new map object from a text file provided with
     * the information specified for a particular type of game
     *
     * @param p the players object
     *
     * @return a new map taken from a textfile
     */
    public Map(Player p, String fileName) {
        String current = "";
        current = new java.io.File("").getAbsolutePath();


//file name
        String mapDataText = "";

        current = current + "\\" + fileName + ".txt";
        System.out.print(current);
        String temporaryContent = "";
        
        try {
            temporaryContent = new String(Files.readAllBytes(Paths.get(current)));
        } catch (IOException ex) {
        System.out.print("error loading file");
        }

        System.out.print(" map data: " + temporaryContent);
        Scanner mapScanner = new Scanner(temporaryContent);

        mapScanner.useDelimiter(";");
        
        String mapSettings = mapScanner.next();
        Scanner settingScanner = new Scanner(mapSettings);
        settingScanner.useDelimiter(",");


        rooms = new Room[(int) settingScanner.next().charAt(0)][(int) settingScanner.next().charAt(0)];
        this.playerX = (int) settingScanner.next().charAt(0);
        this.playerY = (int) settingScanner.next().charAt(0);

        //array list to hold the room settings
        ArrayList<String> roomSettings = new ArrayList<>();

        //while loop to add room settings to the list 
        while (mapScanner.hasNext()) {
            roomSettings.add(mapScanner.next());
        }

        //for each loop to initialize the class members of the room 
        for (String s : roomSettings) {
            Scanner roomScanner = new Scanner(s);
            roomScanner.useDelimiter(",");
            int roomX = (int) roomScanner.next().charAt(0);
            int roomY = (int) roomScanner.next().charAt(0);
            boolean doorArr[] = new boolean[4];

            //create the direction of doors available based on the array provided in the text file 
            for (int i = 0; i < 4; i++) {
                if (roomScanner.next().equalsIgnoreCase("true")) {
                    doorArr[i] = true;
                } else {
                    doorArr[i] = false;
                }
            }

            //check if there is an enemy in the room
            Enemy enemy = new Enemy(0, 0);
            if (roomScanner.next().equalsIgnoreCase("")) {
                enemy = null;
            } else {
                enemy = new Enemy(roomX, roomY);
            }

            //create the room with the specified parameters from the text file
            Room r1 = new Room(doorArr, enemy, roomScanner.next(), p, roomScanner.next());
            this.addRoom(r1, roomX, roomY);
        }


}

/**
 * Method to get the player's x-coordinate
 *
 * @return playerX the player's x-coordinate on the map
 */
public int getPlayerX()
	{
        int rPlayerX = this.playerX;
        return rPlayerX;
    }

	/**
     * Method to get the player's y-coordinate
     *
	 * @return playerY the player's y-coordinate on the map
	*/
    public int getPlayerY()
	{
        int rPlayerY = this.playerY;
        return rPlayerY;
    }

	
    /**
     * This method adds a new room to the map, by adding it to the 2d array
     * rooms
     *
     * @param room room object to be added to the array
     * @param x the rooms horizontal position
     * @param y the rooms vertical position on the map
     *
     * @return a 1 or -1 used to show if the room has been added
     */
    public int addRoom(Room room, int x, int y)
	{
        //check if valid room placement on map
        if (rooms.length - 1 > y && rooms[0].length - 1 > x && x >= 0 && y >= 0) 
		{
            rooms[x][y] = room;
            roomList.add(room);
            return 1;
        }
        return -1;
    }

    /**
     * This method gets the room in the specified position
     *
     * @param x the rooms horizontal position
     * @param y the rooms vertical position on the map
     *
     * @return the room object in that position
    */
    public Room getRoom(int x, int y) 
	{
        //check if the room is on the map
        if (rooms.length - 1 > y && rooms[0].length - 1 > x && x >= 0 && y >= 0) 
		{
            //Room rRooms = new Room(this.rooms);
            return rooms[x][y];
        }
        return null;
    }

    /**
     * Method to put all of the rooms into a list and return them
     * 
     * @return roomListTemp a one dimensional list of all of the room objects 
     */
    public ArrayList<Room> getAllRooms() 
	{
        ArrayList<Room> roomListTemp = new ArrayList<Room>();

        for (Room rm : roomList) 
		{
            roomListTemp.add(rm);
        }
        return roomListTemp;
    }

	 /**
     * Method to check if all of the enemies have been killed in the room
     * return true if enemies all equal null
	 * return false if still enemies
	 *
     * @return boolean based on checks 
     */
    public boolean allRoomsCleared() 
	{
        for (Room room : roomList) 
		{
            if (room.getEnemy() != null)
				{
                return false;
            }
        }
        return true;

    }

    /**
     *
     *
     */
    public void fixRoomDoors() {//untested
        int roomY = 0;
        for (Room[] room1d : rooms) 
		{
            int roomX = 0;
            for (Room r : room1d) 
			{
                if (r.getIsDoor()[0] == true && roomX - 1 >= 0 && this.getRoom(roomX, roomY) == null)
				{
                    r.getIsDoor()[0] = false;
                } 
				else if (r.getIsDoor()[1] == true && roomY + 1 < this.rooms.length && this.getRoom(roomX, roomY) == null)
				{
                    r.getIsDoor()[1] = false;
                } 
				else if (r.getIsDoor()[2] == true && roomX + 1 < this.rooms[0].length && this.getRoom(roomX, roomY) == null)
				{
                    r.getIsDoor()[2] = false;
                } 
				else if (r.getIsDoor()[3] == true && roomY - 1 >= 0 && this.getRoom(roomX, roomY) == null)
				{
                    r.getIsDoor()[3] = false;
                }
                roomX++;
            }
            roomY++;
        }

    }

    /**
     * This method completes the action chosen by the player for a movement on
     * the map
     *
     * @param input The user's command to the player
     *
     * @return a value of i relating to the direction the player moved for
     * testing purposes
     */
    public int runAction(String input){
        //get the action the player chose
        int i = rooms[playerX][playerY].doAction(input);
        this.combatPrintOut = "";
        //if doAction returns one of these values the player chose to move
        //else they chose a different command 
        Player pMain = this.getRoom(playerX, playerY).getPlayer();

		/* if the player isn't dead run the action return by doAction method
		   
		   if i is between 10 and 13 update the player's x or y coordinate to represent the direction and remove them from the current room and add them to the new room
		   
		   if i is 14 call the attack methods for both the player and enemy 
		   
		   if i is 15 apply the item's ability to the player and remove it from the inventory of the player
		*/
        if (pMain.getHealth() > 0){
            if (i == 10){
                Player p = this.getRoom(playerX, playerY).removePlayer();
                playerY--;
                p.setY(playerY);
                this.getRoom(playerX, playerY).addPlayer(p);
            }else if (i == 11){
                Player p = this.getRoom(playerX, playerY).removePlayer();
                playerX++;
                p.setX(playerX);
                this.getRoom(playerX, playerY).addPlayer(p);
            }else if (i == 12){
                Player p = this.getRoom(playerX, playerY).removePlayer();
                playerY++;
                p.setY(playerY);
                this.getRoom(playerX, playerY).addPlayer(p);
            }else if (i == 13){
                Player p = this.getRoom(playerX, playerY).removePlayer();
                playerX--;
                p.setX(playerX);
                this.getRoom(playerX, playerY).addPlayer(p);
            }else if (i == 14){
                Player p = this.getRoom(playerX, playerY).getPlayer();
                Enemy e = this.getRoom(playerX, playerY).getEnemy();
		System.out.println("\nBefore battle: " + e.toString());
                this.combatPrintOut += "\nBefore battle: " + e.toString();
                System.out.println("Before battle: " + p.toString() + "\n");
                this.combatPrintOut += "Before battle: " + p.toString() + "\n";
                p.attack(e);
                //p.takeDamage(1);
				
		//if enemy isn't dead
                if (e.getHealth() > 0)
				{
                    e.attack(p);
                }

                System.out.println("\nAfter battle: " + e.toString());
                this.combatPrintOut += "\nAfter battle: " + e.toString();
                System.out.print("After battle: " + p.toString() + "\n");
                this.combatPrintOut += "After battle: " + p.toString() + "\n";

		//if enemy is dead, remove from room
                if (e.getHealth() <= 0)
				{
                    e = this.getRoom(playerX, playerY).removeEnemy();
                    System.out.print("Enemy dead \n");
                    this.combatPrintOut += "Enemy dead \n";
                }
				
		//if player is dead return 0 to end game
                if (pMain.getHealth() <= 0)
				{
                    System.out.print("Game Over. You have been slain. \n");
                    this.combatPrintOut += "Game Over. You have been slain. \n";
					return 0;
                }
            }else if (i == 15){
				
		//get the player's inventory
                Player p = this.getRoom(playerX, playerY).getPlayer();
                ArrayList<String> inventory = p.getPouch();
                int numItems = 1;
				
                //print the items in the inventory for the player to choose from
                for (String item : inventory){
                    System.out.println(numItems + ". " + item);
                    numItems++;
                }
				
				//check which item they have chosen and call the useItem method
				boolean validInput = false;
				Scanner itemScanner = new Scanner(System.in);
				int itemSelection = 0;
				
				do{
					System.out.println("Please type the number of the item you would like to use. (If you do not want to use any of your items, type any number not in the list to return to the game)");
					while(!itemScanner.hasNextInt()){
						System.out.println("Invalid input, please try again.");
						itemScanner.next(); 
					}
					itemSelection = itemScanner.nextInt();
					validInput = true;
					
				}while (validInput == false);
				
                int item = p.useItem(itemSelection);
            }
            if(i != 14){
                        this.combatPrintOut = "";

            }

        }
		
        //return the action index
        return i;
    }

    /**
     * This method prints the map to the console
     *
     * @return the string variable corresponding to the map
     */
    public String printMap()
	{
        String s = "";
        for (int row = 0; row < (rooms.length * 2) + 1; row++)
		{
            s = s + this.printRow(row) + "\n";
        }
        return s;
    }

    /**
     * This method prints the row for the map
     *
     * @param rowNumber current row to be printed
     *
     * @return the string variable corresponding to row on the map
     */
    private String printRow(int rowNumber){
        String s = "";
		
		//algorithm to print the rows of rooms to create a grid as opposed to a long line of rooms
        if(rowNumber % 2 == 1){
            s = s + this.printCellInter(rooms[0].length, rowNumber / 2);
        }else{
            s = s + this.printLine(rooms[0].length, rowNumber / 2);
        }

        return s;
    }

    /**
     * This method prints the line to distinguish the rooms on the map
     *
     * @param numberOfNodes number of rooms
     *
     * @return the string variable corresponding to a line on the map
     */
    private String printLine(int numberOfNodes, int row){
        String s = "";
		
		//algorithm to build the lines that separate the individual rooms 
        for (int i = 0; i < (numberOfNodes); i++){
            if (row < this.rooms[0].length && this.rooms[(i)][row] != null || (row > 0 && this.rooms[(i)][row - 1] != null)){
                s = s + "--";
            }else{
                s = s + "  ";
            }
        }

        return s;
    }

    /**
     * This method prints the contents in the middle of the cell
     *
     * @param numberOfNodes number of rooms
     *
     * @return the string variable corresponding to the middle of a cell on the
     * map
     */
    private String printCellInter(int numberOfNodes, int row) {
        String s = "";
        boolean wasLastRoom = false;
		
		//algorithm to create the lines that make up the cells which represent the rooms
        for (int i = 0; i < numberOfNodes; i++){
            if (this.rooms[i][row] == null){
                if (wasLastRoom){
                    s = s + "|";
                    wasLastRoom = false;
                }else{
                    s = s + " ";
                }
                s = s + " ";
            }else{
                s = s + "|";
                wasLastRoom = true;
                if (this.playerX == i && this.playerY == row){
                    s = s + "p";
                }else{
                    s = s + " ";
                }
            }
        }
        //s = s + "|";
        return s;

    }

    /**
	 * Our own toString method for this class to print a room on the map
	 *
	 * @param row row of room to print
	 * @param column column of room to print
	 *
	 * @return the information about the room to the user
	*/
    public String toString(int row, int column){
		
		//algorithm to to wok out which room to print
        if (rooms[0].length - 1 > row && rooms.length - 1 > column && column >= 0 && row >= 0 && rooms[column][row] != null){
            return rooms[column][row].toString();
        }else{
            return "no room exists there";
        }
    }
	
	 /**
	 * Method to get the story and put in to  one string variable
	 *
	 * @return string variable containing the story
	 */
	public String getStory(){
		String story = "Dungeon Hero!\n" + "The king has scoured the land for help with a dark evil: The Shadow King.\n" + "The hero, 'The chosen one' has answered the call to save the princess and to receive large sum of wealth.\n"
		+ "Venturing far and wide, he has finally arrived at the nearby town, and begins searching for answers...\n" +
		"Upon leaving the town, he is assailed by goblins!\n" +
		"He must fight to find his way to the dungeon that the Shadow King inhabits.\n" +  "There, he must get past traps, pick locks, and fight to progress, before arriving at the boss room where the 'Evil Shadow King' is waiting, and the princess needs to be saved!\n" + "\nSave the princess and the kingdom!";
		
		return story;
	}

    public String getCombatPrintOut() {
        return combatPrintOut;
    }
        
        

}
