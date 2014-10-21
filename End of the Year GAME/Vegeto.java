import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
 
public class Vegeto 
{
    int x, dx, y, dy;
    Image p1;
    private Image[] vegeto = new Image[16];
    private int[] vegetoRB = new int[16];
    private int[] vegetoLB = new int[16];
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
    
    public Vegeto() 
    {
        ImageIcon a = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeto/Vegeto_stand(r).png");
        ImageIcon b = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeto/Vegeto_stand(l).png");
        ImageIcon c = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeto/Vegeto_run(r).png");
        ImageIcon d = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeto/Vegeto_run(l).png");
        ImageIcon e = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeto/Vegeto_guard(r).png");
        ImageIcon f = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeto/Vegeto_guard(l).png");
        ImageIcon g = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeto/Vegeto_jump(r).png");
        ImageIcon h = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeto/Vegeto_jump(l).png");
        ImageIcon j = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeto/Vegeto_kick(r).png");
        ImageIcon l = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeto/Vegeto_kick(l).png");
        ImageIcon n = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeto/Vegeto_punch(r).png");
        ImageIcon p = new ImageIcon("F:/Documents/My End of the Year Game/Sprites/Vegeto/Vegeto_punch(l).png");
        
        vegeto[0] = a.getImage();
        vegeto[1] = b.getImage();
        vegeto[2] = c.getImage();
        vegeto[3] = d.getImage();
        vegeto[4] = e.getImage();
        vegeto[5] = f.getImage();
        vegeto[6] = g.getImage();
        vegeto[7] = h.getImage();
        vegeto[9] = j.getImage();
        vegeto[11] = l.getImage();
        vegeto[13] = n.getImage();
        vegeto[15] = p.getImage();
        
        vegetoRB[0] = getIconWidth(a);
        vegetoRB[1] = getIconWidth(b);
        vegetoRB[2] = getIconWidth(c);
        vegetoRB[3] = getIconWidth(d);
        vegetoRB[4] = getIconWidth(e);
        vegetoRB[5] = getIconWidth(f);
        vegetoRB[6] = getIconWidth(g);
        vegetoRB[7] = getIconWidth(h);
        vegetoRB[9] = getIconWidth(j);
        vegetoRB[11] = getIconWidth(l);
        vegetoRB[13] = getIconWidth(n);
        vegetoRB[15] = getIconWidth(p);
        
        vegetoLB[0] = getIconHeight(a);
        vegetoLB[1] = getIconHeight(b);
        vegetoLB[2] = getIconHeight(c);
        vegetoLB[3] = getIconHeight(d);
        vegetoLB[4] = getIconHeight(e);
        vegetoLB[5] = getIconHeight(f);
        vegetoLB[6] = getIconHeight(g);
        vegetoLB[7] = getIconHeight(h);
        vegetoLB[9] = getIconHeight(j);
        vegetoLB[11] = getIconHeight(l);
        vegetoLB[13] = getIconHeight(n);
        vegetoLB[15] = getIconHeight(p);
        
        p1 = vegeto[1];
        dx = 0;
        dy = 0;
        x = 800;
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
        if(p1 == vegeto[13] || p1 == vegeto[15])
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
            if(p1 == vegeto[i])
            {
                p1num = i;
            }
        }
        return p1num;
    }
    
    public boolean isBlocking() 
    {
        if(p1 == vegeto[4] || p1 == vegeto[5])
            return true;
        else
            return false;
    }
    
    public boolean isAttackingR() 
    {
        if(p1 == vegeto[9] ||  p1 == vegeto[13])
            return true;
        else
            return false;
    }
    
    public boolean isAttackingL() 
    {
        if(p1 == vegeto[11] || p1 == vegeto[15])
            return true;
        else
            return false;
    }
    
    public int rightBound()
    {
        int rB = x;
        rB += vegetoRB[getP1Num(p1)];
        return rB;
    }
    
    public int lowerBound()
    {
        int lB = y;
        lB += vegetoLB[getP1Num(p1)];
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
                p1 = vegeto[6];
            }
            else if(jumpLeft)
            {
                p1 = vegeto[7];
            }
            else if(runRight)
            {
                p1 = vegeto[2];
            }
            else if(runLeft)
            {
                p1 = vegeto[3];
            }
            else if(facingRight)
            {
                p1 = vegeto[0];
            }
            else if (facingLeft)
            {
                p1 = vegeto[1];
            }
            
            if(punchRight)
            {
                p1 = vegeto[13];
            }
            else if (punchLeft)
            {
                p1 = vegeto[15];
            }
            if(kickRight)
            {
                p1 = vegeto[9];
            }
            else if (kickLeft)
            {
                p1 = vegeto[11];
            }
            if(guardRight)
            {
                p1 = vegeto[4];
            }
            else if (guardLeft)
            {
                p1 = vegeto[5];
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
                p1 = vegeto[6];
            }
            else if(jumpLeft)
            {
                p1 = vegeto[7];
            }
             if(runRight)
            {
                p1 = vegeto[2];
            }
            else if(runLeft)
            {
                p1 = vegeto[3];
            }
            else if(facingRight)
            {
                p1 = vegeto[0];
            }
            else if (facingLeft)
            {
                p1 = vegeto[1];
            }
            
            if(punchRight)
            {
                p1 = vegeto[13];
            }
            else if (punchLeft)
            {
                p1 = vegeto[15];
            }
            if(kickRight)
            {
                p1 = vegeto[9];
            }
            else if (kickLeft)
            {
                p1 = vegeto[11];
            }
            if(guardRight)
            {
                p1 = vegeto[4];
            }
            else if (guardLeft)
            {
                p1 = vegeto[5];
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
                p1 = vegeto[0];
            }
            else if(jumpLeft)
            {
                p1 = vegeto[1];
            }
            else if(runRight)
            {
                p1 = vegeto[2];
            }
            else if(runLeft)
            {
                p1 = vegeto[3];
            }
            else if(facingRight)
            {
                p1 = vegeto[0];
            }
            else if (facingLeft)
            {
                p1 = vegeto[1];
            }
            
            if(punchRight)
            {
                p1 = vegeto[13];
            }
            else if (punchLeft)
            {
                p1 = vegeto[15];
            }
            if(kickRight)
            {
                p1 = vegeto[9];
            }
            else if (kickLeft)
            {
                p1 = vegeto[11];
            }
            if(guardRight)
            {
                p1 = vegeto[4];
            }
            else if (guardLeft)
            {
                p1 = vegeto[5];
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
        if (key == KeyEvent.VK_LEFT)
        {        
                dx = -5;
                p1 = vegeto[3];
                runRight = false;
                runLeft = true;
                facingRight = false;
                facingLeft = true;
                
                if (onPlatform == false)
                    dy = 5;
        }       
    
        if (key == KeyEvent.VK_RIGHT)
        {
                dx = 5;
                p1 = vegeto[2];
                runRight = true;
                runLeft = false;
                facingRight = true;
                facingLeft = false;
                
                if (onPlatform == false)
                    dy = 5;
        }
        
        if (key == KeyEvent.VK_UP)
        {        
            if(onPlatform == true){
                    dy = -20;
                
                if(facingRight == true && facingLeft == false)
                {
                    jumpRight = true;
                    jumpLeft = false;
                    p1 = vegeto[6];
                }
                
                if(facingRight == false && facingLeft == true)
                {
                    jumpRight = false;
                    jumpLeft = true;
                    p1 = vegeto[7];
                }
            }
        }
        
        if (key == KeyEvent.VK_COMMA)
        {
            if(p1 == vegeto[1] || p1 == vegeto[3])
            {
                dx = 0;
                y += 16;
                x += -28;
                p1 = vegeto[15];
                punchRight = false;
                punchLeft = true;
            }

            else if (p1 == vegeto[0] || p1 == vegeto[2])
            {
                dx = 0;
                y += 16;
                x += 2;
                p1 = vegeto[13];
                punchRight = true;
                punchLeft = false;
            }
        }
        
        if (key == KeyEvent.VK_PERIOD)
        {
            if(p1 == vegeto[1] || p1 == vegeto[3])
            {
                dx = 0;
                x += -25;
                y += -8;
                p1 = vegeto[11];
                kickRight = false;
                kickLeft = true;
            }
            else if (p1 == vegeto[0] || p1 == vegeto[2])
            {
                dx = 0;
                x += 10;
                y += -8;
                p1 = vegeto[9];
                kickRight = true;
                kickLeft = false;
            }
        }
        
        if (key == KeyEvent.VK_SLASH)
        {
            if(p1 == vegeto[1] || p1 == vegeto[3])
            {
                dx = 0;
                y += 18;
                x += 8;
                p1 = vegeto[5];
                guardRight = false;
                guardLeft = true;
            }
            else if (p1 == vegeto[0] || p1 == vegeto[2])
            {
                dx = 0;
                x += -12;
                y += 20;
                p1 = vegeto[4];
                guardRight = true;
                guardLeft = false;
            }
        }
    }
    
    public void keyReleased(KeyEvent e) 
    {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT)
        {
                dx = 0;
                p1 = vegeto[1];
                runLeft = false;
                
                if (onPlatform == false)
                    dy = 5;
        }
    
        if (key == KeyEvent.VK_RIGHT)
        {
                dx = 0;
                p1 = vegeto[0];
                runRight = false;
                
                if (onPlatform == false)
                    dy = 5;
        }
        
        if (key == KeyEvent.VK_UP)
        {
            if(onPlatform == false){
                    dy = 5;
                
                if(facingRight == true && facingLeft == false)
                {
                    p1 = vegeto[6];
                }
                
                if(facingRight == false && facingLeft == true)
                {
                    p1 = vegeto[7];
                }
            }
        }
        
        if (key == KeyEvent.VK_COMMA)
        {
            if (p1 == vegeto[15])
            {
                x += 28;
                y += -16;
                p1 = vegeto[1];
                punchLeft = false;
            }

            else if (p1 == vegeto[13])
            {
                x += -2;
                y += -16;
                p1 = vegeto[0];
                punchRight = false;
            }
        }
        
        if (key == KeyEvent.VK_PERIOD)
        {
            if(p1 == vegeto[11])
            {
                x += -4;
                y += 8;
                p1 = vegeto[1];
                kickLeft = false;
            }
            else if (p1 == vegeto[9])
            {
                x += 16;
                y += 8;
                p1 = vegeto[0];
                kickRight = false;
            }
        }
        
        if (key == KeyEvent.VK_SLASH)
        {
            if(p1 == vegeto[5])
            {
                y += -18;
                x += -8;
                p1 = vegeto[1];
                guardLeft = false;
            }
            else if (p1 == vegeto[4])
            {
                y += -20;
                x += 12;
                p1 = vegeto[0];
                guardRight = false;
            }
        }
    }
	 
}