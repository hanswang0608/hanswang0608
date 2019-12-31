import java.util.*;

public class Hand
{
    private ArrayList<Card> arrayOfCards = new ArrayList<Card>();
    private int totalValue;
    private boolean isDealer;

    public Hand(boolean isDealer)
    {
        this.isDealer = isDealer;
    }

    public void addCard(Card card)
    {
        arrayOfCards.add(card);
        totalValue += card.getValue();
    }

    public int getTotalValue()
    {
        return totalValue;
    }

    public String toString(boolean gameOver)
    {
        String output = "";
        if (isDealer)
        {
            if (gameOver)
            {
                for (int i = 0; i < arrayOfCards.size(); i++)
                {
                    output += "\t" + arrayOfCards.get(i) + "\n";
                }
                return "Dealer's Hand:\n" + output;
            }
            else
            {
                output += "\tCard: ?????\n";
                for (int i = 1; i < arrayOfCards.size(); i++)
                {
                    output += "\t" + arrayOfCards.get(i) + "\n";
                }
                return "Dealer's Hand:\n" + output;
            }
        }
        else
        {
            for (int i = 0; i < arrayOfCards.size(); i++)
            {
                output += "\t" + arrayOfCards.get(i) + "\n";
            }
            return "Player's Hand:\n" + output + "\tCurrent Total: " + totalValue + "\n";
        }
    }
}
