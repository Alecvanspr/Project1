package sample.MedicalSection;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import sample.ArrayKeeper;
import javafx.application.Application;
import javafx.stage.Stage;
import sample.inlogScreen.Main;


public class ShowAppointmentsScreen extends Application {
    Scene showAppointmentsScene;
    Main main;
    ArrayKeeper arrayKeeper;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane rootPane = new Pane();
        final int PaneWidth = 800;
        final int PaneHeight = 600;
        rootPane.setMinSize(PaneWidth, PaneHeight);

        Scene scene1 = new Scene(rootPane);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Your appointments");
        primaryStage.show();
        for(int i = 0; i < ArrayKeeper.Data.get(ArrayKeeper.getCurrentUser()).getAppointments().size(); i++){
            System.out.println(ArrayKeeper.Data.get(ArrayKeeper.getCurrentUser()).getAppointments().get(i).getDoctor());
        }
        Button buttonBack = new Button("Go back");
        buttonBack.setOnMouseClicked(E -> {
            MedicalSection medicalSection = new MedicalSection();
            try {
                medicalSection.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}
