package sample.educative;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.Random;

public class WriteWordsScreen extends Application {
    Label lblAnswer = new Label("");
    Random random = new Random();
    Pane pane = new Pane();
    Scene scene = new Scene(pane, 800, 600);
    GetImage getImage = new GetImage();
    Button CorrectAnswer;
    Button random1 = new Button("");
    Button random2 = new Button("");
    ImageView iv;
    Image image;
    int rng = random.nextInt(getImage.animalImages.size() - 1);


    @Override
    public void start(Stage stage) throws Exception {
        Image enterFieldPng = new Image("images/education/answerField.png");
        ImageView enterField = new ImageView(enterFieldPng);
        enterField.relocate(475,80);
        lblAnswer.relocate(475,50);

        CorrectAnswer = new Button("Dragging");
        CorrectAnswer.setScaleX(2.0);
        CorrectAnswer.setScaleY(2.0);
        random1.setScaleX(2.0);
        random1.setScaleY(2.0);
        random2.setScaleX(2.0);
        random2.setScaleY(2.0);

        makeBackGround();

        Button btnBack = new Button("back");
        Button btnNewPic = new Button("next animal");

        btnBack.relocate(0, 575);
        btnBack.setOnAction(E -> {
            goBack(stage);
        });
        btnNewPic.setOnAction(e->{
            makeBackGround();
        });

        buttonMover(CorrectAnswer);
        buttonMover(random1);
        buttonMover(random2);

        pane.getChildren().addAll(enterField,btnBack, btnNewPic, CorrectAnswer , random1 , random2,lblAnswer);

        stage.setTitle("Write words screen");
        stage.setScene(scene);
        stage.show();
    }

    public void goBack(Stage stage) {
        WriteMainScreen writeMainScreen = new WriteMainScreen();
        try {
            writeMainScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //deze method zorgt voor de verandering van de dieren.
    public void makeBackGround() {
        lblAnswer.setText("");
        pane.getChildren().remove(iv);
        rng = random.nextInt(getImage.animalImages.size() - 1);
        int randomAnswer1 = random.nextInt(getImage.animalImages.size() - 1);
        int randomAnswer2 = random.nextInt(getImage.animalImages.size() - 1);
        CorrectAnswer.setText(getImage.animalImages.get(rng).getName());
        random1.setText(getImage.animalImages.get(randomAnswer1).getName());
        random2.setText(getImage.animalImages.get(randomAnswer2).getName());

        RandomizePositions();

        image = getImage.animalImages.get(rng).getImage();
        iv = new ImageView();
        iv.setImage(image);
        iv.setPreserveRatio(true);
        iv.setFitHeight(300);
        iv.relocate(350,250);
        pane.getChildren().add(iv);
    }

    //deze methode zorgt dat je de knop die je beweegt ziet.
    public void buttonMover(Button button){
        //hieronder begint het
        button.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button.setLayoutX(mouseEvent.getSceneX());
                button.setLayoutY(mouseEvent.getSceneY());
            }
        });

        //deze method zorgt ervoor dat er gekeken wordt of de button in de image zit
        button.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(checkEntered(button.getLayoutX(), button.getLayoutY())){ // deze checkt de coördinaten
                    checkCorrect(button.getText());//deze maakt het label aan, Goed of fout
                }
            }
        });
    }
    //deze method haalt de verschillende senario's te voorschijn.
    // hmmm, hoe vaak zou nummer 1 uigevoerd worden?
    public void RandomizePositions(){
        int place = random.nextInt(100);
        if(place%5==0){
            senario5();
        }else if(place%4==0){
            senario4();
        }else if(place%3==0){
            senario3();
        }else if(place%2==0){
            senario2();
        }else{
            senario1();
        }
    }
    
    //met een paar aanpassingen kan dit in een andere class
    public void checkCorrect(String text){
        if(text.equals(CorrectAnswer.getText())){
            lblAnswer.setText("That is the Correct Animal");
            lblAnswer.setTextFill(Paint.valueOf("green"));
        }else{
            lblAnswer.setText("That is the Wrong Animal");
            lblAnswer.setTextFill(Paint.valueOf("red"));
        }
    }
    //deze kan in een andere class
    public boolean checkEntered(double x,double y){
        boolean ret = false;
        if(x>475&&x<675){
            if(y>80&&y<130){
                ret = true;
            }
        }
        return  ret;
    }

    //deze moeten eigenlijk in een andere class, dit ziet er niet mooi uit.
    public void senario1(){
        CorrectAnswer.relocate(100,100);
        random1.relocate(100,300);
        random2.relocate(100,500);
    }
    public void senario2(){
        CorrectAnswer.relocate(100,300);
        random1.relocate(100,500);
        random2.relocate(100,100);
    }
    public void senario3(){
        CorrectAnswer.relocate(100,500);
        random1.relocate(100,100);
        random2.relocate(100,300);
    }
    public void senario4(){
        CorrectAnswer.relocate(100,100);
        random1.relocate(100,500);
        random2.relocate(100,300);
    }
    public void senario5(){
        CorrectAnswer.relocate(100,300);
        random1.relocate(100,100);
        random2.relocate(100,500);
    }
}
