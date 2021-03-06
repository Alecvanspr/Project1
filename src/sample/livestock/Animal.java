package sample.livestock;

import sample.inlogScreen.PersonalData;

import java.util.ArrayList;

public class  Animal {
    public static Long number = 0L;
    //This number is animalnr, but this is the counter.
    private Integer animalnr;
    private String name;
    private String gender;
    private Integer age;
    private String species;
    private String race;
    private int currentUser;
    public ArrayList<Double> weight = new ArrayList<>();
    public ArrayList<String> health = new ArrayList<>();
    public ArrayList<String> dateHealth = new ArrayList<>();
    public ArrayList<String> dateWeight = new ArrayList<>();
    //String name,String gender, Integer age,  String species, String race, Double weight,String Health
    public Animal(Object animalData[]){
        this.animalnr = getUniqueNumber();
        this.name = animalData[0].toString();
        this.gender = animalData[1].toString();
        this.age = Integer.parseInt(animalData[2].toString());
        this.species = animalData[3].toString();
        this.race = animalData[4].toString();
        this.weight.add(Double.parseDouble(animalData[5].toString()));
        this.health.add(animalData[6].toString());
        this.dateWeight.add(""+java.time.LocalDate.now());
        this.dateHealth.add(""+java.time.LocalDate.now());
        makeSpecies(species);
    }
    public void makeSpecies(String species){
        if(!checkSpecies(species)){
            Species speciesObject = new Species(species);
            speciesObject.getArrayListOfSpecies().add(this);

            PersonalData.getSpecies().add(speciesObject);

        }else{
            for(int i =0; i < PersonalData.getSpecies().size(); i++){
                if (PersonalData.getSpecies().get(i).getSpecies().equalsIgnoreCase(this.species)){
                    PersonalData.getSpecies().get(i).addAnimalToArray(this);
                }
            }
        }
    }
    public Boolean checkSpecies(String species) {
        boolean ret = false;
        for (int i = 0; i < PersonalData.getSpecies().size(); i++) {
            if (PersonalData.getSpecies().get(i).getSpecies().equalsIgnoreCase(this.getSpecies())) {
                return true;
            }
        }
        return ret;
    }
    public Integer getAnimalnr(){
        return animalnr;
    }

    public String getGender(){
        return gender;
    }

    public String getSpecies(){
        return species;
    }

    public String getRace(){
        return race;
    }

    public String getName(){
        return name;
    }

    public Integer getAge(){
        return age;
    }

    public Integer getUniqueNumber(){
        return currentUser;
    }

    public void setName(String nameNew){
        name = nameNew;
    }

    public void setAge(Integer ageNew){
        age = ageNew;
    }

    public void setGender(String genderNew){
        gender = genderNew;
    }
    public void setSpecies(String speciesNew){
        species = speciesNew;
    }

    public void setRace(String raceNew){
        race = raceNew;
    }

    public void addWeight(String weightNew){
        Double doubleWeight = Double.parseDouble(weightNew);
        this.weight.add(doubleWeight);
    }
    public ArrayList<Double> getWeight(){
        return weight;
    }
    public void addHealth(String newHealth){
        health.add(newHealth);
    }

    public ArrayList<String> getHealth(){
        return  health;
    }
    public void setDateHealth(String newDate){
        this.dateHealth.add(newDate);
    }
    public void setDateWeight(String newDate){
        this.dateWeight.add(newDate);
    }
    public String getDateHealth(int counter){
        return  dateHealth.get(counter);
    }

    public String getDateWeight(int counter){
        return dateWeight.get(counter);
    }

    public static void main(String[] args) {
    }
}