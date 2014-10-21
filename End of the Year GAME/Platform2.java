import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Platform2 extends JPanel implements ActionListener 
{
    Vegeta2 p1;
    Vegeto p2;
    Timer time;
    
    private boolean gameOver = false;
    
    private int p1Lives;
    private int p2Lives;
    private int p1Health;
    private int p2Health;
    
    private boolean left = true;
    private boolean bottom = true;
    
    private int topX = 50;
    private int topY = 100;
    private int bottomX = 50;
    private int bottomY = 400;

    public Platform2() 
    {
        p1 = new Vegeta2();
        p2 = new Vegeto();
        addKeyListener(new AL());
        setFocusable(true);
        
        p1Lives = 3;
        p2Lives = 3;
        p1Health = 100;
        p2Health = 100;
        
        time = new Timer(5, this);
        time.start();
    }

    public void actionPerformed(ActionEvent e) 
    {
        if(gameOver == false)
        {    
            runBoard();
            p1.move(topX, bottomY, left, bottom);
            p2.move(topX, bottomY, left, bottom);
            collision();
            gameScore();
        }
        if(gameOver == true)
        {
            String input = JOptionPane.showInputDialog("Do you want to play again? (y/n)");
            if(input.equals("y"))
            {
                gameOver = false;
                topX = 50;
                topY = 100;
                bottomX = 50;
                bottomY = 400;
                p1Lives = 3;
                p2Lives = 3;
                p1Health = 100;
                p2Health = 100;
                
                p1 = new Vegeta2();
                p2 = new Vegeto();
            }
            else
            {
                time.stop();
            }
        }
        repaint();
    }
    
    public void collision()
    {
        if(p1.isAttackingR() && p2.isBlocking() == false)
        {
            if(p1.rightBound() >= p2.getX() && p1.rightBound() <= p2.rightBound() && p1.getY() >= (p2.getY() - 5) && p1.lowerBound() <= (p2.lowerBound() + 5))
            {
                p2Health -= p1.getAttackPower();
            }
        }
        if(p2.isAttackingR() && p1.isBlocking() == false)
        {
            if(p2.rightBound() >= p1.getX() && p2.rightBound() <= p1.rightBound() && p2.getY() >= (p1.getY() - 25) && p2.lowerBound() <= (p1.lowerBound() + 25))
            {
                p1Health -= p2.getAttackPower();
            }
        }
        if(p1.isAttackingL() && p2.isBlocking() == false)
        {
            if(p1.getX() <= p2.rightBound() && p1.getX() >= p2.getX() && p1.getY() >= (p2.getY() - 5) && p1.lowerBound() <= (p2.lowerBound() + 5))
            {
                p2Health -= p1.getAttackPower();
            }
        }
        if(p2.isAttackingL() && p1.isBlocking() == false)
        {
            if(p2.getX() <= p1.rightBound() && p2.getX() >= p1.getX() && p2.getY() >= (p1.getY() - 25) && p2.lowerBound() <= (p1.lowerBound() + 25))
            {
                p1Health -= p2.getAttackPower();
            }
        }
    }
    
    public void gameScore()
    {
        if(p1Health <= 0)
        {
            p1Health = 100;
            p1Lives -= 1;
            p1.setLocation(350, 400);
        }
        if(p2Health <= 0)
        {
            p2Health = 100;
            p2Lives -= 1;
            p2.setLocation(800, 400);
        }
        if(p1Lives <= 0 || p2Lives <= 0)
        {
            gameOver = true;
        }
        if(p1.lowerBound() >= 740)
        {
            p1Health = 100;
            p1Lives += -1;
            p1.setLocation(350, 400);
        }
        if(p2.lowerBound() >= 740)
        {
            p2Health = 100;
            p2Lives += -1;
            p2.setLocation(800, 400);
        }
    }
    
    public void runBoard() 
    {
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
    }

    public void paint(Graphics g) 
    {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(Color.BLUE);
        g2.drawString("Player 1 Lives: " + p1Lives, 200, 15);
        g2.drawString("Player 2 Lives: " + p2Lives, 900, 15);
        g2.drawString("Player 1 Health: " + p1Health + "           |||||           Player 2 Health: " + p2Health, 425, 15);
        
        if(gameOver)
        {
            g2.drawString("GAME OVER", 400, 400);
        }

        Rectangle top = new Rectangle(topX, topY, 200, 25);
        Rectangle bottomR = new Rectangle(bottomX, bottomY, 200, 25);

        g2.setColor(Color.GREEN);
        g2.fill(top);
        g2.fill(bottomR);
        
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
        g2.drawImage(p2.getImage(), p2.getX(), p2.getY(), null);
    }

    private class AL extends KeyAdapter 
    {
        public void keyReleased(KeyEvent e) 
        {
            if(gameOver == false)
            {
                p1.keyReleased(e);
                p2.keyReleased(e);
            }
        }
    
        public void keyPressed(KeyEvent e) 
        {
            if(gameOver == false)
            {
                p1.keyPressed(e);
                p2.keyPressed(e);
            }
        }
    }
}
