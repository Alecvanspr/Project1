package sample.MedicalSection;

import java.time.LocalDate;
import java.util.ArrayList;

public class Dates{
    private LocalDate date;
    private ArrayList<String> timeTable = new ArrayList<>();

    public Dates(LocalDate date){
        this.date = date;
        fillTimeTable();
    }

    public ArrayList<String> getTimeTable(){
        return timeTable;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public void fillTimeTable(){
        int min;
        int x = 0;
        while(x < 16){
            int hours = 9 + (int)((0.5)*x);
            if(x%2 == 0){
                min = 0;
                timeTable.add(hours + ":" + min + "0");
            }
            else{
                min = 30;
                timeTable.add(hours + ":" + min);
            }
            x++;
        }
    }

    public void removeTimeFromTimeTable(String chosenTime){
        for(int i = 0; i < timeTable.size(); i++){
            if(timeTable.get(i).equals(chosenTime)){
                this.getTimeTable().remove(i);
            }
        }
    }
}
