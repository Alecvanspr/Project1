package sample.livestock;
import sample.inlogScreen.PersonalData;

import java.util.ArrayList;

public class Species {
    private String species;
    ArrayList<Animal> animalsOfSpecies = new ArrayList<>();
    public Species(String species){
        this.species = species;
        PersonalData.getSpecies().add(this);
    }
    public String getSpecies(){
        return this.species;
    }
    public ArrayList<Animal> getAnimalsOfSpecies(){
        return this.animalsOfSpecies;
    }

}
