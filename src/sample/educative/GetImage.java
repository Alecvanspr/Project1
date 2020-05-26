package sample.educative;

import java.util.ArrayList;

public class GetImage {
    ArrayList<String> letterImages = new ArrayList<>();
    public GetImage(){
        setLetterImages();
    }
    public void setLetterImages(){
        letterImages.add("images/education/DrawA.jpg");
        letterImages.add("images/education/DrawLowera.jpg");
        letterImages.add("images/education/DrawB.jpg");
        letterImages.add("images/education/DrawLowerb.jpg");
        letterImages.add("images/education/DrawC.jpg");
        letterImages.add("images/education/DrawLowerc.jpg");
        letterImages.add("images/education/DrawD.jpg");
        letterImages.add("images/education/DrawLowerd.jpg");
        letterImages.add("images/education/DrawE.jpg");
        letterImages.add("images/education/DrawLowere.jpg");
        letterImages.add("images/education/DrawF.jpg");
        letterImages.add("images/education/DrawLowerf.jpg");
        letterImages.add("images/education/DrawG.jpg");
        letterImages.add("images/education/DrawLowerg.jpg");
        letterImages.add("images/education/DrawH.jpg");
        letterImages.add("images/education/DrawLowerh.jpg");
        letterImages.add("images/education/DrawI.jpg");
        letterImages.add("images/education/DrawLoweri.jpg");
        letterImages.add("images/education/DrawJ.jpg");
        letterImages.add("images/education/DrawLowerj.jpg");
        letterImages.add("images/education/DrawK.jpg");
        letterImages.add("images/education/DrawLowerk.jpg");
        letterImages.add("images/education/DrawL.jpg");
        letterImages.add("images/education/DrawLowerl.jpg");
        letterImages.add("images/education/DrawM.jpg");
        letterImages.add("images/education/DrawLowerm.jpg");
        letterImages.add("images/education/DrawN.jpg");
        letterImages.add("images/education/DrawLowern.jpg");
        letterImages.add("images/education/DrawO.jpg");
        letterImages.add("images/education/DrawLowero.jpg");
        letterImages.add("images/education/DrawP.jpg");
        letterImages.add("images/education/DrawLowerp.jpg");
        letterImages.add("images/education/DrawQ.jpg");
        letterImages.add("images/education/DrawLowerq.jpg");
        letterImages.add("images/education/DrawR.jpg");
        letterImages.add("images/education/DrawLowerr.jpg");
        letterImages.add("images/education/DrawS.jpg");
        letterImages.add("images/education/DrawLowers.jpg");
        letterImages.add("images/education/DrawT.jpg");
        letterImages.add("images/education/DrawLowert.jpg");
        letterImages.add("images/education/DrawU.jpg");
        letterImages.add("images/education/DrawLoweru.jpg");
        letterImages.add("images/education/DrawV.jpg");
        letterImages.add("images/education/DrawLowerv.jpg");
        letterImages.add("images/education/DrawW.jpg");
        letterImages.add("images/education/DrawLowerw.jpg");
        letterImages.add("images/education/DrawX.jpg");
        letterImages.add("images/education/DrawLowerx.jpg");
        letterImages.add("images/education/DrawY.jpg");
        letterImages.add("images/education/DrawLowery.jpg");
        letterImages.add("images/education/DrawZ.jpg");
        letterImages.add("images/education/DrawLowerz.jpg");
        letterImages.add("images/education/Draw!.jpg");
        letterImages.add("images/education/DrawQuestionMark.jpg");
    }
    public String getImage(int place){
        return  letterImages.get(place);
    }
}
