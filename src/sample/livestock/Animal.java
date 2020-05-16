package sample.livestock;

import java.util.ArrayList;

public class Animal {
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

    public Animal(String name,String gender, Integer age,  String species, String race, Double weight,String Health){
        this.animalnr = getUniqueNumber();
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.species = species;
        this.race = race;
        this.weight.add(weight);
        this.health.add(Health);
        this.dateWeight.add(""+java.time.LocalDate.now());
        this.dateHealth.add(""+java.time.LocalDate.now());
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
        /*
        String number = "";
        if((currentUser<100)&&(currentUser>=10)){
            number = "0"+currentUser;
        }else if(currentUser<10){
            number = "00"+currentUser;
        }

         */
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

    public ArrayList<String> getDateWeight(){
        return dateWeight;
    }

    public static void main(String[] args) {
    }
}
class sheep extends Animal{
    String woolQuality;
    public sheep(String gender, Integer age, String name, String species, String race, Double weight,String dateWeight,String woolQuality){
        super(name,gender, age,  species, race, weight,dateWeight);
        this.woolQuality = woolQuality;
    }

}