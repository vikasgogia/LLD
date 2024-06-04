package entities;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {

    private List<Player> players;
    private Dice dice;
    private Board board;
    private Queue<Player> turns;

    public Game(int boardSize, int diceMin, int diceMax, List<Player> players, List<Ladder> ladders, List<Snake> snakes) {
        this.players = players;
        this.board = new Board(boardSize, ladders, snakes);
        this.dice = new Dice(diceMin, diceMax);
        this.turns = new LinkedList<>();

        turns.addAll(players);
    }

    public Player play() {
        while(true) {
            Player currPlayer = turns.poll();

            int jumps = dice.roll(), move = currPlayer.getCurrPosition() + jumps;
            System.out.println("Player " + currPlayer.getName() + ": " + currPlayer.getCurrPosition() + " + " + jumps);

            if(!board.isMoveValid(move)) {
                turns.add(currPlayer);
                continue;
            }

            move = board.getPositionByCheckingSnakesLadders(move);
            currPlayer.setCurrPosition(move);
            turns.add(currPlayer);

            if(board.isWinner(move)) return currPlayer;
        }
    }
}
