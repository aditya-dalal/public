package designPatternsNew.structural.adapter;

/**
 * Created by aditya.dalal on 20/01/17.
 */
public class AudioPlayer implements MediaPlayer {

    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String file) {
        if(audioType.equalsIgnoreCase("vlc")) {
            System.out.println("Playing VLC file: " + file);
        }
        else if(audioType.equalsIgnoreCase("avi") || audioType.equalsIgnoreCase("mp3")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, file);
        }
    }
}
