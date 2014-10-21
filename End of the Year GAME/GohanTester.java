import javax.swing.*;
import java.io.IOException;

public class GohanTester extends JPanel
{
    public static void main()  throws IOException
    {
        JFrame mainWindow = new JFrame("Gohan");
        
        mainWindow.setSize(1200 , 800);
        
        Gohan g = new Gohan();
        mainWindow.getContentPane().add(g);
        
        mainWindow.show();
        
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);
    }
}
