package sample.market;

import java.util.ArrayList;
import java.util.Scanner;

public class Auction {
    private Animal forSale;
    private Bid highestBid;
    private ArrayList<Bid> bidHistory;
    private ArrayList<Animal> forSaleQueue;
    private static ArrayList<Auction> auctionList = new ArrayList<Auction>();
    private Boolean amountMustBeHigher;
    public Auction(Animal animalForSale,Double minPrice){
        this.forSale = animalForSale;
        this.highestBid = firstBid(minPrice);
        ArrayList<Bid> bidHistory = new ArrayList<Bid>();
        this.bidHistory = bidHistory;
        ArrayList<Animal> forSaleQueue = new ArrayList<Animal>();
        this.forSaleQueue = forSaleQueue;
        addToAuctionList(this);


    }
    public Boolean getAmountMustBeHigher(){
        return this.amountMustBeHigher;
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


    public void setHighestBid(Bid bid){
        this.highestBid = bid;
    }

    public ArrayList<Bid> getBidHistory(){
        return bidHistory;
    }

    public boolean isHigher(Double amount){
        if(amount > this.getHighestBid().getAmount()){
            return true;
        }else{
            return false;
        }
    }

    public void makeBid(String user, Double amount){
        if(this.getHighestBid().getUser().equals(user)){
            System.out.println("You have already placed the highest bid.");
        }
        else{
            if(this.isHigher(amount)) {
                Bid newBid = new Bid(user, amount);
                this.setHighestBid(newBid);
                this.getBidHistory().add(newBid);
                System.out.println("Bid succesfully placed!");
                amountMustBeHigher = false;
            }
            else{
                System.out.println("The amount you want to bid MUST be higher than the current highest bid.");
                amountMustBeHigher = true;
            }
        }
    }

    public Bid firstBid(Double minPrice){
        Bid startBid = new Bid("Nobody", minPrice);
        return startBid;
    }

    public String highestBidToString(){
        return "The current highest bid is " + this.getHighestBid().getAmount() + " by " + this.getHighestBid().getUser() + ".";
    }

    public void printBidHistory(){
        for(int i = this.getBidHistory().size()-1; i >= 0; i--) {
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

class Bid{
    private String user;
    private Double amount;

    public Bid(String user, Double amount){
        this.user = user;
        this.amount = amount;
    }

    public Double getAmount(){
        return amount;
    }

    public String getUser(){
        return user;
    }
}
