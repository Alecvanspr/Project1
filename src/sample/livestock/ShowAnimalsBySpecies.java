package sample.livestock;

import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.GoToScreens;
import sample.inlogScreen.PersonalData;
import sample.market.Auction;

public class ShowAnimalsBySpecies {
    ShowAnimalsBySpeciesScreen showAnimalsBySpeciesScreen = new ShowAnimalsBySpeciesScreen();
    GoToScreens goToScreens = GoToScreens.getInstance();
    ArrayKeeper arrayKeeper = new ArrayKeeper();


    public int checkForAminal (String species){
        int ret = 0;
        for (int i = 0; i < arrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getAnimals().size(); i++) {
            if (arrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getAnimals().get(i).getSpecies().equalsIgnoreCase(species)) {
                ret++;
            }
        }
        return ret;
    }
    //int amount, double price, int x
    public void displayBidFields(Stage stage, Object object[]){
        int x = Integer.parseInt(object[2].toString());
        double price = Double.parseDouble(object[1].toString());
        int amount = Integer.parseInt(object[0].toString());
        if (amount <= PersonalData.getSpecies().get(x).getArrayListOfSpecies().size()){
            Auction auction = new Auction(PersonalData.getSpecies().get(x).arrayListOfSpecies.getArrayList().get(0), price);
            for(int i = 1; i < amount; i++){
                auction.addAnimalToQueue(PersonalData.getSpecies().get(x).arrayListOfSpecies.getArrayList().get(i));
            }
            goToScreens.goShowAnimalsBySpiecies(stage);
        }else{
            showAnimalsBySpeciesScreen.playError();
        }
    }
}
