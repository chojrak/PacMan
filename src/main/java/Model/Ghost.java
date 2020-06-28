package Model;

import javax.swing.*;

public class Ghost implements Movable {

    private String lastMove = "left";
    private String nextMove = "left";
    private int currentHorizontalPosition = 335;
    private int currentVerticalPosition = 380;
    private int speed = 3;
    private int picCounter = 0;
    private int movesCounter = 0;
    private boolean ascending = true;
    ImageIcon pic = new ImageIcon("src\\main\\resources\\ghosts\\blinky\\blinkyClosed.png");


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

    public void getNextMove(){
    	double random = Math.random()*4;
    	if(random<=1)
    		nextMove = "left";
    	if(random>1 && random<=2)
    		nextMove = "right";
    	if(random>2 && random<=3)
    		nextMove = "up";
    	if(random>3 && random<=4)
    		nextMove = "down";
    }

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

    public void correction() {
        currentVerticalPosition = (currentVerticalPosition / 24) * 24 + 12;
        currentHorizontalPosition = (currentHorizontalPosition / 24) * 24 + 12;
    }

    public void moveGhost() {
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

    public void picChooser()
    {movesCounter++;
        if (picCounter == 0) {picCounter++; ascending = true;}
        else if (picCounter == 3) {picCounter--; ascending = false;}
        else if (picCounter == 1 && ascending == true) picCounter++;
        else if (picCounter == 2 && ascending == true) picCounter++;
        else if (picCounter == 1 && ascending == false) picCounter--;
        else if (picCounter == 2 && ascending == false) picCounter--;
    }

    public void nextPic () {
        if (picCounter == 0) pic = new ImageIcon("src\\main\\resources\\ghosts\\blinky\\blinkyClosed.png");
        else if (lastMove == "left") pic = new ImageIcon("src\\main\\resources\\ghosts\\blinky\\blinkyLeft"+picCounter+".png");
        else if (lastMove == "right") pic = new ImageIcon("src\\main\\resources\\ghosts\\blinky\\blinkyRight"+picCounter+".png");
        else if (lastMove == "up") pic = new ImageIcon("src\\main\\resources\\ghosts\\blinky\\blinkyUp"+picCounter+".png");
        else if (lastMove == "down") pic = new ImageIcon("src\\main\\resources\\ghosts\\blinky\\blinkyDown"+picCounter+".png");
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
