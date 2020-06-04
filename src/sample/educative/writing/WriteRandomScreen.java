package sample.educative.writing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.GoToScreens;
import sample.educative.GetImage;
import sample.educative.GoToEducative;
import sample.educative.writing.WriteMainScreen;

import java.util.Random;

public class WriteRandomScreen extends Application {
    GoToScreens goToScreens = new GoToScreens();
    GoToEducative goToEducative = new GoToEducative();
    Pane pane = new Pane();
    Scene scene = new Scene(pane, 800, 600);
    GetImage getImage = new GetImage();
    Canvas canvas = new Canvas(800,600);
    GraphicsContext gc;

    @Override
    public void start(Stage stage) throws Exception {
        Button btnClear = new Button("Clear");
        Button btnNewLetter = new Button("Next");

        btnClear.relocate(0,0);
        btnNewLetter.relocate(75,575);
        btnNewLetter.setOnAction(E->{
            makeBackGround();
            clearDrawing();
        });
        btnClear.setOnAction(e->{
            clearDrawing();
        });

        drawing();
        makeBackGround();

        Button btnBack = new Button("back");
        btnBack.relocate(0,575);

        btnBack.setOnAction(E->{
            goback(stage);
        });

        pane.getChildren().addAll(canvas,btnBack,btnNewLetter, btnClear);
        stage.setTitle("Write Screen");
        stage.setScene(scene);
        stage.show();
    }
    public void goback(Stage stage){
       goToScreens.goWriteScreen(stage);
    }
    public void drawing(){
        gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(12);

        scene.setOnMousePressed(e->{
            gc.beginPath();
            gc.lineTo(e.getSceneX(), e.getSceneY());
            gc.stroke();
        });

        scene.setOnMouseDragged(e ->{
            gc.lineTo(e.getSceneX(), e.getSceneY());
            gc.stroke();
        });
    }
    public void makeBackGround(){
        Random random = new Random();
        int getRandomLetter = random.nextInt(getImage.getLetterImages().size()-1);
        BackgroundImage displayLetter = new BackgroundImage(new Image(getImage.getLetterImages().get(getRandomLetter)),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        ImageView imageView = new ImageView();
        pane.setBackground(new Background(displayLetter));
        pane.getChildren().add(imageView);
    }
    public void clearDrawing(){
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

}