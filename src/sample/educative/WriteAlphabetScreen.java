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
    BackgroundImage backgroundImage;
    Image image;
    ImageView imageView;
    private int letter = 0;
    Pane pane = new Pane();
    Scene scene = new Scene(pane, 800, 600);
    GetImage getImage = new GetImage();
    Canvas canvas = new Canvas(800,600);
    GraphicsContext gc;

    @Override
    public void start(Stage stage) throws Exception {
        Image backgroundLines = new Image("images/education/DrawLinesLetter.png");
        backgroundImage = new BackgroundImage(backgroundLines,BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Button btnNextLetter = new Button("Next letter");
        Button btnLastLetter = new Button("Last letter");
        Button btnClear = new Button("Clear");
        Button btnCapital = new Button("Capital");
        Button btnLowerCase = new Button("Lower Case");
        btnCapital.relocate(150 ,575);
        btnLowerCase.relocate(150,575);
        btnNextLetter.relocate(75,575);
        btnClear.relocate(775,575);
        btnLastLetter.setOnAction(E->{
            letter= letter-2;
            checkCounter();
            makeBackGround();
            clearDrawing();
        });

        btnNextLetter.setOnAction(E->{
            letter=letter+2;
            checkCounter();
            makeBackGround();
            clearDrawing();
        });
        btnLowerCase.setOnAction(E->{
            letter++;
            checkCounter();
            makeBackGround();
            clearDrawing();
            pane.getChildren().add(btnCapital);
            pane.getChildren().remove(btnLowerCase);
        });
        btnCapital.setOnAction(E->{
            letter--;
            checkCounter();
            makeBackGround();
            clearDrawing();
            pane.getChildren().add(btnLowerCase);
            pane.getChildren().remove(btnCapital);
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

        pane.getChildren().addAll(canvas,btnNextLetter,btnClear,btnLastLetter,btnLowerCase,btnBack);
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
        pane.getChildren().remove(imageView);
        clearDrawing();
        image = new Image(getImage.getLetterImage(letter));
        imageView = new ImageView(image);
        pane.setBackground(new Background(backgroundImage));
        pane.getChildren().addAll(imageView);
    }
    public void checkCounter(){
        if(letter>getImage.letterImages.size()){
            System.out.println(getImage.letterImages.size());
            letter=0;
        }
    }
}