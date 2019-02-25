package demodemo1;

import java.util.Scanner;

public class textGame {

    public static void printOptions() {
        System.out.println("Choose your action");
        System.out.println("1. Move");
        System.out.println("2. Attack");
        System.out.println("3. Search");
        System.out.println("4. Use Item\n");
    }

    public static void printDirections() {
        System.out.println("1. up");
        System.out.println("2. down");
        System.out.println("3. left");
        System.out.println("4. right");
    }

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        Room demoRoom = new Room(9, 9);
        demoRoom.initialize();
        demoRoom.showRoom();

        while (true) {
            textGame.printOptions();

            int response = keyboard.nextInt();

            if (response == 1) {
                demoRoom.showRoom();
                textGame.printDirections();

                String direction = keyboard.next();

                if (direction == 1) {
                    if (player.getPosX > 0) {
                        Sysetem.out.println("You move upwards");
                    }
                    else {
                        Sysetem.out.println("INVALID");
                    }
                } else if (direction == 2) {
                    Sysetem.out.println("You move downwards");
                } else if (direction == 3) {
                    Sysetem.out.println("You move to the left");
                } else if (direction == 4) {
                    Sysetem.out.println("You move to the Right");
                } else {
                    Sysetem.out.println("INVALID");
                }
            } else if (response == 2) {
                demoRoom.showRoom();
                System.out.println("You attack.\n");
            } else if (response == 3) {
                demoRoom.showRoom();
                System.out.println("You search the area.");
                System.out.println("You find nothing.\n");
            } else if (response == 4) {
                demoRoom.showRoom();
                System.out.println("You use an item.\n");
            } else if (response == 5) {
                System.out.println("You exit the game.\n");
                break;
            } else {
                demoRoom.showRoom();
                System.out.println("INVALID\n");
            }

        }
    }
}