package listeners;

import gui.TorrentGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitListener implements ActionListener {
    private TorrentGUI gui;

    public ExitListener(TorrentGUI gui) {
        this.gui = gui;
    }


    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
