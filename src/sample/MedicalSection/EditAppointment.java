package sample.MedicalSection;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.ButtonSettings;
import sample.GoToScreens;
import sample.inlogScreen.Main;

import java.time.LocalDate;
import java.util.ArrayList;

public class EditAppointment extends Application {
    Scene EditAppointment;
    Main main;
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    ButtonSettings buttonSettings =ButtonSettings.getInstance();
    GoToScreens goToScreens = GoToScreens.getInstance();
    Appointment appointment;
    Pane pane = new Pane();
    ComboBox<String> appointmentComboBox = new ComboBox<>();
    ComboBox<String> specialtyComboBox = new ComboBox<>();
    ComboBox<String> doctorComboBox = new ComboBox<>();
    ComboBox<String> timeComboBox = new ComboBox<>();
    Button appointmentButton = new Button("Select");
    Button specialtyButton = new Button("Select");
    Button doctorButton = new Button("Select");
    Button editAppointmentButton = new Button("Edit Appointment");
    Button dateButton = new Button("Select");
    Button exitButton = new Button("Back");
    Label appointmentLabel = new Label("Appointment: ");
    Label specialtyLabel = new Label("Specialty: ");
    Label doctorLabel = new Label("Doctor: ");
    Label startLabel = new Label("Edit your appointment here");
    Label dateLabel = new Label("Date: ");
    Label timeLabel = new Label("Time: ");
    DatePicker datePicker = new DatePicker();

    public void start(Stage stage) throws Exception{
        makeComboBoxes();
        makeDatePicker();
        makeButtons(stage);
        makeLabels();
        setNothingVisible();
        pane.getChildren().addAll(appointmentLabel, startLabel, timeLabel, dateLabel, doctorLabel, specialtyLabel, exitButton, dateButton, appointmentComboBox, specialtyButton, doctorComboBox,specialtyComboBox, timeComboBox, doctorButton, editAppointmentButton, datePicker, appointmentButton);
        fin(stage);
    }
    public void makeLabels(){
        makeAppointmentLabel();
        makeStartLabel();
        makeTimeLabel();
        makeDateLabel();
        makeDoctorLabel();
        makeSpecialtyLabel();
    }
    public void makeAppointmentLabel(){
        appointmentLabel.relocate(70, 100);
        setLabelFont(appointmentLabel);
    }
    public void makeSpecialtyLabel(){
        specialtyLabel.relocate(70, 150);
        setLabelFont(specialtyLabel);
    }
    public void makeDoctorLabel(){
        doctorLabel.relocate(70, 200);
        setLabelFont(doctorLabel);
    }
    public void makeDateLabel(){
        dateLabel.relocate(70, 250);
        setLabelFont(dateLabel);
    }
    public void makeTimeLabel(){
        timeLabel.relocate(70, 300);
        setLabelFont(timeLabel);
    }
    public void makeStartLabel(){
        startLabel.relocate(150, 30);
        startLabel.setFont(Font.font("Arial", 50));
    }
    public void setLabelFont(Label label){
        label.setFont(Font.font("Arial", 30));
    }
    public void makeButtons(Stage stage){
        makeSpecialtyButton();
        makeDoctorButton();
        makeAppointmentButton();
        makeEditAppointmentButton(stage);
        makeDateButton();
        makeExitButton(stage);
    }
    public void makeExitButton(Stage stage){
        exitButton.relocate(10, 565);
        buttonSettings.onMouse(exitButton);
        goToScreens.goAppointmentsScreen(stage);
    }
    public void makeDateButton(){
        dateButton.relocate(450,260);
        dateButton.setOnAction(E-> {
            if(checkDate(datePicker.getValue())){
                timeComboBox.getItems().clear();
                getTimeTable();
            }else{
                makeErrorNotCorrect();
            }
        });
    }
    public void makeErrorNotCorrect(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Please select a correct date");
        alert.setHeaderText("Date is not correct");
        alert.show();
    }
    public void getTimeTable(){
        if(getDoctor(doctorComboBox.getValue()).checkLocalDate(datePicker.getValue())){
            fillTimeBox(timeComboBox, getDoctor(doctorComboBox.getValue()).getDate(datePicker.getValue()));
        }else{

            Dates date = new Dates(datePicker.getValue());
            fillTimeBox(timeComboBox, date);
        }
        timeComboBox.setVisible(true);
        editAppointmentButton.setVisible(true);
    }
    public void fillTimeBox(ComboBox combobox, Dates date){
        for(int i = 0; i < date.getTimeTable().size(); i++){
            combobox.getItems().add(date.getTimeTable().get(i));
        }
    }
    public void makeEditAppointmentButton(Stage stage){
        editAppointmentButton.relocate(400, 300);
        editAppointmentButton.setOnAction(E-> {
            for(int i = 0; i < getAppointmentList().size(); i++){
                setEditAppointment(stage,i);
            }
        });
    }
    public void setEditAppointment(Stage stage,int i){
        String date = getAppointmentList().get(i).getAppointmentDate() + " " + getAppointmentList().get(i).getAppointmentTime();
        if(date.equalsIgnoreCase(appointmentComboBox.getValue())){
            appointment = getAppointmentList().get(i);
            String oldTime = appointment.getAppointmentTime();
            getAppointmentList().get(i).EditAppointment(timeComboBox.getValue(), datePicker.getValue(),specialtyComboBox.getValue(),getDoctor(doctorComboBox.getValue()));
            removeAndAddTime(timeComboBox.getValue(),oldTime);
            goToScreens.goAppointmentsScreen(stage);
        }
    }

