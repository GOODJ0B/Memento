package main;

import model.Board;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Board board = new Board(0,0);
        board.printBoard();
        boolean keepOnGoing = true;
        while (keepOnGoing){
            String in = input.next();
            if (in.equals("e")){
                break;
            }
            board.walk(in);
        }
    }
}
