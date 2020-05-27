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


    @Override
    public void start(Stage stage) throws Exception {
        Button btnBack = new Button("back");
        btnBack.relocate(0,575);
        btnBack.setOnAction(E->{
            goEducativeScreen(stage);
        });

        Button btnAnswer1 = new Button(Integer.toString(MathGame.ButtonNumber0()));
        Button btnAnswer2 = new Button(Integer.toString(MathGame.ButtonNumber1()));
        Button btnAnswer3 = new Button(Integer.toString(MathGame.ButtonNumber2()));
        Button btnAnswer4 = new Button(Integer.toString(MathGame.ButtonNumber3()));

        Label lblMathProblem = new Label("test");
        lblMathProblem.setFont(Font.font("Arial",50));
        lblMathProblem.relocate(295, 100);
        lblMathProblem.setText(MathGame.MathQuestion());

        pane.getChildren().addAll(btnBack,btnAnswer1,btnAnswer2,btnAnswer3,btnAnswer4, lblMathProblem);
        scene = new Scene(pane, 800, 600);
        stage.setTitle("Math screen");
        stage.setScene(scene);
        stage.show();



        setButtonLayout(btnAnswer1);
        btnAnswer1.relocate(225,200);
        btnAnswer1.setOnMouseClicked(e -> {
            MathGame.NextNumber();
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

        //Contact button
        setButtonLayout(btnAnswer2 );
        btnAnswer2 .relocate(450,200);
        btnAnswer2 .setOnAction(e -> {
            MathGame.NextNumber();
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

        //Market button
        setButtonLayout(btnAnswer3);
        btnAnswer3.relocate(225,400);
        btnAnswer3.setOnAction(e ->{
            MathGame.NextNumber();
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

        //Livestoch button
        setButtonLayout(btnAnswer4);
        btnAnswer4.relocate(450,400);
        btnAnswer4.setOnAction(e -> {
            MathGame.NextNumber();
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
