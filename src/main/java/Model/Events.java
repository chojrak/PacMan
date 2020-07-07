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
            Sounds.eatDotSound();
            
        }
        
        	
    }

    public void meetGhost() {
        if (pacman.currentVerticalPosition / 24 == ghost1.currentVerticalPosition / 24
                && pacman.currentHorizontalPosition / 24 == ghost1.currentHorizontalPosition / 24
                ||
                pacman.currentVerticalPosition / 24 == ghost2.currentVerticalPosition / 24
                        && pacman.currentHorizontalPosition / 24 == ghost2.currentHorizontalPosition / 24
                ||
                pacman.currentVerticalPosition / 24 == ghost3.currentVerticalPosition / 24
                        && pacman.currentHorizontalPosition / 24 == ghost3.currentHorizontalPosition / 24
                ||
                pacman.currentVerticalPosition / 24 == ghost4.currentVerticalPosition / 24
                        && pacman.currentHorizontalPosition / 24 == ghost4.currentHorizontalPosition / 24) {
            map.setNotCatched(false);
            pacman.subtractLife();
        	Sounds.deathSound();
            
        }
    }


}
