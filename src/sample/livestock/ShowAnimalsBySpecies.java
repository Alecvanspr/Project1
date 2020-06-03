package sample.livestock;

import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.inlogScreen.PersonalData;
import sample.market.Auction;

public class ShowAnimalsBySpecies {
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
}
