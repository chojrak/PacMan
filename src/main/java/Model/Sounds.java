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

        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src\\main\\resources\\music\\beginning.wav"));
            if (musicOn == false) clip.open(ais);
            musicOn = true;
            clip.addLineListener(new musicEnd());
            clip.loop(0);


        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void intermission() {

        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src\\main\\resources\\music\\pacman_intermission.wav"));
            //  if (musicOn == false) clip.open(ais);
            musicOn = true;
            clip.addLineListener(new musicEnd());
            clip.loop(0);


        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void eatDotSound() {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src\\main\\resources\\music\\chaps4.wav"));
            if (musicOn == false) clip.open(ais);
            musicOn = true;
            clip.addLineListener(new musicEnd());
            clip.loop(0);

        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void eatFruitSound() {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src\\main\\resources\\music\\fruit.wav"));
            //  if (musicOn == false) clip.open(ais);
            musicOn = true;
            clip.addLineListener(new musicEnd());
            clip.loop(0);

        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void deathSound() {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src\\main\\resources\\music\\death.wav"));
            clip.open(ais);
            musicOn = true;
            clip.addLineListener(new musicEnd());
            clip.loop(0);

        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            ex.printStackTrace();
        }
    }


    public static void eatGhostSound() {

        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src\\main\\resources\\music\\pacman_eatghost.wav"));
            //  if (musicOn == false) clip.open(ais);
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


