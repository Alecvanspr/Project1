package sample.educative;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ButtonSettings;
import sample.GoToScreens;
import sample.Homescreen;
import sample.educative.read.ReadScreen;
import sample.educative.writing.WriteMainScreen;

public class EducativeHomeScreen extends Application {
    ButtonSettings buttonSettings =ButtonSettings.getInstance();
    Pane pane = new Pane();
    GoToScreens goToScreens = GoToScreens.getInstance();
    Scene scene;
    GetImage getImage = new GetImage();
    Button btnBack = new Button("Back");
    Button btnMath = new Button("math");
    Button btnRead = new Button("read");
    Button btnWrite = new Button("write");

    @Override
    public void start(Stage stage) throws Exception {
        makeButtons(stage);
        pane.getChildren().addAll(btnBack, btnMath, btnRead, btnWrite);
        fin(stage);
    }
    public void makeButtons(Stage stage){
        makeBtnBack(stage);
        makeBtnMath(stage);
        makeBtnRead(stage);
        makeBtnWrite(stage);
    }

    public void makeBtnBack(Stage stage){
        btnBack.relocate(0,575);
        buttonSettings.onMouse(btnBack);
        btnBack.setOnAction(e -> {
            goToScreens.goHomeScreen(stage);
        });
    }
    public void makeBtnRead(Stage stage){
        btnRead.relocate(100,200);
        buttonSettings.onMouse(btnRead);
        btnRead.setOnAction(E->{
            goToScreens.goReadScreen(stage);
        });
    }
    public void makeBtnWrite(Stage stage){
        btnWrite.relocate(200,100);
        buttonSettings.onMouse(btnWrite);
        btnWrite.setOnAction(E->{
            goToScreens.goWriteScreen(stage);
        });
    }
    public void makeBtnMath(Stage stage){
        btnMath.relocate(100,100);
        buttonSettings.onMouse(btnMath);
        btnMath.setOnAction(E->{
            goToScreens.goMathGame(stage);
        });
    }
    public void fin(Stage stage){
        scene = new Scene(pane, 800, 600);
        stage.setTitle("Educative homescreen");
        stage.setScene(scene);
        stage.show();
    }

}