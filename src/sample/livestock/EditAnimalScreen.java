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
import sample.inlogScreen.PersonalData;


import static sample.ArrayKeeper.getCurrentUser;

public class EditAnimalScreen extends Application {
    Scene editscene;
    private int currentAnimal;
    private int currentUser;
    ArrayKeeper arrayKeeper = new ArrayKeeper();
    EditAnimal editAnimal = new EditAnimal();

    public EditAnimalScreen(int currentAnimal, int currentUser){
        this.currentAnimal = currentAnimal;
        this.currentUser = currentUser;
    }

    @Override
    public void start(Stage stage) throws Exception{
        PersonalData personalData = ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser());
        Pane pane = new Pane();
        Button btnBack = new Button("Back");
        Button btnEdit = new Button("Edit Animal");
        Label nameAnimal = new Label("Animal name ");
        Label ageAnimal = new Label("Animal Age ");
        Label lblGender = new Label("Animal Gender");
        Label SpeciesAminal = new Label("Animal species ");
        Label lblRace = new Label("Animal race ");
        Button btnDelete = new Button("Delete Animal");
        Button btnSaveChanges = new Button("Apply Changes");

        Label DataNameAnimal = new Label(personalData.getAnimals().get(currentAnimal).getName());
        Label DataAgeAnimal = new Label(""+personalData.getAnimals().get(currentAnimal).getAge());
        Label DataGenderAnimal = new Label(personalData.getAnimals().get(currentAnimal).getGender());
        Label DataSpeciesAnimal = new Label(personalData.getAnimals().get(currentAnimal).getSpecies());
        Label DataRaceAnimal = new Label(personalData.getAnimals().get(currentAnimal).getRace());

        TextField txtfname = new TextField(personalData.getAnimals().get(currentAnimal).getName());
        TextField txtfAge = new TextField(""+personalData.getAnimals().get(currentAnimal).getAge());
        TextField txtfSpecies = new TextField(personalData.getAnimals().get(currentAnimal).getGender());
        TextField txtfGender = new TextField(personalData.getAnimals().get(currentAnimal).getSpecies());
        TextField txtfRace = new TextField(personalData.getAnimals().get(currentAnimal).getRace());

        DataNameAnimal.relocate(250,100);
        DataAgeAnimal.relocate(250,135);
        DataGenderAnimal.relocate(250,170);
        DataSpeciesAnimal.relocate(250,205);
        DataRaceAnimal.relocate(250,240);

        pane.getChildren().addAll(DataNameAnimal,DataAgeAnimal,DataGenderAnimal,DataSpeciesAnimal,DataRaceAnimal);


        txtfname.relocate(450,100);
        txtfAge.relocate(450,135);
        txtfGender.relocate(450,170);
        txtfSpecies.relocate(450,205);
        txtfRace.relocate(450,240);
        btnSaveChanges.relocate(450,310);


        btnDelete.setOnAction(E->{
            editAnimal.deleteAnimal();
            goBack(stage);
        });


        btnBack.setOnAction(E-> {
            goBack(stage);
        });

        btnEdit.setOnAction(E->{
            pane.getChildren().addAll(txtfname,txtfAge,txtfGender,txtfSpecies,txtfRace,btnSaveChanges,btnDelete);
            try {
                btnSaveChanges.setOnAction(e -> {
                    editAnimal.SaveEdits(txtfname, txtfAge, txtfGender, txtfSpecies, txtfRace,currentAnimal);
                    goBack(stage);
                });
            }catch (java.lang.NumberFormatException e){
                pane.getChildren().add(makeError());
            }
            btnEdit.setVisible(false);
        });

        btnBack.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnBack.setScaleX(1.2);
                btnBack.setScaleY(1.2);

            }
        });
        btnBack.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnBack.setScaleX(1);
                btnBack.setScaleY(1);

            }
        });

        btnBack.relocate(10,565);
        btnEdit.relocate(100,310);
        nameAnimal.relocate(100,100);
        ageAnimal.relocate(100,135);
        lblGender.relocate(100,170);
        lblRace.relocate(100,205);
        SpeciesAminal.relocate(100,240);

        pane.getChildren().addAll(nameAnimal,ageAnimal,SpeciesAminal,lblGender,lblRace,btnEdit,btnBack);

        editscene = new Scene(pane,800,600);
        stage.setTitle("Edit "+ ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getAnimals().get(currentAnimal).getName());
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

        public Label makeError(){
            Label ErrorLabel = new Label("Age and weight have to be numbers");
            ErrorLabel.relocate(250,310);
            return ErrorLabel;
        }
    }

