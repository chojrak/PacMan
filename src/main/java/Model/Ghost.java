package Model;

import javax.swing.*;

public class Ghost extends Movable {

    private String nextMove;
    private String name;
    private String box;
    private int lastMoveSnap;


    public Ghost(String name) {
        this.name = name;
        this.lastMoveSnap = 0;
        super.speed = 3;
        super.level = 1;
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

    public void resetPosition() {
        if (this.name == "blinky") {
            this.currentHorizontalPosition = 300;
            this.currentVerticalPosition = 276;
            this.box = "out";
        }
        if (this.name == "clyde") {
            this.currentHorizontalPosition = 324;
            this.currentVerticalPosition = 336;
            this.box = "in";
        }
        if (this.name == "inky") {
            this.currentHorizontalPosition = 276;
            this.currentVerticalPosition = 336;
            this.box = "in";
        }
        if (this.name == "pinky") {
            this.currentHorizontalPosition = 384;
            this.currentVerticalPosition = 336;
            this.box = "in";
        }
        this.lastMove = "up";
        this.nextMove = "up";
        this.movesCounter = 0;
    }

    @Override
    public void nextPic() {
        pic = new ImageIcon("src\\main\\resources\\ghosts\\" + name + "\\" + lastMove + picCounter + ".png");
    }


    public void goingOut() {
        picChooser();
        if (this.currentHorizontalPosition < MapStructure.getGateHorizontal() * 24) {
            moveRight();
            if (movesCounter % 3 == 0) nextPic();
        } else if (this.currentHorizontalPosition > MapStructure.getGateHorizontal() * 24 + 24 - this.speed) {
            moveLeft();
            if (movesCounter % 3 == 0) nextPic();
        } else if (this.currentVerticalPosition > MapStructure.getGetGateVertical() * 24 - 12) {
            moveUp();
            if (movesCounter % 3 == 0) nextPic();
        } else this.box = "out";
    }

    public void freeMovement() {
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

    public void advancedtMove() {
        picChooser();

        if (nextMove == "left" && chckLeft() && (chckUp() || chckDown()) && movesCounter > lastMoveSnap + 50) {
            this.lastMoveSnap = this.movesCounter;
            getNextMove();
            if (nextMove == "right") nextMove = "left";
            if (movesCounter % 3 == 0) nextPic();
        } else if (nextMove == "left" && chckLeft()) {
            moveLeft();
            if (movesCounter % 3 == 0) nextPic();
        } else if (nextMove == "left") keepGoing();

        if (nextMove == "right" && chckRight() && (chckUp() || chckDown()) && movesCounter > lastMoveSnap + 50) {
            this.lastMoveSnap = this.movesCounter;
            getNextMove();
            if (nextMove == "left") nextMove = "right";
            if (movesCounter % 3 == 0) nextPic();
        } else if (nextMove == "right" && chckRight()) {
            moveRight();
            if (movesCounter % 3 == 0) nextPic();
        } else if (nextMove == "right") keepGoing();

        if (nextMove == "up" && chckUp() && (chckLeft() || chckRight()) && movesCounter > lastMoveSnap + 50) {
            this.lastMoveSnap = this.movesCounter;
            getNextMove();
            if (nextMove == "down") nextMove = "up";
            if (movesCounter % 3 == 0) nextPic();
        } else if (nextMove == "up" && chckUp()) {
            moveUp();
            if (movesCounter % 3 == 0) nextPic();
        } else if (nextMove == "up") keepGoing();

        if (nextMove == "down" && chckDown() && (chckLeft() || chckRight()) && movesCounter > lastMoveSnap + 50) {
            this.lastMoveSnap = this.movesCounter;
            getNextMove();
            if (nextMove == "up") nextMove = "down";
            if (movesCounter % 3 == 0) nextPic();
        } else if (nextMove == "down" && chckDown()) {
            moveDown();
            if (movesCounter % 3 == 0) nextPic();
        } else if (nextMove == "down") keepGoing();
    }


    @Override
    public void movePlayer() {
        if (this.box == "out") {
            advancedtMove();
        } else if (this.name == "clyde" && movesCounter < 100 / this.level) freeMovement();
        else if (this.name == "clyde") goingOut();

        else if (this.name == "inky" && movesCounter < 300 / this.level) freeMovement();
        else if (this.name == "inky") goingOut();

        else if (this.name == "pinky" && movesCounter < 500 / this.level) freeMovement();
        else if (this.name == "pinky") goingOut();

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
