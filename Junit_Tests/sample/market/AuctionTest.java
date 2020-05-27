package sample.market;

import org.junit.Assert;
import org.junit.Test;
import sample.livestock.Animal;

public class AuctionTest {
    @Test
    public void TestIsHigher() {
        Animal animal = new Animal("Henk", "M", 4, "horse", "unknown", 4.3, "Good");
        Auction auctio = new Auction(animal, 2.50);
        auctio.makeBid("ok", 4.423, animal);
        Assert.assertTrue(auctio.isHigher(4.424) == true);
    }

    @Test
    public void TestHighestBid() {
        Animal animal = new Animal("Henk", "M", 4, "horse", "unknown", 4.3, "Good");
        Auction auctio = new Auction(animal, 0.0);
        Assert.assertTrue(auctio.getHighestBid().getUser().equals("Nobody") && auctio.getHighestBid().getAmount() == 0.0);
        auctio.makeBid("me", 2.0, animal);
        Assert.assertTrue(auctio.getHighestBid().getUser().equals("me") && auctio.getHighestBid().getAmount() == 2.0);
    }

    @Test
    public void TestForSaleQueue() {
        Animal hors = new Animal("Henk", "M", 4, "horse", "pony", 4.2, "Good");
        Auction auctio = new Auction(hors, 2.5);
        Animal goad = new Animal("Gerda", "F", 3, "goat", "mountain goat", 4.0, "Bad");
        auctio.addAnimalToQueue(goad);
        Assert.assertTrue(auctio.getForSaleQueue().get(0).equals(goad));
        Animal sheeb = new Animal("Grigor", "M", 4, "sheep", "wool", 4.2, "Broken leg");
        auctio.addAnimalToQueue(sheeb);
        auctio.removeAnimalFromQueue(goad);
        Assert.assertTrue(auctio.getForSaleQueue().get(0).equals(sheeb));
    }
}
