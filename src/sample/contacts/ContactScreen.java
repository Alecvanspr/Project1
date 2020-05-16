package sample.contacts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Homescreen;

public class ContactScreen extends Application {

    Scene contactScene;
    Addressbook addressbook = new Addressbook();

    @Override
    public void start(Stage stage) throws Exception{
        Button btnBack = new Button("Back");
        Pane contact = new Pane();

        Button btnAdd = new Button("Add");
        Button btnSave = new Button("Save");
        Button btnFind = new Button("Find");
        Button btnList = new Button("List");
        Button btnEdit = new Button("Edit");

        TextField tfContact = new TextField();

        Label lblname = new Label("Full Name");
        Label lblemail = new Label("Email");
        Label lblphonenumber = new Label("Phone");
        Label lblstreet = new Label("Street");
        Label lblpostelcode = new Label("Postelcode");
        Label lblcity = new Label("City");
        Label lblcountry = new Label("Country");

        Label lblFoundContact = new Label();

        Label nameData = new Label();
        Label emailData = new Label("Email");
        Label phonenumberData = new Label("Phone");
        Label streetData = new Label("Street");
        Label postelcodeData = new Label("Postelcode");
        Label cityData = new Label("City");
        Label countryData = new Label("Country");

        TextField tfName = new TextField();
        TextField tfEmail = new TextField();
        TextField tfPhoneNumber = new TextField();
        TextField tfStreet = new TextField();
        TextField tfPostelCode = new TextField();
        TextField tfCity = new TextField();
        TextField tfCountry = new TextField();



        btnAdd.relocate(500,300);
        btnSave.relocate(545,300);

        btnEdit.relocate(100,490);
        btnList.relocate(310,50);

        btnFind.relocate(260,50);
        tfContact.relocate(100,50);

        String contactNames = Addressbook.list();
        TextArea taContacts = new TextArea(contactNames);
        taContacts.relocate(100,90);
        taContacts.setPrefColumnCount(20);
        taContacts.setPrefRowCount(10);
        taContacts.setEditable(false);

        TextArea taContactsFullDetail = new TextArea(contactNames);
        taContactsFullDetail.relocate(100,290);
        taContactsFullDetail.setPrefColumnCount(20);
        taContactsFullDetail.setPrefRowCount(10);
        taContactsFullDetail.setEditable(false);

        lblname.relocate(430,90);
        lblemail.relocate(430,120);
        lblphonenumber.relocate(430,150);
        lblstreet.relocate(430,180);
        lblpostelcode.relocate(430,210);
        lblcity.relocate(430,240);
        lblcountry.relocate(430,270);

        tfName.relocate(500,90);
        tfEmail.relocate(500,120);
        tfPhoneNumber.relocate(500,150);
        tfStreet.relocate(500,180);
        tfPostelCode.relocate(500,210);
        tfCity.relocate(500,240);
        tfCountry.relocate(500,270);

        btnEdit.setOnAction(E->{

            tfName.setText("");
            tfEmail.setText("");
            tfPhoneNumber.setText("");
            tfStreet.setText("");
            tfPostelCode.setText("");
            tfCity.setText("");
            tfCountry.setText("");
            lblFoundContact.setText("");
        });


        btnAdd.setOnAction(E->{
            Address address = new Address(tfStreet.getText(), tfPostelCode.getText(), tfCity.getText(),tfCountry.getText());
            Contact contactAdd = new Contact(tfName.getText(), tfEmail.getText(), tfPhoneNumber.getText(), address);
            Addressbook.addContact(contactAdd);
            lblFoundContact.setText("");
            taContacts.appendText(tfName.getText() + "\n");
            tfName.setText("");
            tfEmail.setText("");
            tfPhoneNumber.setText("");
            tfStreet.setText("");
            tfPostelCode.setText("");
            tfCity.setText("");
            tfCountry.setText("");

        });


        btnFind.setOnAction(E->{
            String name = tfName.getText();
            lblFoundContact.setText(name);
            lblFoundContact.setOnMouseClicked(event->{
                taContactsFullDetail.setText(Addressbook.displayContact(name) + "\n");
            });
            taContacts.setText("");
            lblFoundContact.relocate(104,95);
            contact.getChildren().add(lblFoundContact);
        });

        btnList.setOnAction(E->{
            lblFoundContact.setText("");
            taContacts.setText("");
            taContacts.appendText(Addressbook.list());
        });

        btnSave.setOnAction(E->{
            addressbook.edit(tfName.getText(),tfEmail.getText(),tfPhoneNumber.getText(),tfStreet.getText(),tfPostelCode.getText(), tfCity.getText(),tfCountry.getText());
        });

        btnEdit.setOnAction(E->{
            lblFoundContact.setText("");
            addressbook.edit(tfName.getText(), tfEmail.getText(), tfPhoneNumber.getText(), tfStreet.getText(),tfPostelCode.getText(),tfCity.getText(),tfCountry.getText());
        });

        contact.getChildren().addAll(btnList, btnSave,btnBack, lblphonenumber, tfPhoneNumber, tfContact,btnAdd,btnEdit,btnFind, lblname, lblemail, lblstreet,lblpostelcode,lblcity,lblcountry,tfCity,tfCountry,tfEmail,tfName,tfPostelCode,tfStreet,taContacts, taContactsFullDetail);
        btnBack.relocate(0,570);



        btnBack.setOnAction(e -> {
            goHomeScreen(stage);
        });

        contactScene = new Scene(contact,800,600);
        stage.setTitle("Contacts");
        stage.setScene(contactScene);
        stage.show();
    }

    public void displayAllContacts(){
        for(int i = 0; i < Addressbook.list().length(); i++){
            Label label = new Label(Addressbook.list());
            label.setOnMouseClicked(E->{

            });

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
}
