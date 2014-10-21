import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;
//import java.util.TimerTask;

public class Platform extends JComponent implements ActionListener
{
    private int p1Lives;
    private int p2Lives;
    private int p1Health;
    private int p2Health;
    //private int count = 0;

    private boolean left = true;
    private boolean bottom = true;
    
    //public Rectangle top;
    //public Rectangle bottomR;
    
    //private static int DELAY = 10;
    Timer time;
    
    private int topX = 50;
    private int topY = 100;
    private int bottomX = 50;
    private int bottomY = 400;
    
    Vegeta p1 = new Vegeta();
    

    public Platform() 
    {
        p1Lives = 3;
        p2Lives = 3;
        p1Health = 100;
        p2Health = 100;
        
        //top = new Rectangle(topX, topY, 200, 25);
        //bottomR = new Rectangle(bottomX, bottomY, 200, 25);
        //go();
        
        time = new Timer(5, this);
        time.start();
    }
    
    public void actionPerformed(ActionEvent e) {
        //go();
        p1.move();
        repaint();
    }
    
/**    public void runBoard() 
   {
        //TimerTask timerTask = new TimerTask() 
        //{
              //public void run() 
              //{
        
                    if (left) 
                    {
                        topX += 1;
                        
                        if (topX >= 900)
                            left = false;
                    }
                    else
                    {
                        topX -= 1;
                        
                        if (topX <= 50)
                            left = true;
                    }
                    
                    if (bottom) 
                    {
                        bottomY -= 1;
                        
                        if (bottomY <= 250)
                            bottom = false;
                    }
                    else
                    {
                        bottomY += 1;
                        
                        if (bottomY >= 600)
                            bottom = true;
                    }
                    
                    
                //repaint();
              //}
        //};

        //Timer timer = new Timer();
        //timer.schedule(timerTask, 0, DELAY);
    }
    
*/
      private class AL extends KeyAdapter {
                    public void keyReleased(KeyEvent e) {
                            p1.keyReleased(e);
                    }
     
                  public void keyPressed(KeyEvent e) {
                            p1.keyPressed(e);
                    }
            }

    public void paint(Graphics g)
    {
        //super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g3 = (Graphics2D) g;
        
        g2.setColor(Color.BLUE);
        g2.drawString("Player 1 Lives: " + p1Lives, 200, 15);
        g2.drawString("Player 2 Lives: " + p2Lives, 900, 15);
        g2.drawString("Player 1 Health: " + p1Health + "           |||||           Player 1 Health: " + p2Health, 425, 15);
        
        Rectangle top = new Rectangle(topX, topY, 200, 25);
        Rectangle bottomR = new Rectangle(bottomX, bottomY, 200, 25);
        

        
        g3.setColor(Color.GREEN);
        g3.fill(top);
        g3.fill(bottomR);
        
        g2.setColor(Color.BLACK);
        g2.fill(new Rectangle(50, 200, 200, 25));
        g2.fill(new Rectangle(500, 200, 200, 25));
        g2.fill(new Rectangle(600, 400, 200, 25));
        g2.fill(new Rectangle(300, 300, 200, 25));
        g2.fill(new Rectangle(300, 475, 200, 25));
        g2.fill(new Rectangle(750, 650, 350, 25));
        g2.fill(new Rectangle(800, 200, 200, 25));
        g2.fill(new Rectangle(700, 500, 200, 25));
        g2.fill(new Rectangle(300, 600, 200, 25));
        g2.fill(new Rectangle(800, 400, 200, 25));
        
        g2.setColor(Color.BLUE);
        g2.draw(new Rectangle(0, 740, 1200, 25));       //Bottom PlatForm
        
        g2.drawImage(p1.getImage(), p1.getX(), p1.getY(), null);
        

    }
}
