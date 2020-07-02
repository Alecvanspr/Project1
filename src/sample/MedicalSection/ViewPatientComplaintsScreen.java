package sample.MedicalSection;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.GoToScreens;
import sample.inlogScreen.Main;
import sample.inlogScreen.PersonalData;

public class ViewPatientComplaintsScreen extends Application{
    Button goBack = new Button("Back");
    Scene ViewPatientComplaintsScreen;
    ArrayKeeper arrayKeeper;
    Main main;
    GoToScreens goToScreens = new GoToScreens();
    Pane pane = new Pane();
    ScrollPane rootPane = new ScrollPane();
    PersonalData currentPatient;
    Doctor currentDoctor;

    @Override
    public void start(Stage stage) throws Exception{
        showPage(stage);
        makeLayout(stage);
        getComplaints();
    }

    public ViewPatientComplaintsScreen(PersonalData currentPatient, Doctor doctor){
        this.currentPatient = currentPatient;
        this.currentDoctor = doctor;
    }

    public void makeLayout(Stage stage){
        fillScrollPane();
        makeButtons(stage);
        makeLabels();
    }

    public void makeButtons(Stage stage){
        makeGoBackButton(stage);
    }

    public void makeGoBackButton(Stage stage){
        setButtonScaleChange(goBack, 1.2);
        goBack.relocate(10, 565);
        pane.getChildren().add(goBack);
        goBack.setOnAction(E -> {
            goToScreens.goViewPatientsScreen(stage);
        });
    }

    public void makeLabels(){
        makePatientNameLabels();
        makeRowLabels();
    }

    public void makePatientNameLabels(){
        Font font = new Font(22);
        Label patient = new Label("Patient: ");
        patient.setFont(font);
        patient.relocate(50, 50);
        Label patientName = new Label(currentPatient.getName());
        patientName.setFont(font);
        patientName.relocate(200, 50);
        pane.getChildren().addAll(patient, patientName);
    }

    public void makeRowLabels(){
        Label rowBodypart = new Label("Bodypart:");
        Label rowFirstNoticed = new Label("First noticed on:");
        Label rowHasBeenCured = new Label("Is cured:");
        Label rowCuredOn = new Label("Cured on:");
        rowBodypart.setStyle("-fx-font-weight: bold;");
        rowFirstNoticed.setStyle("-fx-font-weight: bold;");
        rowHasBeenCured.setStyle("-fx-font-weight: bold;");
        rowCuredOn.setStyle("-fx-font-weight: bold;");
        rowBodypart.relocate(50, 100);
        rowFirstNoticed.relocate(200, 100);
        rowHasBeenCured.relocate(350, 100);
        rowCuredOn.relocate(450, 100);
        pane.getChildren().addAll(rowBodypart, rowFirstNoticed, rowHasBeenCured, rowCuredOn);
    }

    public void fillScrollPane(){
        rootPane.setContent(pane);
    }

    public void setButtonScaleChange(Button button, Double scale){
        button.setOnMouseEntered(E -> {
            button.setScaleX(scale);
            button.setScaleY(scale);
        });
        button.setOnMouseExited(E -> {
            button.setScaleX(1);
            button.setScaleY(1);
        });
    }

    public void showPage(Stage stage){
        ViewPatientComplaintsScreen = new Scene(rootPane,800,600);
        stage.setTitle(currentPatient.getName() + "'s complaint(s) details");
        stage.setScene(ViewPatientComplaintsScreen);
        stage.show();
    }

    public void getComplaints(){
        for(int i = 0; i < currentPatient.getComplaints().size(); i++){
            Label complaint = new Label(currentPatient.getComplaints().get(i).getBodyPart().getName());
            Label firstNoticed = new Label(currentPatient.getComplaints().get(i).getFirstNoticed().toString());
            Label hasBeenCured = new Label(toString(currentPatient.getComplaints().get(i)));
            if(currentPatient.getComplaints().get(i).getHasBeenCured()){
                Label curedOn = new Label(currentPatient.getComplaints().get(i).getCured().toString());
                curedOn.relocate(450, 120+(50*i));
                pane.getChildren().add(curedOn);
            }
            firstNoticed.relocate(200, 120+(50*i));
            hasBeenCured.relocate(350, 120+(50*i));
            complaint.relocate(50, 120+(50*i));
            pane.getChildren().addAll(complaint, firstNoticed, hasBeenCured);
        }
    }

    public String toString(Complaint complaint){
        if(complaint.getHasBeenCured()){
            return "true";
        }
        else{
            return "false";
        }
    }
}
