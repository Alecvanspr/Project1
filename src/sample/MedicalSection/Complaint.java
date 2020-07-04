package sample.MedicalSection;

import java.util.Date;

public class Complaint{
    private Specialty bodyPart;
    private Date firstNoticed;
    private Date cured;
    private boolean hasBeenCured = false;

    public boolean getHasBeenCured(){
        return hasBeenCured;
    }

    public void setHasBeenCured(boolean hasBeenCured){
        this.hasBeenCured = hasBeenCured;
    }

    public Specialty getBodyPart(){
        return bodyPart;
    }

    public Date getFirstNoticed(){
        return firstNoticed;
    }

    public Date getCured(){
        return cured;
    }

    public void setBodyPart(Specialty bodyPartNew){
        bodyPart = bodyPartNew;
    }

    public void setFirstNoticed(Date firstNoticedNew){
        firstNoticed = firstNoticedNew;
    }

    public void setCured(Date curedNew){
        cured = curedNew;
    }
}