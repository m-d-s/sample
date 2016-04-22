import card.Card
import deck.DeckFactory
import hand.Hand
import player.Warrior

/**
 * Created by msimpson on 4/20/16.
 */
class WarriorTest extends GroovyTestCase {
    Warrior genghis;
    Hand hand;
    ArrayList<Card> deck;
    ArrayList<Card> topThree;
    Card handCard;


    void setUp() {
        super.setUp()
        genghis = new Warrior("genghis");
        hand = genghis.getHand();
        deck = DeckFactory.makeDeck();
        topThree = new ArrayList<>();
        topThree.add(deck.get(0));
        topThree.add(deck.get(1));
        topThree.add(deck.get(2));
    }

    void testGetTopCard() {
        hand.addCard(deck.get(0));
        hand.addCard(deck.get(1));
        //hand exhibits queue behavior
        assertEquals(true, genghis.getTopCard().equals(deck.get(0)));
        assertEquals(true, genghis.getTopCard().equals(deck.get(1)));
    }

    void testPlaceAtBottom() {
        //add the fourth card in the deck to the hand
        hand.addCard(deck.get(3));
        //place top three cards at bottom of the hand
        genghis.placeAtBottom(topThree);
        //Cards come out ordered 4th, 1st, 2nd, 3rd
        assertEquals(true, genghis.getTopCard().equals(deck.get(3)));
        assertEquals(true, genghis.getTopCard().equals(deck.get(0)));
        assertEquals(true, genghis.getTopCard().equals(deck.get(1)));
        assertEquals(true, genghis.getTopCard().equals(deck.get(2)));
    }

    void testGetHand() {
        hand.addCard(topThree.get(0));
        hand.addCard(topThree.get(1));
        hand.addCard(topThree.get(2));

        for(int i = 0; i < 3; ++i) {
            handCard = genghis.getTopCard();
            assertEquals(true, handCard.equals(topThree.get(i)));
            assertEquals(true, handCard.class.equals(topThree.get(i).class));
        }
    }

    void testGetName() {
        assertEquals(true, genghis.getName().equals("genghis"));
    }

    void testHasCards() {
        assertEquals(false, hand.isEmpty() == genghis.hasCards());
    }

    void testHandSize() {
        genghis.placeAtBottom(topThree);
        assertEquals(true, genghis.handSize() == 3);
        genghis.getTopCard();
        genghis.getTopCard();
        genghis.getTopCard();
    }

    void testDepleteHand() {
        genghis.placeAtBottom(deck);
        assertEquals(false, hand.isEmpty());
        genghis.depleteHand();
        assertEquals(true, hand.isEmpty());
    }
}
