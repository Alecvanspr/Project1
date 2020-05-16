package sample.market;

import java.util.ArrayList;
import java.util.Timer;

import javafx.scene.control.Alert;
import sample.ArrayKeeper;
import sample.livestock.Animal;
import sample.market.AuctionList;
import java.util.Scanner;

public class Auction {
    private Animal forSale;
    private Bid highestBid;
    private ArrayList<Bid> bidHistory;
    private ArrayList<Animal> forSaleQueue;
    private static ArrayList<Auction> auctionList = new ArrayList<Auction>();
    private int UserId;
    public Auction(Animal animalForSale,Double minPrice){
        this.forSale = animalForSale;
        this.highestBid = firstBid(minPrice,animalForSale);
        ArrayList<Bid> bidHistory = new ArrayList<Bid>();
        this.bidHistory = bidHistory;
        ArrayList<Animal> forSaleQueue = new ArrayList<Animal>();
        this.forSaleQueue = forSaleQueue;
        addToAuctionList(this);
        this.UserId = ArrayKeeper.getCurrentUser();
    }
    public Boolean getAmountMustBeHigher(Double amount, Double highestAmount){
        if(amount > highestAmount){
            return true;
        }else{
            return false;
        }
    }

    public static void addToAuctionList(Auction auction){
        auctionList.add(auction);
    }
    public static ArrayList<Auction> getAuctionList(){
        return auctionList;
    }

    public Animal getForSale(){
        return forSale;
    }

    public ArrayList<Animal> getForSaleQueue(){
        return forSaleQueue;
    }

    public void addAnimalToQueue(Animal animal){
        this.getForSaleQueue().add(animal);
    }

    public void removeAnimalFromQueue(Animal animal){
        this.getForSaleQueue().remove(animal);
    }

    public Bid getHighestBid(){
        return highestBid;
    }

    public int getUserId(){
        return this.UserId;
    }


    public void setHighestBid(Bid bid){
        this.highestBid = bid;
    }

    public ArrayList<Bid> getBidHistory(){
        return bidHistory;
    }

    public boolean isHigher(Double amount){
        if(amount > getHighestBid().getAmount()){
            return true;
        }else{
            return false;
        }
    }

    public void makeBid(String user, Double amount ,Animal animal){
            if(isHigher(amount)) {
                Bid newBid = new Bid(user, amount, animal);
                this.setHighestBid(newBid);
                this.getBidHistory().add(newBid);
                System.out.println("Bid succesfully placed!");
                Alert bidIsPlaced = new Alert(Alert.AlertType.INFORMATION);
                bidIsPlaced.setContentText("Bid of " + amount + " has been placed!");
                bidIsPlaced.show();

            }
            else{
                System.out.println("The amount you want to bid MUST be higher than the current highest bid.");
                Alert bidIsToLow = new Alert(Alert.AlertType.ERROR);
                bidIsToLow.setContentText("Bid is to low! needs to be higher then " + amount);
                bidIsToLow.show();
            }

    }

    public Bid firstBid(Double minPrice,Animal animal){
        Bid startBid = new Bid("Nobody", minPrice,animal);
        return startBid;
    }

    public String highestBidToString(){
        return "The current highest bid is " + this.getHighestBid().getAmount() + " by " + this.getHighestBid().getUser() + ".";
    }

    public void printBidHistory() {
        for (int i = this.getBidHistory().size() - 1; i >= 0; i--) {
            if (i > 0) {
                System.out.printf("%.2f", this.getBidHistory().get(i).getAmount());
                System.out.print(" by " + this.getBidHistory().get(i).getUser() + "\n");
            } else {
                System.out.printf("%.2f", this.getBidHistory().get(i).getAmount());
                System.out.print(" by " + this.getBidHistory().get(i).getUser());
            }
        }
    }


    public static void main(String[] args) {
    }
}

