import java.util.ArrayList;
import java.util.List;

public class Game {

    protected List<Player> playerList = new ArrayList<>();

    public List<Player> getPlayerList() {
        return playerList;
    }

    public List<Integer> strenghts = new ArrayList<>();

    public void register(Player player) {
        playerList.add(player);
    }

    public int round(String playerName1, String playerName2) {

        strenghts.add(-1);
        strenghts.add(-1);
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).name == playerName1) {
                strenghts.set(0, playerList.get(i).getStrength());
            }
            if (playerList.get(i).name == playerName2) {
                strenghts.set(1, playerList.get(i).getStrength());
            }
        }
        if (strenghts.get(0) == -1 && strenghts.get(1) == -1) {
            throw new NoRegisteredExpection("Для продолжения игры необходимо зарегистрироваться обоим игрокам");
        }
        if (strenghts.get(0) == -1 && strenghts.get(1) != -1) {
            throw new NoRegisteredExpection("Для продолжения игры первому игроку необходимо зарегистрироваться");
        }
        if (strenghts.get(0) != -1 && strenghts.get(1) == -1) {
            throw new NoRegisteredExpection("Для продолжения игры второму игроку необходимо зарегистрироваться");
        }
        if (strenghts.get(0) > strenghts.get(1)) {
            return 1;
        } else {
            if (strenghts.get(0) < strenghts.get(1)) {
                return 2;
            } else {
                return 0;
            }
        }
    }


}
