import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
 
public class Vegeta
{
    int x, dx, y, dy;
    int cy = y;
    Image p1;
    private Image[] vegeta = new Image[16];
    
    public Vegeta() 
    {
        ImageIcon a = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Vegeta/Vegeta_Stand(r).png");
        ImageIcon b = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Vegeta/Vegeta_Stand(l).png");
        ImageIcon c = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Vegeta/Vegeta_Run(r).png");
        ImageIcon d = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Vegeta/Vegeta_Run(l).png");
        ImageIcon e = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Vegeta/Vegeta_guard(r).png");
        ImageIcon f = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Vegeta/Vegeta_guard(l).png");
        ImageIcon g = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Vegeta/Vegeta_jump(r).png");
        ImageIcon h = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Vegeta/Vegeta_jump(l).png");
        ImageIcon i = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Vegeta/Vegeta_kick1(r).png");
        ImageIcon j = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Vegeta/Vegeta_kick2(r).png");
        ImageIcon k = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Vegeta/Vegeta_kick1(l).png");
        ImageIcon l = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Vegeta/Vegeta_kick2(l).png");
        ImageIcon m = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Vegeta/Vegeta_punch1(r).png");
        ImageIcon n = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Vegeta/Vegeta_punch2(r).png");
        ImageIcon o = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Vegeta/Vegeta_punch1(l).png");
        ImageIcon p = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Vegeta/Vegeta_punch2(l).png");
        vegeta[0] = a.getImage();
        vegeta[1] = b.getImage();
        vegeta[2] = c.getImage();
        vegeta[3] = d.getImage();
        vegeta[4] = e.getImage();
        vegeta[5] = f.getImage();
        vegeta[6] = g.getImage();
        vegeta[7] = h.getImage();
        vegeta[8] = i.getImage();
        vegeta[9] = j.getImage();
        vegeta[10] = k.getImage();
        vegeta[11] = l.getImage();
        vegeta[12] = m.getImage();
        vegeta[13] = n.getImage();
        vegeta[14] = o.getImage();
        vegeta[15] = p.getImage();
        p1 = vegeta[1];
        dx = 0;
        dy = 0;
        x = 800;
        y = 400;
    }
    
    public void move() 
    {
        x = x + dx;
        y = y + dy;
    }
    
    public boolean isBlocking() 
    {
        if(p1 == vegeta[4] || p1 == vegeta[5])
            return true;
        else
            return false;
    }
    
    public boolean isAttacking() 
    {
        if(p1 == vegeta[11] || p1 == vegeta[9] || p1 == vegeta[15] || p1 == vegeta[13])
            return true;
        else
            return false;
    }
    
    public int getX() 
    {
        return x;
    }
    
    public int getY() 
    {
        return y;
    }
    
    public Image getImage() 
    {
        return p1;
    }
    
    public void delay()
    {
        //try{
        //    Thread.sleep(100);
        //}catch(InterruptedException ex){}
        long count = 1000000;
        for(int i = 0; i <= count; i++){}     
    }
    
    public void vAttack()
    {
        if(p1 == vegeta[14])
        {
            delay();
            p1 = vegeta[15];
        }
        if(p1 == vegeta[15])
        {
            delay();
            p1 = vegeta[1];
        }
        
        
     }
    
    public void keyPressed(KeyEvent e) 
    {
        int key = e.getKeyCode();
        cy = y;
        if (key == KeyEvent.VK_LEFT)
        {        
                dx = -5;
                p1 = vegeta[3];
        }       
    
        if (key == KeyEvent.VK_RIGHT)
        {
                dx = 5;
                p1 = vegeta[2];
        }
        
        if (key == KeyEvent.VK_UP)
        {        
            if(p1 == vegeta[1] || p1 == vegeta[3])
            {
                dy = -5;
                p1 = vegeta[7];
            }
            else if (p1 == vegeta[0] || p1 == vegeta[2])
            {
                dy = -5;
                p1 = vegeta[6];
            }
        }
        
        if (key == KeyEvent.VK_DOWN)
        {        
                dy = 5;
            if(p1 == vegeta[1] || p1 == vegeta[3])
            {
                p1 = vegeta[7];
            }
            else if (p1 == vegeta[0] || p1 == vegeta[2])
            {
                p1 = vegeta[6];
            }
        }
        
        if (key == KeyEvent.VK_SLASH)
        {
            if(p1 == vegeta[1] || p1 == vegeta[3])
            {
                dx = 0;
                p1 = vegeta[5];
            }
            else if (p1 == vegeta[0] || p1 == vegeta[2])
            {
                dx = 0;
                p1 = vegeta[4];
            }
        }
        
        if (key == KeyEvent.VK_PERIOD)
        {
            if(p1 == vegeta[1] || p1 == vegeta[3])
            {
                dx = 0;
                x += -37;
                y += -4;
                p1 = vegeta[11];
            }
            else if (p1 == vegeta[0] || p1 == vegeta[2])
            {
                dx = 0;
                x += 20;
                y += -8;
                p1 = vegeta[9];
            }
        }
        
        if (key == KeyEvent.VK_COMMA)
        {
            if(p1 == vegeta[1] || p1 == vegeta[3])
            {
                dx = 0;
                x += -22;
                p1 = vegeta[15];
            }

            else if (p1 == vegeta[0] || p1 == vegeta[2])
            {
                dx = 0;
                x += 2;
                p1 = vegeta[13];
            }
        }
    }
    
    public void keyReleased(KeyEvent e) 
    {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT)
        {
                dx = 0;
                p1 = vegeta[1];
        }
    
        if (key == KeyEvent.VK_RIGHT)
        {
                dx = 0;
                p1 = vegeta[0];
        }
        
        if (key == KeyEvent.VK_UP)
        {
            dy = 0;
            if(p1 == vegeta[7])
            {
                p1 = vegeta[1];
            }
            else if (p1 == vegeta[6])
            {
                p1 = vegeta[0];
            }
        }
        
        if (key == KeyEvent.VK_DOWN)
        {
            dy = 0;
            if(p1 == vegeta[7])
            {
                p1 = vegeta[1];
            }
            else if (p1 == vegeta[6])
            {
                p1 = vegeta[0];
            }
        }
        
        if (key == KeyEvent.VK_SLASH)
        {
            if(p1 == vegeta[5])
            {
                p1 = vegeta[1];
            }
            else if (p1 == vegeta[4])
            {
                p1 = vegeta[0];
            }
        }
        
        if (key == KeyEvent.VK_PERIOD)
        {
            if(p1 == vegeta[11])
            {
                x += 37;
                y += 4;
                p1 = vegeta[1];
            }
            else if (p1 == vegeta[9])
            {
                x += -20;
                y += 8;
                p1 = vegeta[0];
            }
        }
        
        if (key == KeyEvent.VK_COMMA)
        {
            
            if (p1 == vegeta[15])
            {
                x += 22;
                p1 = vegeta[1];
            }

            else if (p1 == vegeta[13])
            {
                x += -2;
                p1 = vegeta[0];
            }
        }
    }
     
}