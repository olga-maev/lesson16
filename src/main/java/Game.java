import java.util.ArrayList;
import java.util.List;

public class Game {

    protected List<Player> playerList = new ArrayList<>();

    public void register(Player player) {
        playerList.add(player);
    }

    public int round(String playerName1, String playerName2) {
        if (playerList.size() < 2) {
            throw new NoRegisteredExpection("Для продолжения игры необходимо зарегистироваться обоим игрокам");
        }
        if (playerList.get(0).getStrength() > playerList.get(1).getStrength()) {
            return 1;
        } else {
            if (playerList.get(0).getStrength() < playerList.get(1).getStrength()) {
                return 2;
            } else {
                return 0;
            }
        }

    }

}
