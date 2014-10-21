import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
 
public class Vegeta2
{
    int x, dx, y, dy;
    Image p1;
    private Image[] vegeta = new Image[16];
    private int[] vegetaRB = new int[16];
    private int[] vegetaLB = new int[16];
    private int punchPower;
    private int kickPower;
    private boolean facingRight;
    private boolean facingLeft;
    private boolean runRight;
    private boolean runLeft;
    private boolean guardRight;
    private boolean guardLeft;
    private boolean jumpRight;
    private boolean jumpLeft;
    private boolean kickRight;
    private boolean kickLeft;
    private boolean punchRight;
    private boolean punchLeft;
    private boolean onPlatform; 
    
    private int oTopX;
    private int oBottomY;
    private boolean oLeft;
    private boolean oBottom;
    
    public Vegeta2() 
    {
        ImageIcon a = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeta 2/Vegeta_stand(r).png");
        ImageIcon b = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeta 2/Vegeta_stand(l).png");
        ImageIcon c = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeta 2/Vegeta_run(r).png");
        ImageIcon d = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeta 2/Vegeta_run(l).png");
        ImageIcon e = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeta 2/Vegeta_guard(r).png");
        ImageIcon f = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeta 2/Vegeta_guard(l).png");
        ImageIcon g = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeta 2/Vegeta_jump(r).png");
        ImageIcon h = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeta 2/Vegeta_jump(l).png");
        ImageIcon j = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeta 2/Vegeta_kick(r).png");
        ImageIcon l = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeta 2/Vegeta_kick(l).png");
        ImageIcon n = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeta 2/Vegeta_punch(r).png");
        ImageIcon p = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeta 2/Vegeta_punch(l).png");
        
        vegeta[0] = a.getImage();
        vegeta[1] = b.getImage();
        vegeta[2] = c.getImage();
        vegeta[3] = d.getImage();
        vegeta[4] = e.getImage();
        vegeta[5] = f.getImage();
        vegeta[6] = g.getImage();
        vegeta[7] = h.getImage();
        vegeta[9] = j.getImage();
        vegeta[11] = l.getImage();
        vegeta[13] = n.getImage();
        vegeta[15] = p.getImage();
        
        vegetaRB[0] = getIconWidth(a);
        vegetaRB[1] = getIconWidth(b);
        vegetaRB[2] = getIconWidth(c);
        vegetaRB[3] = getIconWidth(d);
        vegetaRB[4] = getIconWidth(e);
        vegetaRB[5] = getIconWidth(f);
        vegetaRB[6] = getIconWidth(g);
        vegetaRB[7] = getIconWidth(h);
        vegetaRB[9] = getIconWidth(j);
        vegetaRB[11] = getIconWidth(l);
        vegetaRB[13] = getIconWidth(n);
        vegetaRB[15] = getIconWidth(p);
        
        vegetaLB[0] = getIconHeight(a);
        vegetaLB[1] = getIconHeight(b);
        vegetaLB[2] = getIconHeight(c);
        vegetaLB[3] = getIconHeight(d);
        vegetaLB[4] = getIconHeight(e);
        vegetaLB[5] = getIconHeight(f);
        vegetaLB[6] = getIconHeight(g);
        vegetaLB[7] = getIconHeight(h);
        vegetaLB[9] = getIconHeight(j);
        vegetaLB[11] = getIconHeight(l);
        vegetaLB[13] = getIconHeight(n);
        vegetaLB[15] = getIconHeight(p);
        
        p1 = vegeta[0];
        dx = 0;
        dy = 0;
        x = 350;
        y = 400;
        
        punchPower = (int)((Math.random() * 100) / 10);
        kickPower = (int)((Math.random() * 100) / 10);
        
        facingRight = true;
        facingLeft = false;
        runRight = false;
        runLeft = false;
        guardRight = false;
        guardLeft = false;
        jumpRight = false;
        jumpLeft = false;
        kickRight = false;
        kickLeft = false;
        punchRight = false;
        punchLeft = false;
        
        onPlatform = false;
    }
    
