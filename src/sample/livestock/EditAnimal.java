package sample.livestock;

import javafx.scene.control.TextField;
import sample.ArrayKeeper;

import static sample.ArrayKeeper.getCurrentUser;

public class EditAnimal {
    private int currentAnimal; // deze kleiner.
    public void SaveEdits(TextField name, TextField age, TextField gender, TextField Species, TextField race,int currentAnimal) {
        this.currentAnimal = currentAnimal;
        int intAge = Integer.parseInt(age.getText());
        if (CheckFilled(name.getText())) {
            ArrayKeeper.Data.get(getCurrentUser()).getAnimals().get(currentAnimal).setName(name.getText());
        }
        if (CheckFilled(age.getText())) {
            ArrayKeeper.Data.get(getCurrentUser()).getAnimals().get(currentAnimal).setAge(intAge);
        }
        if (CheckFilled(gender.getText())) {
            ArrayKeeper.Data.get(getCurrentUser()).getAnimals().get(currentAnimal).setGender(gender.getText());
        }
        if (CheckFilled(Species.getText())) {
            ArrayKeeper.Data.get(getCurrentUser()).getAnimals().get(currentAnimal).setSpecies(Species.getText());
        }
        if (CheckFilled(race.getText())) {
            ArrayKeeper.Data.get(getCurrentUser()).getAnimals().get(currentAnimal).setRace(race.getText());
        }
    }
    public boolean CheckFilled (String isempety){
        boolean ret = true;
        if (isempety.equals("")) {
            ret = false;
        }
        return ret;
    }
    public void deleteAnimal(){
        ArrayKeeper.Data.get(ArrayKeeper.getCurrentUser()).getAnimals().remove(currentAnimal);
    }
}
