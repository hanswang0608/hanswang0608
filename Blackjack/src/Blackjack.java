import java.util.*;

public class Blackjack
{
    private int amount = 1000;
    private int bet;
    private Scanner s1;
    private Scanner s2;
    private String winner;
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;

    public Blackjack()
    {
        s1 = new Scanner(System.in);
        s2 = new Scanner(System.in);
        deck = new Deck();
        playerHand = new Hand(false);
        dealerHand = new Hand(true);
    }

    public void getBet()
    {
            System.out.println("Thank you for playing Black Jack! You have $" + amount + " to play!");
        while(true)
        {
            System.out.println("How much would you like to bet? ");
            int input = s1.nextInt();
            if ((input > amount) || (input < 1))
            {
                System.out.println("Invalid Input!");
            }
            else
            {
                bet = input;
                amount -= bet;
                break;
            }
        }
    }

    public void playerTurn()
    {
        while(playerHand.getTotalValue() <= 21)
        {
            System.out.println("Would you like to hit or stand?");
            String input = s2.nextLine();
            if (input.equals("hit"))
            {
                playerHand.addCard(deck.draw()); 
                System.out.println(playerHand.toString(false));
            }
            else if (input.equals("stand"))
            {
                System.out.println(playerHand.toString(false));
                break;
            }
            else if (input.equals("")){}
            else
            {
                System.out.println("Invalid Input");
            }
        }   
        if (playerHand.getTotalValue() > 21)
        {
            winner = "dealer";
            System.out.println("Your hand is busted!");
        }
    }

    public void dealerTurn()
    {
        System.out.println("Dealer's Turn:\n");
        System.out.println(dealerHand.toString(false));
        while(dealerHand.getTotalValue() <= playerHand.getTotalValue())
        {
            System.out.println("The dealer decides to hit!\n");
            dealerHand.addCard(deck.draw());
            System.out.println(dealerHand.toString(false));
        }
        if (dealerHand.getTotalValue() > 21)
        {
            winner = "player";
            System.out.println("The dealer's hand is busted");
        }
        else
        {
            System.out.println("The decides to stand!");
            winner = "dealer";
        }
    }
    
    public void Start()
    {
        while(amount > 0)
        {
            getBet();
            deck = new Deck();
            deck.shuffle();
            System.out.println("");
            playerHand = new Hand(false);
            dealerHand = new Hand(true);
            for (int i = 0; i < 2; i++)
            {
                playerHand.addCard(deck.draw());
                dealerHand.addCard(deck.draw());
            }
            System.out.println(playerHand.toString(false));
            System.out.println(dealerHand.toString(false));
            playerTurn();
            if (playerHand.getTotalValue() <= 21)
            {
                dealerTurn();
            }
            if (winner.equals("player"))
            {
                amount += bet*2;
                System.out.println("The player has won this round!\n");
            }
            else if (winner.equals("dealer"))
            {
                System.out.println("The dealer has won this round!\n");
            }
            System.out.println("The dealer's hand was:\n" + dealerHand.toString(true));
            if (amount < 1)
            {
                System.out.println("Thank you for playing Black Jack! You have no more money to play. :(");
            }
        }
    }
}