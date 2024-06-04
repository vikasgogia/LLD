package entities;

import java.util.HashMap;
import java.util.List;

public class Board {

    private int boardSize;
    private int winningPosition;
    private HashMap<Integer, Integer> snakesAndLadders;

    public Board(int boardSize, List<Ladder> ladders, List<Snake> snakes) {
        this.boardSize = boardSize;
        this.winningPosition = boardSize * boardSize;
        this.snakesAndLadders = new HashMap<>();

        for(Ladder ladder: ladders)
            snakesAndLadders.put(ladder.getStart(), ladder.getEnd());

        for(Snake snake: snakes)
            snakesAndLadders.put(snake.getStart(), snake.getEnd());
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int getWinningPosition() {
        return winningPosition;
    }

    public int getPositionByCheckingSnakesLadders(int position) {
        if(snakesAndLadders.containsKey(position)) {
            return snakesAndLadders.get(position);
        }
        return position;
    }

    public boolean isWinner(int position) {
        return position == winningPosition;
    }

    public boolean isMoveValid(int position) {
        return position <= winningPosition;
    }
}
