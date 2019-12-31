import java.util.*;
public class DeckTest
{
    public static void main(String[] args)
    {
        Deck d = new Deck();
        d.shuffle();
        for (int i = 0; i <= 51; i++)
        {
            System.out.println(d.draw());
        }
    }
}