package listeners;

import com.turn.ttorrent.client.Client;
import com.turn.ttorrent.client.SharedTorrent;
import gui.TorrentGUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.nio.channels.UnsupportedAddressTypeException;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;

/**
 *
 */
public class StartListener implements ActionListener {

    private static final Logger logger =
            LoggerFactory.getLogger(StartListener.class);

    public static final String outputDir = "C:\\Users\\Kamil\\IdeaProjects\\TorrentClient\\downloaded";

    private TorrentGUI gui;

    public StartListener(TorrentGUI gui){
        this.gui = gui;
    }

    private static Inet4Address getIPv4Address(String iface)
            throws SocketException, UnsupportedAddressTypeException,
            UnknownHostException {
        if (iface != null) {
            Enumeration<InetAddress> addresses =
                    NetworkInterface.getByName(iface).getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress addr = addresses.nextElement();
                if (addr instanceof Inet4Address) {
                    return (Inet4Address)addr;
                }
            }
        }

        InetAddress localhost = InetAddress.getLocalHost();
        if (localhost instanceof Inet4Address) {
            return (Inet4Address)localhost;
        }

        throw new UnsupportedAddressTypeException();
    }

    public void actionPerformed(ActionEvent e) {
        String ifaceValue = null;
       try{
           Client client = new Client(
                   getIPv4Address(ifaceValue),
                   SharedTorrent.fromFile(
                           new File(BrowseListener.getFilepath()),
                           new File(outputDir)


                   ));
           client.setMaxDownloadRate(2048.0);
           client.setMaxUploadRate(2048.0);
           System.out.println("Start downloading...");
           client.download();
           client.addObserver(new Observer() {
               public void update(Observable o, Object arg) {
                   Client client = (Client) o;
                   float progress = client.getTorrent().getCompletion();
                   long downloaded = client.getTorrent().getDownloaded();
                   long uploaded = client.getTorrent().getUploaded();

                   gui.setProgress(progress);
                   gui.setDownloaded(downloaded);
                   gui.setUploaded(uploaded);
                   logger.info("Completed");
               }
           });

       }
       catch (UnknownHostException uhe){
           System.out.println(uhe);
       } catch (NoSuchAlgorithmException e1) {
           e1.printStackTrace();
       } catch (IOException e1) {
           e1.printStackTrace();
       }
    }
}
