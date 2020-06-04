package sample.educative;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.GoToScreens;
import sample.Homescreen;
import sample.educative.read.ReadScreen;
import sample.educative.writing.WriteMainScreen;

public class EducativeHomeScreen extends Application {
    Pane pane = new Pane();
    GoToScreens goToScreens = new GoToScreens();
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
            goToScreens.goEducativeScreen(stage);
        });
        btnMath.setOnAction(E->{
            goToScreens.goMathScreen(stage);
        });
        btnRead.setOnAction(E->{
            goToScreens.goReadScreen(stage);
        });
        btnWrite.setOnAction(E->{
            goToScreens.goWriteScreen(stage);
        });

        pane.getChildren().addAll(btnBack, btnMath, btnRead, btnWrite);

        scene = new Scene(pane, 800, 600);
        stage.setTitle("Educative homescreen");
        stage.setScene(scene);
        stage.show();
    }

}
