package sample.market;
import sample.ArrayKeeper;
import sample.livestock.Animal;

public class Bid{
    private String user;
    private int userInt;
    private Double amount;
    private String date;
    private String timeHours;
    private String timeMin;
    private Animal animal;
    public Bid(Object object[],Animal animal){
        this.user = object[0].toString();
        this.amount = Double.parseDouble(object[1].toString());
        this.userInt = ArrayKeeper.getCurrentUser();
        this.date = ""+java.time.LocalDate.now();
        this.timeHours = ""+java.time.LocalTime.now().getHour();
        this.timeMin = ""+java.time.LocalTime.now().getMinute();
        this.animal = animal;
    }

    public Double getAmount(){
        return amount;
    }

    public String getUser(){
        return user;
    }

    public int getUserInt(){return userInt;}

    public String getDate(){return date;}

    public String getTime(){
        String time = this.timeHours + ":" + this.timeMin;
        return time;
    }
    public Animal getAnimal() {
        return animal;
    }
}
