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
import sample.inlogScreen.SignUpScreenDoctor;

public class ViewPatientsScreen extends Application{
    Scene ViewPatientsScreen;
    ArrayKeeper arrayKeeper;
    Main main;
    GoToScreens goToScreens = GoToScreens.getInstance();
    Pane rootPane = new Pane();

    @Override
    public void start(Stage stage) {
        showPage(stage, rootPane);
        makeLayout(stage);
        getPatients();
    }

    public void makeLayout(Stage stage){
        makeButtons(stage);
        makeScrollPane();
    }

    public void makeButtons(Stage stage){
        makeGoBackButton(stage);
    }

    public void makeScrollPane(){
        ScrollPane scrollPane = new ScrollPane();
    }

    public void makeGoBackButton(Stage stage){
        Button goBack = new Button("Back");
        setButtonScaleChange(goBack, 1.2);
        goBack.relocate(10, 565);
        rootPane.getChildren().add(goBack);
        goBack.setOnAction(E -> {
            goToScreens.goMedicalSection(stage);
        });
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

    public void showPage(Stage stage, Pane pane){
        ViewPatientsScreen = new Scene(pane,800,600);
        stage.setTitle("Your patients");
        stage.setScene(ViewPatientsScreen);
        stage.show();
    }

    public void getPatients(){
        for(int i = 0; i < ArrayKeeper.findDoctor(ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getName()).getPatients().size(); i++){
            Label patientNaam = new Label();
            patientNaam.setText(ArrayKeeper.findDoctor(ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getName()).getPatients().get(i).getName());
            patientNaam.relocate(50, 50+(50*i));
            rootPane.getChildren().add(patientNaam);
        }
    }
}
