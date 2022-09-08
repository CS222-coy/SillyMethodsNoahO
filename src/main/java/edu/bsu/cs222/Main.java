package edu.bsu.cs222;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.lang.NumberFormatException;

import java.io.IOException;

import static javafx.application.Application.launch;

public class Main extends Application {
    public static SillyMethods sillyMethod = new SillyMethods();

    public static String checkYesOrNo(boolean check) {
        if(check) {
            return("Yes");
        }
        return("No");
    }

    @Override
    public void start(Stage stage) throws IOException {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Enter a number to be silly on:");
        sceneTitle.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);
        TextField numberToCheck = new TextField();
        grid.add(numberToCheck, 0, 1);
        Button checkButton = new Button("Submit");
        grid.add(checkButton, 1, 1);
        Text answer1 = new Text();
        grid.add(answer1, 0, 3);
        Text answer2 = new Text();
        grid.add(answer2, 0, 4, 2, 1);
        Text answer3 = new Text();
        grid.add(answer3, 0, 5);

        checkButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String userEntry = numberToCheck.getText();
                int userNum = 0;
                try {
                    userNum = Integer.parseInt(userEntry);
                    answer1.setFill(Color.BLACK);
                }
                catch(final NumberFormatException error) {
                    answer1.setFill(Color.RED);
                    answer1.setText("Give me an actual integer buddy boy >:(");
                    answer2.setText(null);
                    answer3.setText(null);
                    return;
                }
                answer1.setText("Did you guess the ultimate answer?: " + checkYesOrNo(sillyMethod.didGuess42(userNum)));
                answer2.setText("Counting to your number: " + sillyMethod.countTo(userNum));
                answer3.setText("Is your number even?: " + checkYesOrNo(sillyMethod.checkIfEven(userNum)));
            }
        });

        Scene scene = new Scene(grid, 400, 240);
        stage.setTitle("Silly Methods");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
