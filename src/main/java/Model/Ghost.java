package Model;

import javax.swing.*;

public class Ghost extends Movable {

    private String nextMove = "up";
    private String name;


    public Ghost(String name) {
        this.name = name;
        super.lastMove = "up";
        super.currentHorizontalPosition = 335;
        super.currentVerticalPosition = 380;
        super.speed = 3;
        super.pic = new ImageIcon("src\\main\\resources\\ghosts\\" + name + "\\left" + picCounter + ".png");

    }

    public void getNextMove() {
        double random = Math.random() * 4;
        if (random <= 1)
            nextMove = "left";
        if (random > 1 && random <= 2)
            nextMove = "right";
        if (random > 2 && random <= 3)
            nextMove = "up";
        if (random > 3 && random <= 4)
            nextMove = "down";
    }

    @Override
    public void nextPic() {
        if (lastMove == "left")
            pic = new ImageIcon("src\\main\\resources\\ghosts\\" + name + "\\left" + picCounter + ".png");
        else if (lastMove == "right")
            pic = new ImageIcon("src\\main\\resources\\ghosts\\" + name + "\\right" + picCounter + ".png");
        else if (lastMove == "up")
            pic = new ImageIcon("src\\main\\resources\\ghosts\\" + name + "\\up" + picCounter + ".png");
        else if (lastMove == "down")
            pic = new ImageIcon("src\\main\\resources\\ghosts\\" + name + "\\down" + picCounter + ".png");
    }

    @Override
    public void movePlayer() {
        picChooser();
        if (nextMove == "left" && chckLeft()) {moveLeft(); if (movesCounter%3==0) nextPic();}
        else if (nextMove == "left") keepGoing();
        if (nextMove == "right" && chckRight()) {moveRight(); if (movesCounter%3==0) nextPic();}
        else if (nextMove == "right") keepGoing();
        if (nextMove == "up" && chckUp()) {moveUp(); if (movesCounter%3==0) nextPic();}
        else if (nextMove == "up") keepGoing();
        if (nextMove == "down" && chckDown()) {moveDown(); if (movesCounter%3==0) nextPic();}
        else if (nextMove == "down") keepGoing();
    }

    @Override
    public void keepGoing() {
        if (lastMove == "left" && chckLeft()) {moveLeft(); if (movesCounter%3==0) nextPic();}
        else if (lastMove == "left") {correction();getNextMove();}
        else if (lastMove == "right" && chckRight()) {moveRight(); if (movesCounter%3==0) nextPic();}
        else if (lastMove == "right") {correction();getNextMove();}
        else if (lastMove == "up" && chckUp()) {moveUp(); if (movesCounter%3==0) nextPic();}
        else if (lastMove == "up") {correction();getNextMove();}
        else if (lastMove == "down" && chckDown()) {moveDown(); if (movesCounter%3==0) nextPic();}
        else if (lastMove == "down") {correction();getNextMove();}
    }


}
