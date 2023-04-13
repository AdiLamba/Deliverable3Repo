package d3;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractPlayer {
    protected ArrayList<Card> hand = new ArrayList<>();
    int bookCount;

    public AbstractPlayer() {
    	this.hand = new ArrayList<>();
    	this.bookCount = 0;
        for (int i = 0; i < 7; i++) {
            draw();
        }
    }

    public abstract void takeTurn();

    protected void draw() {
        Card card = GoFish.drawCard();
        if (card != null) {
            hand.add(card);
            checkForBooks();
        }
    }

    public int getBookCount() {
        return bookCount;
    }

    protected void checkForBooks() {
        HashMap<Card, Integer> cardCounts = new HashMap<>();
        if (hand == null) {
            return;
        }

        for (Card card : hand) {
            cardCounts.put(card, cardCounts.getOrDefault(card, 0) + 1);
        }

        for (Card card : cardCounts.keySet()) {
            if (cardCounts.get(card) >= 4) {
                hand.removeIf(c -> c == card);
                setBookCount(getBookCount() + 1);
            }
        }
    }

    protected Card requestCard(AbstractPlayer otherPlayer, Card card) {
        ArrayList<Card> removedCards = new ArrayList<>();
        otherPlayer.hand.removeIf(c -> {
            if (c == card) {
                removedCards.add(c);
                return true;
            }
            return false;
        });

        if (!removedCards.isEmpty()) {
            hand.addAll(removedCards);
            checkForBooks();
            return card;
        }

        return null;
    }

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
}
