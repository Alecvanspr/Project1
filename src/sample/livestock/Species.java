package sample.livestock;
import sample.inlogScreen.PersonalData;

import java.util.ArrayList;

public class Species {
    private String species;
    ArrayListOfSpecies arrayListOfSpecies = new ArrayListOfSpecies();
    public Species(String species){
        this.species = species;
    }
    public String getSpecies(){
        return this.species;
    }
    public ArrayList<Animal> getArrayListOfSpecies(){
        return arrayListOfSpecies.getArrayList();
    }
    public void addAnimalToArray(Animal animal){
        arrayListOfSpecies.addAnimal(animal);
    }
}
