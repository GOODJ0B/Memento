package main;

import model.Board;
import model.Caretaker;

import java.util.Scanner;

public class Launcher {

    private Scanner scanner = new Scanner(System.in);
    private Board board = new Board(3, 3);
    private boolean keepOnGoing = true;
    private String message = "Succes! ";

    public static void main(String[] args) {
        new Launcher().run();
    }

    public void run(){
        while (keepOnGoing) {
            String input = askForInput(message);
            if (input.equals("e")) {
                break;
            } else if (input.equals("h")) {
                message = "lopen: w / a / s / d, exit: e, undo: z";
                continue;
            } else if (input.equals("z")){
                message = "Deze funtie is er nog niet!";
                continue;
            }
            message = board.walk(input);
        }
    }

    private String askForInput(String message){
        board.printBoard(message);
        System.out.print("Input (h for help): ");
        return scanner.next();
    }
}
