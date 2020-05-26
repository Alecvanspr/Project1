package sample.educative;

import java.util.ArrayList;

public class GetImage {
    ArrayList<String> letterImages = new ArrayList<>();
    public GetImage(){
        setLetterImages();
    }
    public void setLetterImages(){
        letterImages.add("images/education/DrawA.jpg");
    }
    public String getImage(int place){
        return  letterImages.get(place);
    }
}
