package com.lld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Player {
    public String name;
    public Character marker;

    public Player(String name) {
        this.name = name;
        this.marker = ' ';
    }
}

class Position {
    public int row;
    public int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Status {
    boolean flag;
    String details;

    public Status(boolean flag, String details) {
        this.flag = flag;
        this.details = details;
    }
}

class Board {
    int size;
    char[][] spots;
    int[][] rowCounts;
    int[][] colCounts;
    int[] leftToRightCounts;
    int[] rightToLeftCounts;
    int spotCounter;

    public Board(int size) {
        this.size=size;
        spots = new char[size][size];
        spotCounter = 0;

        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                spots[i][j]= ' ';
            }
        }

        rowCounts = new int[size][2];
        colCounts = new int[size][2];
        leftToRightCounts = new int[2];
        rightToLeftCounts = new int[2];
    }

    public void reset() {
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                spots[i][j]= ' ';
            }
        }

        rowCounts = new int[size][2];
        colCounts = new int[size][2];
        leftToRightCounts = new int[2];
        rightToLeftCounts = new int[2];

    }

    public Status makeTurn(Position pos, Player p) throws Exception {
        int row = pos.row;
        int col = pos.col;

        if (spots[row][col] != ' ') {
            throw new Exception("Invalid turn");
        } else {
            spots[row][col] = p.marker;
            int marker = (p.marker.equals('X') ? 0 : 1);
            spotCounter++;

            rowCounts[row][marker]++;
            colCounts[col][marker]++;

            if (row==col) {
                leftToRightCounts[marker]++;
            }

            if (row + col == size-1) {
                rightToLeftCounts[marker]++;
            }

            if (rowCounts[row][marker]==size || colCounts[col][marker]==size || leftToRightCounts[marker]==size || rightToLeftCounts[marker]==size) {
                for(int i=0;i<size;i++) {
                    for(int j=0;j<size;j++) {
                        System.out.print(spots[i][j] + " ");
                    }
                    System.out.println();
                }

                this.reset();
                return new Status(true, "Player " + p.name + " has own the game.");
            } else if (spotCounter == size * size) {
                this.reset();
                return new Status(true, "It's a tie.");
            }
            return new Status(false, "");
        }
    }
}

class Game {
    List<Player> playerList;
    boolean turn;
    Board board;

    Game() {
        playerList = new ArrayList<>();
        turn = false;
        board = new Board(3);
    }

    void addPlayer(Player p) throws Exception{
        int size = playerList.size();
        if (size==2) {
            throw new Exception("Player 1 and 2 are already added.");
        }

        p.marker = size==0 ? 'X' : 'O';

        System.out.println(p.name + " has been assigned to mark with " + p.marker);
        playerList.add(p);
    }

    void resetBoardSize(int size) {
        System.out.println("Starting a new Game with Board size " + size );
        board = new Board(size);
        turn = false;
    }

    boolean makeTurn(Position p) throws Exception{
        if (playerList.size()<2)  {
            throw new Exception("Not enough players");
        }

        Player currentPlayer = turn ? playerList.get(1) : playerList.get(0);
        turn = !turn;

        Status status = board.makeTurn(p, currentPlayer);

        if (status.flag) {
            System.out.println(status.details);
            return true;
        }
        return false;
    }
}

public class TicTacToe {
    public static void main(String[] args) {
        Game game = new Game();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Player 1: ");
        String name1 = scanner.nextLine();
        System.out.println("Enter Player 2: ");
        String name2 = scanner.nextLine();

        Player p1 = new Player(name1);
        Player p2 = new Player(name2);

        try {
            game.addPlayer(p1);
            game.addPlayer(p2);

            boolean turn = false;
            int row , col ;
            boolean status = false;

            while(true) {
                System.out.println("Turn for Player " + (turn ? 2 : 1));
                row = scanner.nextInt();
                col = scanner.nextInt();

                turn = !turn;

                status = game.makeTurn(new Position(row, col));
                if (status) break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        System.out.print("Enter a string: ");
//        String text = scanner.nextLine();
//
//        System.out.println("You entered: " + number + " and \"" + text + "\"");

        scanner.close();
    }
}
