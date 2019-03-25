package textgame;

import java.awt.Insets;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
//import javafx.scene.control.ButtonBuilder;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.event.ChangeListener;

public class Gamegui extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TextField textField = new TextField();

        HBox hbox = new HBox(textField);

        // primaryStage.setScene(scene);
        Text text = new Text();

        //setting the position of the text 
        text.setX(5);
        text.setY(20);

        Map m = new Map(3, 3);
        Player p = new Player(30, 0, 0);
        Enemy enemyRoomOne = new Enemy(0, 0);
        Enemy enemyRoomTwo = new Enemy(1, 0);
        Enemy enemyRoomThree = new Enemy(1, 1);
        boolean b1[] = {false, true, false, false};
        Room r1 = new Room(b1, enemyRoomOne, "heal potion", p, "A suspiciously quiet room, you look around the cold dark stone room and feel something brush up against your leg and hope it's just a rat. Then out of the darkness a skeleton knight is coming towards you!");
        boolean b2[] = {false, false, true, true};
        Room r2 = new Room(b2, enemyRoomTwo, "attack potion", p, "You enter a well it room with fire torches all the way down the the big long corridor. You see lots of chests to the side, hopefully with lots of items. However guarded by a group of goblins!");
        boolean b3[] = {true, false, false, false};
        Room r3 = new Room(b3, enemyRoomThree, "attack potion", p, "You enter the armory of the dungeon, and see lots of weapons you could pick up. Then out of the darkness appears a roll warrior! ...");

        m.addRoom(r1, 0, 0);
        m.addRoom(r2, 1, 0);
        m.addRoom(r3, 1, 1);

        text.setText("The king has scoured the land for help with a dark evil: The Shadow King.\n"
                + "The hero, 'The chosen one' has answered the call to save the princess and to receive large sum of wealth.\n"
                + "Venturing far and wide, he has finally arrived at the nearby town, and begins searching for answers...\n "
                + "Upon leaving the town, he is assailed by goblins!\n"
                + "He must fight to find his way to the dungeon that the Shadow King inhabits.\n"
                + "riving at the boss room where the 'Evil Shadow King' is waiting, and the princess needs to be saved!\n"
                + "Save the princess and the kingdom!\n" + m.printMap());

        //Creating a Group object  
        ObservableList<String> options = FXCollections.observableArrayList(m.getRoom(m.getPlayerX(), m.getPlayerY()).getDoableActions());

        final ChoiceBox comboBox = new ChoiceBox(options);
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.add(comboBox, 1, 0);
        grid.add(text, 2, 0);

        Scene scene = new Scene(grid, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Dungeon Hero");
        primaryStage.show();
        /*
        ComboBox.valueProperty().addListener(new ChangeListener<String>(){
            @Override public void changed(ObservableValue ov, String t, String t1){
                
            }
            
        
        });
*/
        comboBox.addEventHandler(EventType.ROOT, event -> {
           System.out.println(event.getTarget());
          //if(event.getEventType() == Event.ACTION_EVENT ){
          //comboBox.
               
          //}
            
        });
        
    }
    
    

}
