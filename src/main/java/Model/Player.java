package Model;

import javax.swing.*;

public class Player implements Movable {

    private String lastMove = "left";
    private String lastPressedMove = "left";
    private int currentHorizontalPosition = 335;
    private int currentVerticalPosition = 540;
    private int speed = 4;
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
        if (lastMove == "left" && chckLeft()) moveLeft();
        else if (lastMove == "right" && chckRight()) moveRight();
        else if (lastMove == "up" && chckUp()) moveUp();
        else if (lastMove == "down" && chckDown()) moveDown();
    }

    public void movePlayer() {
        if (lastPressedMove == "left" && chckLeft()) moveLeft();
        else if (lastPressedMove == "left") keepGoing();
        if (lastPressedMove == "right" && chckRight()) moveRight();
        else if (lastPressedMove == "right") keepGoing();
        if (lastPressedMove == "up" && chckUp()) moveUp();
        else if (lastPressedMove == "up") keepGoing();
        if (lastPressedMove == "down" && chckDown()) moveDown();
        else if (lastPressedMove == "down") keepGoing();
    }


    @Override
    public void moveUp() {
        currentVerticalPosition -= speed;
        setLastMove("up");
    }

    @Override
    public void moveDown() {
        currentVerticalPosition += speed;
        setLastMove("down");
    }

    @Override
    public void moveRight() {
        currentHorizontalPosition += speed;
        setLastMove("right");
    }

    @Override
    public void moveLeft() {
        currentHorizontalPosition -= speed;
        setLastMove("left");
    }

    @Override
    public boolean chckUp() {
        return !MapStructure.Map[(currentVerticalPosition - 23 - speed) / 24][currentHorizontalPosition / 24].isObstacle();
    }

    @Override
    public boolean chckDown() {
        return !MapStructure.Map[(currentVerticalPosition + 23 + speed) / 24][currentHorizontalPosition / 24].isObstacle();
    }

    @Override
    public boolean chckRight() {
        return !MapStructure.Map[currentVerticalPosition / 24][(currentHorizontalPosition + 23 + speed) / 24].isObstacle();
    }

    @Override
    public boolean chckLeft() {
        return !MapStructure.Map[currentVerticalPosition / 24][(currentHorizontalPosition - 23 - speed) / 24].isObstacle();
    }



}
