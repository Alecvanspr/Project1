package sample;

import org.junit.Assert;
import org.junit.Test;
import sample.livestock.Animal;

public class AnimalTest {
    @Test
    public void TestGender(){
        Animal animal = new Animal("Henk","M",4,"horse","unknown",4.3, "Good");
        Assert.assertTrue(animal.getGender().equals("M"));
        animal.setGender("F");
        Assert.assertTrue(animal.getGender().equals("F"));
    }

    @Test
    public void TestAge(){
        Animal animal = new Animal("Henk","M",4,"horse","unknown",4.3, "Good");
        Assert.assertTrue(animal.getAge() == 4);
        animal.setAge(2);
        Assert.assertTrue(animal.getAge() == 2);
    }

    @Test
    public void TestName(){
        Animal animal = new Animal("Henk","M",4,"horse","unknown",4.3, "Good");
        Assert.assertTrue(animal.getName().equals("Henk"));
        animal.setName("Rocky");
        Assert.assertTrue(animal.getName().equals("Rocky"));
    }

    @Test
    public void TestSpecies(){
        Animal animal = new Animal("Henk","M",4,"horse","unknown",4.3, "Good");
        Assert.assertTrue(animal.getSpecies().equals("horse"));
        animal.setSpecies("Sheep");
        Assert.assertTrue(animal.getSpecies().equals("Sheep"));
    }

    @Test
    public void TestRace(){
        Animal animal = new Animal("Henk","M",4,"horse","unknown",4.3, "Good");
        Assert.assertTrue(animal.getRace().equals("unknown"));
        animal.setRace("Pony");
        Assert.assertTrue(animal.getRace().equals("Pony"));
    }

    @Test
    public void TestWeight(){
        Animal animal = new Animal("Henk","M",4,"horse","unknown",4.3, "Good");
        Assert.assertTrue(animal.getWeight().get(0) == 4.3);
        animal.addWeight("4.5");
        Assert.assertTrue(animal.getWeight().get(0) == 4.3 && animal.getWeight().get(1) == 4.5);
    }

    @Test
    public void TestHealth(){
        Animal animal = new Animal("Henk","M",4,"horse","unknown",4.3, "Good");
        Assert.assertTrue(animal.getHealth().get(0).equals("Good"));
        animal.addHealth("Deceased");
        Assert.assertTrue(animal.getHealth().get(0).equals("Good") && animal.getHealth().get(1).equals("Deceased"));
    }
}
