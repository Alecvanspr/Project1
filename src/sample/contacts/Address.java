package sample.contacts;

public class Address{
    private String street;
    private String postelCode;
    private String city;
    private String country;

    public Address(String name, String postelCode,String city,String country){
        this.street = name;
        this.postelCode = postelCode;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public String getPostelCode() {
        return postelCode;
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

    public void setPostelCode(String postelCode) {
        this.postelCode = postelCode;
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
                ", postelCode='" + postelCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
