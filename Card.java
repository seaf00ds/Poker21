//Card class
class Card {
    int rank;
    char suit;

    public Card(int rank, char suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        String cardRank;
        switch (this.rank) {
            case 1:
                cardRank = "Ace";
                break;
            case 11:
                cardRank = "Jester";
                break;
            case 12:
                cardRank = "Queen";
                break;
            case 13:
                cardRank = "King";
                break;
            default:
                cardRank = String.valueOf(this.rank);
        }
        return "Card{" + "rank=" + cardRank + ", suit=" + suit + '}';
    }
}
