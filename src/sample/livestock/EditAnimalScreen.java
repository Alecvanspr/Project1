package sample.livestock;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ArrayKeeper;
import sample.ButtonSettings;
import sample.GoToScreens;
import sample.inlogScreen.PersonalData;


import static sample.ArrayKeeper.getCurrentUser;

public class EditAnimalScreen extends Application {
    ButtonSettings buttonSettings =ButtonSettings.getInstance();
    Scene editscene;
    private int currentAnimal;
    private int currentUser;
    Pane pane = new Pane();
    PersonalData personalData = ArrayKeeper.getData().get(currentUser);

    ArrayKeeper arrayKeeper = new ArrayKeeper();
    EditAnimal editAnimal = new EditAnimal();
    GoToScreens goToScreens = GoToScreens.getInstance();
    TextField txtfname = new TextField("");
    TextField txtfAge = new TextField("");
    TextField txtfSpecies = new TextField("");
    TextField txtfGender = new TextField("");
    TextField txtfRace = new TextField("");

    Button btnDelete = new Button("Delete Animal");
    Button btnSaveChanges = new Button("Apply Changes");

    public EditAnimalScreen(int currentAnimal, int currentUser){
        this.currentAnimal = currentAnimal;
        this.currentUser = currentUser;
    }

    @Override
    public void start(Stage stage) throws Exception{
        makeBtnDelete(stage);
        makeBtnBack(stage);
        makeBtnEdit(stage);
        makeLabels();
        makeLabelNames();
        setTextfieldsNames();
        fin(stage);
    }
    public void fin(Stage stage){
        editscene = new Scene(pane,800,600);
        stage.setTitle("Edit "+ ArrayKeeper.getData().get(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).getName());
        stage.setScene(editscene);
        stage.show();
    }
    public void relocateTextFields(){
        txtfname.relocate(450,100);
        txtfAge.relocate(450,135);
        txtfGender.relocate(450,170);
        txtfSpecies.relocate(450,205);
        txtfRace.relocate(450,240);
    }
    public void makeBtnEdit(Stage stage){
        Button btnEdit = new Button("Edit Animal");
        btnEdit.setOnAction(E->{
            relocateTextFields();
            pane.getChildren().addAll(txtfname,txtfAge,txtfGender,txtfSpecies,txtfRace,btnSaveChanges,btnDelete);
            makeBtnSaveChanges(stage);
            btnEdit.setVisible(false);
        });
        btnEdit.relocate(100,310);
        buttonSettings.onMouse(btnEdit);
        pane.getChildren().add(btnEdit);
    }
    public void makeBtnBack(Stage stage){
        Button btnBack = new Button("Back");
        buttonSettings.onMouse(btnBack);
        btnBack.setOnAction(E-> {
            goToScreens.goLiveStock(stage);
        });
        btnBack.relocate(10,565);
        pane.getChildren().add(btnBack);
    }
    public void setTextfieldsNames(){
        txtfname = new TextField(arrayKeeper.getData().get(getCurrentUser()).getAnimals().get(currentAnimal).getName());
        txtfAge = new TextField(""+arrayKeeper.getData().get(getCurrentUser()).getAnimals().get(currentAnimal).getAge());
        txtfSpecies = new TextField(arrayKeeper.getData().get(getCurrentUser()).getAnimals().get(currentAnimal).getGender());
        txtfGender = new TextField(arrayKeeper.getData().get(getCurrentUser()).getAnimals().get(currentAnimal).getSpecies());
        txtfRace = new TextField(arrayKeeper.getData().get(getCurrentUser()).getAnimals().get(currentAnimal).getRace());
    }
    public void makeLabels(){
        Label nameAnimal = new Label("Animal name ");
        Label ageAnimal = new Label("Animal Age ");
        Label lblGender = new Label("Animal Gender");
        Label SpeciesAminal = new Label("Animal species ");
        Label lblRace = new Label("Animal race ");
        nameAnimal.relocate(100,100);
        ageAnimal.relocate(100,135);
        lblGender.relocate(100,170);
        lblRace.relocate(100,205);
        SpeciesAminal.relocate(100,240);
        pane.getChildren().addAll(nameAnimal,ageAnimal,SpeciesAminal,lblGender,lblRace);
    }
    public void makeLabelNames(){
        System.out.println(currentAnimal);
        Label DataNameAnimal = new Label(arrayKeeper.getData().get(getCurrentUser()).getAnimals().get(currentAnimal).getName()); // deze gaat fout
        Label DataAgeAnimal = new Label(""+arrayKeeper.getData().get(getCurrentUser()).getAnimals().get(currentAnimal).getAge());
        Label DataGenderAnimal = new Label(arrayKeeper.getData().get(getCurrentUser()).getAnimals().get(currentAnimal).getGender());
        Label DataSpeciesAnimal = new Label(arrayKeeper.getData().get(getCurrentUser()).getAnimals().get(currentAnimal).getSpecies());
        Label DataRaceAnimal = new Label(arrayKeeper.getData().get(getCurrentUser()).getAnimals().get(currentAnimal).getRace());
        DataNameAnimal.relocate(250,100);
        DataAgeAnimal.relocate(250,135);
        DataGenderAnimal.relocate(250,170);
        DataSpeciesAnimal.relocate(250,205);
        DataRaceAnimal.relocate(250,240);
        pane.getChildren().addAll(DataNameAnimal,DataAgeAnimal,DataGenderAnimal,DataSpeciesAnimal,DataRaceAnimal);
    }
    public void makeBtnDelete(Stage stage){
        btnDelete.setOnAction(E->{
            editAnimal.deleteAnimal();
            goToScreens.goLiveStock(stage);
        });
        buttonSettings.onMouse(btnDelete);
    }
    public void makeBtnSaveChanges(Stage stage){
        try {
            btnSaveChanges.setOnAction(e -> {
                editAnimal.SaveEdits(txtfname, txtfAge, txtfGender, txtfSpecies, txtfRace,currentAnimal);
                goToScreens.goLiveStock(stage);
            });
        }catch (java.lang.NumberFormatException e){
            pane.getChildren().add(makeError());
        }
        btnSaveChanges.relocate(450,310);
        buttonSettings.onMouse(btnSaveChanges);
    }
    public void setCurrentAnimal(int invoerAnimal){
        this.currentAnimal = invoerAnimal;
    }

        public Label makeError(){
            Label ErrorLabel = new Label("Age and weight have to be numbers");
            ErrorLabel.relocate(250,310);
            return ErrorLabel;
        }
    }

