package textgame;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gamegui extends Application {
    private ArrayList<String> refActions;
    private ArrayList<Button> actionArray;
    private Room refRoom = TextGame.m.getRoom(TextGame.Player.getX(),TextGame.Player.getY());
    private Boolean gameRun;

    public ArrayList<String> getRefActions() {
        ArrayList<String> tempRef = this.refActions;
        return tempRef;
    }

    public Room getRefRoom() {
        Room tempRoom = this.refRoom;
        return refRoom;
    }

    public Boolean getGameRun() {
        Boolean tempGameRun = this.gameRun;
        return tempGameRun;
    }

    public void setGameRun(Boolean runValue) {
        this.gameRun = runValue;
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Canvas canvas = new Canvas(500, 500);
        BorderPane posRoot = new BorderPane();
        GraphicsContext gc = canvas.getGraphicsContext2D();

        VBox doableActions = new VBox();

        //While (GET TEXT GAME RUN VALUE) {
            //refRoom = Copy Constructor for  room player is in.
            this.refActions = refRoom.getDoableActions();
            this.actionArray = new ArrayList();

            for (int i = 0; i < refActions.size(); i++) {
                actionArray.add(new Button(refActions.get(i)));
            }

            for (int i = 0; i < actionArray.size(); i++) {
                if (actionArray.get(i).getText().equalsIgnoreCase("MOVE NORTH")) {
                    actionArray.get(i).setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            //Return move north
                        }
                    });
                    //Do something about moving north
                } else if (actionArray.get(i).getText().equalsIgnoreCase("MOVE SOUTH")) {
                    actionArray.get(i).setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            //Return move north
                        }
                    });
                    //Do something about moving south
                } else if (actionArray.get(i).getText().equalsIgnoreCase("MOVE WEST")) {
                    actionArray.get(i).setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            //Return move north
                        }
                    });
                    //Do something about moving west
                } else if (actionArray.get(i).getText().equalsIgnoreCase("MOVE EAST")) {
                    actionArray.get(i).setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            //Return move north
                        }
                    });
                    //Do something about moving east
                } else if (actionArray.get(i).getText().equalsIgnoreCase("ATTACK ENEMY")) {
                    actionArray.get(i).setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            //Return move north
                        }
                    });
                    //Do something about attacking
                } else if (actionArray.get(i).getText().equalsIgnoreCase("USE ITEM")) {
                    actionArray.get(i).setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            //Return move north
                        }
                    });
                    //Do something about using an item
                    //while (Something about making a choice) {
                        //choice 1:  ...
                        //choice ...: ...
                        //Choise n: exit
                    //}
                }
            }
            /*
            Button move = new Button("MOVE");
            Button attack = new Button("ATTACK");
            doableActions.getChildren().add(move);
            doableActions.getChildren().add(attack);
            */

            posRoot.setLeft(doableActions);

            gc.strokeRect(380, 10, 115, 115);
            gc.strokeRect(390, 20, 25, 25);
            gc.strokeRect(420, 20, 25, 25);
            gc.strokeRect(420, 50, 25, 25);
            gc.strokeLine(100, 0, 100, 500);

            root.getChildren().add(posRoot);
            root.getChildren().add(canvas);

            Scene scene = new Scene(root, 500, 500);
            primaryStage.setScene(scene);

            primaryStage.setTitle("Dungeon Hero");
            primaryStage.show();
        //}
    }
}