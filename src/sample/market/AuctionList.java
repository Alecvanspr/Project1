package sample.market;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import sample.ArrayKeeper;
import sample.livestock.Animal;

public class AuctionList {

    public Animal makeAnimal(String name, String gender, int age, String species, String race, double weight, String health){ //dit moet achteaf verwijderd worden
        Animal animal = new Animal(name,gender,age,species,race,weight,health);
        return animal;
    }
    public double stringToDouble(String string){
        double d = Double.parseDouble(string);
        return d;
    }
    public String checkIfDouble(String string){
        if (!string.contains("\\.")){
            String correctString = string + ".0";
            return correctString;
        }else{
            return string;
        }
    }
    public void makeBid(String bidAmount, Auction auction, Label label, Integer howMany, int x, TextField txtBidAmount){
        Double amount = stringToDouble(checkIfDouble(bidAmount));
        auction.makeBid(ArrayKeeper.getPersonalData(ArrayKeeper.getCurrentUser()).getUsername(), amount,auction.getForSale());
        label.setText(auction.getForSale().getSpecies() + "  -  " + howMany.toString() + "  -  " + Auction.getAuctionList().get(x).getHighestBid().getAmount());

        txtBidAmount.setText("");
    }
    public void printLines(Pane auctionList){
        for(int i = 0; i < Auction.getAuctionList().size(); i++) {
            Auction auction = Auction.getAuctionList().get(i);
            Integer howMany = 1+auction.getForSaleQueue().size(); //De +1 is omdat de eerste animal van de auction niet in de queue komt
            Label textField = new Label(auction.getForSale().getSpecies() + "  -  " + howMany.toString() + "  -  " + Auction.getAuctionList().get(i).getHighestBid().getAmount());
            textField.relocate(10, 50 + (30 * i));
            auctionList.getChildren().add(textField);
            Button makeBid = new Button("MakeBid");
            makeBid.relocate(470, 50 + (30 * i));
            auctionList.getChildren().add(makeBid);
            TextField bidAmount = new TextField();
            bidAmount.relocate(250, 50 + (30 * i));
            auctionList.getChildren().add(bidAmount);
            Integer x = i;

            makeBid.setOnAction(E -> {
                makeBid(bidAmount.getText(), auction, textField , howMany, x, bidAmount);
            });
        }
    }
}
