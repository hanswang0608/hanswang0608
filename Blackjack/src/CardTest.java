import java.util.*;
public class CardTest
{
    public static void main(String[] args)
    {
        ArrayList<Card> arrayOfCards = new ArrayList<Card>();
        for (int i = 1; i <= 4; i++)
        {
            for (int j = 1; j<=13; j++)
            {

                arrayOfCards.add(new Card(j,i));
            }
        }
        System.out.println(arrayOfCards.get(0));
        System.out.println(arrayOfCards.get(25));
        System.out.println(arrayOfCards.get(42));
    }
}