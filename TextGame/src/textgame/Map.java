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
        if (rooms.length - 1 < y && rooms[0].length - 1 < x && x >= 0 && y >= 0) {
            rooms[y][x] = room;
            return 1;
        }
        return -1;
    }

    public Room getRoom(int x, int y) {
        if (rooms.length - 1 < y && rooms[0].length - 1 < x && x >= 0 && y >= 0) {
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
        String map = "";
        for (int j = 0; j < rooms.length; j++) {
            for (int r = 0; r < 2; r++) {
                if (r == 1) {

                    for (int i = 0; i < rooms[0].length + 1; i++) {
                        for (int t = 0; t < 2; t++) {
                            if (t == 1) {
                                map = map + " ";
                            } else {
                                map = map + "|";
                            }

                        }
                        //map = map + "\n";

                    }
                } else {
                    for (int i = 0; i < 2*(rooms[0].length + 1); i++) {
                        map = map + "-";

                    }
                                            map = map + "\n";

                }

            }
            map = map + "\n";

        }

        return map;
    }

}
