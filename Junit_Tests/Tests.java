import org.junit.Assert;
import org.junit.Test;
import sample.ArrayKeeper;
import sample.inlogScreen.Main;
import sample.inlogScreen.PersonalData;
import sample.livestock.Animal;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Tests {
    @Test
    public void test1(){
        ArrayKeeper arrayKeeper = new ArrayKeeper();
        arrayKeeper.setCurrentUser(1);
        arrayKeeper.SignUpData("Bob","Kaas","yes","geel", "Geel"); //2
        arrayKeeper.SignUpData("Henk","Kaas","yes","geel", "Geel"); //3
        arrayKeeper.SignUpData("Karel","Kaas","yes","geel", "Geel"); //4

        ArrayList<Animal> animalsbob = new ArrayList<>();
        ArrayList<Animal> animalsHenk = new ArrayList<>();
        ArrayList<Animal> animalsKarel = new ArrayList<>();

        Animal animal1 = new Animal();
        animal1.setName("Blaf");
        Animal animal2 = new Animal();
        animal2.setName("Bruh");
        Animal animal3 = new Animal();
        animal3.setName("Wat een lief hondje");

        animalsbob.add(animal1);
        animalsbob.add(animal2);
        animalsbob.add(animal3);

        Animal animal11 = new Animal();
        animal11.setName("Dier 11");
        Animal animal12 = new Animal();
        animal12.setName("Dier 12");
        Animal animal13 = new Animal();
        animal13.setName("Dier 13");

        animalsHenk.add(animal11);
        animalsHenk.add(animal12);
        animalsHenk.add(animal13);

        Animal animal21 = new Animal();
        animal21.setName("Freek vonk");
        Animal animal22 = new Animal();
        animal22.setName("België");
        Animal animal23 = new Animal();
        animal23.setName("Bruh momentum");

        animalsKarel.add(animal21);
        animalsKarel.add(animal22);
        animalsKarel.add(animal23);

        arrayKeeper.getPersonaldata().get(0).setAnimals(animalsbob);
        arrayKeeper.getPersonaldata().get(1).setAnimals(animalsHenk);
        arrayKeeper.getPersonaldata().get(2).setAnimals(animalsKarel);

        Assert.assertEquals("Belgi", ArrayKeeper.getData(2).getAnimals().get(1).getName());
    }
}
