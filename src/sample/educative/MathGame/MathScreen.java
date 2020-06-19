package sample.educative.MathGame;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
<<<<<<< HEAD
=======
import javafx.scene.control.TextField;
>>>>>>> medical section + mathgame + Homescreenbuttons fix
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
<<<<<<< HEAD
=======
    Random random = new Random();
>>>>>>> medical section + mathgame + Homescreenbuttons fix
    MathGame mathGame = new MathGame();
    Button btnAnswer1 = new Button("");
    Button btnAnswer2 = new Button("");
    Button btnAnswer3 = new Button("");
    Button btnAnswer4 = new Button("");
<<<<<<< HEAD
=======
    Button btnBack = new Button("back");
    Button btnNext = new Button("Next");
    Button btnStart = new Button("Start");
    Button btnRandom = new Button("Random");
    Button btnPlus = new Button("+");
    Button btnMinus = new Button("-");
    Button btnDivide = new Button("/");
    Button btnMultiply = new Button("x");
>>>>>>> medical section + mathgame + Homescreenbuttons fix
    Label lblMathProblem = new Label("");
    Label lblWrightAnswerTotal = new Label("0");
    Label lblWrongAnswerTotal = new Label("0");
    Label lblWrightAnswer = new Label("Good Answers");
    Label lblWrongAnswer = new Label("Wrong Answers");