    public void setLocation(int lx, int ly)
    {
        x = lx;
        y = ly;
    }
    
    public int getAttackPower()
    {
        if(p1 == vegeta[13] || p1 == vegeta[15])
        {
            return punchPower;
        }
        else
        {
            return kickPower;
        }
    }
    
    public int getIconWidth(Icon icon) 
    {
        return icon.getIconWidth();
    }
    
    public int getIconHeight(Icon icon) 
    {
        return icon.getIconHeight();
    }
    
    public int getP1Num(Image pImg)
    {
        int p1num = 0;
        for(int i = 0; i <= 15; i++)
        {
            if(p1 == vegeta[i])
            {
                p1num = i;
            }
        }
        return p1num;
    }
    
    public boolean isBlocking() 
    {
        if(p1 == vegeta[4] || p1 == vegeta[5])
            return true;
        else
            return false;
    }
    
    public boolean isAttackingR() 
    {
        if(p1 == vegeta[9] ||  p1 == vegeta[13])
            return true;
        else
            return false;
    }
    
    public boolean isAttackingL() 
    {
        if(p1 == vegeta[11] || p1 == vegeta[15])
            return true;
        else
            return false;
    }
    
    public int rightBound()
    {
        int rB = x;
        rB += vegetaRB[getP1Num(p1)];
        return rB;
    }
    
