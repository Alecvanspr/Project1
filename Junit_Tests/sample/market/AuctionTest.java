package sample.market;

import org.junit.Assert;
import org.junit.Test;
import sample.livestock.Animal;

import static org.junit.Assert.*;

public class AuctionTest {

    @Test
    public void testGetAmountMustBeHigher(){
        Auction auction = new Auction(new Animal("bert","man",6,"cow",
                "",66.9,"ok"),55.2);
        Double dbl1 = 75.0;
        Double dbl2 = 60.0;
        Assert.assertTrue(auction.getAmountMustBeHigher(dbl1,dbl2));
    }

    @Test
    public void testGetAmountMustBeHigher2(){
        Auction auction = new Auction(new Animal("bert","man",6,"cow",
                "",66.9,"ok"),55.2);
        Double dbl2 = 75.0;
        Double dbl1 = 60.0;
        Assert.assertFalse(auction.getAmountMustBeHigher(dbl1,dbl2));
    }

    @Test
    public void testGetAmountMustBeHigher3(){
        Auction auction = new Auction(new Animal("bert","man",6,"cow",
                "",66.9,"ok"),55.2);
        Double dbl1 = 75.0;
        Double dbl2 = 75.0;
        Assert.assertFalse(auction.getAmountMustBeHigher(dbl1,dbl2));
    }

    @Test
    public void testIsHigher(){
        Auction auction = new Auction(new Animal("bert","man",6,"cow",
                "",66.9,"ok"),55.2);
        Double dbl1 = 69.2;
        Assert.assertTrue(auction.isHigher(dbl1));
    }

}