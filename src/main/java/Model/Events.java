package Model;

import View.Map;

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
                ghost1.setEatableGhosts(true);
                ghost2.setEatableGhosts(true);
                ghost3.setEatableGhosts(true);
                ghost4.setEatableGhosts(true);
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
            ghost1.reverseMove();
            pacman.lastMoveSnap = Integer.valueOf(pacman.movesCounter);
        } else if (ghost2.isEatableGhosts() == true
                && pacman.currentVerticalPosition / 24 == ghost2.currentVerticalPosition / 24
                && pacman.currentHorizontalPosition / 24 == ghost2.currentHorizontalPosition / 24) {
            map.eatenGhost = ghost2.getName();
            ghost2.reverseMove();
            pacman.lastMoveSnap = Integer.valueOf(pacman.movesCounter);
        } else if (ghost3.isEatableGhosts() == true
                && pacman.currentVerticalPosition / 24 == ghost3.currentVerticalPosition / 24
                && pacman.currentHorizontalPosition / 24 == ghost3.currentHorizontalPosition / 24) {
            map.eatenGhost = ghost3.getName();
            ghost3.reverseMove();
            pacman.lastMoveSnap = Integer.valueOf(pacman.movesCounter);
        } else if (ghost4.isEatableGhosts() == true
                && pacman.currentVerticalPosition / 24 == ghost4.currentVerticalPosition / 24
                && pacman.currentHorizontalPosition / 24 == ghost4.currentHorizontalPosition / 24) {
            map.eatenGhost = ghost4.getName();
            ghost4.reverseMove();
            pacman.lastMoveSnap = Integer.valueOf(pacman.movesCounter);
        }
    }


}
