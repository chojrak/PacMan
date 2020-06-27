package Model;

import javax.swing.*;

public class Player implements Movable {

    private String lastMove = "left";
    private String lastPressedMove = "left";
    private int currentHorizontalPosition = 335;
    private int currentVerticalPosition = 540;
    private int speed = 4;
    private int picCounter = 0;
    private int movesCounter = 0;
    private boolean ascending = true;
    ImageIcon pic = new ImageIcon("src\\main\\resources\\pacman\\pacmanClosed.png");


    public ImageIcon getPic() {
        return pic;
    }

    public String getLastMove() {
        return lastMove;
    }

    public int getCurrentHorizontalPosition() {
        return currentHorizontalPosition;
    }

    public int getCurrentVerticalPosition() {
        return currentVerticalPosition;
    }

    public void setLastMove(String lastMove) {
        if (lastMove == "left" || lastMove == "right" || lastMove == "up" || lastMove == "down")
            this.lastMove = lastMove;
    }

    public void setLastPressedMove(String lastPressedMove) {
        if (lastPressedMove == "left" || lastPressedMove == "right" || lastPressedMove == "up" || lastPressedMove == "down")
            this.lastPressedMove = lastPressedMove;
    }

    public void keepGoing() {
        if (lastMove == "left" && chckLeft()) {moveLeft(); if (movesCounter%3==0) nextPic();}
        else if (lastMove == "left") correction();
        else if (lastMove == "right" && chckRight()) {moveRight(); if (movesCounter%3==0) nextPic();}
        else if (lastMove == "right") correction();
        else if (lastMove == "up" && chckUp()) {moveUp(); if (movesCounter%3==0) nextPic();}
        else if (lastMove == "up") correction();
        else if (lastMove == "down" && chckDown()) {moveDown(); if (movesCounter%3==0) nextPic();}
        else if (lastMove == "down") correction();
    }

    public void correction() {
        currentVerticalPosition = (currentVerticalPosition / 24) * 24 + 12;
        currentHorizontalPosition = (currentHorizontalPosition / 24) * 24 + 12;
    }

    public void movePlayer() {
        picChooser();
        if (lastPressedMove == "left" && chckLeft()) {moveLeft(); if (movesCounter%3==0) nextPic();}
        else if (lastPressedMove == "left") keepGoing();
        if (lastPressedMove == "right" && chckRight()) {moveRight(); if (movesCounter%3==0) nextPic();}
        else if (lastPressedMove == "right") keepGoing();
        if (lastPressedMove == "up" && chckUp()) {moveUp(); if (movesCounter%3==0) nextPic();}
        else if (lastPressedMove == "up") keepGoing();
        if (lastPressedMove == "down" && chckDown()) {moveDown(); if (movesCounter%3==0) nextPic();}
        else if (lastPressedMove == "down") keepGoing();
    }

    public void picChooser()
    {movesCounter++;
        if (picCounter == 0) {picCounter++; ascending = true;}
        else if (picCounter == 2) {picCounter--; ascending = false;}
        else if (picCounter == 1 && ascending == true) picCounter++;
        else if (picCounter == 1 && ascending == false) picCounter--;
    }

    public void nextPic () {
        if (picCounter == 0) pic = new ImageIcon("src\\main\\resources\\pacman\\pacmanClosed.png");
        else if (lastMove == "left") pic = new ImageIcon("src\\main\\resources\\pacman\\pacmanLeft"+picCounter+".png");
        else if (lastMove == "right") pic = new ImageIcon("src\\main\\resources\\pacman\\pacmanRight"+picCounter+".png");
        else if (lastMove == "up") pic = new ImageIcon("src\\main\\resources\\pacman\\pacmanUp"+picCounter+".png");
        else if (lastMove == "down") pic = new ImageIcon("src\\main\\resources\\pacman\\pacmanDown"+picCounter+".png");
    }




    @Override
    public void moveUp() {
        currentVerticalPosition -= speed;
        if (lastMove != "up") correction();
        setLastMove("up");
    }

    @Override
    public void moveDown() {
        currentVerticalPosition += speed;
        if (lastMove != "down") correction();
        setLastMove("down");
    }

    @Override
    public void moveRight() {
        currentHorizontalPosition += speed;
        if (lastMove != "right") correction();
        setLastMove("right");
    }

    @Override
    public void moveLeft() {
        currentHorizontalPosition -= speed;
        if (lastMove != "left") correction();
        setLastMove("left");
    }

    @Override
    public boolean chckUp() {
        return !MapStructure.Map[(currentVerticalPosition - 20 - speed) / 24][currentHorizontalPosition / 24].isObstacle();
    }

    @Override
    public boolean chckDown() {
        return !MapStructure.Map[(currentVerticalPosition + 20 + speed) / 24][currentHorizontalPosition / 24].isObstacle();
    }

    @Override
    public boolean chckRight() {
        return !MapStructure.Map[currentVerticalPosition / 24][(currentHorizontalPosition + 20 + speed) / 24].isObstacle();
    }

    @Override
    public boolean chckLeft() {
        return !MapStructure.Map[currentVerticalPosition / 24][(currentHorizontalPosition - 20 - speed) / 24].isObstacle();
    }


}
