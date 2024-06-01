import entities.Game;
import entities.Player;
import entities.piece.PieceO;
import entities.piece.PieceX;

public class Main {
    public static void main(String[] args) {

        int n = 3;
        Player pLayer1 = new Player("Vikas", new PieceX());
        Player pLayer2 = new Player("sakiV", new PieceO());

        Game game = new Game(n, pLayer1, pLayer2);
        game.play();
    }
}