package textgame;

import java.util.ArrayList;

import javafx.application.Application;
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
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Canvas canvas = new Canvas(500, 500);
        BorderPane posRoot = new BorderPane();
        GraphicsContext gc = canvas.getGraphicsContext2D();

        VBox doableActions = new VBox();

        //While (GET TEXT GAME RUN VALUE) {
            Room refRoom = new Room();
            ArrayList<String> refActions = refRoom.getDoableActions();
            ArrayList<Button> actionArray = new ArrayList();

            for (int i = 0; i < refActions.size(); i++) {
                actionArray.add(new Button(refActions.get(i)));
            }

            for (int i = 0; i < actionArray.size(); i++) {
                if (actionArray.get(i).getText().equalsIgnoreCase("MOVE NORTH")) {
                    //Do something about moving north
                } else if (actionArray.get(i).getText().equalsIgnoreCase("MOVE SOUTH")) {
                    //Do ___
                } else if (actionArray.get(i).getText().equalsIgnoreCase("MOVE WEST")) {
                    //Do ___
                } else if (actionArray.get(i).getText().equalsIgnoreCase("MOVE EAST")) {
                    //Do ___
                } else if (actionArray.get(i).getText().equalsIgnoreCase("ATTACK ENEMY")) {
                    //Do ___
                } else if (actionArray.get(i).getText().equalsIgnoreCase("USE ITEM")) {
                    //Do ___
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