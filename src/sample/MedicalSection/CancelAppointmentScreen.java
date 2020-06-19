package sample.MedicalSection;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.ButtonSettings;
import sample.GoToScreens;
import sample.inlogScreen.Main;

import java.util.ArrayList;

public class CancelAppointmentScreen extends Application {
    Scene CancelAppointment;
    Main main;
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    ButtonSettings buttonSettings = ButtonSettings.getInstance();
    GoToScreens goToScreens = GoToScreens.getInstance();
    Pane pane = new Pane();
    Button deleteAppointmentButton = new Button("Delete this appointment");
    Button exitButton = new Button("Back");
    ComboBox<String> appointmentBox = new ComboBox<>();
    CancelAppointments cancelAppointments = new CancelAppointments();
    @Override
    public void start(Stage stage) throws Exception{
        makeButtons(stage);
        makeAppointmentComboBox();
        pane.getChildren().addAll(deleteAppointmentButton, exitButton, appointmentBox);
        fin(stage);
    }
    public void makeButtons(Stage stage){
        makeExitButton(stage);
        makeDeleteAppointmentButton(stage);
    }
    public void makeDeleteAppointmentButton(Stage stage){
        deleteAppointmentButton.relocate(200, 200);
        deleteAppointmentButton.setPrefWidth(100);
        deleteAppointmentButton.setOnAction(E-> {
            String appointment = appointmentBox.getSelectionModel().getSelectedItem();
            cancelAppointments.deleteAppointment(appointment);
            goToScreens.goAppointmentsScreen(stage);
        });
    }


    public void makeAppointmentComboBox(){
        appointmentBox.relocate(100, 200);
        fillComboBox(appointmentBox);
    }
    public void fillComboBox(ComboBox combobox){
        for(int i = 0; i< cancelAppointments.getAppointmentList().size(); i++){
            Appointment appointment = cancelAppointments.getAppointmentList().get(i);
            combobox.getItems().add(appointment.getAppointmentDate().toString() + " " + appointment.getAppointmentTime());
        }
    }

    public void makeExitButton(Stage stage){
        exitButton.relocate(10, 565);
        buttonSettings.onMouse(exitButton);
        exitButton.setOnAction(E-> {
            goToScreens.goAppointmentsScreen(stage);
        });
    }
    public void fin(Stage stage){
        CancelAppointment = new Scene(pane,800,600 );
        stage.setTitle("Cancel appointment");
        stage.setScene(CancelAppointment);
        stage.show();
    }
}
class CancelAppointments{
    public ArrayList<Appointment> getAppointmentList(){
        return ArrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).getAppointments();
    }
    public Appointment getAppointment(String appointment){
        for(int i = 0; i < getAppointmentList().size(); i++){
            String string = getAppointmentList().get(i).getAppointmentDate().toString() + " " + getAppointmentList().get(i).getAppointmentTime();
            if(string.equalsIgnoreCase(appointment)){
                return getAppointmentList().get(i);
            }
        }
        return null;
    }
    public void deleteAppointment(String appointment){

        getAppointmentList().remove(getAppointment(appointment));
    }
}

