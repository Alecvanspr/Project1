package sample.MedicalSection;

import java.time.LocalDate;

public class Complaint{
    private Specialty bodyPart;
    private LocalDate firstNoticed;
    private LocalDate cured;
    private boolean hasBeenCured = false;

    public Complaint(Specialty bodyPart, LocalDate[] timeSpan){
        this.bodyPart = bodyPart;
        this.firstNoticed = timeSpan[0];
        this.cured = timeSpan[1];
    }

    public boolean getHasBeenCured(){
        return hasBeenCured;
    }

    public Specialty getBodyPart(){
        return bodyPart;
    }

    public LocalDate getFirstNoticed(){
        return firstNoticed;
    }

    public LocalDate getCured(){
        return cured;
    }

    public void setBodyPart(Specialty bodyPartNew){
        bodyPart = bodyPartNew;
    }

    public void setFirstNoticed(LocalDate firstNoticedNew){
        firstNoticed = firstNoticedNew;
    }

    public void setCured(LocalDate curedNew){
        cured = curedNew;
    }

    public void setHasBeenCured(boolean hasBeenCured){
        this.hasBeenCured = hasBeenCured;
    }
}