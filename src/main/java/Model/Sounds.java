package Model;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
public class Sounds {

	public static void music() {
	
		try {
	    Clip clip = AudioSystem.getClip();
	    AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src\\main\\resources\\music\\beginning.wav"));
	    clip.open(ais);
	    clip.loop(0);
	    
	} catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
	    ex.printStackTrace();
	}
	}
	
	public static void background() {
		
		try {
	    Clip clip = AudioSystem.getClip();
	    AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src\\main\\resources\\music\\beginning.wav"));
	    clip.open(ais);
	    clip.loop(2);
	    
	    
	} catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
	    ex.printStackTrace();
	}
	}
	 public static void eatDotSound() {
		 try {
			    Clip clip = AudioSystem.getClip();
			    AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src\\main\\resources\\music\\chomp.wav"));
			    clip.open(ais);
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
			    clip.loop(0);
			    
			} catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
			    ex.printStackTrace();
			}
			} 
	 }



