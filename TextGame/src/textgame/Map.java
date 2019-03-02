/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textgame;

import java.util.Scanner;

/**
 *
 * a class to contain a room[][] array and methods to work a game map
 *
 * @author George Smith
 */
public class Map {

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
		Enemy enemyRef = new Enemy(6, 0, 0);
        boolean b1[] = {false, true, false, false};
        Room r1 = new Room(b1, enemyRef, "heal potion", p, "A suspiciously quiet room, you look around the cold dark stone room and feel something brush up against your leg and hope it's just a rat.");
        boolean b2[] = {false, false, true, true};
        Room r2 = new Room(b2 /*, Enemy enemyRef*/, p, "Another empty room, this one much bigger with a long corridor. Although empty you can still hear the Shadow Kings minions plotting");
        boolean b3[] = {true, false, false, false};
        Room r3 = new Room(b3 /*, Enemy enemyRef*/, p, "This room is also empty, you feel very uneasy and decide to turn away and come back when there is more activity...");

        System.out.println(m.addRoom(r1, 0, 0));
        System.out.println(m.addRoom(r2, 1, 0));
        System.out.println(m.addRoom(r3, 1, 1));
        //System.out.println(m.toString(0, 0));
        System.out.println(m.printMap());

        Scanner scanner = new Scanner(System.in);
        boolean t = true;
        while (t) {
            System.out.println(m.printMap());
            System.out.println(m.getRoom(m.playerX, m.playerY).getText());
            System.out.println("you can: " + m.getRoom(m.playerX, m.playerY).getDoableActions());
            String action = scanner.nextLine();
            if (action.equalsIgnoreCase("end")) {
                t = false;
            } else {
                //System.out.println(action);
                int i = m.runAction(action);
				if(i == 0)
				{
					break;
				}

            }

        }
		
    }
    //declare and initialize class members
    Room rooms[][];
    int playerX;
    int playerY;

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
    public int addRoom(Room room, int x, int y) {
        //check if valid room placement on map
        if (rooms.length - 1 > y && rooms[0].length - 1 > x && x >= 0 && y >= 0) {
            rooms[x][y] = room;
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
    public Room getRoom(int x, int y) {
        //check if the room is on the map
        if (rooms.length - 1 > y && rooms[0].length - 1 > x && x >= 0 && y >= 0) {
            return rooms[x][y];
        }
        return null;
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
    public int runAction(String input) {
        //get the action the player chose
        int i = rooms[playerX][playerY].doAction(input);

        //if doAction returns one of these values the player chose to move
        //else they chose a different command 
        Player pMain = this.getRoom(playerX, playerY).getPlayer(); 
	
		if(pMain.getHealth() > 0)
		{
			if (i == 10) {
				Player p = this.getRoom(playerX, playerY).removePlayer();
				playerY--;
				this.getRoom(playerX, playerY).addPlayer(p);
			} else if (i == 11) {
				Player p = this.getRoom(playerX, playerY).removePlayer();
				playerX++;
				this.getRoom(playerX, playerY).addPlayer(p);
			} else if (i == 12) {
				Player p = this.getRoom(playerX, playerY).removePlayer();
				playerY++;
				this.getRoom(playerX, playerY).addPlayer(p);
			} else if (i == 13) {
				Player p = this.getRoom(playerX, playerY).removePlayer();
				playerX--;
				this.getRoom(playerX, playerY).addPlayer(p);
			} else if (i == 14) {
				Player p = this.getRoom(playerX, playerY).getPlayer();
				Enemy e = this.getRoom(playerX, playerY).getEnemy();
				p.attackEnemy(e);
				//p.takeDamage(1);
				e.attack(p);
				System.out.print(p.toString() + "\n");
				
				if(e.getHealth() <= 0)
				{
					e = this.getRoom(playerX, playerY).removeEnemy();
					System.out.print("Enemy dead \n");

				}
			if(pMain.getHealth() <= 0)
			{
				System.out.print("Game Over. You have been slain \n");
				return 0;
			}
		}
			
				

        }
		

        return i;
    }

    /**
     * This method prints the map to the console
     *
     * @return the string variable corresponding to the map
     */
    public String printMap() {
        String s = "";
        for (int row = 0; row < (rooms.length * 2) + 1; row++) {
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
    private String printRow(int rowNumber) {
        String s = "";
        if (rowNumber % 2 == 1) {
            s = s + this.printCellInter(rooms[0].length, rowNumber / 2);
        } else {
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
    private String printLine(int numberOfNodes, int row) {
        String s = "";
        for (int i = 0; i < (numberOfNodes); i++) {
            if (row < this.rooms[0].length && this.rooms[(i)][row] != null
                    || (row > 0 && this.rooms[(i)][row - 1] != null)) {
                s = s + "--";
            } else {
                s = s + "  ";
            }

            /*
            if (row < this.rooms.length && this.rooms[(row)][i] == null) {
                s = s + "  ";
            } else if (row>0 && this.rooms[(row-1)][i] == null) {
                s = s + "--";
            } else if (!(row < this.rooms.length)) {
                s = s + "  ";
            } else {
                s = s + "--";
            }
             */
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
        for (int i = 0; i < numberOfNodes; i++) {
            if (this.rooms[i][row] == null) {

                if (wasLastRoom) {
                    s = s + "|";
                    wasLastRoom = false;
                } else {
                    s = s + " ";
                }
                s = s + " ";
            } else {
                s = s + "|";
                wasLastRoom = true;
                if (this.playerX == i && this.playerY == row) {
                    s = s + "p";
                } else {
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
    public String toString(int row, int column) {
        if (rooms[0].length - 1 > row && rooms.length - 1 > column && column >= 0 && row >= 0 && rooms[column][row] != null) {
            return rooms[column][row].toString();
        } else {
            return "no room exists there";
        }
    }

}
