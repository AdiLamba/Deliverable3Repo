package d3;

import java.util.ArrayList;
import java.util.Random;

public class GoFish {
    private static final Random random = new Random();
    private static ArrayList<Card> deck;
    static AbstractPlayer[] players;

    public static void main(String[] args) {
        initializeDeck();
        players = new AbstractPlayer[]{new HumanPlayer(), new ComputerPlayer()};
        playGame();
    }

    static void initializeDeck() {
        setDeck(new ArrayList<>());
        for (int i = 0; i < 4; i++) {
            for (Card c : Card.values()) {
                getDeck().add(c);
            }
        }
    }

    static void playGame() {
        while (players[0].getBookCount() + players[1].getBookCount() < 13) {
            for (AbstractPlayer player : players) {
                player.takeTurn();
                System.out.println("----------");
            }
        }

        int humanScore = players[0].getBookCount();
        int computerScore = players[1].getBookCount();

        if (humanScore > computerScore) {
            System.out.println("Congratulations, you win " + humanScore + " to " + computerScore + "!");
        } else if (computerScore > humanScore) {
            System.out.println("The AI beat you " + humanScore + " to " + computerScore + "...");
        } else {
            System.out.println("It's a tie at " + humanScore + " each!");
        }
    }

    public static Card drawCard() {
        if (getDeck().isEmpty()) {
            return null;
        }
        return getDeck().remove(random.nextInt(getDeck().size()));
    }

	public static ArrayList<Card> getDeck() {
		return deck;
	}

	public static void setDeck(ArrayList<Card> deck) {
		GoFish.deck = deck;
	}
}
