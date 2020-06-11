package sample.contacts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressbookTest {

    @Before
    public void setup(){
        Addressbook.getListContact().clear();
    }

    @Test
    public void testDisplayContact(){
        String testName= "name";
        String testName2 = "name2";
        Object adressData[] = {"straat", "2593 MR", "Den Haag", "Netherlands"};
        Address address = new Address(adressData);
        Object contactData[] = {"name","name.dfdsf@gmail.com","2636452112"};
        Contact contact = new Contact(contactData,address);
        Addressbook.addContact(contact);
        Assert.assertEquals(Addressbook.displayContact(testName), contact.toString());
            }

    @Test
    public void testDisplayContact2(){
        String testName= "name";
        String testName2 = "name2";
        Object object[] = {"straat", "2593 MR", "Den Haag", "Netherlands"};
        Address address = new Address(object);
        Object contactData[] = {"name","name.dfdsf@gmail.com","2636452112"};
        Contact contact = new Contact(contactData,address);
        Addressbook.addContact(contact);
        Assert.assertEquals(Addressbook.displayContact(testName2), null);
    }

    @Test
    public void testSearchContact(){
        String testName= "name";
        String testName2 = "name2";
        Object object[] = {"straat", "2593 MR", "Den Haag", "Netherlands"};
        Address address = new Address(object);
        Object contactData[] = {"name","name.dfdsf@gmail.com","2636452112"};
        Contact contact = new Contact(contactData,address);
        Addressbook.addContact(contact);
        Assert.assertEquals(Addressbook.searchContact(testName,0), contact);
    }

    @Test
    public void testSearchContact2(){
        String testName= "name";
        String testName2 = "name2";
        Object object[] = {"straat", "2593 MR", "Den Haag", "Netherlands"};
        Address address = new Address(object);
        Object contactData[] = {"name","name.dfdsf@gmail.com","2636452112"};
        Contact contact = new Contact(contactData,address);
        Addressbook.addContact(contact);
        Assert.assertEquals(Addressbook.searchContact(testName2,0), null);
    }

}