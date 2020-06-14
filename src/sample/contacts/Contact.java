package sample.contacts;

public class Contact{
    private String name;
    private String email;
    private String phoneNumber;
    private Address address;
//String name, String email, String phoneNumber
    public Contact(Object object[], Address address){
        this.name = object[0].toString();
        this.email = object[1].toString();
        this.phoneNumber = object[2].toString();
        this.address = address;
    }

    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return this.getName() + "\n" + this.getEmail()
                + "\n" + this.getPhoneNumber() + "\n" + this.getAddress().getStreet()
                + "\n" + this.getAddress().getPostalCode() + "\n" + this.getAddress().getCity()
                + "\n" + this.getAddress().getCountry();
    }

}
