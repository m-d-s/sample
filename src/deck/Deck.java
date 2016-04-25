package deck;
import card.Card;
/**
 * Created by msimpson on 4/23/16.
 */
public interface Deck {
  /* Create the deck of cards */
  void create( int numberOfSuits, int numberOfRanks );

  /* deal a card from the deck */
  Card deal();

  /* Shuffle the deck */
  void shuffle();
}
