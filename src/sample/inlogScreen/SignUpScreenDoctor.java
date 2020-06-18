package sample.inlogScreen;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.GoToScreens;
import sample.MedicalSection.Doctor;
import sample.MedicalSection.Specialty;

import java.util.ArrayList;

public class SignUpScreenDoctor extends Application { //todo SOLID maken
    GoToScreens goToScreens = GoToScreens.getInstance();
    Scene SignUpScreenDoctor;
    Main main;
    ArrayKeeper arraykeeper = new ArrayKeeper();

    @Override
    public void start(Stage stage) throws Exception{
        Pane pane = new Pane();
        //Button not doctor
        Button exitBtn = new Button("Im actually not a doctor");
        exitBtn.setPrefWidth(150);
        exitBtn.relocate(10, 565);

        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                goToScreens.goSignUp(stage);
            }
        });
        pane.getChildren().add(exitBtn);



        TextField textFieldUsername = new TextField();
        PasswordField passwordField = new PasswordField();
        PasswordField passwordFieldConf = new PasswordField();
        TextField textFieldBirth = new TextField();
        TextField securityAnswer = new TextField();
        ComboBox securityQuestions = new ComboBox();
        Label ErrorMessage = new Label("");
        Label labelUsername = new Label("Username");
        Label labelPassword = new Label("Password");
        Label labelPasswordConf = new Label("Confirm password");
        Label labelBirth = new Label("Date of birth");
        Label labelSecurity = new Label("Security question in case you forget your password");
        securityQuestions.getItems().addAll("What is your favorite color?","What was the name of your first pet?","What was your first city of residence?");
        textFieldUsername.relocate(100,70);
        passwordField.relocate(100,115);
        passwordFieldConf.relocate(100,160);
        textFieldBirth.relocate(100,205);
        securityQuestions.relocate(100,250);
        securityAnswer.relocate(100, 278);
        pane.getChildren().addAll(textFieldUsername, passwordField,passwordFieldConf, textFieldBirth, securityAnswer, ErrorMessage, labelUsername,
                labelPassword, labelPasswordConf, labelBirth, labelSecurity, securityQuestions);

        labelUsername.relocate(100,50);
        labelSecurity.relocate(100,230);
        labelPassword.relocate(100,95);
        labelBirth.relocate(100,185);
        labelPasswordConf.relocate(100, 140);
        ErrorMessage.relocate(100,265);

        //comboboxes for specialty
        Label specialtyText = new Label("What are your specialties?");
        ComboBox<String> specialty1 = new ComboBox<>();
        for(int i = 0; i < arraykeeper.getSpecialtiesArrayList().size(); i++){
            specialty1.getItems().add(arraykeeper.getSpecialtiesArrayList().get(i).getName());
        }
        ArrayList<Specialty> specialties = new ArrayList<>();
        Button addSpecialty = new Button("add");
        addSpecialty.relocate(250,368);
        ArrayList<Specialty> allSpecialties = arraykeeper.getSpecialtiesArrayList();
        addSpecialty.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent){
                Boolean alreadyHave = false;
                if(specialties.size() == 0){
                    for(int i = 0; i < allSpecialties.size(); i++){
                        if(specialty1.getValue().equals(allSpecialties.get(i).getName())){
                            specialties.add(allSpecialties.get(i));
                        }
                    }
                }else{
                    for(int j = 0; j < specialties.size(); j++){
                        if (specialties.get(j).getName().equals(specialty1.getValue())){
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setContentText("You already have this specialty!");
                            alert.show();
                            alreadyHave = true;
                        }
                    }
                    if(alreadyHave == false){
                        for(int i = 0; i < allSpecialties.size(); i++){
                            if(allSpecialties.get(i).getName().equals(specialty1.getValue())){
                                specialties.add(allSpecialties.get(i));
                            }
                        }
                    }
                }
                specialty1.setValue("");
            }
        });
        specialtyText.relocate(100, 348);
        specialty1.relocate(100, 368);
        //Docter name
        TextField doctorName = new TextField("");
        doctorName.relocate(100, 323);
        Label doctorNameText = new Label("Your real name");
        doctorNameText.relocate(100, 303);
        //registerButton
        Button signUp = new Button("Sign up");
        signUp.relocate(600, 200);
        signUp.setPrefWidth(75);
        pane.getChildren().addAll(addSpecialty, specialty1, specialtyText,doctorName, doctorNameText, signUp);


        signUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String[] doctorData = {textFieldUsername.getText(),doctorNameText.getText(),passwordField.getText(),textFieldBirth.getText(),
                        securityQuestions.getValue().toString(),securityAnswer.getText()};
                Doctor.makeDoctor(doctorData,specialties
                );

                Main main = new Main();
                try {
                    main.start(stage);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });
    }
    public void fin(Stage stage){
        SignUpScreenDoctor = new Scene(pane, 800, 600);
        stage.setTitle("Sign up as doctor");
        stage.setScene(SignUpScreenDoctor);
        stage.show();}
}
