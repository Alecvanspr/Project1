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

import java.sql.Time;
import java.util.Date;

public class MakeAppointment extends Application {
    Scene makeAppointmentScene;
    Main main;
    ArrayKeeper arrayKeeper;
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
        Label doctorLabel = new Label("Doctor: ");
        setLabel(doctorLabel);
        Label dateLabel = new Label("Date: ");
        setLabel(dateLabel);
        Label timeLabel = new Label("Time: ");
        setLabel(timeLabel);

        //Combobox for specialties
        pane.getChildren().addAll(specialtyLabel,doctorLabel,dateLabel,timeLabel);
        ComboBox specialtyBox = new ComboBox();
        Specialty diabetes = new Specialty("Diabetes");
        Specialty skin = new Specialty("Skin");
        Specialty eyes = new Specialty("Eyes");
        Specialty ear = new Specialty("Ear");
        Specialty general = new Specialty("General");
        specialtyBox.getItems().addAll(diabetes.getName(),skin.getName(),eyes.getName(),ear.getName(),general.getName());
        specialtyBox.relocate(250, 108);
        pane.getChildren().add(specialtyBox);

        //Combobox for Doctors
        //DE DOKTER COMBOBOX FILTERT NOG NIET OP SPECIALTIES!!!
        ComboBox doctorBox = new ComboBox();
        for(int i = 0; i < Doctor.getDoctors().size(); i++){
                doctorBox.getItems().add(Doctor.getDoctors().get(i).getName());
        }
        doctorBox.relocate(250, 157);
        pane.getChildren().add(doctorBox);

        //Combobox for dates
        ComboBox dateBox = new ComboBox();

        dateBox.relocate(250, 207);
        pane.getChildren().add(dateBox);
        //Combobox for times
        ComboBox timeBox = new ComboBox();

        timeBox.relocate(250, 260);
        pane.getChildren().add(timeBox);

        Button makeAppointment = new Button("Make appointment");
        makeAppointment.setOnKeyPressed(E -> {
            Appointment newAppointment = new Appointment((Doctor) doctorBox.getValue(), (Date) specialtyBox.getValue(), (Time) timeBox.getValue());
            goBack(stage);
        });
        pane.getChildren().add(makeAppointment);

        makeAppointmentScene = new Scene(pane, 800, 600);
        stage.setTitle("Make appointment here");
        stage.setScene(makeAppointmentScene);
        stage.show();
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

    public void goBack(Stage stage) {
        MedicalSection medicalSection = new MedicalSection();
        try {
            medicalSection.start(stage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
