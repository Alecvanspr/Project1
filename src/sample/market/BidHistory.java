package sample.market;

import sample.ArrayKeeper;

import java.util.ArrayList;

public class BidHistory {
        private ArrayList<Bid> userBidHistoryList = new ArrayList<>();
        private int userInt;

        public BidHistory() {
            this.userInt = ArrayKeeper.getCurrentUser();
            ArrayList<Bid> temporarlyList = new ArrayList<>();
            for (int i = 0; i < Auction.getAuctionList().size(); i++) {
                temporarlyList = Auction.getAuctionList().get(i).getBidHistory();
                for (int j = 0; j < temporarlyList.size(); j++) {
                    if (this.userInt == temporarlyList.get(j).getUserInt()) {
                        userBidHistoryList.add(temporarlyList.get(j));
                    }
                }
            }
        }

        public int getUserInt() {
            return userInt;
        }

        public ArrayList<Bid> getUserBidHistoryList() {
            return this.userBidHistoryList;
     }
}
