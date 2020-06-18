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
import sample.ButtonSettings;
import sample.GoToScreens;
import sample.MedicalSection.Doctor;
import sample.MedicalSection.Specialty;
import sample.educative.read.tenseScreens.IrregularWords.MakeArrayListsText;

import java.util.ArrayList;

public class SignUpScreenDoctor extends Application { //todo SOLID maken
    ArrayKeeper arraykeeper = new ArrayKeeper();
    GoToScreens goToScreens = GoToScreens.getInstance();
    //ButtonSettings buttonSettings = ButtonSettings.getInstance();
    Scene SignUpScreenDoctor;
    Main main;
    Pane pane = new Pane();
    TextField textFieldUsername = new TextField();
    PasswordField passwordField = new PasswordField();
    PasswordField passwordFieldConf = new PasswordField();
    TextField doctorName = new TextField("");
    TextField textFieldBirth = new TextField();
    TextField securityAnswer = new TextField();
    ComboBox securityQuestions = new ComboBox();
    ComboBox<String> specialty1 = new ComboBox<>();
    ArrayList<Specialty> specialties = new ArrayList<>();
    ArrayList<Specialty> allSpecialties = arraykeeper.getSpecialtiesArrayList();
    Label doctorNameText = new Label("Your real name");


    @Override
    public void start(Stage stage) throws Exception {

        makeButtons(stage);
        makeLabels();
        fin(stage);
    }
    public void setTextTextfields(){
        securityQuestions.getItems().addAll("What is your favorite color?","What was the name of your first pet?","What was your first city of residence?");
        textFieldUsername.relocate(100,70);
        passwordField.relocate(100,115);
        passwordFieldConf.relocate(100,160);
        textFieldBirth.relocate(100,205);
        securityQuestions.relocate(100,250);
        securityAnswer.relocate(100, 278);
        pane.getChildren().addAll(textFieldUsername, passwordField,passwordFieldConf, textFieldBirth, securityAnswer, securityQuestions);

    }
    public void makeButtons(Stage stage){
        makeButtonback(stage);
        makeButtonSignUp(stage);
        makeAddSpecialty(stage);
    }
    public void makeButtonback(Stage stage){
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
        ButtonSettings.onMouse(exitBtn);
    }
    public void makeButtonSignUp(Stage stage){
        Button signUp = new Button("Sign up");
        signUp.relocate(600,200);
        signUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String[] doctorData = {textFieldUsername.getText(),doctorNameText.getText(),passwordField.getText(),textFieldBirth.getText(),
                        securityQuestions.getValue().toString(),securityAnswer.getText()};
                Doctor.makeDoctor(doctorData,specialties
                );
                goToScreens.goMain(stage);
            }
        });
        signUp.setPrefWidth(75);
    }
    public void makeLabels(){
        makeLabelsSecurity();
        MakeLabelsPassword();
        makeLabelPersonData();
        }
        public void makeLabelPersonData(){
            Label specialtyText=new Label("What are your specialties?");
            Label ErrorMessage=new Label("");
            Label labelUsername=new Label("Username");
            Label labelBirth=new Label("Date of birth");
            labelUsername.relocate(100,50);
            labelBirth.relocate(100,185);
            ErrorMessage.relocate(100,265);
            specialtyText.relocate(100,348);
            pane.getChildren().addAll(ErrorMessage,labelUsername,labelBirth,specialtyText);
        }
        public void MakeLabelsPassword(){
            Label labelPassword=new Label("Password");
            Label labelPasswordConf=new Label("Confirm password");
            labelPassword.relocate(100,95);
            labelPasswordConf.relocate(100,140);
            pane.getChildren().addAll(labelPassword,labelPasswordConf);
        }
        public void makeLabelsSecurity(){
            Label labelSecurity=new Label("Security question in case you forget your password");
            labelSecurity.relocate(100,230);
            for (int i = 0; i < arraykeeper.getSpecialtiesArrayList().size(); i++) {
                specialty1.getItems().add(arraykeeper.getSpecialtiesArrayList().get(i).getName());
            }
            pane.getChildren().add(labelSecurity);
        }
    public void makeAddSpecialty(Stage stage) {
        Button addSpecialty = new Button("add");
        addSpecialty.relocate(250, 368);
        addSpecialty.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            addsSpecialtybtn();
            }
        });
        pane.getChildren().add(addSpecialty);
        ButtonSettings.onMouse(addSpecialty);
    }
    public void addsSpecialtybtn(){
        Boolean alreadyHave = false;
        if (specialties.size() == 0) {
            addsSpecialty();
        } else {
            makeError(alreadyHave);
            saveData(alreadyHave);
        }
    }
    public void addsSpecialty(){
        for (int i = 0; i < allSpecialties.size(); i++) {
            if (specialty1.getValue().equals(allSpecialties.get(i).getName())) {
                specialties.add(allSpecialties.get(i));
            }
        }
    }
    public void makeError(boolean alreadyHave) {
        for (int j = 0; j < specialties.size(); j++) {
            if (specialties.get(j).getName().equals(specialty1.getValue())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You already have this specialty!");
                alert.show();
                alreadyHave = true;
            }
        }
    }
    public void saveData(boolean alreadyHave){
        if (alreadyHave == false) {
            for (int i = 0; i < allSpecialties.size(); i++) {
                if (allSpecialties.get(i).getName().equals(specialty1.getValue())) {
                    specialties.add(allSpecialties.get(i));
                }
            }
        }
    }
    public void fillComboBox(){
        for (int i = 0; i < arraykeeper.getSpecialtiesArrayList().size(); i++) {
            specialty1.getItems().add(arraykeeper.getSpecialtiesArrayList().get(i).getName());
        }
    }
    public void makeTextFields(){
        specialty1.setValue("");
        specialty1.relocate(100,368);
        doctorName.relocate(100,323);
        doctorNameText.relocate(100,303);
        pane.getChildren().addAll( specialty1, doctorName, doctorNameText);
    }

    public void fin(Stage stage){
        SignUpScreenDoctor = new Scene(pane, 800, 600);
        stage.setTitle("Sign up as doctor");
        stage.setScene(SignUpScreenDoctor);
        stage.show();}
}
