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
        Label nameAnimal = new Label("Animal name "+ personalData.getAnimals().get(currentAnimal).getName());
        Label ageAnimal = new Label("Animal Age " + personalData.getAnimals().get(currentAnimal).getAge());
        Label lblGender = new Label("Animal Gender "+ personalData.getAnimals().get(currentAnimal).getGender());
        Label SpeciesAminal = new Label("Animal species "+ personalData.getAnimals().get(currentAnimal).getSpecies());
        Label lblUserStamp = new Label("User "+ getCurrentUser() + currentUser);
        Button btnDelete = new Button("Delete Animal");
        Button btnSaveChanges = new Button("Apply Changes");
        TextField txtfname = new TextField();
        TextField txtfAge = new TextField();
        TextField txtfSpecies = new TextField();
        TextField txtfGender = new TextField();
        txtfname.relocate(300,100);
        txtfAge.relocate(300,135);
        txtfGender.relocate(300,170);
        txtfSpecies.relocate(300,205);
        btnSaveChanges.relocate(300,240);

        lblUserStamp.relocate(300,275);

        btnDelete.setOnAction(E->{
            deleteAnimal();
            goBack(stage);
        });


        btnBack.setOnAction(E-> {
            goBack(stage);
            System.out.println(currentAnimal);
            System.out.println(currentUser);
        });
        btnEdit.setOnAction(E->{
            pane.getChildren().addAll(txtfname,txtfAge,txtfGender,txtfSpecies,btnSaveChanges,btnDelete);
            btnSaveChanges.setOnAction(e->{
                SaveEdits(txtfname,txtfAge,txtfGender,txtfSpecies);
                goBack(stage);
            });
        });

        btnBack.relocate(10,565);
        btnEdit.relocate(100,240);
        nameAnimal.relocate(100,100);
        ageAnimal.relocate(100,135);
        lblGender.relocate(100,170);
        SpeciesAminal.relocate(100,205);

        pane.getChildren().addAll(nameAnimal,ageAnimal,SpeciesAminal,lblGender,btnEdit,btnBack,lblUserStamp);

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
    public void SaveEdits(TextField name,TextField age,TextField gender,TextField Species) {
        if (CheckFilled(name.getText())) {
            ArrayKeeper.Data.get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).setName(name.getText());
        }
        if (CheckFilled(age.getText())) {
            ArrayKeeper.Data.get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).setAge(Integer.parseInt(age.getText()));
        }
        if (CheckFilled(gender.getText())) {
            ArrayKeeper.Data.get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).setGender(gender.getText());
        }
        if (CheckFilled(Species.getText())) {
            ArrayKeeper.Data.get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).setSpecies(Species.getText());
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

