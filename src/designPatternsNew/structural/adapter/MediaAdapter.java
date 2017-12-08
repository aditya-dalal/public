package designPatternsNew.structural.adapter;

/**
 * Created by aditya.dalal on 20/01/17.
 */
public class MediaAdapter implements MediaPlayer{

    AdvancedMediaPlayer player;

    public MediaAdapter(String audioType) {
        if(audioType.equalsIgnoreCase("avi"))
            player = new AVIPlayer();
        else if(audioType.equalsIgnoreCase("mp3"))
            player = new MP3Player();
    }

    @Override
    public void play(String audioType, String file) {
        if(audioType.equalsIgnoreCase("avi"))
            player.playAVI(file);
        else if(audioType.equalsIgnoreCase("mp3"))
            player.playMP3(file);
    }
}
