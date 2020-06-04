package sample.MedicalSection;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import sample.MedicalSection.Doctor;
public class Dates{
    private LocalDate date;
    ArrayList<String> timeTable = new ArrayList<>();
    ArrayList<Boolean> timeChosen = new ArrayList<>();
    public Dates(LocalDate date){
        this.date = date;
        fillTimeTable();


    }
    public LocalDate getDate(){
        return this.date;
    }
    public void fillTimeTable(){
        int x = 0;
        int min;
        while (x < 16){
            int hours = 9 + (int)((0.5)*x);
            if(x%2 == 0){
                min =0;
                timeTable.add(hours+":"+min);
            }else{
                min = 30;
                timeTable.add(hours+":"+min);
            }
            timeChosen.add(false);
            x++;
        }
    }
    public void setChosenTimeOnTrue(String time){
        for(int i = 0; i < timeTable.size(); i++){
            if(timeTable.get(i).equalsIgnoreCase(time)){
                timeChosen.set(i, true);
            }
        }
    }
    public Boolean checkIfChosen(String time){
        for(int i = 0; i < timeTable.size(); i++){
            if(timeTable.get(i).equalsIgnoreCase(time)){
                if(timeChosen.get(i)){
                    return false;
                }else{
                    timeChosen.set(i, true);
                    return true;
                }
            }else{
                return false;
            }
        }
        return false;
    }
}
