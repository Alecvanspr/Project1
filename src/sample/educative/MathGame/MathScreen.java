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
    Button btnAnswer1 = new Button("");
    Button btnAnswer2 = new Button("");
    Button btnAnswer3 = new Button("");
    Button btnAnswer4 = new Button("");
    Label lblMathProblem = new Label("");
    Label lblWrightAnswerTotal = new Label("0");
    Label lblWrongAnswerTotal = new Label("0");
    Label lblWrightAnswer = new Label("Good Answers");
    Label lblWrongAnswer = new Label("Wrong Answers");
    Button btnNext = new Button("Next");
    Button btnStart = new Button("Start");

    Label lblOperators = new Label("Choose Your Operators");
    Button btnPlus = new Button("+");
    Button btnMinus = new Button("-");
    Button btnDivide = new Button("/");
    Button btnMultiply = new Button("x");



    @Override
    public void start(Stage stage) throws Exception {
        Button btnBack = new Button("back");
        btnBack.relocate(0,575);
        btnBack.setOnAction(E->{
            goEducativeScreen(stage);
        });


        lblOperators.relocate(53,375);

        btnNext.relocate(685, 300);

        lblMathProblem.setFont(Font.font("Arial",50));
        lblMathProblem.relocate(295, 100);


        lblWrongAnswer.setFont(Font.font("Arial",25));
        lblWrongAnswer.relocate(30, 200);


        lblWrongAnswerTotal.setFont(Font.font("Arial",25));
        lblWrongAnswerTotal.relocate(110, 230);


        lblWrightAnswer.setFont(Font.font("Arial",25));
        lblWrightAnswer.relocate(620, 200);


        lblWrightAnswerTotal.setFont(Font.font("Arial",25));
        lblWrightAnswerTotal.relocate(700,230);

        pane.getChildren().addAll(btnBack,btnAnswer1,btnAnswer2,btnAnswer3,btnAnswer4, lblMathProblem,btnStart,lblWrongAnswer,lblWrongAnswerTotal,lblWrightAnswer, lblWrightAnswerTotal,lblOperators,btnPlus,btnMinus,btnDivide,btnMultiply);
        scene = new Scene(pane, 800, 600);
        stage.setTitle("Math screen");
        stage.setScene(scene);
        stage.show();


        btnStart.relocate(95,435);
        btnStart.setOnMouseClicked(e -> {
        newGame();
        });

        btnPlus.relocate(60, 400);
        btnPlus.setOnMouseClicked(e -> {
            mathGame.setPlusBtn(true);
            btnPlus.setStyle("-fx-background-color: #0000ff; ");
        });

        btnMinus.relocate(120, 400);
        btnMinus.setOnMouseClicked(e -> {
            mathGame.setMinusBtn(true);
            btnMinus.setStyle("-fx-background-color: #0000ff; ");
        });

        btnDivide.relocate(150,400);
        btnDivide.setOnMouseClicked(e -> {
            mathGame.setDivideBtn(true);
            btnDivide.setStyle("-fx-background-color: #0000ff; ");
        });

        btnMultiply.relocate(90, 400);
        btnMultiply.setOnMouseClicked(e -> {
            mathGame.setMultiplyBtn(true);
            btnMultiply.setStyle("-fx-background-color: #0000ff; ");
        });

        btnNext.setOnMouseClicked(e -> {
            if(mathGame.getStartBtn()) {
                mathGame.setRandNumb();
                mathGame.RandomOperator();
                lblMathProblem.setText(mathGame.MathQuestion());
                btnAnswer1.setText(Integer.toString(mathGame.ButtonNumber0()));
                btnAnswer2.setText(Integer.toString(mathGame.ButtonNumber1()));
                btnAnswer3.setText(Integer.toString(mathGame.ButtonNumber2()));
                btnAnswer4.setText(Integer.toString(mathGame.ButtonNumber3()));
                btnAnswer1.setStyle(null);
                btnAnswer2.setStyle(null);
                btnAnswer3.setStyle(null);
                btnAnswer4.setStyle(null);
                pane.getChildren().remove(btnNext);
            }
        });

        setButtonLayout(btnAnswer1);
        btnAnswer1.relocate(225,200);
        btnAnswer1.setOnMouseClicked(e -> {
            checkAnswer(btnAnswer1);
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
            checkAnswer(btnAnswer2);
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
            checkAnswer(btnAnswer3);
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
            checkAnswer(btnAnswer4);
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
    public void newGame(){
        if(!mathGame.getStartBtn()) {
            mathGame.setRandNumb();
            mathGame.RandomOperator();
            lblMathProblem.setText(mathGame.MathQuestion());
            btnAnswer1.setText(Integer.toString(mathGame.ButtonNumber0()));
            btnAnswer2.setText(Integer.toString(mathGame.ButtonNumber1()));
            btnAnswer3.setText(Integer.toString(mathGame.ButtonNumber2()));
            btnAnswer4.setText(Integer.toString(mathGame.ButtonNumber3()));
            mathGame.setGame(true);
            pane.getChildren().removeAll(btnStart,btnDivide,btnMinus,btnMultiply,btnPlus,lblOperators);
        }
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
    public void checkAnswer(Button button){
        if(mathGame.getGame()) {
            int buttonInt = Integer.parseInt(button.getText());
            if(mathGame.getAnswer() == buttonInt) {
                System.out.println("True");
                button.setStyle("-fx-background-color: #00ff00; ");
                mathGame.setWrightAnswers();
                lblWrightAnswerTotal.setText(Integer.toString(mathGame.getWrightAnswers()));
                pane.getChildren().add(btnNext);
            }else{
                System.out.println("False");
                button.setStyle("-fx-background-color: #ff0000; ");
                mathGame.setWrongAnswers();
                lblWrongAnswerTotal.setText(Integer.toString(mathGame.getWrongAnswers()));
            }
        }
    }
}
