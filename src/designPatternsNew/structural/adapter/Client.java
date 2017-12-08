package designPatternsNew.structural.adapter;

/**
 * Created by aditya.dalal on 20/01/17.
 */
public class Client {

    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        player.play("avi", "file.avi");
        player.play("mp3", "file.mp3");
        player.play("vlc", "file.vlc");
    }
}
