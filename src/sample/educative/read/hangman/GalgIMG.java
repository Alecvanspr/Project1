package sample.educative.read.hangman;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class GalgIMG extends Parent {
    private int galgStartX = 100;
    private int galgStartY = 20;
    private int galgEndX = galgStartX;
    private int galgEndY = galgStartY+50;

    Circle head = new Circle(20);
    Line body = new Line();
    Line leftArm = new Line();
    Line rightArm = new Line();
    Line leftLeg = new Line();
    Line rightLeg = new Line();

    public SimpleIntegerProperty tries = new SimpleIntegerProperty();
    public GalgIMG(){
        makeHead();
        makeBody();
        makeLeftArm();
        makeRightArm();
        makeLeftLeg();
        makeRightLeg();

        getChildren().addAll(head,body,leftArm,rightArm,leftLeg,rightLeg);
        tries.set(getChildren().size());
    }
    public void reset(){
        getChildren().forEach(node -> node.setVisible(false));
        tries.set(getChildren().size());
    }
    public void takeAwayTry(){
        for(Node n : getChildren()){
            if(!n.isVisible()){
                n.setVisible(true);
                tries.set(tries.get()-1);
                break;
            }
        }
    }
    public void makeHead(){
        head.setTranslateX(galgStartX);
    }
    public void makeBody(){
        body.setStartX(galgStartX);
        body.setStartY(galgStartY);
        body.setEndX(galgEndX);
        body.setEndY(galgEndY);
    }
    public void makeRightArm(){
        rightArm.setStartX(galgStartX);
        rightArm.setStartY(galgStartY);
        rightArm.setEndX(galgEndX-40);
        rightArm.setEndY(galgEndY+10);
    }
    public void makeLeftArm(){
        leftArm.setStartX(galgStartX);
        leftArm.setStartY(galgStartY);
        leftArm.setEndX(galgEndX+40);
        leftArm.setEndY(galgEndY+10);
    }
    public void makeRightLeg(){
        rightLeg.setStartX(galgEndX);
        rightLeg.setStartY(galgEndY);
        rightLeg.setEndX(galgEndX-25);
        rightLeg.setEndY(galgEndY+50);
    }
    public void makeLeftLeg(){
        leftLeg.setStartX(galgEndX);
        leftLeg.setStartY(galgEndY);
        leftLeg.setEndX(galgEndX+25);
        leftLeg.setEndY(galgEndY+50);
    }
}
