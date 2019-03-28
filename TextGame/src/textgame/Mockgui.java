package textgame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class Mockgui extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        //Holds actions
        VBox buttonBox = new VBox();
        //Shows results
        VBox showBox = new VBox();

        Scene scene = new Scene(root, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dungeon Hero");

        Button moveEast = new Button("Move East");
        Button moveWest = new Button("Move West");
        Button moveNorth = new Button("Move North");
        Button moveSouth = new Button("Move South");
        Button searchRoom = new Button("Search Room");
        Button useItem = new Button("Use Item");
        Button attackEnemy = new Button("Attack Enemy");

        Text text = new Text();//will hold description and map
        Map m = new Map(3, 3);//create map... to be converted to a file load system
        Player p = new Player(30, 0, 0);
        Enemy enemyRoomOne = new Enemy(0, 0);
        Enemy enemyRoomTwo = new Enemy(1, 0);
        Enemy enemyRoomThree = new Enemy(1, 1);
        boolean b1[] = {false, true, false, false};
        Room r1 = new Room(b1, enemyRoomOne, "heal potion", p, "A suspiciously quiet room, you look around the cold dark stone room and feel\n something brush up against your leg and hope it's just a rat. Then out of the\n darkness a skeleton knight is coming towards you!");
        boolean b2[] = {false, false, true, true};
        Room r2 = new Room(b2, enemyRoomTwo, "attack potion", p, "You enter a well it room with fire torches all the way down the the big\n long corridor. You see lots of chests to the side, hopefully with lots of items.\n However guarded by a group of goblins!");
        boolean b3[] = {true, false, false, false};
        Room r3 = new Room(b3, enemyRoomThree, "attack potion", p, "You enter the armory of the dungeon, and see lots of weapons you could\n pick up. Then out of the darkness appears a troll warrior! ...");

        //get list of doable actions
        Room tempRoom = new Room(Map.getRoom(Player.getPosX(), Player.getPosY()));

        moveEast.setDisable(true);
        moveWest.setDisable(true);
        moveNorth.setDisable(true);
        moveSouth.setDisable(true);
        searchRoom.setDisable(true);
        useItem.setDisable(true);
        attackEnemy.setDisable(true);

        //handle actions
        EventHandler buttonHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button tempButton = event.getTarget();
                tempButton.getText();
                
            }
        };
    }
}