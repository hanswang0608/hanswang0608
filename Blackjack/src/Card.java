public class Card{
    protected int rank;
    protected int suit;
    protected int value;

    public void setRank(int r){
        rank = r;
    }

    public void setSuit(int s){
        suit = s;
    }

    public void setValue(int v){
        value = v;
    }

    public int getRank(){
        return rank;
    }

    public int getSuit(){
        return suit;
    }

    public int getValue(){
        return value;
    }

    public Card(int r, int s){
        rank = r;
        suit = s;
        if (r == 1){
            value = 11;
        }
        else if(r == 11 || r == 12 || r == 13){
            value = 10;
        }
        else{
            value = r;
        }
    }

    public String toString(){
        String r;
        String s;
        if (rank == 1)
        {
            r = "Ace";
        }
        else if (rank == 11)
        {
            r = "Jack";
        }
        else if (rank == 12)
        {
            r = "Queen";
        }
        else if (rank == 13)
        {
            r = "King";
        }
        else
        {
            r = String.valueOf(rank);
        }
        if (suit == 1)
        {
            s = "Spades";
        }
        else if (suit == 2)
        {
            s = "Hearts";
        }
        else if (suit == 3)
        {
            s = "Clubs";
        }
        else
        {
            s = "Diamonds";
        }
        return "Card: " + r + " of " + s;
    }
}