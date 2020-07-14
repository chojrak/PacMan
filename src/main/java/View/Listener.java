package View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {
    Map map;

    public Listener(Map map) {
        this.map = map;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) map.player.setLastPressedMove("right");
        if (e.getExtendedKeyCode() == KeyEvent.VK_LEFT) map.player.setLastPressedMove("left");
        if (e.getExtendedKeyCode() == KeyEvent.VK_UP) map.player.setLastPressedMove("up");
        if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN) map.player.setLastPressedMove("down");

        if (e.getExtendedKeyCode() == KeyEvent.VK_D) map.blinky.setNextMove("right");
        if (e.getExtendedKeyCode() == KeyEvent.VK_A) map.blinky.setNextMove("left");
        if (e.getExtendedKeyCode() == KeyEvent.VK_W) map.blinky.setNextMove("up");
        if (e.getExtendedKeyCode() == KeyEvent.VK_S) map.blinky.setNextMove("down");

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}



