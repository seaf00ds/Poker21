import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Poker21 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //I'm using arraylist to hold the cards
        ArrayList<Card> p1 = new ArrayList<>();
        ArrayList<Card> p2 = new ArrayList<>();
        ArrayList<Card> deckOfCards = new ArrayList<>();

        //the for loop makes the deck we'll be using
        for (int i = 1; i < 14; i++) {
            Card spades = new Card(i, 'S');
            deckOfCards.add(spades);
            Card hearts = new Card(i, 'H');
            deckOfCards.add(hearts);
            Card clovers = new Card(i, 'C');
            deckOfCards.add(clovers);
            Card diamonds = new Card(i, 'D');
            deckOfCards.add(diamonds);
        }

        //shows the deck and the associated points
        System.out.println("Here's the deck and the points each card is worth.\n(Note: 11 is Jester, 12 is Queen, and 13 is King.)");
        Deck.showCards(deckOfCards);
        Collections.shuffle(deckOfCards); //shuffles the arraylist
        System.out.println("The Deck is now shuffled!");
        System.out.println("========================================================================================================");
        System.out.println("Let see how lucky you are! \nTo win this game, draw cards that add up to 21 points or score higher than your opponent!");
        System.out.println("The lucky meter said you have a " + Deck.areYouLucky() + "% chance of winning!");

        //draw card(s) from the deck
        boolean stayInLoop = true;
        while (stayInLoop) {
            p1.add(Deck.drawACard(deckOfCards));
            System.out.println("Your current hand: " + p1);
            System.out.println("Draw another card?\n[y/n]");
            if (scan.nextLine().equals("n")) {
                stayInLoop = false;
            }
        }
        System.out.println("========================================================================================================");

        //Determines which card combinations
        if (Deck.sameSuit(p1) && p1.size() > 1) {
            System.out.println("Your cards have the same Suit!");
        }
        if (Deck.fourOfAKind(p1)) {
            System.out.println("Your hand has four of a kind!");
        } else if (Deck.threeOfAKind(p1)) {
            System.out.println("Your hand has three of a kind!");
        } else if (Deck.twoOfAKind(p1)) {
            System.out.println("Your hand has two of a kind!");
        }

        //calculates the score for each player
        int player1Score = Deck.playerCalculation(p1);
        int player2Score = Deck.opponentCalculation(deckOfCards, p2);

        System.out.println("Your opponent scored: " + player2Score);
        //prints out the different ways you can win and lose
        if (player1Score > 21) {
            System.out.println("Your score went over 21!\nYou Lose");
        } else if (player1Score == 21) {
            System.out.println("You got 21! You Win!");
        } else if (player1Score < player2Score && player2Score <= 21) {
            System.out.println("You scored: " + player1Score + "\nYour opponent Wins!");
        } else if (player2Score < player1Score && player1Score <= 21) {
            System.out.println("You scored: " + player1Score + "\nYou Win!");
        } else if (player1Score == player2Score) {
            System.out.println("We have a tie!");
        }
        System.out.println("Game Over");
    }
}