    public int lowerBound()
    {
        int lB = y;
        lB += vegetaLB[getP1Num(p1)];
        return lB;
    }
        
    
    public void move(int topX, int bottomY, boolean left, boolean bottom) 
    {
        x = x + dx;
        y = y + dy;
        
        oTopX = topX;
        oBottomY = bottomY;
        oLeft = left;
        oBottom = bottom;
        
            
            if(jumpRight)
            {
                p1 = vegeta[6];
            }
            else if(jumpLeft)
            {
                p1 = vegeta[7];
            }
            else if(runRight)
            {
                p1 = vegeta[2];
            }
            else if(runLeft)
            {
                p1 = vegeta[3];
            }
            else if(facingRight)
            {
                p1 = vegeta[0];
            }
            else if (facingLeft)
            {
                p1 = vegeta[1];
            }
            
            if(punchRight)
            {
                p1 = vegeta[13];
            }
            else if (punchLeft)
            {
                p1 = vegeta[15];
            }
            if(kickRight)
            {
                p1 = vegeta[9];
            }
            else if (kickLeft)
            {
                p1 = vegeta[11];
            }
            if(guardRight)
            {
                p1 = vegeta[4];
            }
            else if (guardLeft)
            {
                p1 = vegeta[5];
            }
            
            if(jumpLeft && runRight)
            {
                jumpLeft = false;
                jumpRight = true;
            }
            else if(jumpRight && runLeft)
            {
                jumpLeft = true;
                jumpRight = false;
            }

        if(lowerBound() >= 100 && lowerBound() <= 125 && rightBound() >= topX && getX() <= (topX + 200) && dy >= 0)
        {
            onPlatform = true;
            dy = 0;
            
            if(jumpRight)
            {
                p1 = vegeta[6];
            }
            else if(jumpLeft)
            {
                p1 = vegeta[7];
            }
             if(runRight)
            {
                p1 = vegeta[2];
            }
            else if(runLeft)
            {
                p1 = vegeta[3];
            }
            else if(facingRight)
            {
                p1 = vegeta[0];
            }
            else if (facingLeft)
            {
                p1 = vegeta[1];
            }
            
            if(punchRight)
            {
                p1 = vegeta[13];
            }
            else if (punchLeft)
            {
                p1 = vegeta[15];
            }
            if(kickRight)
            {
                p1 = vegeta[9];
            }
            else if (kickLeft)
            {
                p1 = vegeta[11];
            }
            if(guardRight)
            {
                p1 = vegeta[4];
            }
            else if (guardLeft)
            {
                p1 = vegeta[5];
            }
            
            if(jumpLeft && runRight)
            {
                jumpLeft = false;
                jumpRight = true;
            }
            else if(jumpRight && runLeft)
            {
                jumpLeft = true;
                jumpRight = false;
            }

            if(left)
            {
                x += 1;
            }
            else
            {
                x += -1;
            }
        }
        if(lowerBound() >= bottomY && lowerBound() <= (bottomY + 25) && rightBound() >= 50 && getX() <= 250 && dy >= 0)
        {
            onPlatform = true;
            dy = 0;
            
            if(jumpRight)
            {
                p1 = vegeta[0];
            }
            else if(jumpLeft)
            {
                p1 = vegeta[1];
            }
            else if(runRight)
            {
                p1 = vegeta[2];
            }
            else if(runLeft)
            {
                p1 = vegeta[3];
            }
            else if(facingRight)
            {
                p1 = vegeta[0];
            }
            else if (facingLeft)
            {
                p1 = vegeta[1];
            }
            
            if(punchRight)
            {
                p1 = vegeta[13];
            }
            else if (punchLeft)
            {
                p1 = vegeta[15];
            }
            if(kickRight)
            {
                p1 = vegeta[9];
            }
            else if (kickLeft)
            {
                p1 = vegeta[11];
            }
            if(guardRight)
            {
                p1 = vegeta[4];
            }
            else if (guardLeft)
            {
                p1 = vegeta[5];
            }
            
            if(jumpLeft && runRight)
            {
                jumpLeft = false;
                jumpRight = true;
            }
            else if(jumpRight && runLeft)
            {
                jumpLeft = true;
                jumpRight = false;
            }

            if(bottom)
            {
                y -= 1;
            }
            else
            {
                y += 1;
            }
        }
        
        if(rightBound() >= 300 && x <= 500 && lowerBound() >= 300 && lowerBound() <= 350 && dy >= 0){
            onPlatform = true;
            dy = 0;
           
        }
        
        else if(rightBound() >= 50 && x <= 250 && lowerBound() >= 200 && lowerBound() <= 250 && dy >= 0){
        
           onPlatform = true;
           dy = 0;
           
        }
        
        else if(rightBound() >= 500 && x <= 700 && lowerBound() >= 200 && lowerBound() <= 250 && dy >= 0){
        
           onPlatform = true;
           dy = 0;
           
        }
        
        else if(rightBound() >= 600 && x <= 1000 && lowerBound() >= 400 && lowerBound() <= 450 && dy >= 0){
        
           onPlatform = true;
           dy = 0;
           
        }
        
        else if(rightBound() >= 300 && x <= 500 && lowerBound() >= 475 && lowerBound() <= 525 && dy >= 0){
        
           onPlatform = true;
           dy = 0;
           
        }
        
        else if(rightBound() >= 750 && x <= 1100 && lowerBound() >= 650 && lowerBound() <= 700 && dy >= 0){
        
           onPlatform = true;
           dy = 0;
           
        }
        
        else if(rightBound() >= 800 && x <= 1000 && lowerBound() >= 200 && lowerBound() <= 250 && dy >= 0){
        
           onPlatform = true;
           dy = 0;
           
        }
        
        else if(rightBound() >= 700 && x <= 900 && lowerBound() >= 500 && lowerBound() <= 550 && dy >= 0){
        
           onPlatform = true;
           dy = 0;
           
        }
        
        else if(rightBound() >= 300 && x <= 500 && lowerBound() >= 600 && lowerBound() <= 650 && dy >= 0){
        
           onPlatform = true;
           dy = 0;
           
        }
        
        else if(rightBound() >= 800 && x <= 1000 && lowerBound() >= 400 && lowerBound() <= 450 && dy >= 0){
        
           onPlatform = true;
           dy = 0;
           
        }
        
        else{
           onPlatform = false;
        } 
        
        if(onPlatform)
        {
            if(facingRight)
                jumpRight = false;
            else if(facingLeft)
                jumpLeft = false;
        }

    
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
                p1 = vegeta[3];
                runRight = false;
                runLeft = true;
                facingRight = false;
                facingLeft = true;
                
                if (onPlatform == false)
                    dy = 5;
        }       
    
