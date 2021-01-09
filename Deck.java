//Deck.java is used to hold all the functions Poker21 will be using

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Deck {
    //Shows the cards that are currently in the deck
    static public void showCards(ArrayList<Card> deckOfCards) {
        try {
            for (int x = 0; x < deckOfCards.size(); x++) {
                System.out.println(deckOfCards.get(x).rank + " " + deckOfCards.get(x).suit);
            }
            System.out.println("This deck has " + deckOfCards.size() + " cards");
        } catch (Exception e) {
            System.out.println("Something went wrong when printing the deck of cards\n" + "Error: " + e);
        }
    }
    //This is how the player's score will be calculated
    static public int playerCalculation(ArrayList<Card> playerHand) {
        Scanner scan = new Scanner(System.in);
        int total = 0;
        for (int j = 0; j < playerHand.size(); j++) {
            if (playerHand.get(j).rank == 1) {
                System.out.println("You have an ace! Do you want it scored as 1 or 10?\n(Type in '1' or '10')");
                String aceChoice;
                aceChoice = scan.nextLine();
                if (aceChoice.equals("1")) {
                    playerHand.get(j).rank = 1;
                } else {
                    playerHand.get(j).rank = 10;
                }
            }
            total += playerHand.get(j).rank;
        }
        System.out.println("Your current hand: " + playerHand);
        System.out.println(total);
        return total;
    }
    //This is how the opponent will play the game
    static public int opponentCalculation(ArrayList<Card> deckOfCards, ArrayList<Card> playerHand) {
        Random rand = new Random();
        int total = 0;
        int k = 0;

        while (total < 17) {

            int rando = rand.nextInt(deckOfCards.size());
            Card drawACard = deckOfCards.get(rando);
            deckOfCards.remove(rando);

            playerHand.add(drawACard);
            total += playerHand.get(k).rank;
            k++;
        }
        return total;
    }
    //returns the Card that was removed from the arraylist
    static public Card drawACard(ArrayList<Card> deckOfCards) {
        Random rand = new Random();
        int rando = rand.nextInt(deckOfCards.size());
        Card drawACard = deckOfCards.get(rando);
        deckOfCards.remove(rando);
        return drawACard;
    }
    //Card combinations function, print when cards are in a certain format
    static public boolean sameSuit(ArrayList<Card> playerHand) {
        Character initialChar = playerHand.get(0).suit;
        boolean sameSuitCards = false;

        for (int h = 0; h < playerHand.size(); h++) {
            if (!initialChar.equals(playerHand.get(h).suit)) {
                sameSuitCards = false;
            } else {
                sameSuitCards = true;
            }
        }
        return sameSuitCards;
    }
    //Card combinations function
    static public boolean fourOfAKind(ArrayList<Card> playerHand) {
        for (int s = 0; s < playerHand.size(); s++) {
            int fourOfAKindCount = 0;
            for (int t = 0; t < playerHand.size(); t++) {
                if (playerHand.get(s).rank == playerHand.get(t).rank) {
                    fourOfAKindCount++;
                }
            }
            if (fourOfAKindCount >= 4) {
                return true;
            }
        }
        return false;
    }
    //Card combinations function
    static public boolean threeOfAKind(ArrayList<Card> playerHand) {
        for (int s = 0; s < playerHand.size(); s++) {
            int threeOfAKindCount = 0;
            for (int t = 0; t < playerHand.size(); t++) {
                if (playerHand.get(s).rank == playerHand.get(t).rank) {
                    threeOfAKindCount++;
                }
            }
            if (threeOfAKindCount >= 3) {
                return true;
            }
        }
        return false;
    }
    //Card combinations function
    static public boolean twoOfAKind(ArrayList<Card> playerHand) {
        for (int s = 0; s < playerHand.size(); s++) {
            int twoOfAKindCount = 0;
            for (int t = 0; t < playerHand.size(); t++) {
                if (playerHand.get(s).rank == playerHand.get(t).rank) {
                    twoOfAKindCount++;
                }
            }
            if (twoOfAKindCount >= 2) {
                return true;
            }
        }
        return false;
    }

    //generates a random double
    static public double areYouLucky() {
        Random rand = new Random();
        int rando = rand.nextInt(100);
        return (rando/100.0) * 100;
    }
}
