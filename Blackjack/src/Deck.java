import java.util.*;

public class Deck{
    protected ArrayList<Card> arrayOfCards = new ArrayList<Card>();
    
    public Deck()
    {
        for (int i = 1; i <= 13; i++)
        {
            for (int j = 1; j <= 4; j++)
            {
                arrayOfCards.add(new Card(i, j));
            }
        }
    }

    public void shuffle(){
        Random r = new Random();
        for (int i = 0; i < 1000000; i++){
            int tempFirstCard = r.nextInt(arrayOfCards.size());
            int tempSecondCard = r.nextInt(arrayOfCards.size());
            Card firstCard = arrayOfCards.get(tempFirstCard);
            arrayOfCards.set(tempFirstCard, arrayOfCards.get(tempSecondCard));
            arrayOfCards.set(tempSecondCard, firstCard);
        }
    }

    public Card draw(){
        
        return arrayOfCards.remove(arrayOfCards.size()-1);
    }
}