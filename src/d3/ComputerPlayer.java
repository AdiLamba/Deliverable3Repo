package d3;

import java.util.Random;

public class ComputerPlayer extends AbstractPlayer {
    private Random random = new Random();

    @Override
    public void takeTurn() {
        while (true) {
            Card requestedCard = hand.get(random.nextInt(hand.size()));
            System.out.println("The AI requests a " + requestedCard);

            Card receivedCard = requestCard(GoFish.players[0], requestedCard);
            if (receivedCard != null) {
                System.out.println("The AI received a " + receivedCard + " from you.");
                checkForBooks();
            } else {
                System.out.println("The AI didn't get the card. Go Fish!");
                draw();
                break;
            }
        }
    }
}
