import entities.Game;
import entities.Ladder;
import entities.Player;
import entities.Snake;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Player> players = new ArrayList<>() {
            {
                add(new Player("vikas"));
                add(new Player("him"));
                add(new Player("sum"));
                add(new Player("viju"));
            }
        };

        List<Snake> snakes = new ArrayList<>() {
            {
                add(new Snake(17, 7));
                add(new Snake(54, 34));
                add(new Snake(62, 19));
                add(new Snake(87, 36));
                add(new Snake(92, 73));
                add(new Snake(98, 79));
            }
        };

        List<Ladder> ladders = new ArrayList<>() {
            {
                add(new Ladder(2, 38));
                add(new Ladder(4, 14));
                add(new Ladder(51, 67));
                add(new Ladder(30, 56));
                add(new Ladder(80, 99));
                add(new Ladder(45, 79));
            }
        };

        Game game = new Game(10, 1, 6, players, ladders, snakes);
        Player player = game.play();
        System.out.println("Winner is: " + player.getName());
    }
}