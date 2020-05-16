package sample.livestock;

import java.util.ArrayList;

public class Animal {
    public static Long number = 0L;
    //This number is animalnr, but this is the counter.
    private Long animalnr;
    private String name;
    private String gender;
    private Integer age;
    private String species;
    private String race;
    public ArrayList<Double> weight = new ArrayList<>();
    public ArrayList<String> health = new ArrayList<>();
    public ArrayList<String> dateHealth = new ArrayList<>();
    public ArrayList<String> dateWeight = new ArrayList<>();

    public Animal(String name,String gender, Integer age,  String species, String race, Double weight,String health){
        System.out.println(weight);
        this.animalnr = getUniqueNumber();
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.species = species;
        this.race = race;
        this.weight.add(weight);
        this.health.add(health);
    }

    public Long getAnimalnr(){
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

    public Long getUniqueNumber(){
        return number++;
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
        return  dateWeight.get(counter);
    }
}