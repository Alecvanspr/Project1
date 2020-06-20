package sample;

import javafx.stage.Stage;
import sample.MedicalSection.*;
import sample.contacts.ContactScreen;
import sample.educative.EducativeHomeScreen;
import sample.educative.MathGame.MathScreen;
import sample.educative.read.ReadScreen;
import sample.educative.read.StoryScreen;
import sample.educative.read.WordReadScreen;
import sample.educative.writing.*;
import sample.inlogScreen.ForgotPasswordScreen;
import sample.inlogScreen.Main;
import sample.inlogScreen.SignUpScreen;
import sample.inlogScreen.SignUpScreenDoctor;
import sample.livestock.*;
import sample.market.*;
import sample.profileSettings.EditSettingsScreen;
import sample.profileSettings.ProfileSettingsScreen;


public class GoToScreens {
    private static GoToScreens instance;
    private GoToScreens(){
    }
    public static GoToScreens getInstance() {
        if(instance == null){
            instance = new GoToScreens();
        }
        return instance;
    }

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
        AddHealthCheckScreen addHealthCheckScreen = new AddHealthCheckScreen(currentAnimal);
        try {
            addHealthCheckScreen.start(stage);
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

    public void goMain(Stage stage){
        Main main = new Main();
        try {
            main.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void goEducativeScreen(Stage stage){
        EducativeHomeScreen educativeHomeScreen = new EducativeHomeScreen();
        try {
            educativeHomeScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void goReadScreen(Stage stage){
        ReadScreen readScreen = new ReadScreen();
        try {
            readScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void goWriteScreen(Stage stage){
        WriteMainScreen writeMainScreen = new WriteMainScreen();
        try {
            writeMainScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void goRandom(Stage stage){
        WriteRandomScreen writeRandomScreen = new WriteRandomScreen();
        try {
            writeRandomScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void goNumbers(Stage stage){
        WriteNumbersScreen writeNumbersScren = new WriteNumbersScreen();
        try {
            writeNumbersScren.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void goAlphabet(Stage stage){
        WriteAlphabetScreen writeAlphabetScreen = new WriteAlphabetScreen();
        try {
            writeAlphabetScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void goWords(Stage stage){
        WriteWordsScreen writeWordsScreen = new WriteWordsScreen();
        try {
            writeWordsScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void goWordReading(Stage stage){
        WordReadScreen wordReadScreen = new WordReadScreen();
        try {
            wordReadScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void goProfile(Stage stage){
        ProfileSettingsScreen pScreen = new ProfileSettingsScreen();
        try {
            pScreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void goContacts(Stage stage){
        ContactScreen contactScreen = new ContactScreen();
        try {
            contactScreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void goForgetPassword(Stage stage){
        ForgotPasswordScreen forgotPasswordScreen = new ForgotPasswordScreen();
        try{
            forgotPasswordScreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void goSignUp(Stage stage){
        SignUpScreen signUpScreen = new SignUpScreen();
        try{
            signUpScreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void goNewAnimal(Stage stage){
        AddanimalScreen addanimalScreen = new AddanimalScreen();
        try {
            addanimalScreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void goEditAnimal(Stage stage,int animal){
        EditAnimalScreen editAnimalScreen = new EditAnimalScreen(animal,ArrayKeeper.getCurrentUser());
        try {
            editAnimalScreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void goMedicalSection(Stage stage){
        MedicalSection medicalSection = new MedicalSection();
        try {
            medicalSection.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void goMakeAppointment(Stage stage){
        MakeAppointment makeAppointment = new MakeAppointment();
        try {
            makeAppointment.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void goAppointmentsScreen(Stage stage){
        ShowAppointmentsScreen showAppointmentsScreen = new ShowAppointmentsScreen();
        try {
            showAppointmentsScreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void goEditAppointment(Stage stage){
        EditAppointment editAppointment = new EditAppointment();
        try {
            editAppointment.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void goSignUpDoctorScreen(Stage stage){
        SignUpScreenDoctor signUpScreenDoctor = new SignUpScreenDoctor();
        try {
            signUpScreenDoctor.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void goAddHealthCheck(Stage stage,int currentAnimal){
        AddHealthCheckScreen addHealthCheckScreen = new AddHealthCheckScreen(currentAnimal);
        try {
            addHealthCheckScreen.start(stage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void goViewPatientsScreen(Stage stage){
        ViewPatientsScreen viewPatientsScreen = new ViewPatientsScreen();
        try{
            viewPatientsScreen.start(stage);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void goStoryScreen(Stage stage) {
        StoryScreen storyScreen = new StoryScreen();
        try{
            storyScreen.start(stage);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void goShowPastAppointments(Stage stage){
        ShowPastAppointments showPastAppointments = new ShowPastAppointments();
        try{
            showPastAppointments.start(stage);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void goCancelAppointments(Stage stage){
        CancelAppointmentScreen cancelAppointmentScreen = new CancelAppointmentScreen();
        try{
            cancelAppointmentScreen.start(stage);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void goMathGame(Stage stage) {
        MathScreen mathScreen = new MathScreen();
        try{
            mathScreen.start(stage);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void goPastAppointments(Stage stage){
        PastAppointmentScreen pastAppointmentScreen = new PastAppointmentScreen();
        try{
            pastAppointmentScreen.start(stage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goNotesScreen(Stage stage,int currentAppointment){
        NotesScreen notesScreen = new NotesScreen(currentAppointment);
        try{
            notesScreen.start(stage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
