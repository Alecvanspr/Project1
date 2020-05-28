package sample.educative;

import javafx.scene.image.Image;

public class FlashCards {

    private Image image;
    private String name;

    public FlashCards(Image image, String name){
        this.image = image;
        this.name = name;
    }

    public Image getImage() {
        return image;
    }
    public String getName() {
        return name;
    }
}
