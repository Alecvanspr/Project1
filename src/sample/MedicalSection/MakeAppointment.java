package sample.MedicalSection;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.ButtonSettings;
import sample.Checks;
import sample.GoToScreens;
import sample.inlogScreen.Main;
import java.time.LocalDate;
import java.util.Optional;

public class  MakeAppointment extends Application {
    Scene makeAppointmentScene;
    Main main;
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    LocalDate date;
    String chosenDoctor;
    Pane pane = new Pane();
    GoToScreens goToScreens = GoToScreens.getInstance();
    ButtonSettings buttonSettings = ButtonSettings.getInstance();
    private int labelNumber = 0;

    Button exitButton = new Button("Back");
    Button selectSpecialty = new Button("Select");
    Button selectDoctor = new Button("Select");
    Button selectDate = new Button("Select date");
    Button makeAppointment = new Button("Make Appointment");

    Label specialtyLabel = new Label("Specialty: ");
    Label doctorLabel = new Label("Doctor: ");
    Label dateLabel = new Label("Date: ");
    Label timeLabel = new Label("Time: ");
    Label title = new Label("Make Appointment");

    ComboBox timeBox = new ComboBox();
    ComboBox specialtyBox = new ComboBox();
    ComboBox doctorBox = new ComboBox();

    DatePicker datePicker = new DatePicker();



