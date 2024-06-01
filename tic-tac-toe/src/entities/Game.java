package entities;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);
    private final Player player1, player2;
    private final Board board;
    private final Queue<Player> turns;

    public Game(int n, Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board(n);
        this.turns = new LinkedList<>();

        turns.add(player1);
        turns.add(player2);
    }

    private int[] getMoveCoordinates() {
        int[] coordinates = new int[2];

        int i=0;
        System.out.println("Input (x, y) where you would like to place your piece: ");
        while(scanner.hasNextInt() && i< 2) coordinates[i++] = scanner.nextInt();
        return coordinates;
    }

    public void play() {
        while(!board.isBoardFull()) {
            int[] coordinates = getMoveCoordinates();
            int x = coordinates[0], y = coordinates[1];

            // maintain the order of turns of individual players
            Player currPlayer = turns.peek();

            // make a move of the current player
            if(!board.makeMove(x, y, currPlayer.getPiece())) {
                System.out.println("Wrong move, try again!");
                continue;
            }
            board.printBoard();
            turns.poll();
            turns.add(currPlayer);

            // check if the current player's move make him win
            if(board.isWin(x, y, currPlayer.getPiece())) {
                System.out.println("Player " + currPlayer.getName() + " wins the game!");
                break;
            }
        }
    }
}
