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
import sample.educative.GetImage;
import sample.educative.writing.WriteMainScreen;

public class WriteNumbersScreen extends Application {
    private int number = 0;
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

        Button btnLastNumber = new Button("Last");
        Button btnNewNumber = new Button("Next");
        Button btnClear = new Button("Clear");
        Button btnBack = new Button("back");
        btnBack.relocate(0,575);
        btnNewNumber.relocate(75,575);
        btnLastNumber.relocate(45,575);

        btnNewNumber.setOnAction(E->{
            clearAndNext();
        });
        btnClear.setOnAction(e->{
            clearDrawing();
        });
        btnBack.setOnAction(E->{
            goBack(stage);
        });
        btnLastNumber.setOnAction(E->{
            number-=2;
            clearAndNext();
        });

        pane.getChildren().addAll(canvas, btnBack, btnClear,btnNewNumber,btnLastNumber);
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
        BackgroundImage displayNumber = new BackgroundImage(new Image(getImage.getNumberImages().get(number)),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        ImageView imageView = new ImageView();
        pane.setBackground(new Background(displayNumber));
        pane.getChildren().add(imageView);
        number++;
        checkNumber();
    }
    public void clearDrawing(){
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
    public void checkNumber(){
        if(number>=10){
            number = 0;
        }else if(number<0){
            number = 9;
        }
    }
    public void clearAndNext(){
        checkNumber();
        makeBackGround();
        clearDrawing();
    }
}