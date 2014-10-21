import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.JComponent;
import java.awt.Image;
import java.lang.Object;
import javax.swing.JPanel;

public class Gohan  extends JComponent
{
    private final int width = 4;
    private final int height = 10;
    private final int rows = 10;
    private final int cols = 6;
    private Image p1;
    BufferedImage[] gohan = new BufferedImage[rows * cols];

    public Gohan()  throws IOException
    {
        getImages();
        go();
    }
    
    public void getImages()  throws IOException
    {
        File inF = new File("H:\\JavaIlangovan\\End of the Year Project\\Sprites\\gohan_sheet.png"); 
        BufferedImage bigImg = ImageIO.read(inF);

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                gohan[(i * cols) + j] = bigImg.getSubimage(i * width, j * height, width, height);
            }
        }
        
        p1 = bigImg;

    }
    
    public void go()
    {
        //blah
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        g2.drawImage(p1, 100, 100, null);
    }
}
