package Model;

import javax.swing.*;

public abstract class Movable {
    protected String lastMove;
    protected String lastPressedMove;
    protected int currentHorizontalPosition;
    protected int currentVerticalPosition;
    protected int speed;
    protected int picCounter;
    public int movesCounter;
    protected boolean ascending;
    protected int level;
    protected ImageIcon pic;



    public abstract void nextPic();
    public abstract void movePlayer();
    public abstract void keepGoing();

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



    public void correction() {
        currentVerticalPosition = (currentVerticalPosition / 24) * 24 + 12;
        currentHorizontalPosition = (currentHorizontalPosition / 24) * 24 + 12;
    }



    public void picChooser()
    {movesCounter++;
        if (picCounter == 0) {picCounter++; ascending = true;}
        else if (picCounter == 2) {picCounter--; ascending = false;}
        else if (picCounter == 1 && ascending == true) picCounter++;
        else if (picCounter == 1 && ascending == false) picCounter--;
    }



    public void moveUp() {
        currentVerticalPosition -= speed;
        if (lastMove != "up") correction();
        setLastMove("up");
    }

    public void moveDown() {
        currentVerticalPosition += speed;
        if (lastMove != "down") correction();
        setLastMove("down");
    }

    public void moveRight() {
        if (currentHorizontalPosition + speed > 623 &&
        MapStructure.Map[currentVerticalPosition / 24][(currentHorizontalPosition + 20 + speed) / 24+1].isTeleport()) currentHorizontalPosition = 47;
        else currentHorizontalPosition += speed;
        if (lastMove != "right") correction();
        setLastMove("right");
    }

    public void moveLeft() {
        if (currentHorizontalPosition - speed < 47
        && MapStructure.Map[currentVerticalPosition / 24][(currentHorizontalPosition - 20 - speed) / 24-1].isTeleport()) currentHorizontalPosition = 625;
        else currentHorizontalPosition -= speed;
        if (lastMove != "left") correction();
        setLastMove("left");
    }

    public boolean chckUp() {
        return !MapStructure.Map[(currentVerticalPosition - 20 - speed) / 24][currentHorizontalPosition / 24].isObstacle()
                && !MapStructure.Map[(currentVerticalPosition - 20 - speed) / 24][currentHorizontalPosition / 24].isTeleport();
    }

    public boolean chckDown() {
        return !MapStructure.Map[(currentVerticalPosition + 20 + speed) / 24][currentHorizontalPosition / 24].isObstacle()
                && !MapStructure.Map[(currentVerticalPosition + 20 + speed) / 24][currentHorizontalPosition / 24].isTeleport();
    }

    public boolean chckRight() {
        return !MapStructure.Map[currentVerticalPosition / 24][(currentHorizontalPosition + 20 + speed) / 24].isObstacle()
                && !MapStructure.Map[currentVerticalPosition / 24][(currentHorizontalPosition + 20 + speed) / 24].isTeleport();
    }

    public boolean chckLeft() {
        return !MapStructure.Map[currentVerticalPosition / 24][(currentHorizontalPosition - 20 - speed) / 24].isObstacle()
                && !MapStructure.Map[currentVerticalPosition / 24][(currentHorizontalPosition - 20 - speed) / 24].isTeleport();
    }
}
