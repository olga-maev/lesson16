import java.util.ArrayList;
import java.util.List;

public class Game {

    protected List<Player> playerList = new ArrayList<>();

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void register(Player player) {
        playerList.add(player);
    }

    public int round(String playerName1, String playerName2) {

        int player1Regisrtation = -1;
        int player2Regisrtation = -1;
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).name.equals(playerName1)) {
                player1Regisrtation = playerList.get(i).getStrength();
            }
            if (playerList.get(i).name.equals(playerName2)) {
                player2Regisrtation = playerList.get(i).getStrength();
            }
        }
        if (player1Regisrtation == -1 && player2Regisrtation == -1) {
            throw new NoRegisteredExpection("Для продолжения игры необходимо зарегистрироваться обоим игрокам");
        }
        if (player1Regisrtation == -1 && player2Regisrtation != -1) {
            throw new NoRegisteredExpection("Для продолжения игры первому игроку необходимо зарегистрироваться");
        }
        if (player1Regisrtation != -1 && player2Regisrtation == -1) {
            throw new NoRegisteredExpection("Для продолжения игры второму игроку необходимо зарегистрироваться");
        }
        if (player1Regisrtation > player2Regisrtation) {
            return 1;
        } else {
            if (player1Regisrtation < player2Regisrtation) {
                return 2;
            } else {
                return 0;
            }
        }
    }


}
