package sample.JavaFXTests;

import org.junit.Assert;
import org.junit.Test;
import sample.GoToScreens;

public class javaFXTests {
    GoToScreens goToScreens;
    @Test
    public void testEmpety(){
        Assert.assertTrue(checkEmpety());
    }
    public boolean checkEmpety(){
        boolean ret = false;
        if(goToScreens ==(null)){
            ret = true;
        }
        return ret;
    }
}
