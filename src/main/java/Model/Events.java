package Model;

import View.Map;

import javax.swing.*;

public class Events {
    Player pacman;
    Map map;
    Ghost ghost1;
    Ghost ghost2;
    Ghost ghost3;
    Ghost ghost4;


    public Events(Player pacman, Map map, Ghost ghost1, Ghost ghost2, Ghost ghost3, Ghost ghost4) {
        this.pacman = pacman;
        this.ghost1 = ghost1;
        this.ghost2 = ghost2;
        this.ghost3 = ghost3;
        this.ghost4 = ghost4;
        this.map = map;
        eatDot();
        death();
        eatGhost();
        clearedMap();
        extraLife();
    }

    public void eatDot() {
        if (!(MapStructure.Map[pacman.currentVerticalPosition / 24][pacman.currentHorizontalPosition / 24].getTreat().equals("none"))
                && pacman.currentVerticalPosition / 24 * 24 + 12 < pacman.currentVerticalPosition && pacman.lastMove == "up"
                ||
                !(MapStructure.Map[pacman.currentVerticalPosition / 24][pacman.currentHorizontalPosition / 24].getTreat().equals("none"))
                        && pacman.currentVerticalPosition / 24 * 24 + 12 > pacman.currentVerticalPosition && pacman.lastMove == "down"
                ||
                !(MapStructure.Map[pacman.currentVerticalPosition / 24][pacman.currentHorizontalPosition / 24].getTreat().equals("none"))
                        && pacman.currentHorizontalPosition / 24 * 24 + 12 < pacman.currentHorizontalPosition && pacman.lastMove == "left"
                ||
                !(MapStructure.Map[pacman.currentVerticalPosition / 24][pacman.currentHorizontalPosition / 24].getTreat().equals("none"))
                        && pacman.currentHorizontalPosition / 24 * 24 + 12 > pacman.currentHorizontalPosition && pacman.lastMove == "right"
        ) {
            String dot = MapStructure.Map[pacman.currentVerticalPosition / 24][pacman.currentHorizontalPosition / 24].getTreat();
            MapStructure.Map[pacman.currentVerticalPosition / 24][pacman.currentHorizontalPosition / 24].setTreat("none");
            if (dot.equals("smallDot")) {
                pacman.addPoints(10);
                Sounds.eatDotSound();
            } else if (dot.equals("bigDot")) {
                Sounds.eatFruitSound();
                ghost1.setEatableGhosts(true);
                ghost2.setEatableGhosts(true);
                ghost3.setEatableGhosts(true);
                ghost4.setEatableGhosts(true);
                pacman.lastMoveSnap = pacman.movesCounter;
                ghost1.reverseMove();
                ghost2.reverseMove();
                ghost3.reverseMove();
                ghost4.reverseMove();
                Sounds.intermission();

            }


        }


    }

    public void death() {
        if (ghost1.isEatableGhosts() == false
                && (meetGhost(ghost1) || meetGhostCorrection(ghost1))
                ||
                ghost2.isEatableGhosts() == false
                        && (meetGhost(ghost2) || meetGhostCorrection(ghost2))
                ||
                ghost3.isEatableGhosts() == false
                        && (meetGhost(ghost3) || meetGhostCorrection(ghost3))
                ||
                ghost4.isEatableGhosts() == false
                        && (meetGhost(ghost4) || meetGhostCorrection(ghost4))) {
            map.setNotCatched(false);
            pacman.subtractLife();
            Sounds.deathSound();
        }
    }

    public boolean meetGhost (Ghost g) {
        return (pacman.currentVerticalPosition / 24 == g.currentVerticalPosition / 24
                && pacman.currentHorizontalPosition / 24 == g.currentHorizontalPosition / 24);
    }

    public boolean meetGhostCorrection(Ghost g) {
        return (pacman.lastMove.equals("right") && g.lastMove.equals("left")
                && pacman.currentVerticalPosition == g.currentVerticalPosition
                && pacman.currentHorizontalPosition + 24 > g.currentHorizontalPosition
                && pacman.currentHorizontalPosition < g.currentHorizontalPosition
                ||
                g.lastMove.equals("right") && pacman.lastMove.equals("left")
                        && g.currentVerticalPosition == pacman.currentVerticalPosition
                        && g.currentHorizontalPosition + 24 > pacman.currentHorizontalPosition
                        && g.currentHorizontalPosition < pacman.currentHorizontalPosition
                ||
                pacman.lastMove.equals("down") && g.lastMove.equals("up")
                        && pacman.currentHorizontalPosition == g.currentHorizontalPosition
                        && pacman.currentVerticalPosition + 24 > g.currentVerticalPosition
                        && pacman.currentVerticalPosition < g.currentVerticalPosition
                ||
                g.lastMove.equals("down") && pacman.lastMove.equals("up")
                        && g.currentHorizontalPosition == pacman.currentHorizontalPosition
                        && g.currentVerticalPosition + 24 > pacman.currentVerticalPosition
                        && g.currentVerticalPosition < pacman.currentVerticalPosition);
    }

    public void eatGhost() {
        if (ghost1.isEatableGhosts() == true
                && (meetGhost(ghost1) || meetGhostCorrection(ghost1))) {
            map.eatenGhost = ghost1.getName();
            Sounds.eatGhostSound();
        } else if (ghost2.isEatableGhosts() == true
                && (meetGhost(ghost2) || meetGhostCorrection(ghost2))) {
            map.eatenGhost = ghost2.getName();
            Sounds.eatGhostSound();
        }else if (ghost3.isEatableGhosts() == true
                && (meetGhost(ghost3) || meetGhostCorrection(ghost3))) {
            map.eatenGhost = ghost3.getName();
            Sounds.eatGhostSound();
        } else if (ghost4.isEatableGhosts() == true
                && (meetGhost(ghost4) || meetGhostCorrection(ghost4))) {
            map.eatenGhost = ghost4.getName();
            Sounds.eatGhostSound();
        }
    }

    public void clearedMap() {
        boolean test = false;
        for (int j = 0; j <= 29 && test == false; j++) {
            for (int i = 0; i <= 27 && test == false; i++) {
                if (!MapStructure.Map[j][i].getTreat().equals("none")) test = true;
            }
        }
        if (!test) {
            pacman.setPic(new ImageIcon("src\\main\\resources\\pacman\\pacmanClosed.png"));
            map.repaint();

            map.setNotCatched(false);

            MapStructure.fillWithTreats();
            Sounds.win();
            ghost1.level++;
            ghost2.level++;
            ghost3.level++;
            ghost4.level++;
            pacman.level++;
            if (ghost1.speed < 5) {
                ghost1.speed++;
                ghost2.speed++;
                ghost3.speed++;
                ghost4.speed++;
            } else if (map.refresh > 10) map.refresh -= 2;
        }
    }

    public void extraLife() {
        if (pacman.getPoints() % 10000 == 0) {
            pacman.addLife();
            pacman.addPoints(1);
            Sounds.eatFruitSound();
        }
    }

}
