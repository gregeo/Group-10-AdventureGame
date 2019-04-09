//import javafx.io.IOExpection;
//import javafx.io.InputStream;
//import javafx.nio.file.File;
//import javafx.nio.file.Paths;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.text.Font;


import javafx.application.Application;
import javafx.scene.Scene;

public class StartScreen extends Application{

	//@Override
	//public static void main(String[] args){
	//	launch(args);
	//}
	public void start(Stage primaryStage) throws Exception {

		//InputStream is = file.newInputStream(path.get("Desktop/black/black.jpg"));
		//Image ing = new Image(is);
		//is.close();

		VBox root = new VBox();
		Text text = new Text("DUNGEON HERO");
		text.setFont(Font.font("Verdana", 50));
		text.setFill(Color.RED);
		root.setAlignment(Pos.TOP_CENTER);
		root.setPadding(new Insets (100,0,0,0));
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
		Scene scene2 = new Scene(game, 800, 600);


		buttons.setOnAction(click -> {
			//FadeTransition ft = new FadeTransition(Duration.second(0.5), this);
			primaryStage.setScene(scene2);
		});

		root.getChildren().addAll(text, button);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
	/*public void MenuButton(String name){
			Text text;

			text = new Text(name);
			text.setFont(Font.font("Verdana", 15));
			text.setFill(Color.WHITE);

			Rectangle box = new Rectangle(300, 100);
			box.setFill(Color.BLACK);
			//box.setEffect(new GaussianBlur(3,5));

			box.setAlignment(Pos.BOT_CENTER);
			getChildren().addAll(box, text);

			setOnMouseEntered(event -> {
				//box.setTranslateX(10);
				//test.SetTranslateX(10);
				box.setFill(Color.WHITE);
				text.setFill(Color.RED);
			});

			setOnMouseExited(event -> {
				//box.setTranslateX(0);
				//test.setTranslateX(0);
				box.setFill(Color.BlACK);
				text.setFill(Color.WHITE);
			});

			DropShadow drop = new DropShadow(50, Color.WHITE);
			drop.setInput(new Glow());

			setOnMousePressed(event -> setEffect(drop));
			setonMouseReleased(event -> setEffect(null));

		*/
