package sample;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ButtonSettings {
    private static ButtonSettings instance;
    private ButtonSettings(){
    }
    public static ButtonSettings getInstance(){
        if(instance==null) {
            instance=new ButtonSettings();
        }
        return instance;
    }
    public static void onMouse(Button button) {
        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button.setScaleX(1.2);
                button.setScaleY(1.2);

            }
        });
        button.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button.setScaleX(1);
                button.setScaleY(1);

            }
        });
    }
    public static void setButtonLayout(Button button){
        button.setPrefHeight(150);
        button.setPrefWidth(150);
    }
}
