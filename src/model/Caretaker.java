package model;

import java.util.Stack;

public class Caretaker {

    private Board originator;
    private Stack<Board.Memento> history;

    public Caretaker(Board originator) {
        this.originator = originator;
        history = new Stack<>();
    }

    public void saveState(){
        history.push(originator.save());
    }

    public void undo(){
        if(history.isEmpty()){
            return;
        }
        originator.restore(history.pop());
    }



}
