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

public class WriteAlphabetScreen extends Application {
    GoToScreens goToScreens = GoToScreens.getInstance();
    Image backgroundLines = new Image("images/education/DrawLinesLetter.png");
    BackgroundImage backgroundImage = new BackgroundImage(backgroundLines,BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
            BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    Image image;
    ImageView imageView;
    private int letter = 0;
    Pane pane = new Pane();
    Scene scene = new Scene(pane, 800, 600);
    GetImage getImage = new GetImage();
    Canvas canvas = new Canvas(800,600);
    GraphicsContext gc;
    Button btnNextLetter = new Button("Next letter");
    Button btnLastLetter = new Button("Last letter");
    Button btnClear = new Button("Clear");
    Button btnCapital = new Button("Capital");
    Button btnLowerCase = new Button("Lower Case");
    Button btnBack = new Button("back");

    @Override
    public void start(Stage stage) throws Exception {
        makeBtnNextLetter();
        makeBtnLastLetter();
        makeBtnClear();
        makeBtnCapital();
        makeBtnLowerCase();
        makeBtnBack(stage);

        drawing();
        makeBackGround();

        pane.getChildren().addAll(canvas,btnNextLetter,btnClear,btnLastLetter,btnLowerCase,btnBack);

        fin(stage);
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
        if(letter>getImage.getLetterImages().size()){
            letter=0;
        }
    }
    public void clearAndNext(){
        checkCounter();
        makeBackGround();
        clearDrawing();
    }
    public void makeBtnNextLetter(){
        btnNextLetter.relocate(75,575);
        btnNextLetter.setOnAction(E->{
            letter=letter+2;
            clearAndNext();
        });
    }
    public void makeBtnLastLetter(){
        btnLastLetter.setOnAction(E->{
            letter= letter-2;
            clearAndNext();
        });
    }
    public void makeBtnClear(){
        btnClear.relocate(775,575);
        btnClear.setOnAction(E->{
            clearDrawing();
        });
    }
    public void makeBtnCapital(){
        btnCapital.relocate(150 ,575);
        btnCapital.setOnAction(E->{
            letter--;
            pane.getChildren().add(btnLowerCase);
            pane.getChildren().remove(btnCapital);
            clearAndNext();
        });
    }
    public void makeBtnLowerCase(){
        btnLowerCase.relocate(150,575);
        btnLowerCase.setOnAction(E->{
            letter++;
            clearAndNext();
            pane.getChildren().add(btnCapital);
            pane.getChildren().remove(btnLowerCase);
        });
    }
    public void makeBtnBack(Stage stage){
        btnBack.relocate(0,575);
        btnBack.setOnAction(E->{
            goToScreens.goWriteScreen(stage);
        });
    }
    public void fin(Stage stage){
        stage.setTitle("Write Screen");
        stage.setScene(scene);
        stage.show();
    }
}