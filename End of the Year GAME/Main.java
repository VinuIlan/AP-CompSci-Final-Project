import javax.swing.*;

/**
 * Main
 * 
 * @author (Vinu and Vivek) 
 * @version (1)
 */
public class Main
{
    public Main()
    {
        JFrame mainWindow = new JFrame();
        mainWindow.add(new Platform2());
        mainWindow.setTitle("Super Smash Bros(w/ DBZ characters) - Vinu & Vivek Style");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(1200 , 800);
        mainWindow.setVisible(true);
        
    }
    
    public static void main(String[] args)
    {
        new Main();
    }
}
