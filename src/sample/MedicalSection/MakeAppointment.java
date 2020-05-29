package sample.MedicalSection;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.inlogScreen.Main;
import sample.MedicalSection.Specialty;
public class MakeAppointment extends Application {
    Scene makeAppointmentScene;
    Main main;
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    private int labelNumber = 0;
    @Override
    public void start(Stage stage) throws Exception{
        Pane pane = new Pane();

        //Exit button
        Button exitButton = new Button("Back");
        exitButton.relocate(10,565);
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
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        pane.getChildren().add(exitButton);
        Label specialtyLabel = new Label("Specialty: ");
        setLabel(specialtyLabel);
        Label docterLabel = new Label("Docter: ");
        setLabel(docterLabel);
        Label dateLabel = new Label("Date: ");
        setLabel(dateLabel);
        Label timeLabel = new Label("Time: ");
        setLabel(timeLabel);
        pane.getChildren().addAll(specialtyLabel,docterLabel,dateLabel,timeLabel);
        /*//Combobox for specialty's

        ComboBox specialtyBox = new ComboBox();
        for(int i = 0; i < arrayKeeper.specialtiesArrayList.size(); i++){
            specialtyBox.getItems().add(arrayKeeper.specialtiesArrayList.get(i).getName());
        }
        specialtyBox.relocate(250, 110);
        pane.getChildren().add(specialtyBox);

        for(int i = 0; i < arrayKeeper.getDoctorsArrayList().size(); i++){
            if(arrayKeeper.getDoctorsArrayList().get(i).checkSpecialty(getSpecialty(specialtyBox.getPromptText()))){
                Label doctorLabel = new Label(arrayKeeper.getDoctorsArrayList().get(i).getName());
                doctorLabel.relocate(250, 150 + (i*25));
                pane.getChildren().add(docterLabel);
            }
        }*/

        ComboBox specialtyBox = new ComboBox();
        for(int i = 0; i < arrayKeeper.specialtiesArrayList.size(); i++){
            specialtyBox.getItems().add(arrayKeeper.specialtiesArrayList.get(i));
        }
        specialtyBox.relocate(250, 110);
        pane.getChildren().add(specialtyBox);

        makeAppointmentScene = new Scene(pane, 800, 600);
        stage.setTitle("Make Appointment here");
        stage.setScene(makeAppointmentScene);
        stage.show();
    }
    public Specialty getSpecialty(String name){
        for(int i = 0; i < arrayKeeper.specialtiesArrayList.size(); i++){
            if(arrayKeeper.specialtiesArrayList.get(i).getName().equals(name)){
                return arrayKeeper.specialtiesArrayList.get(i);
            }
        }
        return arrayKeeper.specialtiesArrayList.get(0);
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
            label.relocate(100, 100);
        }else if(this.labelNumber == 1){
            label.relocate(100, 150);
        }else if(this.labelNumber == 2){
            label.relocate(100, 200);
        }else{
            label.relocate(100, 250);
        }
        labelNumber++;

    }


}
