package sample.MedicalSection;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import sample.ArrayKeeper;
import sample.GoToScreens;

public class NotesScreen extends Application {
    Pane pane = new Pane();
    GoToScreens goToScreens = GoToScreens.getInstance();
    PastAppointment pastAppointment;
    Scene scene;
    int currentAppointment;

    public NotesScreen(PastAppointment pastAppointment){
        this.pastAppointment = pastAppointment;
    }
    @Override
    public void start(Stage stage) throws Exception {
        makeLabels();
        makeButtons(stage);
        fin(stage);
    }
    public void fin(Stage stage){
        scene = new Scene(pane,800,600);
        stage.setTitle("Notes from your appointment");
        stage.setScene(scene);
        stage.show();
    }
    public void makeLabels(){
        showDate();
        showTime();
        showDoctor();
        showNote();
    }
    public void showDate(){
        Label dateLabel = new Label(pastAppointment.getAppointmentDate().toString());
        dateLabel.relocate(100,40);
        pane.getChildren().add(dateLabel);
    }
    public void showTime(){
        Label timeLabel = new Label(pastAppointment.getAppointmentTime());
        timeLabel.relocate(200,40);
        pane.getChildren().add(timeLabel);
    }
    public void showDoctor(){
        Label doctorLabel = new Label(pastAppointment.getDoctor().getName());
        doctorLabel.relocate(300,40);
        pane.getChildren().add(doctorLabel);
    }
    public void showNote(){
        Label showNotes = new Label(pastAppointment.getNotes());
        showNotes.relocate(100,75);
        pane.getChildren().add(showNotes);
    }
    public void makeButtons(Stage stage){
        makeBtnEdit();
        makeBtnBack(stage);
    }
    public void makeBtnEdit(){
        Button btnEdit = new Button("Edit Note");
        btnEdit.relocate(400,40);
        btnEdit.setOnAction(E->{
            editNoteLabel();
        });
        if(checkIfDocter()) {
            pane.getChildren().add(btnEdit);
        }
    }
    public boolean checkIfDocter(){
        for(int i = 0;i<ArrayKeeper.getDoctorsArrayList().size();i++){
            if (pastAppointment.getDoctor().getName().equals(ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getName())) {
                if (pastAppointment.getDoctor().getPassword().equals(ArrayKeeper.getDoctorsArrayList().get(i).getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }
    public void editNoteLabel(){

    }
    public void makeBtnBack(Stage stage){
        Button btnBack = new Button("Back");
        btnBack.setOnAction(E->{
            goToScreens.goMedicalSection(stage);
        });
        btnBack.relocate(0,565);
        pane.getChildren().add(btnBack);
    }
}
