package sample.educative;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Homescreen;
import sample.educative.read.ReadScreen;
import sample.educative.writing.WriteMainScreen;

public class EducativeHomeScreen extends Application {
    Pane pane = new Pane();
    Scene scene;
    GetImage getImage = new GetImage();

    @Override
    public void start(Stage stage) throws Exception {
        Button btnBack = new Button("Back");
        Button btnMath = new Button("math");
        Button btnRead = new Button("read");
        Button btnWrite = new Button("write");

        btnBack.relocate(0,575);
        btnMath.relocate(100,100);
        btnRead.relocate(100,200);
        btnWrite.relocate(200,100);

        btnBack.setOnAction(e -> {
            returnHome(stage);
        });
        btnMath.setOnAction(E->{
            goMathScreen(stage);
        });
        btnRead.setOnAction(E->{
            goReadScreen(stage);
        });
        btnWrite.setOnAction(E->{
            goWriteScreen(stage);
        });

        pane.getChildren().addAll(btnBack, btnMath, btnRead, btnWrite);

        scene = new Scene(pane, 800, 600);
        stage.setTitle("Educative homescreen");
        stage.setScene(scene);
        stage.show();
    }
    public void goMathScreen(Stage stage){
        MathScreen mathScreen = new MathScreen();
        try {
            mathScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void goReadScreen(Stage stage){
        ReadScreen readScreen = new ReadScreen();
        try {
            readScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void goWriteScreen(Stage stage){
        WriteMainScreen writeMainScreen = new WriteMainScreen();
        try {
            writeMainScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void returnHome(Stage stage){
        Homescreen homescreen = new Homescreen();
        try {
            homescreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
