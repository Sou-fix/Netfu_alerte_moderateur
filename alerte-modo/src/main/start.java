package main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.AWTException;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import sun.net.www.protocol.http.HttpURLConnection;

public class start {

    public static void main(String[] args) {
    	 javax.swing.SwingUtilities.invokeLater(new Runnable() {  
    		  
             public void run() {  
                 createAndShowGUI();  
             }  
         });  
    	check(); 
    }
    public static void check() {
    	try {
        	long galgarion = 0L;
        	long crail = 0L;
        	long mono7 = 0L;
        	long monox = 0L;
        	long monoix = 0L;
        	
            start td = new start();
        	while (true) {
        		Thread.sleep(1000);
           	 LocalDateTime ldt = LocalDateTime.now();
           	 String date_now = DateTimeFormatter.ofPattern("MM-dd-HH:mm:ss", Locale.ENGLISH).format(ldt);
                String httpsURL = "http://netfu.net/checking/modos";

                URL myurl;
    			
    				myurl = new URL(httpsURL);

                HttpURLConnection con = (HttpURLConnection) myurl.openConnection();
                con.setRequestProperty ( "User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:63.0) Gecko/20100101 Firefox/63.0" );
                InputStream ins = con.getInputStream();
                InputStreamReader isr = new InputStreamReader(ins);
                BufferedReader in = new BufferedReader(isr);
                String inputLine;
                String page = "";
            while ((inputLine = in.readLine()) != null) {
               
               page += inputLine+"\n";
            }
            if(mono7 == 0L) {
            	if(page.contains("614|")) {
            	galgarion=Integer.parseInt(page.substring(page.indexOf("614|")+4,page.indexOf("614|")+14));
                textArea.append("Dernier ban sur Galgarion le "+time(Integer.parseInt(page.substring(page.indexOf("614|")+4,page.indexOf("614|")+14))) + "\n");
            	}
            	if(page.contains("613|")) {
                crail=Integer.parseInt(page.substring(page.indexOf("613|")+4,page.indexOf("613|")+14));
                textArea.append("Dernier ban sur Crail le "+time(Integer.parseInt(page.substring(page.indexOf("613|")+4,page.indexOf("613|")+14))) + "\n");
            	}
            	/// mono
            	if(page.contains("622|")) {	
            mono7=Integer.parseInt(page.substring(page.indexOf("622|")+4,page.indexOf("622|")+14));
            textArea.append("Dernier ban sur Mono 7 le "+time(Integer.parseInt(page.substring(page.indexOf("622|")+4,page.indexOf("622|")+14))) + "\n");
            	}
            	if(page.contains("625|")) {
            monox=Integer.parseInt(page.substring(page.indexOf("625|")+4,page.indexOf("625|")+14));
            textArea.append("Dernier ban sur Mono X le "+time(Integer.parseInt(page.substring(page.indexOf("625|")+4,page.indexOf("625|")+14))) + "\n");
            	}
            	if(page.contains("624|")) {
            monoix=Integer.parseInt(page.substring(page.indexOf("624|")+4,page.indexOf("624|")+14)); 
            textArea.append("Dernier ban sur Mono IX le "+time(Integer.parseInt(page.substring(page.indexOf("624|")+4,page.indexOf("624|")+14))) + "\n");
            	}
            textArea.append("---------------------------------------------------------------"+ "\n");
            }
            else {
            	if(page.contains("622|"))
            if(mono7 != Integer.parseInt(page.substring(page.indexOf("622|")+4,page.indexOf("622|")+14))){
            mono7=Integer.parseInt(page.substring(page.indexOf("622|")+4,page.indexOf("622|")+14)); 
                    alerte_sound();
            textArea.append("Ban sur Mono 7 le "+date_now + "\n");
            td.displayTray("Ban sur Mono 7 le "+date_now);
            
            }
            	if(page.contains("625|"))
            if(monox != Integer.parseInt(page.substring(page.indexOf("625|")+4,page.indexOf("625|")+14))){
                monox=Integer.parseInt(page.substring(page.indexOf("625|")+4,page.indexOf("625|")+14)); 
                        alerte_sound();
                 textArea.append("Ban sur Mono X le "+date_now + "\n");
                 td.displayTray("Ban sur Mono X le "+date_now);
                
                }
            	if(page.contains("624|"))
            if(monoix != Integer.parseInt(page.substring(page.indexOf("624|")+4,page.indexOf("624|")+14))){
                monoix=Integer.parseInt(page.substring(page.indexOf("624|")+4,page.indexOf("624|")+14)); 
                        alerte_sound();
                textArea.append("Ban sur Mono IX le "+date_now + "\n");
                td.displayTray("Ban sur Mono IX le "+date_now);
                
                }
            // mono
            	if(page.contains("613|"))
                    if(crail != Integer.parseInt(page.substring(page.indexOf("613|")+4,page.indexOf("613|")+14))){
                        crail=Integer.parseInt(page.substring(page.indexOf("613|")+4,page.indexOf("613|")+14)); 
                                alerte_sound();
                        textArea.append("Ban sur Crail le "+date_now + "\n");
                        td.displayTray("Ban sur Crail le "+date_now);
                        
                        }
            	if(page.contains("614|"))
                    if(galgarion != Integer.parseInt(page.substring(page.indexOf("614|")+4,page.indexOf("614|")+14))){
                    	galgarion=Integer.parseInt(page.substring(page.indexOf("624|")+4,page.indexOf("614|")+14)); 
                                alerte_sound();
                        textArea.append("Ban sur Galgarion le "+date_now + "\n");
                        td.displayTray("Ban sur Galgarion le "+date_now);
                        
                        }
            }
            in.close();
        	}
    			} catch (IOException e) {
    				textArea.append("Erreur"+ "\n");
    				System.out.println("Erreur");
    				check();
    			} catch (InterruptedException e) {
    				textArea.append("Erreur"+ "\n");
    				System.out.println("Erreur");
    				check();
    			} catch (AWTException e) {
    				textArea.append("Erreur"+ "\n");
    				System.out.println("Erreur");
    				check();
    			}	
    }
    
    static JTextArea textArea = new JTextArea(30, 42);
    private static void createAndShowGUI() {  
  
        // Create and set up the window.  
        final JFrame frame = new JFrame("Alerte Ban");  
  
        // Display the window.  
        frame.setSize(500, 500);  
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set flow layout for the frame  
        frame.getContentPane().setLayout(new FlowLayout());  
  
          
        JScrollPane scrollableTextArea = new JScrollPane(textArea);  
  
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
  
        frame.getContentPane().add(scrollableTextArea); 
    
    }
    public void displayTray(String text) throws AWTException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        //Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        //Alternative (if the icon is on the classpath):
        Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("modo.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Alerte Ban");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("Alerte Ban");
        tray.add(trayIcon);

        trayIcon.displayMessage("Alerte Ban", text, MessageType.WARNING);
    }
	public static String time(long time) {
        Date date = new java.util.Date(time*1000L); 
     // the format of your date
     SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM-dd HH:mm:ss"); 
     // give a timezone reference for formatting (see comment at the bottom)
     String formattedDate = sdf.format(date);
     return formattedDate;	
	}
    public static void alerte_sound() {
   	 AudioClip clip = Applet.newAudioClip(start.class.getResource("alert.wav"));
        clip.play();
   }
}