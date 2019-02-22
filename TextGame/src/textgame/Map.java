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

    Room rooms[][];
    int playerX;
    int playerY;

    public Map(int length, int height) {
        this(length, height, 0, 0);
    }

    public Map(int length, int height, int playerX, int playerY) {
        rooms = new Room[length][height];
    }

    public int addRoom(Room room, int x, int y) {
        if (rooms.length - 1 > y && rooms[0].length - 1 > x && x >= 0 && y >= 0) {
            rooms[y][x] = room;
            return 1;
        }
        return -1;
    }

    public Room getRoom(int x, int y) {
        if (rooms.length - 1 > y && rooms[0].length - 1 > x && x >= 0 && y >= 0) {
            return rooms[y][x];
        }
        return null;
    }

    public int runAction(String input) {
        int i = rooms[playerY][playerX].doAction(input);

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

    public String printMap() {
        String s = "";
        for (int row = 0; row < (rooms.length * 2) + 1; row++) {
            s = s + this.printRow(row) + "\n";
        }
        return s;
    }

    private String printRow(int rowNumber) {
        String s = "";
        if (rowNumber % 2 == 1) {
            s = s + this.printCellInter(rooms[0].length, rowNumber);
        } else {
            s = s + this.printLine(rooms[0].length);
        }

        return s;
    }

    private String printLine(int numberOfNodes) {
        String s = "";
        for (int i = 0; i < (numberOfNodes * 2) + 1; i++) {
            s = s + "-";
        }

        return s;
    }

    private String printCellInter(int numberOfNodes, int row) {
        String s = "";
        for (int i = 0; i < numberOfNodes; i++) {
            s = s + "|";
            s = s + " ";//more logic is still requierd here
        }
        s = s + "|";
        return s;

    }

    public String toRoomString(int row, int columb) {
        if (rooms.length - 1 > row && rooms[0].length - 1 > columb && columb >= 0 && row >= 0 && rooms[row][columb]!= null) {
            return rooms[row][columb].toString();
        } else {
            return "no room exists there";
        }
    }

    public static void main(String[] args) {
        Map m = new Map(4, 3);
        System.out.print(m.printMap());
        Player p = new Player(6,0,0);
        boolean b[] = {true,false,true,false};
        Room r = new Room(b /*, Enemy enemyRef*/, "ping pong ball", p);
        System.out.println(m.addRoom(r, 0, 0));
        System.out.println(m.toRoomString(0, 0));

    }

}
