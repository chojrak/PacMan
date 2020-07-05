package Model;

import View.Map;

public class Events {
    Player pacman;
    Map map;
    Ghost ghost;

    public Events(Player pacman, Map map, Ghost ghost) {
        this.pacman = pacman;
        this.ghost = ghost;
        this.map = map;
        eatDot();
    }

    public void eatDot() {
        if (MapStructure.Map[pacman.currentVerticalPosition / 24][pacman.currentHorizontalPosition / 24].isTreat()
                && pacman.currentVerticalPosition / 24 * 24 + 12 < pacman.currentVerticalPosition && pacman.lastMove == "up"
                ||
                MapStructure.Map[pacman.currentVerticalPosition / 24][pacman.currentHorizontalPosition / 24].isTreat()
                        && pacman.currentVerticalPosition / 24 * 24 + 12 > pacman.currentVerticalPosition && pacman.lastMove == "down"
                ||
                MapStructure.Map[pacman.currentVerticalPosition / 24][pacman.currentHorizontalPosition / 24].isTreat()
                        && pacman.currentHorizontalPosition / 24 * 24 + 12 < pacman.currentHorizontalPosition && pacman.lastMove == "left"
                ||
                MapStructure.Map[pacman.currentVerticalPosition / 24][pacman.currentHorizontalPosition / 24].isTreat()
                        && pacman.currentHorizontalPosition / 24 * 24 + 12 > pacman.currentHorizontalPosition && pacman.lastMove == "right"
        ) {
            MapStructure.Map[pacman.currentVerticalPosition / 24][pacman.currentHorizontalPosition / 24].setTreat(false);
            pacman.addPoints(10);
        }
    }
}
