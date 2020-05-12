package sample.livestock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.inlogScreen.PersonalData;

import java.util.ArrayList;

import static sample.ArrayKeeper.getCurrentUser;

public class EditAnimal extends Application {
    Scene editscene;
    private int currentAnimal;
    private int currentUser;
    ArrayKeeper arrayKeeper = new ArrayKeeper();

    //Animal animal = ArrayKeeper.Data.get(currentUser).getAnimals().get(currentAnimal); //kijk of je dit later kan implementeren
    public EditAnimal(int currentAnimal,int currentUser){
        this.currentAnimal = currentAnimal;
        this.currentUser = currentUser;
    }

    @Override
    public void start(Stage stage) throws Exception{
        PersonalData personalData = ArrayKeeper.Data.get(currentUser);
        Pane pane = new Pane();
        Button btnBack = new Button("Back");
        Button btnEdit = new Button("Edit Animal");
        Label nameAnimal = new Label("Animal name ");
        Label ageAnimal = new Label("Animal Age ");
        Label lblGender = new Label("Animal Gender");
        Label SpeciesAminal = new Label("Animal species ");
        Label lblRace = new Label("Animal race ");
        Label lblWeight = new Label("Animal Weight");
        Button btnDelete = new Button("Delete Animal");
        Button btnSaveChanges = new Button("Apply Changes");

        Label DataNameAnimal = new Label(personalData.getAnimals().get(currentAnimal).getName());
        Label DataAgeAnimal = new Label(""+personalData.getAnimals().get(currentAnimal).getAge());
        Label DataGenderAnimal = new Label(personalData.getAnimals().get(currentAnimal).getGender());
        Label DataSpeciesAnimal = new Label(personalData.getAnimals().get(currentAnimal).getSpecies());
        Label DataRaceAnimal = new Label(personalData.getAnimals().get(currentAnimal).getRace());
        Label DataWeightAnimal = new Label(""+ personalData.getAnimals().get(currentAnimal).getWeight());

        TextField txtfname = new TextField(personalData.getAnimals().get(currentAnimal).getName());
        TextField txtfAge = new TextField(""+personalData.getAnimals().get(currentAnimal).getAge());
        TextField txtfSpecies = new TextField(personalData.getAnimals().get(currentAnimal).getGender());
        TextField txtfGender = new TextField(personalData.getAnimals().get(currentAnimal).getSpecies());
        TextField txtfRace = new TextField(personalData.getAnimals().get(currentAnimal).getRace());
        TextField txtfWeight = new TextField(""+personalData.getAnimals().get(currentAnimal).getWeight());

        DataNameAnimal.relocate(250,100);
        DataAgeAnimal.relocate(250,135);
        DataGenderAnimal.relocate(250,170);
        DataSpeciesAnimal.relocate(250,205);
        DataRaceAnimal.relocate(250,240);
        DataWeightAnimal.relocate(250,275);

        pane.getChildren().addAll(DataNameAnimal,DataAgeAnimal,DataGenderAnimal,DataSpeciesAnimal,DataRaceAnimal,DataWeightAnimal);


        txtfname.relocate(450,100);
        txtfAge.relocate(450,135);
        txtfGender.relocate(450,170);
        txtfSpecies.relocate(450,205);
        txtfRace.relocate(450,240);
        txtfWeight.relocate(450,275);
        btnSaveChanges.relocate(450,310);


        btnDelete.setOnAction(E->{
            deleteAnimal();
            goBack(stage);
        });


        btnBack.setOnAction(E-> {
            goBack(stage);
        });
        btnEdit.setOnAction(E->{
            pane.getChildren().addAll(txtfname,txtfAge,txtfGender,txtfSpecies,txtfRace,txtfWeight,btnSaveChanges,btnDelete);
            try {
                btnSaveChanges.setOnAction(e -> {
                    SaveEdits(txtfname, txtfAge, txtfGender, txtfSpecies, txtfRace, txtfWeight);
                    goBack(stage);
                });
            }catch (java.lang.NumberFormatException e){
                Label ErrorLabel = new Label("Age and weight have to be numbers");
                ErrorLabel.relocate(250,310);
                pane.getChildren().add(ErrorLabel);
            }
            btnEdit.setVisible(false);
        });

        btnBack.relocate(10,565);
        btnEdit.relocate(100,310);
        nameAnimal.relocate(100,100);
        ageAnimal.relocate(100,135);
        lblGender.relocate(100,170);
        lblRace.relocate(100,205);
        SpeciesAminal.relocate(100,240);
        lblWeight.relocate(100,275);

        pane.getChildren().addAll(nameAnimal,ageAnimal,SpeciesAminal,lblGender,lblRace,lblWeight,btnEdit,btnBack);

        editscene = new Scene(pane,800,600);
        stage.setTitle("Edit "+ ArrayKeeper.Data.get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).getName()); //+ArrayKeeper.Data.get(ArrayKeeper.getCurrentUser()).animals.get().getName()
        stage.setScene(editscene);
        stage.show();
    }
    public void setCurrentAnimal(int invoerAnimal){
        this.currentAnimal = invoerAnimal;
    }
    public void goBack(Stage stage){
        Livestock livestock = new Livestock();
        try {
            livestock.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void SaveEdits(TextField name,TextField age,TextField gender,TextField Species,TextField race, TextField Weight) {
        int intAge = Integer.parseInt(age.getText());
        double doubleWeight = Double.parseDouble(Weight.getText());
        if (CheckFilled(name.getText())) {
            ArrayKeeper.Data.get(getCurrentUser()).getAnimals().get(currentAnimal).setName(name.getText());
        }
        if (CheckFilled(age.getText())) {
            ArrayKeeper.Data.get(getCurrentUser()).getAnimals().get(currentAnimal).setAge(intAge);
        }
        if (CheckFilled(gender.getText())) {
            ArrayKeeper.Data.get(getCurrentUser()).getAnimals().get(currentAnimal).setGender(gender.getText());
        }
        if (CheckFilled(Species.getText())) {
            ArrayKeeper.Data.get(getCurrentUser()).getAnimals().get(currentAnimal).setSpecies(Species.getText());
        }
        if (CheckFilled(race.getText())) {
            ArrayKeeper.Data.get(getCurrentUser()).getAnimals().get(currentAnimal).setRace(race.getText());
        }
        if (CheckFilled(Weight.getText())) {
            ArrayKeeper.Data.get(getCurrentUser()).getAnimals().get(currentAnimal).setWeight(doubleWeight);
        }

    }
        public boolean CheckFilled (String isempety){
            boolean ret = true;
            if (isempety.equals("")) {
                ret = false;
            }
            return ret;
        }
        public void deleteAnimal(){
        ArrayKeeper.Data.get(ArrayKeeper.getCurrentUser()).getAnimals().remove(currentAnimal);
        }
    }

