package sample.MedicalSection;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.GoToScreens;
import sample.inlogScreen.Main;
import sample.inlogScreen.PersonalData;

public class ViewPatientsScreen extends Application{
    Button goBack = new Button("Back");
    Scene ViewPatientsScreen;
    ArrayKeeper arrayKeeper;
    Main main;
    GoToScreens goToScreens = new GoToScreens();
    Pane pane = new Pane();
    ScrollPane rootPane = new ScrollPane();

    @Override
    public void start(Stage primarystage) throws Exception{
        showPage(primarystage);
        makeLayout(primarystage);
        getPatients(primarystage);
    }

    public void makeLayout(Stage stage){
        fillScrollPane();
        makeButtons(stage);
    }

    public void makeButtons(Stage stage){
        makeGoBackButton(stage);
    }

    public void makeGoBackButton(Stage stage){
        setButtonScaleChange(goBack, 1.2);
        goBack.relocate(10, 565);
        pane.getChildren().add(goBack);
        goBack.setOnAction(E -> {
            goToScreens.goMedicalSection(stage);
        });
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
        ViewPatientsScreen = new Scene(rootPane,800,600);
        stage.setTitle("Your patients");
        stage.setScene(ViewPatientsScreen);
        stage.show();
    }

    public void getPatients(Stage stage){
        for(int i = 0; i < ArrayKeeper.findDoctor(ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getName()).getPatients().size(); i++){
            Label patientNaam = new Label(ArrayKeeper.findDoctor(ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getName()).getPatients().get(i).getName());
            PersonalData patient = ArrayKeeper.searchPersonalData(ArrayKeeper.findDoctor(ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getName()).getPatients().get(i).getUsername());
            patientNaam.setOnMouseClicked(E -> {
                goToScreens.goViewPatientComplaintsScreen(stage, patient, ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getName());
            });
            patientNaam.relocate(50, 50+(50*i));
            pane.getChildren().add(patientNaam);
        }
    }
}
