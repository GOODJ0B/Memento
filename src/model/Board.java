package model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final int boardHeight = 6;
    private final int boardWidth = 6;

    private List<List<String>> board = new ArrayList<>();

    private int currentX;
    private int currentY;

    private boolean dead;

    public Board(int x, int y) {
        for (int i = 0; i < boardHeight; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < boardWidth; j++) {
                row.add(" - ");
            }
            board.add(row);
        }
        this.currentX = x;
        this.currentY = y;
        this.dead = false;
        board.get(currentY).set(currentX, " x ");
    }

    public void printBoard() {
        for (List<String> row : board) {
            for (String point : row) {
                System.out.print(point);
            }
            System.out.println();
        }
    }

    public void walk(String direction) {
        if (dead) {
            System.out.println("Je bent al dood...");
            return;
        }
        switch (direction) {
            case "l":
                changeX(-1);
                break;
            case "r":
                changeX(1);
                break;
            case "u":
                changeY(-1);
                break;
            case "d":
                changeY(1);
                break;
            default:
                System.out.println("ongeldige input");
        }
    }

    private void changeX(int change) {
        if (currentX + change < 0 || currentX + change == boardWidth) {
            playerDied();
            return;
        }
        if (board.get(currentY).get(currentX + change).equals(" x ")) {
            playerDied();
            return;
        }
        currentX += change;
        board.get(currentY).set(currentX, " x ");
        printBoard();
    }

    private void changeY(int change) {
        if (currentY + change < 0 || currentY + change == boardHeight) {
            playerDied();
            return;
        }
        if (board.get(currentY + change).get(currentX).equals(" x ")) {
            playerDied();
            return;
        }
        currentY += change;
        board.get(currentY).set(currentX, " x ");
        printBoard();
    }

    private void playerDied() {
        System.out.println("Je bent dood!");
        dead = true;
    }

}
