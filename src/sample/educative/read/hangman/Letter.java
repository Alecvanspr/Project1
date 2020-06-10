package sample.educative.read.hangman;

import javafx.animation.RotateTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Letter extends StackPane {
    private Rectangle bg = new Rectangle(40,60);
    private Text text;

    public Letter(char letter){
        bg.setFill(Color.WHITE);
        bg.setStroke(Color.BLUE);

        text = new Text(String.valueOf(letter).toUpperCase());
        text.setFont(HangmanScreen.segoeButBigger);
        text.setVisible(false);

        setAlignment(Pos.CENTER);
        getChildren().addAll(bg,text);
    }
    public void show(){
        RotateTransition rt = new RotateTransition(Duration.seconds(1), bg);
        rt.setAxis(Rotate.Y_AXIS);
        rt.setToAngle(180);
        rt.setOnFinished(event -> text.setVisible(true));
        rt.play();
    }
    public boolean isEqualTo(char other){
        return text.getText().equals(String.valueOf(other).toUpperCase());
    }
}

