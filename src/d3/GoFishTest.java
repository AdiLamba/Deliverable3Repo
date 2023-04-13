package d3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GoFishTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGoodDrawCard() {
		// Create a new deck with one card
		GoFish.setDeck(new ArrayList<>(Collections.singletonList(Card.ACE)));
		// Draw the card from the deck
		Card card = GoFish.drawCard();
		// Verify that the card is not null
		assertNotNull(card);
		// Verify that the card is the one we added to the deck
		assertEquals(Card.ACE, card);
	}

	@Test
	void testBadDrawCard() {
		// Create a new empty deck
		GoFish.setDeck(new ArrayList<>());
		// Draw a card from the deck
		Card card = GoFish.drawCard();
		// Verify that the card is null
		assertNull(card);
	}

	@Test
	void testBoundaryGetCard() {
		// Create a new deck with all the cards in the deck
		GoFish.setDeck(new ArrayList<>(Arrays.asList(Card.values())));
		// Draw all the cards from the deck
		for (int i = 0; i < 52; i++) {
			GoFish.drawCard();
		}
		// Try to draw one more card from the deck
		Card card = GoFish.drawCard();
		// Verify that the card is null
		assertNull(card);
	}

	@Test
	void testGoodInitializeDeck() {
		// Call the initializeDeck() method
		GoFish.initializeDeck();
		// Verify that the deck has 52 cards
		assertEquals(52, GoFish.getDeck().size());
		// Verify that the deck contains all the cards
		assertTrue(GoFish.getDeck().containsAll(Arrays.asList(Card.values())));
	}

	@Test
	void testBadInitializeDeck() {
		// Set the deck to null
		GoFish.setDeck(null);
		// Call the initializeDeck() method
		GoFish.initializeDeck();
		// Verify that the deck is not null
		assertNotNull(GoFish.getDeck());
	}

	@Test
	void testBoundaryInitializeDeck() {
		// Create a new deck with one card
		GoFish.setDeck(new ArrayList<>(Arrays.asList(Card.ACE)));
		// Call the initializeDeck() method
		GoFish.initializeDeck();
		// Verify that the deck has 52 cards
		assertEquals(52, GoFish.getDeck().size());
		// Verify that the deck contains all the cards
		assertTrue(GoFish.getDeck().containsAll(Arrays.asList(Card.values())));
	}

	@Test
	public void testSetDeckGood() {
		ArrayList<Card> deck = new ArrayList<>();
		deck.add(Card.ACE);
		deck.add(Card.KING);
		GoFish.setDeck(deck);
		assertEquals(deck, GoFish.getDeck());
	}

	@Test
	public void testSetDeckBad() {
		GoFish.setDeck(null);
	}

	@Test
	public void testSetDeckBoundary() {
		ArrayList<Card> deck = new ArrayList<>();
		GoFish.setDeck(deck);
		assertEquals(deck, GoFish.getDeck());
	}

}
