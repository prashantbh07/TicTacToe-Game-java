package com.prashant;


import java.util.Scanner;

class TicTacToe {
    static char[][] board;

    // 3X3 board is created and at the same initialization also occur
    public TicTacToe() {
        board = new char[3][3];
        initBord();
    }

    // initialization board with empty character
    void initBord() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // DisplayBoard
    static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // place mark with 'x' and 'o' character
    static void placeMark(int row, int col, char mark) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            board[row][col] = mark;
        } else {
            System.out.println("invalid position");
        }
    }

    // check column win condition
    static boolean checkColWin() {
        for (int j = 0; j < 2; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }
        return false;
    }

    // check row win condition
    static boolean checkRowWin() {
        for (int i = 0; i < 2; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    // check diagonal win condition
    static  boolean checkDiagWin() {
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] ||
                board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    boolean isValidMove(int row, int col) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            if (TicTacToe.board[row][col] == ' ') {
                return true;
            }
        }
        return false;
    }
}



// **making class***

class HumanPlayer{
    String name;
    char mark;

    // constructor which initialize the name & mark
    HumanPlayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    // function called as make move which will take row and column and as lon as the move is
    // invalid will keep giving him chance to make a move and the movement is a valid coordinates
    // its going to place the mark on the board.

    void makeMove(){
        Scanner scan  = new Scanner(System.in);
        int row;
        int col;
        do {
            System.out.println("Enter the roe & col");
            row = scan.nextInt();
            col = scan.nextInt();
        } while (!isValidMove(row,col));

        TicTacToe.placeMark(row,col,mark);

    }

    // to check move is valid or invalid

    boolean isValidMove(int row , int col){
        if (row>=0 && row<=2 && col>=0 && col<=2 ){
            if (TicTacToe.board[row][col] == ' ') {
                return true;
            }
        }
        return false;
    }


}



// main class
 class LaunchTicTacToeGame {

    // main function
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();

        // creating the object p1 & p2 of the HumanPlayer class

        HumanPlayer p1 = new HumanPlayer("Bob", 'x');
        HumanPlayer p2 = new HumanPlayer("priya", 'o');

        // now who is current payer
        HumanPlayer cp;
        cp = p1;  // now current player is p1

        while (true) {
            System.out.println(cp.name + " turn");
            cp.makeMove();
            TicTacToe.displayBoard();

            // every time player makes a move then we have to check it is resulted in a win
            if (TicTacToe.checkColWin() || TicTacToe.checkRowWin() || TicTacToe.checkDiagWin()) {
                System.out.println(cp.name + " has won");
                break;
            } else {
                if (cp == p1) {
                    cp = p2;
                } else {
                    cp = p1;
                }
            }

        }
    }
}

