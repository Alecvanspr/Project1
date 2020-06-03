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
    public void fillTimeTable(){
        int x = 0;
        int min = 0;
        while (x < 16){
            int hours = 9 + ((1/2)*x);
            if(x%2 == 0){

                timeTable.add(hours+":"+min);
            }else{
                min = 30;
                timeTable.add(hours+":"+min);
            }
            timeChosen.add(false);
            x++;
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