<<<<<<< HEAD
    Button btnNext = new Button("Next");
    Button btnStart = new Button("Start");

    @Override
    public void start(Stage stage) throws Exception {
        Button btnBack = new Button("back");
=======
    Label lblOperators = new Label("Choose Your Operators");
    TextField tfBound1 = new TextField("Set Number");
    int textfieldbound;

    @Override
    public void start(Stage stage) throws Exception {
        makeButtons(stage);
        makeLabels();
        makeTextField();
        makeError();
        fin(stage);

        pane.getChildren().addAll(tfBound1,btnRandom,btnBack,btnAnswer1,btnAnswer2,btnAnswer3,btnAnswer4, lblMathProblem,btnStart,lblWrongAnswer,lblWrongAnswerTotal,lblWrightAnswer, lblWrightAnswerTotal,lblOperators,btnPlus,btnMinus,btnDivide,btnMultiply);
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
            mathGame.setNumberBound(textfieldbound);
            mathGame.setGame(true);
            pane.getChildren().removeAll(tfBound1,btnStart,btnDivide,btnMinus,btnMultiply,btnPlus,lblOperators,btnRandom);
        }
    }
    public void makeTextField(){
        makeTextFieldBound();
    }
    public void makeTextFieldBound(){
        tfBound1.relocate(40, 435);
    }
    public void makeButtons(Stage stage){
        makeButtonAnswer1();
        makeButtonAnswer2();
        makeButtonAnswer3();
        makeButtonAnswer4();
        makeButtonBack(stage);
        makeButtonNext();
        makeButtonPlus();
        makeButtonMinus();
        makeButtonMultiply();
        makeButtonDivide();
        makeButtonStart();
        makeButtonRandom();
    }
    public void makeButtonBack(Stage stage){
>>>>>>> medical section + mathgame + Homescreenbuttons fix
        btnBack.relocate(0,575);
        btnBack.setOnAction(E->{
            goEducativeScreen(stage);
        });
<<<<<<< HEAD


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

        pane.getChildren().addAll(btnBack,btnAnswer1,btnAnswer2,btnAnswer3,btnAnswer4, lblMathProblem,btnStart,lblWrongAnswer,lblWrongAnswerTotal,lblWrightAnswer, lblWrightAnswerTotal);
        scene = new Scene(pane, 800, 600);
        stage.setTitle("Math screen");
        stage.setScene(scene);
        stage.show();


        btnStart.relocate(390,575);
        btnStart.setOnMouseClicked(e -> {
        newGame();
        });

        btnNext.setOnMouseClicked(e -> {
            if(mathGame.getStartBtn()) {
                mathGame.setRandNumb();
=======
    }
    public void makeButtonStart(){
        btnStart.relocate(95,470);
        btnStart.setOnMouseClicked(e -> {
            //textfieldbound = Integer.parseInt(tfBound1.getText());
            newGame();
        });
    }
    public void makeError(){
        try{
            //textfieldbound = Integer.parseInt(tfBound1.getText());
        }catch(java.lang.NoSuchFieldError ex){
            System.out.println("error");
        }
    }
    public void makeButtonPlus(){
        btnPlus.relocate(30, 400);
        btnPlus.setOnMouseClicked(e -> {
            mathGame.setRandOperator(0);
            btnPlus.setStyle("-fx-background-color: #0000ff; ");
        });
    }
    public void makeButtonMinus(){
        btnMinus.relocate(90, 400);
        btnMinus.setOnMouseClicked(e -> {
            mathGame.setRandOperator(1);
            btnMinus.setStyle("-fx-background-color: #0000ff; ");
        });
    }
    public void makeButtonMultiply(){
        btnMultiply.relocate(60, 400);
        btnMultiply.setOnMouseClicked(e -> {
            mathGame.setRandOperator(3);
            btnMultiply.setStyle("-fx-background-color: #0000ff; ");
        });
    }
    public void makeButtonDivide(){
        btnDivide.relocate(120,400);
        btnDivide.setOnMouseClicked(e -> {
            mathGame.setRandOperator(2);
            btnDivide.setStyle("-fx-background-color: #0000ff; ");
        });
    }
    public void makeButtonRandom(){
        btnRandom.relocate(150,400);
        btnRandom.setOnMouseClicked(e -> {
            mathGame.setRandOperator(random.nextInt(4));
            btnRandom.setStyle("-fx-background-color: #0000ff; ");
        });
    }
    public void makeButtonNext(){
        btnNext.setOnMouseClicked(e -> {
            if(mathGame.getStartBtn()) {
                mathGame.setRandNumb();
                mathGame.RandomOperator();
>>>>>>> medical section + mathgame + Homescreenbuttons fix
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
<<<<<<< HEAD

=======
    }
    public void makeButtonAnswer1(){
>>>>>>> medical section + mathgame + Homescreenbuttons fix
        setButtonLayout(btnAnswer1);
        btnAnswer1.relocate(225,200);
        btnAnswer1.setOnMouseClicked(e -> {
            checkAnswer(btnAnswer1);
        });
<<<<<<< HEAD

=======
>>>>>>> medical section + mathgame + Homescreenbuttons fix
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
<<<<<<< HEAD

=======
    }
    public void makeButtonAnswer2(){
>>>>>>> medical section + mathgame + Homescreenbuttons fix
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
<<<<<<< HEAD

=======
    }
    public void makeButtonAnswer3(){
>>>>>>> medical section + mathgame + Homescreenbuttons fix
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
<<<<<<< HEAD

=======
    }
    public void makeButtonAnswer4(){
>>>>>>> medical section + mathgame + Homescreenbuttons fix
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
<<<<<<< HEAD
    public void newGame(){
        if(!mathGame.getStartBtn()) {
            mathGame.setRandNumb();
            lblMathProblem.setText(mathGame.MathQuestion());
            btnAnswer1.setText(Integer.toString(mathGame.ButtonNumber0()));
            btnAnswer2.setText(Integer.toString(mathGame.ButtonNumber1()));
            btnAnswer3.setText(Integer.toString(mathGame.ButtonNumber2()));
            btnAnswer4.setText(Integer.toString(mathGame.ButtonNumber3()));
            mathGame.setGame(true);
            pane.getChildren().remove(btnStart);
        }
    }

=======
    public void makeLabels(){
        makeLabelAll();
    }
    public void makeLabelAll(){
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
    }
>>>>>>> medical section + mathgame + Homescreenbuttons fix
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
<<<<<<< HEAD
}
=======
    public void fin(Stage stage){
        scene = new Scene(pane, 800, 600);
        stage.setTitle("Math screen");
        stage.setScene(scene);
        stage.show();
    }
}
>>>>>>> medical section + mathgame + Homescreenbuttons fix
