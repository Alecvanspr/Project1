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

    public void edit(String contactData[]){
        for(Contact contact : contacts) {
            if(contact.getName().equalsIgnoreCase(contactData[0])){
                contact.setName(contactData[0]);
                contact.setEmail(contactData[1]);
                contact.setPhoneNumber(contactData[2]);
                contact.getAddress().setStreet(contactData[3]);
                contact.getAddress().setPostalCode(contactData[4]);
                contact.getAddress().setCity(contactData[5]);
                contact.getAddress().setCountry(contactData[6]);
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

