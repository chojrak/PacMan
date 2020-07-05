package Model;

import javax.swing.*;

public class Ghost extends Movable {

    private String nextMove;
    private String name;


    public Ghost(String name) {
        this.name = name;
        super.speed = 3;
        super.pic = new ImageIcon("src\\main\\resources\\ghosts\\" + name + "\\up" + picCounter + ".png");
        resetPosition();

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

    public void resetPosition () {
        if (this.name == "blinky") {
            this.currentHorizontalPosition = 300;
            this.currentVerticalPosition = 276;
        }
        if (this.name == "clyde") {
            this.currentHorizontalPosition = 324;
            this.currentVerticalPosition = 336;
        }
        if (this.name == "inky") {
            this.currentHorizontalPosition = 276;
            this.currentVerticalPosition = 336;
        }
        if (this.name == "pinky") {
            this.currentHorizontalPosition = 384;
            this.currentVerticalPosition = 336;
        }
        this.lastMove = "up";
        this.nextMove = "up";
    }

    @Override
    public void nextPic() {
        pic = new ImageIcon("src\\main\\resources\\ghosts\\" + name + "\\" + lastMove + picCounter + ".png");
    }

    @Override
    public void movePlayer() {
        picChooser();
        if (nextMove == "left" && chckLeft()) {
            moveLeft();
            if (movesCounter % 3 == 0) nextPic();
        } else if (nextMove == "left") keepGoing();


        if (nextMove == "right" && chckRight()) {
            moveRight();
            if (movesCounter % 3 == 0) nextPic();
        } else if (nextMove == "right") keepGoing();


        if (nextMove == "up" && chckUp()) {
            moveUp();
            if (movesCounter % 3 == 0) nextPic();
        } else if (nextMove == "up") keepGoing();


        if (nextMove == "down" && chckDown()) {
            moveDown();
            if (movesCounter % 3 == 0) nextPic();
        } else if (nextMove == "down") keepGoing();
    }

    @Override
    public void keepGoing() {
        if (lastMove == "left" && chckLeft()) {
            moveLeft();
            if (movesCounter % 3 == 0) nextPic();
        } else if (lastMove == "left") {
            correction();
            getNextMove();
        } else if (lastMove == "right" && chckRight()) {
            moveRight();
            if (movesCounter % 3 == 0) nextPic();
        } else if (lastMove == "right") {
            correction();
            getNextMove();
        } else if (lastMove == "up" && chckUp()) {
            moveUp();
            if (movesCounter % 3 == 0) nextPic();
        } else if (lastMove == "up") {
            correction();
            getNextMove();
        } else if (lastMove == "down" && chckDown()) {
            moveDown();
            if (movesCounter % 3 == 0) nextPic();
        } else if (lastMove == "down") {
            correction();
            getNextMove();
        }
    }


}
