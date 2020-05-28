package sample.educative;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class WriteWordsScreen extends Application {

    Pane pane = new Pane();
    Scene scene = new Scene(pane, 800, 600);
    GetImage getImage = new GetImage();
    Text target;
    Button source;
    ImageView iv;
    Image image;

    @Override
    public void start(Stage stage) throws Exception {
        source = new Button("Dragging");
        source.setScaleX(2.0);
        source.setScaleY(2.0);

        target = new Text(250, 100, "Drop answer here");
        target.setScaleX(2.0);
        target.setScaleY(2.0);

        makeBackGround();
        Button btnBack = new Button("back");
        Button btnNewPic = new Button("new animal1");
        btnBack.relocate(0, 575);
        btnBack.setOnAction(E -> {
            goBack(stage);
        });
        btnNewPic.setOnAction(e->{
            makeBackGround();
        });

       //hieronder begint het
        source.setOnMouseDragged(e->{
            source.setLayoutX(e.getSceneX());
            source.setLayoutY(e.getSceneY());
        });


        source.setOnMouseDragged(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent event) {
                // drag was detected, start drag-and-drop gesture
                System.out.println("onDragDetected");

                // allow any transfer mode
                Dragboard db = source.startDragAndDrop(TransferMode.MOVE);

                // put a string on dragboard
                ClipboardContent content = new ClipboardContent();
                content.putString(source.getText());
                db.setContent(content);

                event.consume();
            }
        });


        target.setOnDragOver(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* data is dragged over the target */
                System.out.println("onDragOver");

                /* accept it only if it is  not dragged from the same node
                 * and if it has a string data */
                if (event.getGestureSource() != target &&
                        event.getDragboard().hasString()) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }

                event.consume();
            }
        });

        target.setOnDragEntered(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture entered the target */
                System.out.println("onDragEntered");
                /* show to the user that it is an actual gesture target */
                if (event.getGestureSource() != target &&
                        event.getDragboard().hasString()) {
                    target.setFill(Color.GREEN);
                }

                event.consume();
            }
        });

        target.setOnDragExited(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* mouse moved away, remove the graphical cues */
                target.setFill(Color.BLACK);

                event.consume();
            }
        });

        target.setOnDragDropped(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* data dropped */
                System.out.println("onDragDropped");
                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    target.setText(db.getString());
                    success = true;
                }
                /* let the source know whether the string was successfully
                 * transferred and used */
                event.setDropCompleted(success);

                event.consume();
            }
        });

        source.setOnDragDone(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                System.out.println("onDragDone");
                /* if the data was successfully moved, clear it */
                if (event.getTransferMode() == TransferMode.MOVE) {
                    source.setText("");
                }

                event.consume();
            }
        });

        //hier eindigd het

        pane.getChildren().addAll(btnBack, btnNewPic,source,target);

        stage.setTitle("Write words screen");
        stage.setScene(scene);
        stage.show();
    }

    public void goBack(Stage stage) {
        WriteMainScreen writeMainScreen = new WriteMainScreen();
        try {
            writeMainScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void makeBackGround() {
        pane.getChildren().remove(iv);
        Random random = new Random();
        int rng = random.nextInt(getImage.animalImages.size() - 1);
        int randomAnswer1 = random.nextInt(getImage.animalImages.size() - 1);
        int randomAnswer2 = random.nextInt(getImage.animalImages.size() - 1);
        target = new Text(250, 100, "Drop answer here");
        source.setText(getImage.animalImages.get(rng).getName());
        source.relocate(500,100);
        image = getImage.animalImages.get(rng).getImage();
        iv = new ImageView();
        iv.setImage(image);
        iv.setPreserveRatio(true);
        iv.setFitHeight(300);
        iv.relocate(350,250);
        pane.getChildren().add(iv);
    }
}
