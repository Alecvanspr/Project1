package sample.livestock;

import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.inlogScreen.PersonalData;
import sample.market.Auction;

public class ShowAnimalsBySpecies {
    ShowAnimalsBySpeciesScreen showAnimalsBySpeciesScreen = new ShowAnimalsBySpeciesScreen();
    ArrayKeeper arrayKeeper = new ArrayKeeper();


    public int checkForAminal (String species){
        int ret = 0;
        for (int i = 0; i < arrayKeeper.getData(ArrayKeeper.getCurrentUser()).getAnimals().size(); i++) {
            if (arrayKeeper.getData(ArrayKeeper.getCurrentUser()).getAnimals().get(i).getSpecies().equalsIgnoreCase(species)) {
                ret++;
            }
        }
        return ret;
    }
    public void displayBidFields(Stage stage, int amount, double price, int x){
        if (amount <= PersonalData.getSpecies().get(x).getArrayListOfSpecies().size()){
            Auction auction = new Auction(PersonalData.getSpecies().get(x).arrayListOfSpecies.getArrayList().get(0), price);
            for(int i = 1; i < amount; i++){
                auction.addAnimalToQueue(PersonalData.getSpecies().get(x).arrayListOfSpecies.getArrayList().get(i));
            }
            showAnimalsBySpeciesScreen.goShowAnimalsBySpiecies(stage);
        }else{
            showAnimalsBySpeciesScreen.playError();
        }
    }

}
