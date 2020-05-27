package sample.educative;

import java.util.ArrayList;

public class GetImage {
    ArrayList<String> letterImages = new ArrayList<>();
    ArrayList<String> numberImages = new ArrayList<>();
    public GetImage(){
        setLetterImages();
        setNumberImages();
    }
    public void setNumberImages(){
        numberImages.add("images/education/Numbers/0.jpg");
        numberImages.add("images/education/Numbers/1.jpg");
        numberImages.add("images/education/Numbers/2.jpg");
        numberImages.add("images/education/Numbers/3.jpg");
        numberImages.add("images/education/Numbers/4.jpg");
        numberImages.add("images/education/Numbers/5.jpg");
        numberImages.add("images/education/Numbers/6.jpg");
        numberImages.add("images/education/Numbers/7.jpg");
        numberImages.add("images/education/Numbers/8.jpg");
        numberImages.add("images/education/Numbers/9.jpg");
    }
    public void setLetterImages(){
        letterImages.add("images/education/Uppercase/DrawA.jpg");
        letterImages.add("images/education/Lowercase/DrawLowera.png");
        letterImages.add("images/education/Uppercase/DrawB.jpg");
        letterImages.add("images/education/Lowercase/DrawLowerb.png");
        letterImages.add("images/education/Uppercase/DrawC.jpg");
        letterImages.add("images/education/Lowercase/DrawLowerc.png");
        letterImages.add("images/education/Uppercase/DrawD.jpg");
        letterImages.add("images/education/Lowercase/DrawLowerd.png");
        letterImages.add("images/education/Uppercase/DrawE.jpg");
        letterImages.add("images/education/Lowercase/DrawLowere.png");
        letterImages.add("images/education/Uppercase/DrawF.jpg");
        letterImages.add("images/education/Lowercase/DrawLowerf.png");
        letterImages.add("images/education/Uppercase/DrawG.jpg");
        letterImages.add("images/education/Lowercase/DrawLowerg.png");
        letterImages.add("images/education/Uppercase/DrawH.jpg");
        letterImages.add("images/education/Lowercase/DrawLowerh.png");
        letterImages.add("images/education/Uppercase/DrawI.jpg");
        letterImages.add("images/education/Lowercase/DrawLoweri.png");
        letterImages.add("images/education/Uppercase/DrawJ.jpg");
        letterImages.add("images/education/Lowercase/DrawLowerj.png");
        letterImages.add("images/education/Uppercase/DrawK.jpg");
        letterImages.add("images/education/Lowercase/DrawLowerk.png");
        letterImages.add("images/education/Uppercase/DrawL.jpg");
        letterImages.add("images/education/Lowercase/DrawLowerl.png");
        letterImages.add("images/education/Uppercase/DrawM.jpg");
        letterImages.add("images/education/Lowercase/DrawLowerm.png");
        letterImages.add("images/education/Uppercase/DrawN.jpg");
        letterImages.add("images/education/Lowercase/DrawLowern.png");
        letterImages.add("images/education/Uppercase/DrawO.jpg");
        letterImages.add("images/education/Lowercase/DrawLowero.png");
        letterImages.add("images/education/Uppercase/DrawP.jpg");
        letterImages.add("images/education/Lowercase/DrawLowerp.png");
        letterImages.add("images/education/Uppercase/DrawQ.jpg");
        letterImages.add("images/education/Lowercase/DrawLowerq.png");
        letterImages.add("images/education/Uppercase/DrawR.jpg");
        letterImages.add("images/education/Lowercase/DrawLowerr.png");
        letterImages.add("images/education/Uppercase/DrawS.jpg");
        letterImages.add("images/education/Lowercase/DrawLowers.png");
        letterImages.add("images/education/Uppercase/DrawT.jpg");
        letterImages.add("images/education/Lowercase/DrawLowert.png");
        letterImages.add("images/education/Uppercase/DrawU.jpg");
        letterImages.add("images/education/Lowercase/DrawLoweru.png");
        letterImages.add("images/education/Uppercase/DrawV.jpg");
        letterImages.add("images/education/Lowercase/DrawLowerv.png");
        letterImages.add("images/education/Uppercase/DrawW.jpg");
        letterImages.add("images/education/Lowercase/DrawLowerw.png");
        letterImages.add("images/education/Uppercase/DrawX.jpg");
        letterImages.add("images/education/Lowercase/DrawLowerx.png");
        letterImages.add("images/education/Uppercase/DrawY.jpg");
        letterImages.add("images/education/Lowercase/DrawLowery.png");
        letterImages.add("images/education/Uppercase/DrawZ.jpg");
        letterImages.add("images/education/Lowercase/DrawLowerz.png");
        letterImages.add("images/education/Draw!.jpg");
        letterImages.add("images/education/DrawQuestionMark.jpg");
    }
    public String getLetterImage(int place){
        return  letterImages.get(place);
    }
    public String getNumberImage(int place){
        return numberImages.get(place);
    }
}
