package sample.educative;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class WriteWordsCards {

    ArrayList<FlashCards> imageFlashcards = new ArrayList<>();
    GetImage getImage = new GetImage();

    public WriteWordsCards(){
        linkImagesWNames();
    }

    public void linkImagesWNames(){
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(0)),
                        "alligator"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(1)),
                "bear"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(2)),
                "bird"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(3)),
                "cat"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(4)),
                "chicken"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(5)),
                "cow"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(6)),
                "dog"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(7)),
                "duck"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(8)),
                "elephant"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(9)),
                "fish"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(10)),
                "fox"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(11)),
                "frog"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(12)),
                "giraffe"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(13)),
                "goat"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(14)),
                "hamster"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(15)),
                "hippo"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(16)),
                "horse"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(17)),
                "kangaroo"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(18)),
                "koala"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(19)),
                "lion"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(20)),
                "monkey"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(21)),
                "mouse"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(22)),
                "octopus"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(23)),
                "panda"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(24)),
                "penguin"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(25)),
                "pig"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(26)),
                "rabbit"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(27)),
                "rhino"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(28)),
                "seal"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(29)),
                "shark"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(30)),
                "sheep"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(31)),
                "snake"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(32)),
                "squirrel"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(33)),
                "tiger"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(34)),
                "turtle"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(35)),
                "walrus"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(36)),
                "whale"));
        imageFlashcards.add(new FlashCards(new Image(getImage.getAnimalImage(37)),
                "zebra"));

    }


}
