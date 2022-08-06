import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(12, "Player1", 15);
    Player player2 = new Player(14, "Player2", 45);
    Player player3 = new Player(44, "Player3", 5);
    Player player5 = new Player(48, "Player5", 15);

    @Test
    public void souldWinnerPlayer1() {
        game.register(player3);
        game.register(player2);
        game.register(player1);
        game.register(player5);


        int expented = 2;
        int actual = game.round(player1.name, player2.name);
//        int actual = game.playerList.size();

        Assertions.assertEquals(expented, actual);
    }

    @Test
    public void souldWinnerPlayer2() {
        game.register(player3);
        game.register(player2);
        game.register(player1);
        game.register(player5);

        int expected = 1;
        int actual = game.round(player2.name, player3.name);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void souldWinnerPlayersEquel() {
        game.register(player3);
        game.register(player2);
        game.register(player1);
        game.register(player5);

        int expected = 0;
        int actual = game.round(player1.name, player5.name);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void souldWinnerFirstPlayerError() {
        Player player4 = new Player(25, "Player4", 15);
        game.register(player3);

        Assertions.assertThrows(NoRegisteredExpection.class, () -> {
            game.round("Player4", player3.name);
        });
    }

    @Test
    public void souldWinnerSecindPlayerError() {
        Player player4 = new Player(25, "Player4", 15);
        game.register(player3);

        Assertions.assertThrows(NoRegisteredExpection.class, () -> {
            game.round(player3.name, "Player4");
        });
    }

    @Test
    public void souldWinnerAllPlaers() {

        Assertions.assertThrows(NoRegisteredExpection.class, () -> {
            game.round("Player3", "Player4");
        });
    }
}
