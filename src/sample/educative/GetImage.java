package sample.educative;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class GetImage {
    ArrayList<String> letterImages = new ArrayList<>();
    ArrayList<String> numberImages = new ArrayList<>();
    ArrayList<FlashCards> animalImages = new ArrayList<>();
    public GetImage(){
        setLetterImages();
        setNumberImages();
        setAnimalImages();
    }
    public void setNumberImages(){
        numberImages.add("images/education/Numbers/0.jpg");
        numberImages.add("images/education/Numbers/1.jpg");
        numberImages.add("images/education/Numbers/2.jpg");
        numberImages.add("images/education/Numbers/3.jpg");
        numberImages.add("images/education/Numbers/4.jpg");
        numberImages.add("images/education/Numbers/5.jpg");
        numberImages.add("images/education/Numbers/6.jpg");
        numberImages.add("images/education/Numbers/7.jpg");
        numberImages.add("images/education/Numbers/8.jpg");
        numberImages.add("images/education/Numbers/9.jpg");
    }
    public void setLetterImages(){
        letterImages.add("images/education/Uppercase/DrawA.png");
        letterImages.add("images/education/Lowercase/DrawLowera.png");
        letterImages.add("images/education/Uppercase/DrawB.png");
        letterImages.add("images/education/Lowercase/DrawLowerb.png");
        letterImages.add("images/education/Uppercase/DrawC.png");
        letterImages.add("images/education/Lowercase/DrawLowerc.png");
        letterImages.add("images/education/Uppercase/DrawD.png");
        letterImages.add("images/education/Lowercase/DrawLowerd.png");
        letterImages.add("images/education/Uppercase/DrawE.png");
        letterImages.add("images/education/Lowercase/DrawLowere.png");
        letterImages.add("images/education/Uppercase/DrawF.png");
        letterImages.add("images/education/Lowercase/DrawLowerf.png");
        letterImages.add("images/education/Uppercase/DrawG.png");
        letterImages.add("images/education/Lowercase/DrawLowerg.png");
        letterImages.add("images/education/Uppercase/DrawH.png");
        letterImages.add("images/education/Lowercase/DrawLowerh.png");
        letterImages.add("images/education/Uppercase/DrawI.png");
        letterImages.add("images/education/Lowercase/DrawLoweri.png");
        letterImages.add("images/education/Uppercase/DrawJ.png");
        letterImages.add("images/education/Lowercase/DrawLowerj.png");
        letterImages.add("images/education/Uppercase/DrawK.png");
        letterImages.add("images/education/Lowercase/DrawLowerk.png");
        letterImages.add("images/education/Uppercase/DrawL.png");
        letterImages.add("images/education/Lowercase/DrawLowerl.png");
        letterImages.add("images/education/Uppercase/DrawM.png");
        letterImages.add("images/education/Lowercase/DrawLowerm.png");
        letterImages.add("images/education/Uppercase/DrawN.png");
        letterImages.add("images/education/Lowercase/DrawLowern.png");
        letterImages.add("images/education/Uppercase/DrawO.png");
        letterImages.add("images/education/Lowercase/DrawLowero.png");
        letterImages.add("images/education/Uppercase/DrawP.png");
        letterImages.add("images/education/Lowercase/DrawLowerp.png");
        letterImages.add("images/education/Uppercase/DrawQ.png");
        letterImages.add("images/education/Lowercase/DrawLowerq.png");
        letterImages.add("images/education/Uppercase/DrawR.png");
        letterImages.add("images/education/Lowercase/DrawLowerr.png");
        letterImages.add("images/education/Uppercase/DrawS.png");
        letterImages.add("images/education/Lowercase/DrawLowers.png");
        letterImages.add("images/education/Uppercase/DrawT.png");
        letterImages.add("images/education/Lowercase/DrawLowert.png");
        letterImages.add("images/education/Uppercase/DrawU.png");
        letterImages.add("images/education/Lowercase/DrawLoweru.png");
        letterImages.add("images/education/Uppercase/DrawV.png");
        letterImages.add("images/education/Lowercase/DrawLowerv.png");
        letterImages.add("images/education/Uppercase/DrawW.png");
        letterImages.add("images/education/Lowercase/DrawLowerw.png");
        letterImages.add("images/education/Uppercase/DrawX.png");
        letterImages.add("images/education/Lowercase/DrawLowerx.png");
        letterImages.add("images/education/Uppercase/DrawY.png");
        letterImages.add("images/education/Lowercase/DrawLowery.png");
        letterImages.add("images/education/Uppercase/DrawZ.png");
        letterImages.add("images/education/Lowercase/DrawLowerz.png");
        letterImages.add("images/education/Draw!.jpg");
        letterImages.add("images/education/DrawQuestionMark.jpg");
    }

    public void setAnimalImages() {
        animalImages.add(makeFlashCard("images/education/Animals/alligator.png","alligator"));
        animalImages.add(makeFlashCard("images/education/Animals/bear.png","bear"));
        animalImages.add(makeFlashCard("images/education/Animals/bird.png","bird"));
        animalImages.add(makeFlashCard("images/education/Animals/cat.png","cat"));
        animalImages.add(makeFlashCard("images/education/Animals/chicken.png","chicken"));
        animalImages.add(makeFlashCard("images/education/Animals/cow.png","cow"));
        animalImages.add(makeFlashCard("images/education/Animals/dog.png","dog"));
        animalImages.add(makeFlashCard("images/education/Animals/duck.png","duck"));
        animalImages.add(makeFlashCard("images/education/Animals/elephant.png","elephant"));
        animalImages.add(makeFlashCard("images/education/Animals/fish.png","fish"));
        animalImages.add(makeFlashCard("images/education/Animals/fox.png","fox"));
        animalImages.add(makeFlashCard("images/education/Animals/frog.png","frog"));
        animalImages.add(makeFlashCard("images/education/Animals/giraffe.png","giraffe"));
        animalImages.add(makeFlashCard("images/education/Animals/goat.png","goat"));
        animalImages.add(makeFlashCard("images/education/Animals/hamster.png","hamster"));
        animalImages.add(makeFlashCard("images/education/Animals/hippo.png","hippo"));
        animalImages.add(makeFlashCard("images/education/Animals/horse.png","horse"));
        animalImages.add(makeFlashCard("images/education/Animals/kangaroo.png","kangaroo"));
        animalImages.add(makeFlashCard("images/education/Animals/koala.png","koala"));
        animalImages.add(makeFlashCard("images/education/Animals/lion.png","lion"));
        animalImages.add(makeFlashCard("images/education/Animals/monkey.png","monkey"));
        animalImages.add(makeFlashCard("images/education/Animals/mouse.png","mouse"));
        animalImages.add(makeFlashCard("images/education/Animals/octopus.png","octopus"));
        animalImages.add(makeFlashCard("images/education/Animals/penguin.png","penguin"));
        animalImages.add(makeFlashCard("images/education/Animals/pig.png","pig"));
        animalImages.add(makeFlashCard("images/education/Animals/rabbit.png","rabbit"));
        animalImages.add(makeFlashCard("images/education/Animals/rhino.png","rhinoceros"));
        animalImages.add(makeFlashCard("images/education/Animals/seal.png","seal"));
        animalImages.add(makeFlashCard("images/education/Animals/shark.png","shark"));
        animalImages.add(makeFlashCard("images/education/Animals/sheep.png","sheep"));
        animalImages.add(makeFlashCard("images/education/Animals/snake.png","snake"));
        animalImages.add(makeFlashCard("images/education/Animals/squirrel.png","squirrel"));
        animalImages.add(makeFlashCard("images/education/Animals/tiger.png","tiger"));
        animalImages.add(makeFlashCard("images/education/Animals/turtle.png","turtle"));
        animalImages.add(makeFlashCard("images/education/Animals/walrus.png","walrus"));
        animalImages.add(makeFlashCard("images/education/Animals/whale.png","whale"));
        animalImages.add(makeFlashCard("images/education/Animals/zebra.png","zebra"));
    }

    public String getLetterImage(int place){
        return  letterImages.get(place);
    }

    public String getNumberImage(int place){
        return numberImages.get(place);
    }

    public FlashCards getAnimalImage(int place){
        return animalImages.get(place);
    }

    public ArrayList<String> getLetterImages() {
        return letterImages;
    }

    public ArrayList<String> getNumberImages() {
        return numberImages;
    }

    public ArrayList<FlashCards> getAnimalImages() {
        return animalImages;
    }

    public FlashCards makeFlashCard(String image, String animalName){
        FlashCards flashCards = new FlashCards((new Image(image)),animalName);
        return flashCards;
    }
}
