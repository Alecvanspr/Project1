package sample.MedicalSection;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.inlogScreen.Main;
import sample.MedicalSection.Specialty;

import javax.swing.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public class  MakeAppointment extends Application {
    Scene makeAppointmentScene;
    Main main;
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    LocalDate date;
    String chosenDoctor;

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
        selectDoctor.setVisible(false);
        doctorBox.setVisible(false);

        ComboBox selectTime = new ComboBox();


        DatePicker datePicker = new DatePicker();
        datePicker.setVisible(false);
        datePicker.relocate(250, 260);

        selectSpecialty.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                selectTime.getItems().clear();
                doctorBox.getItems().clear();
                datePicker.getEditor().clear();
                removeItems(doctorBox);
                String selectedSpecialty = specialtyBox.getSelectionModel().getSelectedItem().toString();
                makeDoctorBox(doctorBox,selectedSpecialty, pane, selectDoctor);
                selectDoctor.setVisible(true);
                doctorBox.setVisible(true);
            }
        });
        Button selectDate = new Button("Select date");
        selectDate.relocate(450, 260);
        selectDate.setVisible(false);

        selectDoctor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                datePicker.setVisible(true);
                selectDate.setVisible(true);
                datePicker.getEditor().clear();
                selectTime.getItems().clear();
            }
        });
        Button makeAppointment = new Button("Make Appointment");
        selectTime.relocate(250, 300);
        makeAppointment.relocate(400, 300);
        selectTime.setVisible(false);
        makeAppointment.setVisible(false);

        selectDate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                selectTime.getItems().clear();
                chosenDoctor = doctorBox.getSelectionModel().getSelectedItem().toString();
                date = datePicker.getValue();
                if(checkDate(date)){
                    if(getDoctor(chosenDoctor).checkLocalDate(date)){
                        for(int i = 0; i < getDoctor(chosenDoctor).getDate(date).getTimeTable().size();i++){
                            selectTime.getItems().add(getDoctor(chosenDoctor).getDate(date).getTimeTable().get(i));
                        }
                    }else{
                        Dates appointmentDate = new Dates(date);
                        getDoctor(chosenDoctor).addLocalDate(appointmentDate);
                        for(int i = 0; i < appointmentDate.getTimeTable().size();i++){
                            selectTime.getItems().add(appointmentDate.getTimeTable().get(i));
                        }
                    }
                    selectTime.setVisible(true);
                    makeAppointment.setVisible(true);
                }else{
                    Alert dateNotCorrect = new Alert(Alert.AlertType.ERROR);
                    dateNotCorrect.setTitle("Date not correct!");
                    dateNotCorrect.setHeaderText("Date is not correct. Please select another one!");
                    dateNotCorrect.show();
                }

            }
        });

        makeAppointment.setOnMouseClicked(E -> {
            Alert alertConfirmation = new Alert(Alert.AlertType.CONFIRMATION);
            alertConfirmation.setTitle("Confirm appointment");
            alertConfirmation.setHeaderText("Are you sure you want to make an appointment with " + doctorBox.getValue() + " at " + selectTime.getValue() + " on " + datePicker.getValue() + " for " + specialtyBox.getValue());


            if(selectTime.getValue() != null){
                if(Checks.checkIfTimeAvailable((String) selectTime.getValue())) {
                    Optional<ButtonType> option = alertConfirmation.showAndWait();
                    if (option.get() == ButtonType.OK) {
                        Appointment newAppointment = new Appointment(ArrayKeeper.findDoctor(doctorBox.getSelectionModel().getSelectedItem().toString()), datePicker.getValue(), selectTime.getSelectionModel().getSelectedItem().toString(), ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()), specialtyBox.getSelectionModel().getSelectedItem().toString());
                        ArrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).addAppointment(newAppointment);
                        getDoctor(doctorBox.getSelectionModel().getSelectedItem().toString()).getAppointments().add(newAppointment);

                        getDoctor((String) doctorBox.getValue()).getDate(datePicker.getValue()).removeTimeFromTimeTable((String) selectTime.getValue());
                        MedicalSection medicalSection = new MedicalSection();
                        try {
                            medicalSection.start(stage);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                else{
                    Alert notAvailableAlert = new Alert(Alert.AlertType.ERROR);
                    notAvailableAlert.setTitle("Time not available");
                    notAvailableAlert.setHeaderText("You already have an appointment at this time!");
                    notAvailableAlert.show();
                }
            }
            else{
                Alert timeAlert = new Alert(Alert.AlertType.ERROR);
                timeAlert.setTitle("No time selected!");
                timeAlert.setHeaderText("You must select a time before you can make an appointment!");
                timeAlert.show();
            }
        });

        pane.getChildren().addAll(specialtyBox, selectSpecialty, selectDoctor, doctorBox, datePicker, selectDate,selectTime, makeAppointment);

        makeAppointmentScene = new Scene(pane, 800, 600);
        stage.setTitle("Make appointment");
        stage.setScene(makeAppointmentScene);
        stage.show();

    }

    public void removeItems(ComboBox comboBox){
        comboBox.getItems().clear();
    }

    public void makeSpecialtyBox(ComboBox comboBox){
        for( int i =0; i < arrayKeeper.getSpecialtiesArrayList().size(); i++){
            comboBox.getItems().add(arrayKeeper.getSpecialtiesArrayList().get(i).getName());
        }
        comboBox.relocate(250,160);

    }
    public Doctor getDoctor(String name){
        for(int i = 0; i < arrayKeeper.getDoctorsArrayList().size(); i++){
            if(name.equalsIgnoreCase(arrayKeeper.getDoctorsArrayList().get(i).getName())){
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
                    doctorBox.getItems().add(arrayKeeper.getDoctorsArrayList().get(i).getName());
                }
            }
        }
        doctorBox.relocate(250,210);
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
    public Boolean checkDate(LocalDate date){
        LocalDate today = LocalDate.now();
        if(date.getYear() >= today.getYear() && date.getMonth().getValue() >= today.getMonth().getValue() && date.getDayOfMonth() > today.getDayOfMonth()){
            return true;
        }else{
            return false;
        }
    }
}