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
import javafx.stage.Stage;

import java.util.Random;

public class WriteNumbersScreen extends Application {
    Pane pane = new Pane();
    Scene scene = new Scene(pane, 800, 600);
    GetImage getImage = new GetImage();
    Canvas canvas = new Canvas(800,600);
    GraphicsContext gc;
    Image aaa;

    @Override
    public void start(Stage stage) throws Exception {

        drawing();
        makeBackGround();

        Button btnNewNumber = new Button("Next");
        Button btnClear = new Button("Clear");
        Button btnBack = new Button("back");
        btnBack.relocate(0,575);
        btnNewNumber.relocate(75,575);

        btnNewNumber.setOnAction(E->{
            makeBackGround();
            clearDrawing();
        });
        btnClear.setOnAction(e->{
            clearDrawing();
        });
        btnBack.setOnAction(E->{
            goBack(stage);
        });

        pane.getChildren().addAll(canvas, btnBack, btnClear,btnNewNumber);
        stage.setTitle("Write numbers screen");
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
        int getRandomNumber = random.nextInt(getImage.numberImages.size()-1);
        BackgroundImage displayNumber = new BackgroundImage(new Image(getImage.numberImages.get(getRandomNumber)),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        ImageView imageView = new ImageView();
        pane.setBackground(new Background(displayNumber));
        pane.getChildren().add(imageView);
    }
    public void clearDrawing(){
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

}