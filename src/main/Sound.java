package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[30];
    FloatControl fc;
    int volumeSCale = 1;
    float volume;

    public Sound() {
        soundURL[0] = getClass().getResource("/sound/OddLook.wav");
        soundURL[1] = getClass().getResource("/sound/TakingFirstAidKit.wav");
        soundURL[2] = getClass().getResource("/sound/GunEffect.wav");
        soundURL[3] = getClass().getResource("/sound/hitmonster.wav");
        soundURL[4] = getClass().getResource("/sound/receivedamage.wav");
        soundURL[5] = getClass().getResource("/sound/GtaMenu.wav");
        soundURL[6] = getClass().getResource("/sound/Die.wav");
        soundURL[7] = getClass().getResource("/sound/map.wav");
        soundURL[8] = getClass().getResource("/sound/Victory.wav");

    }

    public void setFile(int i){
        try{

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            checkVolume();

        }catch(Exception e){
        }
    }

    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){

        clip.stop();
    }
    public void checkVolume(){

        switch(volumeSCale){
            case 0:
                volume = -80f;
                break;
            case 1:
                volume = -20f;
                break;
            case 2:
                volume = -12f;
                break;
            case 3:
                volume = -5f;
                break;
            case 4: volume = 1f;
                break;
            case 5:
                volume = 6f;
                break;

        }

        fc.setValue(volume);
    }
}
