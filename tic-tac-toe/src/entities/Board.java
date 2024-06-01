package entities;

import entities.piece.Piece;
import entities.piece.PieceX;

public class Board {

    private int n;
    private int moves;
    private Piece[][] board;

    public Board(int n) {
        this.n = n;
        this.board = new Piece[n][n];
    }

    public synchronized boolean makeMove(int x, int y, Piece piece) {
        if(x < 0 || y < 0 || x >= n || y >= n || board[x][y] != null)
            return false;

        board[x][y] = piece;
        moves++;
        return true;
    }

    public boolean isBoardFull() {
        return moves == (n * n);
    }

    public boolean isWin(int x, int y, Piece piece) {
        boolean rowCheck = true, colCheck = true, diagonalCheck = true, antiDiagonalCheck = true;

        // check all rows of column y
        for(int i=0; i< n; i++) {
            if(board[i][y] != piece) {
                rowCheck = false;
                break;
            }
        }

        // check all cols of row x
        for(int i=0; i< n; i++) {
            if(board[x][i] != piece) {
                colCheck = false;
                break;
            }
        }

        // check the diagonal
        for(int i=0; i< n; i++) {
            if(board[i][i] != piece) {
                diagonalCheck = false;
                break;
            }
        }

        // check anti diagonal
        for(int i=0, j=n-1; i < n && j >= 0; i++, j--) {
            if(board[i][j] != piece) {
                antiDiagonalCheck = false;
                break;
            }
        }

        return (rowCheck || colCheck || diagonalCheck || antiDiagonalCheck);
    }

    public void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == null) System.out.print("- ");
                else System.out.print((board[i][j] instanceof PieceX ? "X" : "O") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
