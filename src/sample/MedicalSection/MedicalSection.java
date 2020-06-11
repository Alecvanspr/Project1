package sample.MedicalSection;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.ButtonSettings;
import sample.GoToScreens;
import sample.inlogScreen.Main;

public class MedicalSection extends Application {
    Scene MedicalSection;
    Main main;
    ArrayKeeper arrayKeeper;
    FutureAppointments futureAppointments;
    int buttonNumber = 0;
    Pane pane = new Pane();
    GoToScreens goToScreens = new GoToScreens();
    ButtonSettings buttonSettings = new ButtonSettings();
    Label welcome = new Label("Welcome to the medical section");
    Label myAppointments = new Label("My Appointments");
    TextArea taAppointment = new TextArea();
    ListView<String> ListView = new ListView<>();
    ObservableList<String> medicalSectionAppointments = FXCollections.observableArrayList();
    Button btnBack = new Button("Back");
    Button makeAppointmentbtn = new Button("Make appointment");
    Button yourAppointmentbtn = new Button("Your appointments");

    @Override
    public void start(Stage stage) throws Exception{
        makeButtons(stage);
        makeLabels();
        makeListView();
        pane.getChildren().addAll(welcome, btnBack, makeAppointmentbtn, yourAppointmentbtn, myAppointments,ListView);
        fin(stage);

    }

    public void Listener(){
        medicalSectionAppointments.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println("List Invalidated");
            }
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
    public void makeListView(){
        makeAppointmentListView();
    }
    public void makeAppointmentListView(){
        ListView.relocate(425, 240);
        ListView.setPrefHeight(310);
        ListView.setPrefWidth(255);
        ListView.setItems(medicalSectionAppointments);
    }
    public void makeLabels(){
        makeStartLabel();
        makeAppointmentLabel();
    }
    public void makeStartLabel(){
        welcome.setFont(Font.font("Arial", 30));
        welcome.relocate(225, 100);
    }
    public void makeAppointmentLabel(){
        myAppointments.setFont(Font.font("Arial", 20));
        myAppointments.relocate(475, 200);
        myAppointments.setStyle("-fx-underline: true");
    }
    public void makeMenuButton(Button button){
        setButtonPosition(button, buttonNumber);
        setButtonLayout(button);
    }

    public void setButtonScaleChange(Button button, Double scale){
        button.setScaleX(scale);
        button.setScaleY(scale);
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
}
