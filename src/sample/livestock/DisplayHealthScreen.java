package sample.livestock;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.ButtonSettings;
import sample.GoToScreens;

public class DisplayHealthScreen extends Application {
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    ButtonSettings buttonSettings =ButtonSettings.getInstance();
    GoToScreens goToScreens = new GoToScreens();
    Scene healthScene;
    ScrollPane healthScroll = new ScrollPane();
    Pane healthPane = new Pane();
    public int plaats = 100;
    int currentAnimal;
    int currentUser;

    @Override
    public void start(Stage stage) throws Exception{
        makeBtnAdd(stage);
        makeBtnback(stage);
        makeLabels();
        ShowHealth();
        fin(stage);
    }
    public void fin(Stage stage){
        healthScroll.setContent(healthPane);
        healthScene = new Scene(healthScroll,800,600);
        stage.setTitle("Health of "+ arrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).getName());
        stage.setScene(healthScene);
        stage.show();
    }
    public void makeLabels(){
        Label NameAnimal = new Label("Animal : "+arrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).getName());
        Label lblDateAnouncement = new Label("Date check");
        Label lblHealthAnouncement = new Label("Health situation");
        NameAnimal.relocate(100,45);
        lblHealthAnouncement.relocate(100,80);
        lblDateAnouncement.relocate(300,80);
        healthPane.getChildren().addAll(NameAnimal,lblDateAnouncement,lblHealthAnouncement);
    }
    public void makeBtnAdd(Stage stage){
        Button btnAdd = new Button("Add new health check");
        btnAdd.relocate(300,45);
        btnAdd.setOnAction(E->{
            goToScreens.goAddHealthCheck(stage,currentAnimal);
        });
        buttonSettings.onMouse(btnAdd);
        healthPane.getChildren().add(btnAdd);
    }
    public void makeBtnback(Stage stage){
        Button btnBack = new Button("Back");
        btnBack.relocate(0,565);
        buttonSettings.onMouse(btnBack);
        btnBack.setOnAction(E->{
            goToScreens.goLiveStock(stage);
        });
        healthPane.getChildren().add(btnBack);
    }
    public DisplayHealthScreen(int currentAnimal, int CurrentUser){
        this.currentAnimal = currentAnimal;
        this.currentUser = CurrentUser;
    }

    public void ShowHealth(){
        for(int i = 0; i<arrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).getHealth().size(); i++){
            Label Health = new Label(arrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).getHealth().get(i));
            Label CheckDate = new Label(arrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).getDateHealth(i));
            Health.relocate(300, plaats);
            CheckDate.relocate(100,plaats);
            plaats = plaats+35;
            healthPane.getChildren().addAll(CheckDate,Health);
        }
    }
}
