package listeners;
import gui.TorrentGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BrowseListener implements ActionListener {

    private File file;
    private TorrentGUI gui;
    private String filename = "";
    public static String filepath;

    public BrowseListener(TorrentGUI gui){
        this.gui = gui;
    }


    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File("."));
        int result = jFileChooser.showOpenDialog(this.gui);

        if (result == jFileChooser.APPROVE_OPTION){
            setFile(jFileChooser.getSelectedFile());
            filename = file.getName();
            filepath = file.getPath();
            gui.setFileName("File name : "+ filename);
            gui.setFilepath("File path : "+ filepath);
        }

    }


    public void setFile(File file) {
        this.file = file;
    }
    public static String getFilepath(){
        return filepath;
    }


}
