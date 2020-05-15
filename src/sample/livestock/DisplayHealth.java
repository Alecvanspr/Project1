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
import sample.Homescreen;

public class DisplayHealth extends Application {
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    Scene healthScene;
    ScrollPane healthScroll = new ScrollPane();
    Pane healthPane = new Pane();
    public int plaats = 100;
    int currentAnimal;
    int currentUser;

    @Override
    public void start(Stage stage) throws Exception{
        Button btnBack = new Button("Back");
        btnBack.relocate(0,565);
        Label NameAnimal = new Label("Animal : "+arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).getName());
        Button btnAdd = new Button("Add new health check");
        Label lblDateAnouncement = new Label("Date check");
        Label lblHealthAnouncement = new Label("Health situation");
        ShowHealth();

        NameAnimal.relocate(100,45);
        btnAdd.relocate(300,45);
        lblHealthAnouncement.relocate(100,80);
        lblDateAnouncement.relocate(300,80);

        btnAdd.setOnAction(E->{
            goHealthCheck(stage);
                });

        btnBack.setOnAction(E->{
            goBack(stage);
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


        healthPane.getChildren().addAll(btnBack,NameAnimal,lblDateAnouncement,lblHealthAnouncement,btnAdd);
        healthScroll.setContent(healthPane);
        healthScene = new Scene(healthScroll,800,600);
        stage.setTitle("Health of "+ arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).getName());
        stage.setScene(healthScene);
        stage.show();
    }
    public DisplayHealth(int currentAnimal,int CurrentUser){
        this.currentAnimal = currentAnimal;
        this.currentUser = CurrentUser;
    }
    public void goBack(Stage stage){
        Livestock livestock = new Livestock();
        try {
            livestock.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goHealthCheck(Stage stage){
        AddHeathCheck addHeathCheck = new AddHeathCheck(currentAnimal);
        try {
            addHeathCheck.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void ShowHealth(){
        for(int i = 0; i<arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).getHealth().size(); i++){
            Label Health = new Label(arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).getHealth().get(i));
            Label CheckDate = new Label(arrayKeeper.getPersonaldata().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).getDateHealth(i));
            Health.relocate(300, plaats);
            CheckDate.relocate(100,plaats);
            plaats = plaats+35;
            healthPane.getChildren().addAll(CheckDate,Health);
        }
    }
}