    public void removeAndAddTime(String newTime, String oldTime){
        getDoctor(doctorComboBox.getValue()).getDate(datePicker.getValue()).addTimeToTimeTable(oldTime);
        getDoctor(doctorComboBox.getValue()).getDate(datePicker.getValue()).removeTimeFromTimeTable(newTime);
    }

    public void makeAppointmentButton(){
        appointmentButton.relocate(390, 110);
        appointmentButton.setOnAction(E->{
            specialtyButton.setVisible(true);
            specialtyComboBox.setVisible(true);
            doctorComboBox.getItems().clear();
            datePicker.getEditor().clear();
            timeComboBox.getItems().clear();
        });
    }
    public void makeDoctorButton(){
        doctorButton.relocate(350,210);
        doctorButton.setOnAction(E-> {
            if(checkIfValue(doctorComboBox)){
                datePicker.setVisible(true);
                dateButton.setVisible(true);
                datePicker.getEditor().clear();
                timeComboBox.getItems().clear();
            }
        });
    }
    public void makeSpecialtyButton(){
        specialtyButton.relocate(350,160);
        specialtyButton.setOnAction(E-> {
            if(checkIfValue(specialtyComboBox)){
                doctorComboBox.setVisible(true);
                doctorButton.setVisible(true);
                doctorComboBox.getItems().clear();
                fillDoctorBox(specialtyComboBox.getValue());
                datePicker.getEditor().clear();
                timeComboBox.getItems().clear();
            }
        });
    }
    public void setNothingVisible(){
        doctorButton.setVisible(false);
        doctorComboBox.setVisible(false);
        datePicker.setVisible(false);
        timeComboBox.setVisible(false);
        editAppointmentButton.setVisible(false);
        specialtyComboBox.setVisible(false);
        specialtyButton.setVisible(false);
        dateButton.setVisible(false);
    }
    public void makeDatePicker(){
        datePicker.relocate(250, 260);
    }
    public void makeComboBoxes(){
        makeAppointmentComboBox();
        makeSpecialtyBox();
        makeDoctorBox();
        makeTimeBox();
    }
    public void makeTimeBox(){
        timeComboBox.relocate(250, 300);

    }
    public Boolean checkDate(LocalDate date){
        LocalDate today = LocalDate.now();
        if(date.getYear() >= today.getYear() && date.getMonth().getValue() >= today.getMonth().getValue() && date.getDayOfMonth() > today.getDayOfMonth()){
            return true;
        }else{
            return false;
        }
    }
    public Doctor getDoctor(String doctor){
        for(int i = 0; i < arrayKeeper.getDoctorsArrayList().size(); i++){
            if(arrayKeeper.getDoctorsArrayList().get(i).getName().equalsIgnoreCase(doctor)){
                return arrayKeeper.getDoctorsArrayList().get(i);
            }
        }
        return null;
    }
    public void fillDoctorBox(String specialty){
        for(int i =0; i < arrayKeeper.getDoctorsArrayList().size(); i++){
            for(int j = 0; j < arrayKeeper.getDoctorsArrayList().get(i).getSpecialties().size(); j++){
                if(arrayKeeper.getDoctorsArrayList().get(i).getSpecialties().get(j).getName().equalsIgnoreCase(specialty)){
                    doctorComboBox.getItems().add(arrayKeeper.getDoctorsArrayList().get(i).getName());
                }
            }
        }
    }
    public void makeDoctorBox(){
        doctorComboBox.relocate(250,210);
    }
    public void makeSpecialtyBox(){
        addSpecialties(specialtyComboBox);
        specialtyComboBox.relocate(250,160);
    }
    public void addSpecialties(ComboBox comboBox){
        for(int i = 0; i < arrayKeeper.getSpecialtiesArrayList().size(); i++){
            comboBox.getItems().add(arrayKeeper.getSpecialtiesArrayList().get(i).getName());
        }
    }
    public void makeAppointmentComboBox(){
        appointmentComboBox.relocate(250, 110);
        addAppointments(appointmentComboBox);

    }
    public void addAppointments(ComboBox comboBox){

        for(int i =0; i< getAppointmentList().size(); i++){
            comboBox.getItems().addAll(getAppointmentList().get(i).getAppointmentDate().toString()+" "+getAppointmentList().get(i).getAppointmentTime());
        }
    }
    public ArrayList<Appointment> getAppointmentList(){
        return ArrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).getAppointments();
    }
    public void makeNoInputAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Missing a selection");
        alert.setContentText("Please make sure all the boxes are filled!");
        alert.show();
    }
    public void fin(Stage stage){
        EditAppointment = new Scene(pane,800,600);
        stage.setTitle("Edit Appointment");
        stage.setScene(EditAppointment);
        stage.show();
    }
    public Boolean checkIfValue(ComboBox combobox){
        if (combobox.getValue() == null){
            makeNoInputAlert();
            return false;
        }else {
            return true;
        }
    }
}
