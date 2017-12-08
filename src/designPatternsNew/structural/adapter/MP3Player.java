package designPatternsNew.structural.adapter;

/**
 * Created by aditya.dalal on 20/01/17.
 */
public class MP3Player implements AdvancedMediaPlayer {

    @Override
    public void playAVI(String file) {}

    @Override
    public void playMP3(String file) {
        System.out.println("Playing MP3 file: " + file);
    }
}
