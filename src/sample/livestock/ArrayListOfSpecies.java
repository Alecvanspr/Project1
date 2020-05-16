package sample.livestock;

import java.util.ArrayList;

public class ArrayListOfSpecies {
    ArrayList<Animal> arrayList = new ArrayList<>();

    public ArrayListOfSpecies(){

    }
    public void addAnimal(Animal animal){
        arrayList.add(animal);
    }
    public ArrayList<Animal> getArrayList(){
        return this.arrayList;
    }
}
