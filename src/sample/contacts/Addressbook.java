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


    public void edit(String name,  String email , String number, String street, String postelcode, String city, String country){
        for(Contact contact : contacts) {
            if(contact.getName().equalsIgnoreCase(name)){
                contact.setName(name);
                contact.setEmail(email);
                contact.setPhoneNumber(number);
                contact.getAddress().setStreet(street);
                contact.getAddress().setPostelCode(postelcode);
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
            if(contact.getName().equals(c))
            return contact.getName() + "\n" + contact.getEmail()
                    + "\n" + contact.getPhoneNumber() + "\n" + contact.getAddress().getStreet()
                    + "\n" + contact.getAddress().getPostelCode() + "\n" + contact.getAddress().getCity()
                    + "\n" + contact.getAddress().getCountry();
        }
        return null;
    }



    @Override
    public String toString() {
        return "contacts=" + contacts;
    }
}

