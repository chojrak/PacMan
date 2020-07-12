package Model;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.*;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Sounds {

    static boolean musicOn = false;

    public static void music() {
        newSound(true, new File("src\\main\\resources\\music\\beginning.wav"));
    }

    public static void intermission() {
        newSound(false, new File("src\\main\\resources\\music\\pacman_intermission.wav"));
    }

    public static void eatDotSound() {
        newSound(true, new File("src\\main\\resources\\music\\chaps4.wav"));
    }

    public static void eatFruitSound() {
        newSound(false, new File("src\\main\\resources\\music\\fruit.wav"));
    }

    public static void deathSound() {
        newSound(false, new File("src\\main\\resources\\music\\death.wav"));
    }


    public static void eatGhostSound() {
        newSound(false, new File("src\\main\\resources\\music\\pacman_eatghost.wav"));
    }

    public static void newSound(boolean prioritySound, File file) {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            if (prioritySound) {
                if (musicOn == false) clip.open(ais);
            }
            musicOn = true;
            clip.addLineListener(new musicEnd());
            clip.loop(0);

        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            ex.printStackTrace();
        }
    }


}


class musicEnd implements LineListener {
    @Override
    public void update(LineEvent event) {
        if (event.getType() == LineEvent.Type.STOP) Sounds.musicOn = false;
    }
}


