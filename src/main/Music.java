package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {

    Clip clip;
    GUI gui;


    public Music(GUI gui) {
        this.gui = gui;
    }

    public void setFile(String soundFileName) {

        try {
            File file = new File(soundFileName);
            AudioInputStream music = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(music);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public  void stop() {
       clip.stop();
       clip.close();
    }
}
