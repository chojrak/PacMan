package Model;

import javax.swing.*;

public class Player extends Movable {
    private int points;
    private int lifes;


    public Player() {
        super.lastMoveSnap = 0;
        super.speed = 4;
        this.points = 0;
        this.lifes = 3;

        resetPosition();
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public int getLifes() {
        return lifes;
    }

    public void subtractLife() {
        this.lifes--;
    }

    public void addLife() {
        this.lifes++;
    }


    public void resetPosition(){
        this.currentHorizontalPosition = 335;
        this.currentVerticalPosition = 540;
        this.lastMove = "left";
        this.lastPressedMove = "left";
        this.pic = new ImageIcon("src\\main\\resources\\pacman\\pacmanClosed.png");
    }


    @Override
    public void nextPic() {
        if (picCounter == 0) pic = new ImageIcon("src\\main\\resources\\pacman\\pacmanClosed.png");
        else if (lastMove == "left")
            pic = new ImageIcon("src\\main\\resources\\pacman\\pacmanLeft" + picCounter + ".png");
        else if (lastMove == "right")
            pic = new ImageIcon("src\\main\\resources\\pacman\\pacmanRight" + picCounter + ".png");
        else if (lastMove == "up") pic = new ImageIcon("src\\main\\resources\\pacman\\pacmanUp" + picCounter + ".png");
        else if (lastMove == "down")
            pic = new ImageIcon("src\\main\\resources\\pacman\\pacmanDown" + picCounter + ".png");
    }

    @Override
    public void movePlayer() {
        picChooser();
        if (lastPressedMove == "left" && chckLeft()) {
            moveLeft();
            if (movesCounter % 3 == 0) nextPic();
        } else if (lastPressedMove == "left") keepGoing();
        if (lastPressedMove == "right" && chckRight()) {
            moveRight();
            if (movesCounter % 3 == 0) nextPic();
        } else if (lastPressedMove == "right") keepGoing();
        if (lastPressedMove == "up" && chckUp()) {
            moveUp();
            if (movesCounter % 3 == 0) nextPic();
        } else if (lastPressedMove == "up") keepGoing();
        if (lastPressedMove == "down" && chckDown()) {
            moveDown();
            if (movesCounter % 3 == 0) nextPic();
        } else if (lastPressedMove == "down") keepGoing();
    }

    @Override
    public void keepGoing() {
        if (lastMove == "left" && chckLeft()) {
            moveLeft();
            if (movesCounter % 3 == 0) nextPic();
        } else if (lastMove == "left") correction();
        else if (lastMove == "right" && chckRight()) {
            moveRight();
            if (movesCounter % 3 == 0) nextPic();
        } else if (lastMove == "right") correction();
        else if (lastMove == "up" && chckUp()) {
            moveUp();
            if (movesCounter % 3 == 0) nextPic();
        } else if (lastMove == "up") correction();
        else if (lastMove == "down" && chckDown()) {
            moveDown();
            if (movesCounter % 3 == 0) nextPic();
        } else if (lastMove == "down") correction();
    }


}