        if (key == KeyEvent.VK_D)
        {
                dx = 5;
                p1 = vegeta[2];
                runRight = true;
                runLeft = false;
                facingRight = true;
                facingLeft = false;
                
                if (onPlatform == false)
                    dy = 5;
        }
        
        if (key == KeyEvent.VK_W)
        {        
            if(onPlatform == true){
                    dy = -20;
                
                if(facingRight == true && facingLeft == false)
                {
                    jumpRight = true;
                    jumpLeft = false;
                    p1 = vegeta[6];
                }
                
                if(facingRight == false && facingLeft == true)
                {
                    jumpRight = false;
                    jumpLeft = true;
                    p1 = vegeta[7];
                }
            }
        }
        
        if (key == KeyEvent.VK_3)
        {
            if(p1 == vegeta[1] || p1 == vegeta[3])
            {
                dx = 0;
                y += 5;
                p1 = vegeta[5];
                guardRight = false;
                guardLeft = true;
            }
            else if (p1 == vegeta[0] || p1 == vegeta[2])
            {
                dx = 0;
                x += 5;
                y += 5;
                p1 = vegeta[4];
                guardRight = true;
                guardLeft = false;
            }
        }
        
        if (key == KeyEvent.VK_2)
        {
            if(p1 == vegeta[1] || p1 == vegeta[3])
            {
                dx = 0;
                x += -10;
                y += 1;
                p1 = vegeta[11];
                kickRight = false;
                kickLeft = true;
            }
            else if (p1 == vegeta[0] || p1 == vegeta[2])
            {
                dx = 0;
                x += -5;
                y += 1;
                p1 = vegeta[9];
                kickRight = true;
                kickLeft = false;
            }
        }
        
        if (key == KeyEvent.VK_1)
        {
            if(p1 == vegeta[1] || p1 == vegeta[3])
            {
                dx = 0;
                y += 8;
                x += -18;
                p1 = vegeta[15];
                punchRight = false;
                punchLeft = true;
            }

            else if (p1 == vegeta[0] || p1 == vegeta[2])
            {
                dx = 0;
                y += 8;
                x += 10;
                p1 = vegeta[13];
                punchRight = true;
                punchLeft = false;
            }
        }
    }
    
    public void keyReleased(KeyEvent e) 
    {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A)
        {
                dx = 0;
                p1 = vegeta[1];
                runLeft = false;
                
                if (onPlatform == false)
                    dy = 5;
        }
    
        if (key == KeyEvent.VK_D)
        {
                dx = 0;
                p1 = vegeta[0];
                runRight = false;
                
                if (onPlatform == false)
                    dy = 5;
        }
        
        if (key == KeyEvent.VK_W)
        {
            if(onPlatform == false){
                    dy = 5;
                
                if(facingRight == true && facingLeft == false)
                {
                    p1 = vegeta[6];
                }
                
                if(facingRight == false && facingLeft == true)
                {
                    p1 = vegeta[7];
                }
            }
        }

        if (key == KeyEvent.VK_3)
        {
            if(p1 == vegeta[5])
            {
                y += -5;
                p1 = vegeta[1];
                guardLeft = false;
            }
            else if (p1 == vegeta[4])
            {
                y += -5;
                x += -5;
                p1 = vegeta[0];
                guardRight = false;
            }
        }
        
        if (key == KeyEvent.VK_2)
        {
            if(p1 == vegeta[11])
            {
                x += 10;
                y += -1;
                p1 = vegeta[1];
                kickLeft = false;
            }
            else if (p1 == vegeta[9])
            {
                x += 5;
                y += -1;
                p1 = vegeta[0];
                kickRight = false;
            }
        }
        
        if (key == KeyEvent.VK_1)
        {
            if (p1 == vegeta[15])
            {
                x += 18;
                y += -8;
                p1 = vegeta[1];
                punchLeft = false;
            }

            else if (p1 == vegeta[13])
            {
                x += -10;
                y += -8;
                p1 = vegeta[0];
                punchRight = false;
            }
        }
    }
     
}