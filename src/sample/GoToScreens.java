package sample;

import javafx.stage.Stage;
import sample.profileSettings.ProfileSettingsScreen;

public class GoToScreens {
    public void goProfileSettingScreen(Stage stage){
        ProfileSettingsScreen profileSettingsScreen = new ProfileSettingsScreen();
        try {
            profileSettingsScreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
