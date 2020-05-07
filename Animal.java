package Marketplace;

public class Animal {
    public static Long number = 0L;
    //This number is animalnr, but this is the counter.
    private Long animalnr;
    private String name;
    private String gender;
    private Integer age;
    private String species;
    private String race;
    private Double weight;

    public Animal(){
        this.animalnr = getUniqueNumber();
    }

    public Animal(String gender, Integer age, String name, String species, String race, Double weight){
        this.animalnr = getUniqueNumber();
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.species = species;
        this.race = race;
        this.weight = weight;
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

    public double getWeight(){
        return weight;
    }

    public String getName(){
        return name;
    }

    public Integer getAge(){
        return age;
    }

    public Long getUniqueNumber(){
        number = number+1;
        return number;
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

    public void setWeight(Double weightNew){
        weight = weightNew;
    }

    public static void main(String[] args) {
    }
}