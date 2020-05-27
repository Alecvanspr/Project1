package sample.educative;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.Random;

public class WriteAlphabetScreen extends Application {
    private int letter = 0;
    Pane pane = new Pane();
    Scene scene = new Scene(pane, 800, 600);
    GetImage getImage = new GetImage();
    Canvas canvas = new Canvas(800,600);
    GraphicsContext gc;

    @Override
    public void start(Stage stage) throws Exception {
        Button btnNextLetter = new Button("Next letter");
        Button btnClear = new Button("Clear");
        btnNextLetter.relocate(75,575);
        btnNextLetter.setOnAction(E->{
            letter++;
            checkCounter(letter);
            makeBackGround();
        });

        btnClear.setOnAction(E->{
            clearDrawing();
        });

        drawing();
        makeBackGround();


        Button btnBack = new Button("back");
        btnBack.relocate(0,575);

        btnBack.setOnAction(E->{
            goBack(stage);
        });

        pane.getChildren().addAll(canvas,btnNextLetter,btnClear,btnBack);
        stage.setTitle("Write Screen");
        stage.setScene(scene);
        stage.show();
    }
    public void goBack(Stage stage){
        WriteMainScreen writeMainScreen = new WriteMainScreen();
        try {
            writeMainScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void drawing(){
        gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
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
    public void clearDrawing(){
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
    public void makeBackGround(){
        clearDrawing();
        BackgroundImage displayLetter = new BackgroundImage(new Image(getImage.letterImages.get(letter)),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        ImageView imageView = new ImageView();
        pane.setBackground(new Background(displayLetter));
        pane.getChildren().addAll(imageView);
    }
    public void checkCounter(int counter){
        if(counter>=getImage.letterImages.size()){
            counter=0;
        }
    }
}