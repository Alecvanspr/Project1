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
import sample.Homescreen;
import sample.inlogScreen.Main;

public class MedicalSection extends Application {
    Scene MedicalSection;
    Main main;
    ArrayKeeper arrayKeeper;
    int buttonNumber = 0;

    @Override
    public void start(Stage stage) throws Exception{
        Pane pane = new Pane();
        Label welcome = new Label("Welcome to the medical section");
        welcome.setFont(Font.font("Arial", 30));
        welcome.relocate(225, 100);
        pane.getChildren().add(welcome);

        Button btnBack = new Button("Back");
        btnBack.relocate(10,565);
        btnBack.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(btnBack, 1.2);
            }
        });

        btnBack.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(btnBack, 1.0);
            }
        });

        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Homescreen homescreen = new Homescreen();
                try {
                    homescreen.start(stage);
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        pane.getChildren().add(btnBack);
        //menu Buttons
        Button makeAppointmentbtn = new Button("Make appointment");
        makeMenuButton(makeAppointmentbtn, pane);
        makeAppointmentbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MakeAppointment makeAppointment = new MakeAppointment();
                try {
                    makeAppointment.start(stage);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        Button yourAppointmentbtn = new Button("Your appointments");
        makeMenuButton(yourAppointmentbtn, pane);
        yourAppointmentbtn.setOnMouseClicked(E -> {
            ShowAppointmentsScreen showAppointmentsScreen = new ShowAppointmentsScreen();
            try{
                showAppointmentsScreen.start(stage);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Button contactInformationbtn = new Button("Click here to contact us");
        makeMenuButton(contactInformationbtn, pane);

        MedicalSection = new Scene(pane,800,600);
        stage.setTitle("Medical Section");
        stage.setScene(MedicalSection);
        stage.show();
    }

    public void makeMenuButton(Button button, Pane pane){
        setButtonPosition(button, buttonNumber);
        setButtonLayout(button);
        button.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(button, 1.0);
            }
        });
        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScaleChange(button, 1.2);
            }
        });
        pane.getChildren().add(button);
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
}
