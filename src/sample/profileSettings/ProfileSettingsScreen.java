package sample.profileSettings;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.Homescreen;


public class ProfileSettingsScreen extends Application {
    Homescreen homescreen = new Homescreen();
    Scene Settings;
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    public int currentUser= ArrayKeeper.getCurrentUser();

    public void start(Stage stage) throws Exception{
        Label textName = new Label("Username : " + ArrayKeeper.Data.get(currentUser).getUsername());
        Label txtRealName = new Label("Name : " + ArrayKeeper.Data.get(currentUser).getName());
        Label txtBirthDate = new Label("Birth date : "+ArrayKeeper.Data.get(currentUser).getBirthDate());
        Label textGender = new Label("Gender :" + ArrayKeeper.Data.get(currentUser).getGender());
        Label textPhonenumber = new Label("Phone number : " + ArrayKeeper.Data.get(currentUser).getPhoneNumber());
        Button btnBack = new Button("Back");
        Button btnEdit = new Button("Edit Profile");
        Pane pSettings = new Pane();
        pSettings.getChildren().addAll( btnBack,btnEdit,textName,txtRealName,txtBirthDate,textGender,textPhonenumber);

        textName.relocate(100,100);
        txtRealName.relocate(100,125);
        txtBirthDate.relocate(100,150);
        textGender.relocate(100,175);
        textPhonenumber.relocate(100,200);

        if(arrayKeeper.getPersonaldata().get(currentUser).getIsDocter()){
            Label doctorStart = new Label("Docter info");
            doctorStart.setFont(Font.font("Arail", 20));
            doctorStart.relocate(300, 100);
            Label doctorName = new Label("Name: " + arrayKeeper.getPersonaldata().get(currentUser).getDocter().getName());
            doctorName.relocate(300, 125);
            Label specialtiesLabel = new Label("Specialty's ");
            specialtiesLabel.relocate(300, 150);
            for (int i = 0; i < arrayKeeper.getPersonaldata().get(currentUser).getDocter().getSpecialties().size(); i++){
                Label label = new Label(arrayKeeper.getPersonaldata().get(currentUser).getDocter().getSpecialties().get(i).getName());
                label.relocate(300, 175+(25*i));
                pSettings.getChildren().addAll(label);
            }
            pSettings.getChildren().addAll(doctorName,specialtiesLabel);


        }
        btnBack.relocate(0,570);
        btnBack.setOnAction(e -> {
            goHomeScreen(stage);
        });

        btnEdit.relocate(100,235);
        btnEdit.setOnAction(e -> {
            goEdit(stage);
        });

        btnBack.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnBack.setScaleX(1.2);
                btnBack.setScaleY(1.2);

            }
        });
        btnBack.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnBack.setScaleX(1);
                btnBack.setScaleY(1);

            }
        });

        Settings = new Scene(pSettings,800,600);
        stage.setTitle("Profile settings");
        stage.setScene(Settings);
        stage.show();
    }
    public void goHomeScreen(Stage stage){
        Homescreen homescreen = new Homescreen();
        try {
            homescreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goEdit(Stage stage){
        EditSettingsScreen editSettingsScreen = new EditSettingsScreen();
        try {
            editSettingsScreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
