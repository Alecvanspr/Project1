package sample.MedicalSection;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.inlogScreen.Main;
import sample.MedicalSection.Specialty;

import javax.swing.*;

public class MakeAppointment extends Application {
    Scene makeAppointmentScene;
    Main main;
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    private int labelNumber = 0;
    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();

        //Exit button
        Button exitButton = new Button("Back");
        exitButton.relocate(10, 565);
        exitButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScale(exitButton, 1.0);
            }
        });
        exitButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScale(exitButton, 1.2);
            }
        });
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MedicalSection medicalSection = new MedicalSection();
                try {
                    medicalSection.start(stage);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        pane.getChildren().add(exitButton);
        Label specialtyLabel = new Label("Specialty: ");
        setLabel(specialtyLabel);
        Label doctorLabel = new Label("Doctor: ");
        setLabel(doctorLabel);
        Label dateLabel = new Label("Date: ");
        setLabel(dateLabel);
        Label timeLabel = new Label("Time: ");
        setLabel(timeLabel);
        pane.getChildren().addAll(specialtyLabel, doctorLabel, dateLabel, timeLabel);
        ComboBox specialtyBox = new ComboBox();
        makeSpecialtyBox(specialtyBox);

        Button selectSpecialty = new Button("Select");
        selectSpecialty.relocate(350, 160);

        ComboBox doctorBox = new ComboBox();
        Button selectDoctor = new Button("Select");
        selectDoctor.relocate(350 , 210);

        selectSpecialty.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String selectedSpecialty = specialtyBox.getSelectionModel().getSelectedItem().toString();
                makeDoctorBox(doctorBox,selectedSpecialty, pane,selectDoctor);
            }
        });




        pane.getChildren().addAll(specialtyBox, selectSpecialty);


        makeAppointmentScene = new Scene(pane, 800, 600);
        stage.setTitle("Make appointment");
        stage.setScene(makeAppointmentScene);
        stage.show();

    }
    public void makeSpecialtyBox(ComboBox comboBox){
        for( int i =0; i < arrayKeeper.getSpecialtiesArrayList().size(); i++){
            comboBox.getItems().add(arrayKeeper.getSpecialtiesArrayList().get(i).getName());
        }
        comboBox.relocate(250,160);

    }
    public Doctor getDoctor(String name){
        for(int i = 0; i < arrayKeeper.getDoctorsArrayList().size(); i++){
            if(name.equalsIgnoreCase(arrayKeeper.doctorsArrayList.get(i).getName())){
                return arrayKeeper.getDoctorsArrayList().get(i);
            }
        }
        return arrayKeeper.getDoctorsArrayList().get(0);
    }
    public void makeSpecialtyLabels(Pane pane,Doctor doctor){
        int x= 0;
        for(int i = 0; i < doctor.getSpecialties().size();i++){
            Label label = new Label(doctor.getSpecialties().get(i).getName());
            if(x == 0){
                label.relocate(500, 200);
            }else if(x == 1){
                label.relocate(500, 225);
            }else if(x == 2){
                label.relocate(500, 250);
            }else if(x == 3){
                label.relocate(500, 275);
            }else{
                label.relocate(500, 300);
            }
            pane.getChildren().add(label);
        }
    }
    public void makeDoctorBox(ComboBox doctorBox, String specialty,Pane pane, Button button){
        for(int i = 0; i < arrayKeeper.getDoctorsArrayList().size(); i++){
            for(int j = 0; j < arrayKeeper.getDoctorsArrayList().get(i).getSpecialties().size(); j++){

                if(arrayKeeper.getDoctorsArrayList().get(i).getSpecialties().get(j).getName().equalsIgnoreCase(specialty)){
                    System.out.println("Yes");
                    doctorBox.getItems().add(arrayKeeper.getDoctorsArrayList().get(i).getName());
                }
            }
        }
        doctorBox.relocate(250,210);
        pane.getChildren().addAll(doctorBox, button);

    }

    public void setButtonScale(Button button, Double scale){
        button.setScaleY(scale);
        button.setScaleX(scale);
    }
    public void setLabel(Label label){
        label.setFont(Font.font("Arial", 30));
        setLabelLocation(label);
    }
    public void setLabelLocation(Label label){
        if(this.labelNumber == 0){
            label.relocate(100, 150);
        }else if(this.labelNumber == 1) {
            label.relocate(100, 200);
        }else if(this.labelNumber == 2){
            label.relocate(100, 250);
        }else {
            label.relocate(100, 300);
        }
        labelNumber++;

    }


}
