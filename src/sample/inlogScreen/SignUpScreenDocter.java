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
import sample.Homescreen;
import sample.MedicalSection.Docter;
import sample.MedicalSection.Specialty;

import java.util.ArrayList;

public class SignUpScreenDocter extends Application {
    Scene SignUpScreenDocter;
    Main main;
    ArrayKeeper arraykeeper = new ArrayKeeper();

    @Override
    public void start(Stage stage) throws Exception{
        Pane pane = new Pane();
        //Button not docter
        Button exitBtn = new Button("Im actually not a docter");
        exitBtn.setPrefWidth(150);
        exitBtn.relocate(10, 565);
        exitBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScale(exitBtn, 1.2);
            }
        });
        exitBtn.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScale(exitBtn, 1.0);
            }
        });
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main main = new Main();
                try {
                    main.start(stage);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        pane.getChildren().add(exitBtn);
        //comboboxes for specialty
        Label specialtyText = new Label("What are your specialty's?");
        ComboBox<String> specialty1 = new ComboBox<String>();
        for(int i = 0; i < arraykeeper.specialtiesArrayList.size(); i++){
            specialty1.getItems().add(arraykeeper.specialtiesArrayList.get(i).getName());
        }
        ArrayList<Specialty> specialties = new ArrayList<>();
        Button addSpecialty = new Button("add");
        addSpecialty.relocate(400,100);
        ArrayList<Specialty> allSpecialties = arraykeeper.specialtiesArrayList;
        addSpecialty.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
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
                            alert.setContentText("You already have this Specialty!");
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
        specialtyText.relocate(300, 75);
        specialty1.relocate(300, 100);
        //Docter name
        TextField docterName = new TextField("");
        docterName.setPrefWidth(150);
        docterName.relocate(100, 100);
        Label docterNameText = new Label("Type here your docter name");
        docterNameText.setFont(Font.font("Aral", 15));
        docterNameText.relocate(100, 75);
        //registerButton
        Button register = new Button("Register");
        register.relocate(200, 200);
        register.setPrefWidth(75);
        pane.getChildren().addAll(addSpecialty, specialty1, specialtyText,docterName, docterNameText, register);

        register.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScale(register, 1.0);
            }
        });
        register.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonScale(register, 1.2);
            }
        });
        register.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Docter docter = new Docter(docterName.getPromptText(), ArrayKeeper.getCurrentUser(), specialties);
                Main main = new Main();
                try {
                    main.start(stage);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });
        SignUpScreenDocter = new Scene(pane, 800, 600);
        stage.setTitle("Register as docter");
        stage.setScene(SignUpScreenDocter);
        stage.show();
    }

    public void setButtonScale(Button button, Double scale){
        button.setScaleY(scale);
        button.setScaleX(scale);
    }
}
