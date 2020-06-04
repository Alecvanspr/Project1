package sample;

import javafx.stage.Stage;
import sample.livestock.*;
import sample.market.*;
import sample.profileSettings.EditSettingsScreen;
import sample.profileSettings.ProfileSettingsScreen;

public class GoToScreens {
    public void goProfileSettingScreen(Stage stage){
        ProfileSettingsScreen profileSettingsScreen = new ProfileSettingsScreen();
        try {
            profileSettingsScreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goHomeScreen(Stage stage){
        Homescreen homescreen = new Homescreen();
        try {
            homescreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goEditSettings(Stage stage){
        EditSettingsScreen editSettingsScreen = new EditSettingsScreen();
        try {
            editSettingsScreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goAutionlist(Stage stage){
        AuctionListScreen auctionListScreen = new AuctionListScreen();
        try {
            auctionListScreen.start(stage);
        }   catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goBidHistory(Stage stage){
        BidHistoryScreen bidHistoryScreen = new BidHistoryScreen();
        try{
            bidHistoryScreen.start(stage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goYourAuction(Stage stage){
        UserAuctions userAuctions = new UserAuctions();
        try{
            userAuctions.start(stage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goToMakeAuction(Stage stage){
        MakeAuctionScreen makeAuctionScreen = new MakeAuctionScreen();
        try {
            makeAuctionScreen.start(stage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goLiveStock(Stage stage){
        Livestock livestock = new Livestock();
        try{
            livestock.start(stage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goMarketplace(Stage stage){
        MarketplaceScreen marketplaceScreen = new MarketplaceScreen();
        try {
            marketplaceScreen.start(stage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goShowAnimalsBySpiecies (Stage stage){
        ShowAnimalsBySpeciesScreen showAnimalsBySpeciesScreen = new ShowAnimalsBySpeciesScreen();
        try {
            showAnimalsBySpeciesScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void goAddWeight(Stage stage,int currentAnimal){
        AddWeightCheckScreen addWeightCheckScreen = new AddWeightCheckScreen(currentAnimal);
        try {
            addWeightCheckScreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goHealthCheck(Stage stage,int currentAnimal){
        AddHeathCheckScreen addHeathCheckScreen = new AddHeathCheckScreen(currentAnimal);
        try {
            addHeathCheckScreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void displayWeight(Stage stage,int currentAnimal){
        DisplayWeightScreen displayWeightScreen = new DisplayWeightScreen(currentAnimal,ArrayKeeper.getCurrentUser());
        try {
            displayWeightScreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void displayHealth(Stage stage,int currentAnimal){
        DisplayHealthScreen displayHealthScreen = new DisplayHealthScreen(currentAnimal, ArrayKeeper.getCurrentUser());
        try {
            displayHealthScreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