    @Override
    public void start(Stage stage) throws Exception {
        pane.setStyle("-fx-background-color:#F0F8FF");
        setNotVisible();
        makeButtons(stage);
        makeDatePicker();
        makeLabels();
        makeComboBoxes();
        pane.getChildren().addAll(title, specialtyLabel, doctorLabel, dateLabel, timeLabel, exitButton, specialtyBox, selectSpecialty, selectDoctor, doctorBox, datePicker, selectDate,timeBox, makeAppointment);
        fin(stage);
    }
    public void makeAppointmentButton(Stage stage) {
        makeAppointment.relocate(325, 300);
        makeAppointment.setOnMouseClicked(E -> {
            if(timeBox.getValue() != null){
                if(Checks.checkIfTimeAvailable((String) timeBox.getValue())) {
                    makeConfirmationAlert(stage);
                }
                else{
                    makeTimeNotAvailableAlert();
                }
            }
            else{
                makeNoTimeSelectedAlert();
            }
        });
    }
    public void makeConfirmationAlert(Stage stage){
        Alert alertConfirmation = new Alert(Alert.AlertType.CONFIRMATION);
        alertConfirmation.setTitle("Confirm appointment");
        alertConfirmation.setHeaderText("Are you sure you want to make an appointment with " + doctorBox.getValue() + " at " + timeBox.getValue() + " on " + datePicker.getValue() + " for " + specialtyBox.getValue());
        Optional<ButtonType> option = alertConfirmation.showAndWait();
        if(option.get() == ButtonType.OK){
            makeAppointment(stage);
        }

    }
    public void makeAppointment(Stage stage){
        Appointment newAppointment = new Appointment(ArrayKeeper.findDoctor(doctorBox.getSelectionModel().getSelectedItem().toString()), datePicker.getValue(), timeBox.getSelectionModel().getSelectedItem().toString(), ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()), specialtyBox.getSelectionModel().getSelectedItem().toString());
        ArrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).addAppointment(newAppointment);
        getDoctor(doctorBox.getSelectionModel().getSelectedItem().toString()).getAppointments().add(newAppointment);

        getDoctor((String) doctorBox.getValue()).getDate(datePicker.getValue()).removeTimeFromTimeTable((String) timeBox.getValue());
        goToScreens.goMedicalSection(stage);
    }
    public void makeTimeNotAvailableAlert(){
        Alert notAvailableAlert = new Alert(Alert.AlertType.ERROR);
        notAvailableAlert.setTitle("Time not available");
        notAvailableAlert.setHeaderText("You already have an appointment at this time!");
        notAvailableAlert.show();
    }
    public void makeNoTimeSelectedAlert(){
        Alert timeAlert = new Alert(Alert.AlertType.ERROR);
        timeAlert.setTitle("No time selected!");
        timeAlert.setHeaderText("You must select a time before you can make an appointment!");
        timeAlert.show();
    }
    public void makeDatePicker(){
        datePicker.relocate(250, 260);

    }
    public void makeSpecialtyButton(){
        selectSpecialty.relocate(350, 160);
        selectSpecialty.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                timeBox.getItems().clear();
                doctorBox.getItems().clear();
                datePicker.getEditor().clear();
                removeItems(doctorBox);
                String selectedSpecialty = specialtyBox.getSelectionModel().getSelectedItem().toString();
                makeDoctorBox(doctorBox,selectedSpecialty);
                selectDoctor.setVisible(true);
                doctorBox.setVisible(true);
            }
        });
    }
    public void setNotVisible(){
        selectDoctor.setVisible(false);
        doctorBox.setVisible(false);
        datePicker.setVisible(false);
        selectDate.setVisible(false);
        timeBox.setVisible(false);
        makeAppointment.setVisible(false);

    }
    public void makeButtons(Stage stage){
        makeExitButton(stage);
        makeSpecialtyButton();
        makeDoctorButton();
        makeDateButton();
        makeAppointmentButton(stage);
    }
    public void makeDateButton(){
        selectDate.relocate(425, 260);
        selectDate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                getTimeTable();
            }
        });
    }
    public void getTimeTable(){
        timeBox.getItems().clear();
        chosenDoctor = doctorBox.getSelectionModel().getSelectedItem().toString();
        date = datePicker.getValue();
        if(checkDate(date)){
            if(getDoctor(chosenDoctor).checkLocalDate(date)){
                fillTimeTable();
            }else{
                makeNewDate();
            }
            timeBox.setVisible(true);
            makeAppointment.setVisible(true);
        }else{
            DateNotCorrectAlert();
        }
    }
    public void makeNewDate(){
        Dates appointmentDate = new Dates(date);
        getDoctor(chosenDoctor).addLocalDate(appointmentDate);
        for(int i = 0; i < appointmentDate.getTimeTable().size();i++){
            timeBox.getItems().add(appointmentDate.getTimeTable().get(i));
        }
    }
    public void fillTimeTable(){
        for(int i = 0; i < getDoctor(chosenDoctor).getDate(date).getTimeTable().size();i++){
            timeBox.getItems().add(getDoctor(chosenDoctor).getDate(date).getTimeTable().get(i));
        }
    }
    public void DateNotCorrectAlert(){
        Alert dateNotCorrect = new Alert(Alert.AlertType.ERROR);
        dateNotCorrect.setTitle("Date not correct!");
        dateNotCorrect.setHeaderText("Date is not correct. Please select another one!");
        dateNotCorrect.show();
    }
    public void makeDoctorButton(){
        selectDoctor.relocate(330 , 210);
        selectDoctor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                datePicker.setVisible(true);
                selectDate.setVisible(true);
                datePicker.getEditor().clear();
                timeBox.getItems().clear();
            }
        });
    }
    public void makeSpecialtyBox(){
        for( int i =0; i < arrayKeeper.getSpecialtiesArrayList().size(); i++){
            specialtyBox.getItems().add(arrayKeeper.getSpecialtiesArrayList().get(i).getName());
        }
        specialtyBox.relocate(250,160);
    }
    public void makeComboBoxes(){
        makeSpecialtyBox();
        makeTimeBox();
    }
    public void makeTimeBox(){
        timeBox.relocate(250, 300);

    }

    public void makeDateLabel() {
        setLabel(dateLabel);
    }
    public void makeTimeLabel(){
        setLabel(timeLabel);
    }
    public void makeDoctorLabel(){
        setLabel(doctorLabel);
    }
    public void makeTitleLabel(){
        title.relocate(100, 50);
        title.setFont(Font.font("Arial", 30));
    }
    public void makeSpecialtyLabel(){
        setLabel(specialtyLabel);
    }
    public void makeLabels(){
        makeSpecialtyLabel();
        makeTitleLabel();
        makeDoctorLabel();
        makeDateLabel();
        makeTimeLabel();
    }

    public void makeExitButton(Stage stage){
        exitButton.relocate(10, 565);
        buttonSettings.onMouse(exitButton);
        exitButton.setOnAction(E-> {
            goToScreens.goMedicalSection(stage);
        });
    }

    public void removeItems(ComboBox comboBox){
        comboBox.getItems().clear();
    }
    public Doctor getDoctor(String name) {
        for (int i = 0; i < arrayKeeper.getDoctorsArrayList().size(); i++) {
            if (name.equalsIgnoreCase(arrayKeeper.getDoctorsArrayList().get(i).getName())) {
                return arrayKeeper.getDoctorsArrayList().get(i);
            }
        }
        return arrayKeeper.getDoctorsArrayList().get(0);
    }
    public void makeDoctorBox(ComboBox doctorBox, String specialty){
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
    public void fin(Stage stage){
        makeAppointmentScene = new Scene(pane, 800, 600);
        stage.setTitle("Make appointment");
        stage.setScene(makeAppointmentScene);
        stage.show();
    }
}