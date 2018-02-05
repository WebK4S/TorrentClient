import gui.TorrentGUI;

import javax.swing.*;
import java.awt.*;

public class TorrentClient {

    public static final int DEFAULT_WIDTH = 1000;
    public static final int DEFAULT_HEIGHT = 600;

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                TorrentGUI gui = new TorrentGUI();
                gui.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
                gui.setResizable(false);
                gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                gui.setVisible(true);
            }
        });
    }
}
