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
    static boolean interMSSound = false;

    public static void music() {
        newSound(true, new File("src\\main\\resources\\music\\beginning.wav"));
    }

    public static void intermission() {
        if (!interMSSound) {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src\\main\\resources\\music\\pacman_intermission.wav"));
            clip.open(ais);
            clip.setFramePosition(0);
            clip.start();
            interMSSound = true;
            clip.addLineListener(new interMSSoundEnd());

        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            ex.printStackTrace();
        }}
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

    public static void win() {
        newSound(false, new File("src\\main\\resources\\music\\pacman_extrapac.wav"));
    }

    public static void newSound(boolean prioritySound, File file) {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            clip.open(ais);
            clip.setFramePosition(0);
            if (prioritySound) {
                if (musicOn == false)
                    clip.start();
            } else if (!prioritySound) clip.start();
            musicOn = true;
            clip.addLineListener(new musicEnd());

        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        music();
    }


}


class musicEnd implements LineListener {
    @Override
    public void update(LineEvent event) {
        if (event.getType() == LineEvent.Type.STOP) Sounds.musicOn = false;
    }
}

class interMSSoundEnd implements LineListener {
    @Override
    public void update(LineEvent event) {
        if (event.getType() == LineEvent.Type.STOP) Sounds.interMSSound = false;
    }
}


