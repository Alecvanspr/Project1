package sample;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ButtonSettings {
    public void onMouse(Button button) {
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
    public void setButtonLayout(Button button){
        button.setPrefHeight(100);
        button.setPrefWidth(100);
    }
}
