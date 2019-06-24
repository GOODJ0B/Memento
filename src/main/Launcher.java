package main;

import model.Board;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Board board = new Board(3, 3);
        board.printBoard();
        boolean keepOnGoing = true;
        while (keepOnGoing) {
            System.out.print("Input (h for help): ");
            String in = input.next();
            if (in.equals("e")) {
                break;
            } else if (in.equals("h")) {
                System.out.println("lopen: w / a / s / d, exit: e, undo: z");
                continue;
            }
            board.walk(in);
        }
    }
}
