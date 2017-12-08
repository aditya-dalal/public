package designPatternsNew.structural.adapter;

/**
 * Created by aditya.dalal on 20/01/17.
 */
public class AVIPlayer implements AdvancedMediaPlayer {

    @Override
    public void playAVI(String file) {
        System.out.println("Playing AVI file: " +file);
    }

    @Override
    public void playMP3(String file) {

    }
}
