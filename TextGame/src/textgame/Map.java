/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textgame;

/**
 *
 * a class to contain a room[][] array and methods to work a game map
 *
 * @author George Smith
 */
public class Map {
    
        public static void main(String[] args) {

        //testing commands for this class
        Map m = new Map(3, 3);
        System.out.print(m.printMap());
        Player p = new Player(6, 0, 0);
        boolean b[] = {true, false, true, false};
        Room r1 = new Room(b /*, Enemy enemyRef*/, "ping pong ball", p);
        Room r2 = new Room(b /*, Enemy enemyRef*/, p);
        Room r3 = new Room(b /*, Enemy enemyRef*/, p);

        System.out.println(m.addRoom(r1, 0, 0));
        System.out.println(m.addRoom(r2, 1, 0));
        System.out.println(m.addRoom(r2, 1, 1));
        System.out.println(m.toString(0, 0));
        System.out.print(m.printMap());

    }

    //declare and intialize class members
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
    }

    /**
     * This method adds a new room to the map, by adding it to the 2d array
     * rooms
     *
     * @param room room object to be added to the array
     * @param x the rooms horizontal postion
     * @param y the rooms vertical position on the map
     *
     * @return a 1 or -1 used to show if the room has been added
     */
    public int addRoom(Room room, int x, int y) {
        //check if valid room placement on map
        if (rooms.length - 1 > y && rooms[0].length - 1 > x && x >= 0 && y >= 0) {
            rooms[y][x] = room;
            return 1;
        }
        return -1;
    }

    /**
     * This method gets the room in the specified position
     *
     * @param x the rooms horizontal postion
     * @param y the rooms vertical position on the map
     *
     * @return the room object in that postion
     */
    public Room getRoom(int x, int y) {
        //check if the room is on the map
        if (rooms.length - 1 > y && rooms[0].length - 1 > x && x >= 0 && y >= 0) {
            return rooms[y][x];
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
        int i = rooms[playerY][playerX].doAction(input);

        //if doAction returns one of these values the player chose to move
        //else they chose a diffretn command 
        if (i == 10) {
            playerY++;
        } else if (i == 11) {
            playerX++;
        } else if (i == 12) {
            playerY--;
        } else if (i == 13) {
            playerX--;
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
            if(row < this.rooms.length && this.rooms[(row)][i] != null ||
                    (row > 0 && this.rooms[(row - 1)][i] != null)){
                s = s + "--";
            }else{
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
            if (this.rooms[row][i] == null) {

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
        if (rooms.length - 1 > row && rooms[0].length - 1 > column && column >= 0 && row >= 0 && rooms[row][column] != null) {
            return rooms[row][column].toString();
        } else {
            return "no room exists there";
        }
    }



}
