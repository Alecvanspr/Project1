package sample.MedicalSection;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import sample.ArrayKeeper;
import sample.GoToScreens;

public class NotesScreen extends Application {
    PastAppointments pastAppointments =PastAppointments.getInstance();
    Pane pane = new Pane();
    GoToScreens goToScreens = GoToScreens.getInstance();
    //PastAppointment pastAppointment;
    Scene scene;
    int currentAppointment;
    TextArea editNote = new TextArea();

    public NotesScreen(PastAppointment pastAppointment,int currentAppointment){
        this.currentAppointment = currentAppointment;
        pastAppointments.fillPastAppointments();
    }
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println(pastAppointments.getPastAppointments().get(currentAppointment).getDoctor().getName());
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
        Label dateLabel = new Label(pastAppointments.getPastAppointments().get(currentAppointment).getAppointmentDate().toString());
        dateLabel.relocate(100,40);
        pane.getChildren().add(dateLabel);
    }
    public void showTime(){
        Label timeLabel = new Label(pastAppointments.getPastAppointments().get(currentAppointment).getAppointmentTime());
        timeLabel.relocate(200,40);
        pane.getChildren().add(timeLabel);
    }
    public void showDoctor(){
        Label doctorLabel = new Label(pastAppointments.getPastAppointments().get(currentAppointment).getDoctor().getName());
        doctorLabel.relocate(300,40);
        pane.getChildren().add(doctorLabel);
    }
    public void showNote(){
        System.out.println(pastAppointments.getPastAppointments().get(currentAppointment).getNotes());
        Label showNotes = new Label(pastAppointments.getPastAppointments().get(currentAppointment).getNotes());
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
            if (pastAppointments.getPastAppointments().get(currentAppointment).getDoctor().getName().equals(ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getName())) {
                if (pastAppointments.getPastAppointments().get(currentAppointment).getDoctor().getPassword().equals(ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }
    public void editNoteLabel(){
        editNote.relocate(100,120);
        editNote.setMaxSize(300,300);
        makeBtnSave();
        pane.getChildren().add(editNote);
    }
    public void makeBtnSave(){
        Button btnSave = new Button("Save Notes");
        btnSave.relocate(300,575);
        btnSave.setOnAction(E->{
            pastAppointments.getPastAppointments().get(currentAppointment).setNotes(editNote.getText());
            pane.getChildren().remove(btnSave);
            pane.getChildren().remove(editNote);
            showNote();
        });
        pane.getChildren().add(btnSave);
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
