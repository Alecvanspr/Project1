package sample.MedicalSection;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.ButtonSettings;
import sample.GoToScreens;
import sample.Homescreen;
import sample.inlogScreen.Main;

public class MedicalSection extends Application {
    Scene MedicalSection;
    Main main;
    ArrayKeeper arrayKeeper;
    int buttonNumber = 0;
    Pane pane = new Pane();
    GoToScreens goToScreens = new GoToScreens();
    ButtonSettings buttonSettings = new ButtonSettings();
    Label welcome = new Label("Welcome to the medical section");
    Button btnBack = new Button("Back");
    Button makeAppointmentbtn = new Button("Make appointment");
    Button yourAppointmentbtn = new Button("Your appointments");
    Button pastAppointmentsbtn = new Button("Your past appointments");
    Button viewPatients = new Button("View your patients");

    @Override
    public void start(Stage stage) throws Exception{
        makeButtons(stage);
        makeLabels();

        pane.getChildren().addAll(welcome, btnBack, makeAppointmentbtn, yourAppointmentbtn, contactInformationbtn);
        fin(stage);

    }
    public void makePastAppointmentsButton(Stage stage){
        makeMenuButton(pastAppointmentsbtn);
        pastAppointmentsbtn.setOnAction(E-> {
            goToScreens.goShowPastAppointments(stage);
        });
    }
    public void makeYourAppointmentButton(Stage stage){
        makeMenuButton(yourAppointmentbtn);
        yourAppointmentbtn.setOnMouseClicked(E -> {
            goToScreens.goAppointmentsScreen(stage);
        });
    }
    public void makeButtons(Stage stage){
        makeBackButton(stage);
        makeAppointmentButton(stage);
        makeYourAppointmentButton(stage);
        makePastAppointmentsButton(stage);
    }
    public void makeBackButton(Stage stage){
        btnBack.relocate(10,565);
        buttonSettings.onMouse(btnBack);
        btnBack.setOnAction(E->{
            goToScreens.goHomeScreen(stage);
        });
    }
    public void makeAppointmentButton(Stage stage){
        makeMenuButton(makeAppointmentbtn);
        makeAppointmentbtn.setOnAction(E-> {
            goToScreens.goMakeAppointment(stage);
        });
    }

    public void makeLabels(){
        makeStartLabel();
    }
    public void makeStartLabel(){
        welcome.setFont(Font.font("Arial", 30));
        welcome.relocate(225, 100);
    }
    public void makeMenuButton(Button button){
        setButtonPosition(button, buttonNumber);
        setButtonLayout(button);
    }

    public void setButtonScaleChange(Button button, Double scale){
        button.setOnMouseEntered(E -> {
            button.setScaleX(scale);
            button.setScaleY(scale);
        });
        button.setOnMouseExited(E -> {
            button.setScaleX(1);
            button.setScaleY(1);
        });
    }

    public void setButtonLayout(Button button){
        button.setPrefWidth(150);
        button.setPrefHeight(150);
    }

    public void setButtonPosition(Button button, int buttonNumber){
        if(buttonNumber == 0){
            button.relocate(225, 200);
        }
        else if(buttonNumber == 1){
            button.relocate(225, 400);
        }
        else if(buttonNumber == 2){
            button.relocate(450, 200);
        }
        else{
            button.relocate(450, 400);
        }
        buttonNumber();
    }

    public void buttonNumber(){
        buttonNumber++;
    }
    public void fin(Stage stage){
        MedicalSection = new Scene(pane,800,600);
        stage.setTitle("Medical Section");
        stage.setScene(MedicalSection);
        stage.show();
    }

    public void setViewPatientsVisible(){
        if(ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()) instanceof Doctor){
            viewPatients.setVisible(true);
        }
    }
}
