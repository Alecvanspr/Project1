package sample.MedicalSection;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.inlogScreen.Main;

import java.util.ArrayList;

public class EditAppointment extends Application {
    Scene EditAppointment;
    Main main;
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    Pane pane = new Pane();
    ComboBox<String> appointmentComboBox = new ComboBox<>();
    ComboBox<Specialty> specialtyComboBox = new ComboBox<>();
    ComboBox<Doctor> doctorComboBox = new ComboBox<>();
    ComboBox<String> timeComboBox = new ComboBox<>();
    Button specialtyButton = new Button("Select");
    Button doctorButton = new Button("Select");
    Button dateButton = new Button("Select");
    DatePicker datePicker = new DatePicker();

    public void start(Stage stage) throws Exception{
        makeComboBoxes();
        makeDatePicker();
    }
    public void makeButtons(){

    }
    public void makeSpecialtyButton(){
        specialtyButton.relocate(350,160);
        specialtyButton.setOnAction(E-> {

        });
    }
    public void makeDatePicker(){
        datePicker.relocate(450, 260);
    }
    public void makeComboBoxes(){
        makeAppointmentComboBox();
        makeSpecialtyBox();
        makeDoctorBox();
    }
    public void makeTimeBox(){
        timeComboBox.relocate(260, 300);

    }
    public void fillDoctorBox(String specialty){

    }
    public void makeDoctorBox(){
        doctorComboBox.relocate(350,210);
    }
    public void makeSpecialtyBox(){
        addSpecialties(specialtyComboBox);
        specialtyComboBox.relocate(350,160);
    }
    public void addSpecialties(ComboBox comboBox){
        for(int i = 0; i < arrayKeeper.getSpecialtiesArrayList().size(); i++){
            comboBox.getItems().add(arrayKeeper.getSpecialtiesArrayList().get(i).getName());
        }
    }
    public void makeAppointmentComboBox(){
        appointmentComboBox.relocate(350, 110);
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
}
