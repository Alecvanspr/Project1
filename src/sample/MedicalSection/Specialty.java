package sample.MedicalSection;

public class Specialty {
    private String name;
    private static int specialtyNumber;


    public Specialty(String name){

        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
}

