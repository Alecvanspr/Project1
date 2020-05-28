package sample.contacts;

public class Address{
    private String street;
    private String postalCode;
    private String city;
    private String country;

    public Address(String name, String postelCode,String city,String country){
        this.street = name;
        this.postalCode = postelCode;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "{" +
                "street='" + street + '\'' +
                ", postelCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
