package sample.market;
import java.text.DateFormat;
import java.util.Date;
import sample.ArrayKeeper;

public class Bid{
    private String user;
    private int userInt;
    private Double amount;
    private String date;
    private String timeHours;
    private String timeMin;
    public Bid(String user, Double amount){
        this.user = user;
        this.amount = amount;
        this.userInt = ArrayKeeper.getCurrentUser();
        this.date = ""+java.time.LocalDate.now();
        this.timeHours = ""+java.time.LocalTime.now().getHour();
        this.timeMin = ""+java.time.LocalTime.now().getMinute();
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
}
