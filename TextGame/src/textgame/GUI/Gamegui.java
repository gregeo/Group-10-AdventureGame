package textgame.GUI;

import java.util.ArrayList;
import textgame.backend.Room;
import textgame.backend.Player;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import textgame.backend.Enemy;
import textgame.backend.Map;

/**
 * class to represent the GUI portion of the game
 *
 */
public class Gamegui extends Application {

    ListView<String> optionsDrop;
    MultipleSelectionModel<String> optionModel;
    ObservableList<String> options;
    Map m;
    Text text;

    /*
    public Gamegui(ListView<String> optionsDrop, MultipleSelectionModel<String> optionModel, ObservableList<String> options, Map m, Text text) {
        this.optionsDrop = optionsDrop;
        this.optionModel = optionModel;
        this.options = options;
        this.m = m;
        this.text = text;
    }
     */
    public static void main(String[] args) {
        //main method to launch the GUI
        launch(args);
    }

    /**
     * overridden method from the Application class to create our interface
     *
     * @param primaryStage Primary stage that will contain a grid containing
     * text and a drop menu
     */
    @Override
    public void start(Stage primaryStage) {

        //InputStream is = file.newInputStream(path.get("Desktop/black/black.jpg"));
        //Image ing = new Image(is);
        //is.close();
        VBox root = new VBox();
        Text titletext = new Text("DUNGEON HERO");
        Text desctext = new Text("The king has scoured the land for help with a dark evil: The Shadow King.\n"
                + "The hero, 'The chosen one' has answered the call to save the princess and to receive large sum of wealth.\n"
                + "Venturing far and wide, he has finally arrived at the nearby town, and begins searching for answers...\n "
                + "Upon leaving the town, he is assailed by goblins!\n"
                + "He must fight to find his way to the dungeon that the Shadow King inhabits.\n"
                + "riving at the boss room where the 'Evil Shadow King' is waiting, and the princess needs to be saved!\n"
                + "Save the princess and the kingdom!\n");
        titletext.setFont(Font.font("Verdana", 50));
        titletext.setFill(Color.RED);
        desctext.setFont(Font.font("Verdana", 12));
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(100, 0, 0, 0));
        //root.setFill(Color.BLACK);

        //ImageView ingView = newImageView(ing);
        //ingView.setFitWidth(800);
        //ingView.setFitHeight(600);
        HBox button = new HBox();
        button.setAlignment(Pos.BOTTOM_CENTER);
        Button buttons = new Button("START");
        button.getChildren().add(buttons);

        Scene scene = new Scene(root, 800, 600);

        VBox game = new VBox();

        root.getChildren().addAll(titletext, desctext,button);

        primaryStage.setScene(scene);
        primaryStage.show();

//begin grid pane(root node setup)
        GridPane grid = new GridPane();//root node
        grid.setVgap(4);
        grid.setHgap(10);
//end grid pane(root node setup)
//begin scene setup
        Scene scene2 = new Scene(grid, 800, 300);
        primaryStage.setTitle("Dungeon Hero");
//end scene setup
// begin text box setup
        text = new Text();//will hold description and map
        m = new Map(3, 3);//create map... to be converted to a file load system
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

        //add all of the rooms to the map
        m.addRoom(r1, 0, 0);
        m.addRoom(r2, 1, 0);
        m.addRoom(r3, 1, 1);

        //set the text to include the story on the interface for the user and print the map
        text.setText("The king has scoured the land for help with a dark evil: The Shadow King.\n"
                + "The hero, 'The chosen one' has answered the call to save the princess and to receive large sum of wealth.\n"
                + "Venturing far and wide, he has finally arrived at the nearby town, and begins searching for answers...\n "
                + "Upon leaving the town, he is assailed by goblins!\n"
                + "He must fight to find his way to the dungeon that the Shadow King inhabits.\n"
                + "riving at the boss room where the 'Evil Shadow King' is waiting, and the princess needs to be saved!\n"
                + "Save the princess and the kingdom!\n" + m.printMap());
        text.setText(m.getRoom(m.getPlayerX(), m.getPlayerY()).getText() + "\n" + m.printMap());
        grid.add(text, 2, 0);
//end text box setup
//begin menu setup

//end menu setup
//start new menu setup
        ArrayList list = m.getRoom(m.getPlayerX(), m.getPlayerY()).getDoableActions();
        for (int i = 0; i < 10; i++) {
            //list.add(" ");
        }

        options = FXCollections.observableArrayList(m.getRoom(m.getPlayerX(), m.getPlayerY()).getDoableActions());//gets a list of doable actions for th

        optionsDrop = new ListView<String>(options);
        optionsDrop.setEditable(true);
        optionsDrop.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        optionModel = optionsDrop.getSelectionModel();

        optionModel.selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override

            public void changed(ObservableValue<? extends String> changed, String oldVal, String newVal) {
                int i = m.runAction(newVal);
                options = FXCollections.observableArrayList(m.getRoom(m.getPlayerX(), m.getPlayerY()).getDoableActions());//gets a list of doable actions for th
                //text.setText(m.getRoom(m.getPlayerX(), m.getPlayerY()).getText() + "\n" + m.printMap());
                //ArrayList hh = m.getRoom(m.getPlayerX(), m.getPlayerY()).getDoableActions();
                //options = FXCollections.observableArrayList(hh);
                //optionModel.clearSelection();
                ListView<String> optionsDrop = new ListView<String>(options);
                optionsDrop.setEditable(true);
                optionsDrop.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                MultipleSelectionModel<String> optionModel = optionsDrop.getSelectionModel();
                optionModel.selectedItemProperty().addListener(this);
                // optionModel = optionsDrop.getSelectionModel();
                //optionModel.clearSelection();
                GridPane nextgrid = new GridPane();//root node
                nextgrid.setVgap(4);
                nextgrid.setHgap(10);
                Scene scene2 = new Scene(nextgrid, 800, 300);
                nextgrid.add(text, 2, 0);
                nextgrid.add(optionsDrop, 1, 0);
                primaryStage.setScene(scene2);
            }

        });
        grid.add(optionsDrop, 1, 0);

        buttons.setOnAction(click -> {
            //FadeTransition ft = new FadeTransition(Duration.second(0.5), this);
            primaryStage.setScene(scene2);
        });

//end new Menu setup
        primaryStage.show();

    }

}
