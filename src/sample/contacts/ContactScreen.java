package sample.contacts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.GoToScreens;

public class ContactScreen extends Application {
    GoToScreens goToScreens = GoToScreens.getInstance();
    Scene contactScene;
    Addressbook addressbook = new Addressbook();
    int currentUser=0;
    Pane pane = new Pane();

    TextField tfContact = new TextField();
    TextField tfName = new TextField();
    TextField tfEmail = new TextField();
    TextField tfPhoneNumber = new TextField();
    TextField tfStreet = new TextField();
    TextField tfPostelCode = new TextField();
    TextField tfCity = new TextField();
    TextField tfCountry = new TextField();
    TextArea taContacts = new TextArea("");
    Label lblFoundContactExtra = new Label();
    TextArea taContactsFullDetail = new TextArea();

    @Override
    public void start(Stage stage) throws Exception{
        makeLabels();
        relocateTextFields();
        String contactNames = Addressbook.list();
        printContactnames(contactNames);
        printContactsFullDetail(contactNames);
        makeButtons(stage);
        fin(stage);
    }
    public void fin(Stage stage){
        contactScene = new Scene(pane,800,600);
        stage.setTitle("Contacts");
        stage.setScene(contactScene);
        stage.show();
    }
    public void makeButtons(Stage stage){
        makeBtnBack(stage);
        makeBtnAdd();
        makeBtnSave();
        makeBtnFind();
        makebtnList();
        makeBtnEdit();
        makeClear();
    }
    public void relocateTextFields(){
        tfName.relocate(500,90);
        tfEmail.relocate(500,120);
        tfPhoneNumber.relocate(500,150);
        tfStreet.relocate(500,180);
        tfPostelCode.relocate(500,210);
        tfCity.relocate(500,240);
        tfCountry.relocate(500,270);
        tfContact.relocate(100,50);
        pane.getChildren().addAll(tfContact,tfName,tfEmail,tfPhoneNumber,tfStreet,tfPostelCode,tfCity,tfCountry);
    }
    public void printContactnames(String contactNames){
        taContacts.setText(contactNames);
        taContacts.relocate(100,90);
        taContacts.setPrefColumnCount(20);
        taContacts.setPrefRowCount(10);
        taContacts.setEditable(false);
        pane.getChildren().add(taContacts);
    }
    public void printContactsFullDetail(String contactNames){
        taContactsFullDetail.setText(contactNames);
        taContactsFullDetail.relocate(100,290);
        taContactsFullDetail.setPrefColumnCount(20);
        taContactsFullDetail.setPrefRowCount(10);
        taContactsFullDetail.setEditable(false);
        pane.getChildren().add(taContactsFullDetail);
    }

    public void makeBtnBack(Stage stage){
        Button btnBack = new Button("Back");
        btnBack.relocate(0,570);
        btnBack.setOnAction(e -> {
            goToScreens.goHomeScreen(stage);
        });
        pane.getChildren().add(btnBack);
    }
    public void makeBtnAdd(){
        Button btnAdd = new Button("Add");
        btnAdd.relocate(500,300);
        btnAdd.setOnAction(E->{
            addContact();
        });
        pane.getChildren().add(btnAdd);
    }
    public void addContact(){
        Object adressData[] = {tfStreet.getText(), tfPostelCode.getText(), tfCity.getText(),tfCountry.getText()};
        Address address = new Address(adressData);
        Object contactData[] = {tfName.getText(), tfEmail.getText(), tfPhoneNumber.getText()};
        Contact contactAdd = new Contact(contactData, address);
        Addressbook.addContact(contactAdd);
        taContacts.appendText(tfName.getText() + "\n");
        lblFoundContactExtra.setText("");
            clear();
    }
    public void makeBtnSave(){
        Button btnSave = new Button("Save");
        btnSave.relocate(545,300);
        btnSave.setOnAction(E->{
            String contactInfo[] = {tfName.getText(),tfEmail.getText(),tfPhoneNumber.getText(),tfStreet.getText(),tfPostelCode.getText(), tfCity.getText(),tfCountry.getText()};
            addressbook.edit(contactInfo);
        });
        pane.getChildren().add(btnSave);
    }
    public void makeBtnFind(){
        Button btnFind = new Button("Find");
        btnFind.relocate(260,50);
        btnFind.setOnAction(E->{
            findContact();
        });
        pane.getChildren().add(btnFind);
    }
    public void findContact(){
        String name = tfContact.getText();
        lblFoundContactExtra.setText(name);
        lblFoundContactExtra.setTextFill(Color.web("#0000FF"));
        lblFoundContactExtra.setOnMouseClicked(event->{
            taContactsFullDetail.setText("");
            taContactsFullDetail.appendText(Addressbook.displayContact(name) + "\n");
            lblFoundContactExtra.setText("");
        });
        taContacts.setText("");
        lblFoundContactExtra.relocate(107,94);
        pane.getChildren().addAll(lblFoundContactExtra);
    }
    public void makebtnList(){
        Button btnList = new Button("List");
        btnList.relocate(310,50);
        btnList.setOnAction(E->{
            lblFoundContactExtra.setText("");
            taContacts.setText("");
            taContacts.appendText(Addressbook.list());
        });
        pane.getChildren().add(btnList);
    }
    public void makeBtnEdit(){
        Button btnEdit = new Button("Edit");
        btnEdit.relocate(100,490);
        btnEdit.setOnAction(E->{
            addressbook.searchContact(tfContact.getText(),currentUser);
            tfName.setText(Addressbook.getListContact().get(currentUser).getName());
            tfEmail.setText(Addressbook.getListContact().get(currentUser).getEmail());
            tfPhoneNumber.setText(Addressbook.getListContact().get(currentUser).getPhoneNumber());
            tfStreet.setText(Addressbook.getListContact().get(currentUser).getAddress().getStreet());
            tfPostelCode.setText(Addressbook.getListContact().get(currentUser).getAddress().getPostalCode());
            tfCity.setText(Addressbook.getListContact().get(currentUser).getAddress().getCity());
            tfCountry.setText(Addressbook.getListContact().get(currentUser).getAddress().getCountry());
        });
        pane.getChildren().add(btnEdit);
    }
    public void makeClear(){
        Button btnClear = new Button("Clear");
        btnClear.relocate(593,300);
        btnClear.setOnAction(E->{
                clear();
        });
        pane.getChildren().add(btnClear);
    }
    public void makeLabels(){
        Label lblname = new Label("Full Name");
        Label lblemail = new Label("Email");
        Label lblphonenumber = new Label("Phone");
        Label lblstreet = new Label("Street");
        Label lblpostelcode = new Label("Postelcode");
        Label lblcity = new Label("City");
        Label lblcountry = new Label("Country");
        lblname.relocate(430,90);
        lblemail.relocate(430,120);
        lblphonenumber.relocate(430,150);
        lblstreet.relocate(430,180);
        lblpostelcode.relocate(430,210);
        lblcity.relocate(430,240);
        lblcountry.relocate(430,270);
        pane.getChildren().addAll(lblname,lblemail,lblphonenumber,lblstreet,lblpostelcode,lblcity,lblcountry);
    }
    public void clear(){
        tfName.setText("");
        tfEmail.setText("");
        tfPhoneNumber.setText("");
        tfStreet.setText("");
        tfPostelCode.setText("");
        tfCity.setText("");
        tfCountry.setText("");
    }
}
