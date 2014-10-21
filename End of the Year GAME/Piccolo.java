import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
 
public class Piccolo 
{
    int x, dx, y, dy;
    Image p1;
    private Image[] piccolo = new Image[16];
    
    public Piccolo() 
    {
        ImageIcon a = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Piccolo/Piccolo_stand(r).png");
        ImageIcon b = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Piccolo/Piccolo_stand(l).png");
        ImageIcon c = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Piccolo/Piccolo_run(r).png");
        ImageIcon d = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Piccolo/Piccolo_run(l).png");
        ImageIcon e = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Piccolo/Piccolo_guard(r).png");
        ImageIcon f = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Piccolo/Piccolo_guard(l).png");
        ImageIcon g = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Piccolo/Piccolo_jump(r).png");
        ImageIcon h = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Piccolo/Piccolo_jump(l).png");
        ImageIcon i = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Piccolo/Piccolo_kick1(r).png");
        ImageIcon j = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Piccolo/Piccolo_kick2(r).png");
        ImageIcon k = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Piccolo/Piccolo_kick1(l).png");
        ImageIcon l = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Piccolo/Piccolo_kick2(l).png");
        ImageIcon m = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Piccolo/Piccolo_punch1(r).png");
        ImageIcon n = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Piccolo/Piccolo_punch2(r).png");
        ImageIcon o = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Piccolo/Piccolo_punch1(l).png");
        ImageIcon p = new ImageIcon("H:/JavaIlangovan/End of the Year Project/Sprites to Use/Piccolo/Piccolo_punch2(l).png");
        piccolo[0] = a.getImage();
        piccolo[1] = b.getImage();
        piccolo[2] = c.getImage();
        piccolo[3] = d.getImage();
        piccolo[4] = e.getImage();
        piccolo[5] = f.getImage();
        piccolo[6] = g.getImage();
        piccolo[7] = h.getImage();
        piccolo[8] = i.getImage();
        piccolo[9] = j.getImage();
        piccolo[10] = k.getImage();
        piccolo[11] = l.getImage();
        piccolo[12] = m.getImage();
        piccolo[13] = n.getImage();
        piccolo[14] = o.getImage();
        piccolo[15] = p.getImage();
        p1 = piccolo[0];
        dx = 0;
        dy = 0;
        x = 350;
        y = 400;
    }
    
    public void move() 
    {
        x = x + dx;
        y = y + dy;
    }
    
    public boolean isBlocking() 
    {
        if(p1 == piccolo[4] || p1 == piccolo[5])
            return true;
        else
            return false;
    }
    
    public boolean isAttacking() 
    {
        if(p1 == piccolo[11] || p1 == piccolo[9] || p1 == piccolo[15] || p1 == piccolo[13])
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
    
    public void keyPressed(KeyEvent e) 
    {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A)
        {        
                dx = -5;
                p1 = piccolo[3];
        }       
    
        if (key == KeyEvent.VK_D)
        {
                dx = 5;
                p1 = piccolo[2];
        }
        
        if (key == KeyEvent.VK_W)
        {        
                dy = -5;
            if(p1 == piccolo[1] || p1 == piccolo[3])
            {
                p1 = piccolo[7];
            }
            else if (p1 == piccolo[0] || p1 == piccolo[2])
            {
                p1 = piccolo[6];
            }
        }
        
        if (key == KeyEvent.VK_S)
        {        
            dy = 5;
            if(p1 == piccolo[1] || p1 == piccolo[3])
            {
                p1 = piccolo[7];
            }
            else if (p1 == piccolo[0] || p1 == piccolo[2])
            {
                p1 = piccolo[6];
            }
        }
        
        if (key == KeyEvent.VK_1)
        {
            if(p1 == piccolo[1] || p1 == piccolo[3])
            {
                dx = 0;
                x += -28;
                p1 = piccolo[15];
            }
            else if (p1 == piccolo[0] || p1 == piccolo[2])
            {
                dx = 0;
                x += 2;
                p1 = piccolo[13];
            }
        }
        
        if (key == KeyEvent.VK_2)
        {
            if(p1 == piccolo[1] || p1 == piccolo[3])
            {
                dx = 0;
                x += -65;
                y += -8;
                p1 = piccolo[11];
            }
            else if (p1 == piccolo[0] || p1 == piccolo[2])
            {
                dx = 0;
                x += 53;
                y += -8;
                p1 = piccolo[9];
            }
        }
        
        if (key == KeyEvent.VK_3)
        {
            dx = 0;
            if(p1 == piccolo[1] || p1 == piccolo[3])
            {
                y += 13;
                p1 = piccolo[5];
            }
            else if (p1 == piccolo[0] || p1 == piccolo[2])
            {
                x += 6;
                y += 15;
                p1 = piccolo[4];
            }
        }
    }
    
    public void keyReleased(KeyEvent e) 
    {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A)
        {
                dx = 0;
                p1 = piccolo[1];
        }
    
        if (key == KeyEvent.VK_D)
        {
                dx = 0;
                p1 = piccolo[0];
        }
        
        if (key == KeyEvent.VK_W)
        {
            dy = 0;
            if(p1 == piccolo[7])
            {
                p1 = piccolo[1];
            }
            else if (p1 == piccolo[6])
            {
                p1 = piccolo[0];
            }
        }
        
        if (key == KeyEvent.VK_S)
        {
            dy = 0;
            if(p1 == piccolo[7])
            {
                p1 = piccolo[1];
            }
            else if (p1 == piccolo[6])
            {
                p1 = piccolo[0];
            }
        }
        
        if (key == KeyEvent.VK_1)
        {
            if(p1 == piccolo[15])
            {
                x += 28;
                p1 = piccolo[1];
            }
            else if (p1 == piccolo[13])
            {
                x += -2;
                p1 = piccolo[0];
            }
        }
        
        if (key == KeyEvent.VK_2)
        {
            if(p1 == piccolo[11])
            {
                x += 65;
                y += 8;
                p1 = piccolo[1];
            }
            else if (p1 == piccolo[9])
            {
                x += -53;
                y += 8;
                p1 = piccolo[0];
            }
        }
        
        if (key == KeyEvent.VK_3)
        {
            if(p1 == piccolo[5])
            {
                y += -13;
                p1 = piccolo[1];
            }
            else if (p1 == piccolo[4])
            {
                x += -6;
                y += -15;
                p1 = piccolo[0];
            }
        }
    }
	 
}