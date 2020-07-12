package Model;

import View.Map;
import View.RightPanel;

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
        meetGhost();
        eatGhost();
        clearedMap();
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

    public void meetGhost() {
        if (ghost1.isEatableGhosts() == false
                && pacman.currentVerticalPosition / 24 == ghost1.currentVerticalPosition / 24
                && pacman.currentHorizontalPosition / 24 == ghost1.currentHorizontalPosition / 24
                ||
                ghost2.isEatableGhosts() == false
                        && pacman.currentVerticalPosition / 24 == ghost2.currentVerticalPosition / 24
                        && pacman.currentHorizontalPosition / 24 == ghost2.currentHorizontalPosition / 24
                ||
                ghost3.isEatableGhosts() == false
                        && pacman.currentVerticalPosition / 24 == ghost3.currentVerticalPosition / 24
                        && pacman.currentHorizontalPosition / 24 == ghost3.currentHorizontalPosition / 24
                ||
                ghost4.isEatableGhosts() == false
                        && pacman.currentVerticalPosition / 24 == ghost4.currentVerticalPosition / 24
                        && pacman.currentHorizontalPosition / 24 == ghost4.currentHorizontalPosition / 24) {
            map.setNotCatched(false);
            pacman.subtractLife();
            Sounds.deathSound();


        }
    }

    public void eatGhost() {
        if (ghost1.isEatableGhosts() == true
                && pacman.currentVerticalPosition / 24 == ghost1.currentVerticalPosition / 24
                && pacman.currentHorizontalPosition / 24 == ghost1.currentHorizontalPosition / 24) {
            map.eatenGhost = ghost1.getName();

        } else if (ghost2.isEatableGhosts() == true
                && pacman.currentVerticalPosition / 24 == ghost2.currentVerticalPosition / 24
                && pacman.currentHorizontalPosition / 24 == ghost2.currentHorizontalPosition / 24) {
            map.eatenGhost = ghost2.getName();
        } else if (ghost3.isEatableGhosts() == true
                && pacman.currentVerticalPosition / 24 == ghost3.currentVerticalPosition / 24
                && pacman.currentHorizontalPosition / 24 == ghost3.currentHorizontalPosition / 24) {
            map.eatenGhost = ghost3.getName();
        } else if (ghost4.isEatableGhosts() == true
                && pacman.currentVerticalPosition / 24 == ghost4.currentVerticalPosition / 24
                && pacman.currentHorizontalPosition / 24 == ghost4.currentHorizontalPosition / 24) {
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
        if(!test) {map.setNotCatched(false);

            MapStructure.fillWithTreats();

            ghost1.level++;
            ghost2.level++;
            ghost3.level++;
            ghost4.level++;
            pacman.level++;
            if (ghost1.speed< 5) {ghost1.speed++;
            ghost2.speed++;
            ghost3.speed++;
            ghost4.speed++;}
            else map.refresh = map.refresh/3*2;
        }
    }

}
