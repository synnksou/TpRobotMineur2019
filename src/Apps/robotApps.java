package Apps;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import com.company.*;

import java.io.IOException;

public class robotApps extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane= new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(25);
        gridPane.setVgap(15);

        Label label = new Label("Bienvenue dans mon robot mineur");
        gridPane.add(label,0,2);
        label.setTextFill(Color.BLUE);



        Button button=new Button("Jouer");
        gridPane.add(button,0,3);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String args[] = new String[0];
                try {
                    Main.main(args);
                } catch (DejaOccuperExecption dejaOccuperExecption) {
                    dejaOccuperExecption.printStackTrace();
                }
            }
        });

        Button buttonClose = new Button("Fermer");
        gridPane.add(buttonClose,0,4);
        buttonClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });

        Scene scene=new Scene(gridPane,300,300);
        primaryStage.setTitle("Robot Mineur");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
