package sample.educative.MathGame;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.educative.EducativeHomeScreen;

import java.util.Random;

public class MathScreen  extends Application {
    Pane pane = new Pane();
    Scene scene;
    MathGame mathGame = new MathGame();

    @Override
    public void start(Stage stage) throws Exception {
        Button btnBack = new Button("back");
        btnBack.relocate(0,575);
        btnBack.setOnAction(E->{
            goEducativeScreen(stage);
        });

        Button btnStart = new Button("Start");
        Button btnAnswer1 = new Button("");
        Button btnAnswer2 = new Button("");
        Button btnAnswer3 = new Button("");
        Button btnAnswer4 = new Button("");


        Label lblMathProblem = new Label("");
        lblMathProblem.setFont(Font.font("Arial",50));
        lblMathProblem.relocate(295, 100);

        Label lblWrongAnswer = new Label("Wrong Aswers");
        lblWrongAnswer.setFont(Font.font("Arial",25));
        lblWrongAnswer.relocate(30, 200);

        Label lblWrongAnswerTotal = new Label("0");
        lblWrongAnswerTotal.setFont(Font.font("Arial",25));
        lblWrongAnswerTotal.relocate(110, 230);

        pane.getChildren().addAll(btnBack,btnAnswer1,btnAnswer2,btnAnswer3,btnAnswer4, lblMathProblem,btnStart,lblWrongAnswer,lblWrongAnswerTotal);
        scene = new Scene(pane, 800, 600);
        stage.setTitle("Math screen");
        stage.setScene(scene);
        stage.show();


        btnStart.relocate(390,575);
        btnStart.setOnMouseClicked(e -> {
            if(!mathGame.getStartBtn()) {
                lblMathProblem.setText(mathGame.MathQuestion());
                btnAnswer1.setText(Integer.toString(mathGame.ButtonNumber0()));
                btnAnswer2.setText(Integer.toString(mathGame.ButtonNumber1()));
                btnAnswer3.setText(Integer.toString(mathGame.ButtonNumber2()));
                btnAnswer4.setText(Integer.toString(mathGame.ButtonNumber3()));
                mathGame.setRandNumb();
                mathGame.setGame(true);
            }
        });

        setButtonLayout(btnAnswer1);
        btnAnswer1.relocate(225,200);
        btnAnswer1.setOnMouseClicked(e -> {
            if(mathGame.getGame()) {
                lblMathProblem.setText(mathGame.MathQuestion());
                btnAnswer1.setText(Integer.toString(mathGame.ButtonNumber0()));
                btnAnswer2.setText(Integer.toString(mathGame.ButtonNumber1()));
                btnAnswer3.setText(Integer.toString(mathGame.ButtonNumber2()));
                btnAnswer4.setText(Integer.toString(mathGame.ButtonNumber3()));
                mathGame.setRandNumb();
            }
        });
        btnAnswer1.setOnMousePressed(e -> {
            if(mathGame.getAnswer() == mathGame.ButtonNumber1()) {
                btnAnswer1.setStyle("-fx-background-color: #00ff00; ");
                lblWrongAnswerTotal.setText(Integer.toString(mathGame.getWrongAnswers()));

            }else{
                btnAnswer1.setStyle("-fx-background-color: #ff0000; ");
                lblWrongAnswerTotal.setText(Integer.toString(mathGame.getWrongAnswers()));
            }
        });

        btnAnswer1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(btnAnswer1, 1.0);
            }
        });
        btnAnswer1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(btnAnswer1, 1.2);
            }
        });

        setButtonLayout(btnAnswer2 );
        btnAnswer2 .relocate(450,200);
        btnAnswer2 .setOnAction(e -> {
            if(mathGame.getGame()) {
                lblMathProblem.setText(mathGame.MathQuestion());
                btnAnswer1.setText(Integer.toString(mathGame.ButtonNumber0()));
                btnAnswer2.setText(Integer.toString(mathGame.ButtonNumber1()));
                btnAnswer3.setText(Integer.toString(mathGame.ButtonNumber2()));
                btnAnswer4.setText(Integer.toString(mathGame.ButtonNumber3()));
                mathGame.setRandNumb();
            }
        });

        btnAnswer2 .setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(btnAnswer2 , 1.2);
            }
        });
        btnAnswer2 .setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(btnAnswer2 , 1.0);
            }
        });

        setButtonLayout(btnAnswer3);
        btnAnswer3.relocate(225,400);
        btnAnswer3.setOnAction(e ->{
            if(mathGame.getGame()) {
                lblMathProblem.setText(mathGame.MathQuestion());
                btnAnswer1.setText(Integer.toString(mathGame.ButtonNumber0()));
                btnAnswer2.setText(Integer.toString(mathGame.ButtonNumber1()));
                btnAnswer3.setText(Integer.toString(mathGame.ButtonNumber2()));
                btnAnswer4.setText(Integer.toString(mathGame.ButtonNumber3()));
                mathGame.setRandNumb();
            }
        });
        btnAnswer3.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(btnAnswer3, 1.0);
            }
        });
        btnAnswer3.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(btnAnswer3, 1.2);
            }
        });

        setButtonLayout(btnAnswer4);
        btnAnswer4.relocate(450,400);
        btnAnswer4.setOnAction(e -> {
            if(mathGame.getGame()) {
                lblMathProblem.setText(mathGame.MathQuestion());
                btnAnswer1.setText(Integer.toString(mathGame.ButtonNumber0()));
                btnAnswer2.setText(Integer.toString(mathGame.ButtonNumber1()));
                btnAnswer3.setText(Integer.toString(mathGame.ButtonNumber2()));
                btnAnswer4.setText(Integer.toString(mathGame.ButtonNumber3()));
                mathGame.setRandNumb();
            }
        });
        btnAnswer4.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(btnAnswer4, 1.2);
            }
        });
        btnAnswer4.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(btnAnswer4, 1.0);
            }
        });


    }
    public void setButtonLayout(Button button){
        button.setPrefHeight(150);
        button.setPrefWidth(150);
    }
    public void setButtonScaleChange(Button button, Double scale){
        button.setScaleY(scale);
        button.setScaleX(scale);
    }

    public void goEducativeScreen(Stage stage){
        EducativeHomeScreen educativeHomeScreen = new EducativeHomeScreen();
        try {
            educativeHomeScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
