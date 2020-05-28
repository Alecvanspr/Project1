package sample.contacts;

import java.util.ArrayList;
import java.util.List;

public class Addressbook {
    private static List<Contact> contacts = new ArrayList<>();


    public static void addContact(Contact c){
        contacts.add(c);
    }


    public static List<Contact> find(String search){
        for(Contact contact : contacts) {
            if(contact.getName().equalsIgnoreCase(search)){
                return contacts;
            }
        }
        return null;
    }

    public static String getContact(Contact contact){
        return contact.getName();
    }

    public void edit(String name,  String email , String number, String street, String postalcode, String city, String country){
        for(Contact contact : contacts) {
            if(contact.getName().equalsIgnoreCase(name)){
                contact.setName(name);
                contact.setEmail(email);
                contact.setPhoneNumber(number);
                contact.getAddress().setStreet(street);
                contact.getAddress().setPostalCode(postalcode);
                contact.getAddress().setCity(city);
                contact.getAddress().setCountry(country);
            }
        }
    }


    public static String list(){
        String ret = "";
        for(Contact contact : contacts) {
            ret = ret+ contact.getName() + "\n";
        }
        return ret;
    }

    public static String displayContact(String c){
        for(Contact contact : contacts) {
            System.out.println(c);
            if(contact.getName().toLowerCase().contains(c))
                return contact.toString();
        }
        return null;
    }

    public static Contact searchContact(String name,  int currentUser){
        for(int i=0; i<getListContact().size();i++){
            if(name.equalsIgnoreCase(getListContact().get(i).getName())){
                currentUser=i;
                return getListContact().get(i);
            }
        }
        return null;
    }

    public static List<Contact> getListContact(){
        return contacts;
    }

    @Override
    public String toString() {
        return "contacts=" + contacts;
    }
}

