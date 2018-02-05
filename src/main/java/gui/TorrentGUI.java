package gui;

import listeners.*;

import javax.swing.*;
import java.awt.*;

/**
 * Class resposnsible for drawing GUI
 *
 */
//
public class TorrentGUI extends JFrame{

    //PANELS

    private JPanel torrents;
    private JPanel buttons;
    private JPanel peerstats;
    private JPanel details;

    // BUTTONS
    private JButton start;
    private JButton resume;
    private JButton pause;
    private JButton stop;
    private JButton browse;
    private JButton exit;

    private JLabel filename;
    private JLabel progress;
    private JLabel filepath;
    private JLabel downloaded;
    private JLabel uploaded;
    //


    public TorrentGUI() {
        setTitle("Torrent Client");
        setLayout(new BorderLayout());


        torrents = new JPanel();
        torrents.setPreferredSize(new Dimension(1000,150));
        torrents.setBackground(Color.BLUE);



        // BUTTONS


        buttons = new JPanel();
        buttons.setLayout(new GridLayout(6,1));
        buttons.setPreferredSize(new Dimension(200,250));
        buttons.setBackground(Color.RED);


        start = new JButton("Start");
        start.addActionListener(new StartListener(this));

        resume = new JButton("Resume");
        resume.addActionListener(new ResumeListener());

        pause = new JButton("Pause");
        pause.addActionListener(new PauseListener());

        stop = new JButton("Stop");
        stop.addActionListener(new StopListener());

        browse = new JButton("Browse");
        browse.addActionListener(new BrowseListener(this));

        exit = new JButton("Exit");
        exit.addActionListener(new ExitListener(this));

        buttons.add(start);
        buttons.add(resume);
        buttons.add(pause);
        buttons.add(stop);
        buttons.add(browse);
        buttons.add(exit);

        //END BUTTONS


        details = new JPanel();
        details.setLayout(new GridLayout(6,1));
        details.setPreferredSize(new Dimension(800,250));
        details.setBackground(Color.GRAY);

        filename = new JLabel();
        filepath = new JLabel();
        progress = new JLabel();
        downloaded = new JLabel();
        uploaded = new JLabel();


        details.add(filename);
        details.add(filepath);
        details.add(progress);
        details.add(downloaded);
        details.add(uploaded);

        peerstats = new JPanel();
        peerstats.setPreferredSize(new Dimension(1000,150));
        peerstats.setBackground(Color.ORANGE);







        add(torrents, BorderLayout.NORTH);
        add(buttons, BorderLayout.EAST);
        add(details, BorderLayout.WEST);
        add(peerstats, BorderLayout.SOUTH);



    }

    public JPanel getDetails() {
        return details;
    }

    public void setFileName(String filename){
        this.filename.setText(filename);
    }

    public void setFilepath(String filepath) {
        this.filepath.setText(filepath);
    }
    public String getFilepath() {
        return filepath.getText();
    }
    public void setProgress(float progress){
       String progres = Float.toString(progress);
       this.progress.setText("Progress : " + progres);
    }
    public void setDownloaded(long downloaded){
        String down = Long.toString(downloaded);
        this.downloaded.setText("Downloaded : " + down);
    }
    public void setUploaded(long uploaded){
        String up = Long.toString(uploaded);
        this.uploaded.setText("Uploaded : " + up);
    }

}
