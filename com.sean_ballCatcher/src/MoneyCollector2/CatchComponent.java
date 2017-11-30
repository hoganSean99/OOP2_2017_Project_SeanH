package MoneyCollector2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CatchComponent extends JComponent implements KeyListener, Runnable
{
    private CatchEngine engine;
    private boolean leftPressed = false;
    private boolean rightPressed = false;

    public CatchComponent()
    {
        super();
        engine = new CatchEngine();
        setPreferredSize(new Dimension(engine.WIDTH, engine.HEIGHT));

        addKeyListener(this);
        Thread run = new Thread(this);
        run.start();
    }

    //TRY: http://www.dummies.com/programming/java/try-statements-in-java/
    public void run()
    {
        while(true)
        {
            try
            {
                //THREAD: https://www.journaldev.com/1020/thread-sleep-java
                Thread.sleep(50);
            }
            catch(Exception ex)
            {
            }
            requestFocus();
            updateState();
            repaint();
        }
    }

    public void paint(Graphics g)
    {
        engine.draw(g);
    }

    public void updateState()
    {
        if(leftPressed)
            engine.moveLeft();
        if(rightPressed)
            engine.moveRight();
        engine.update();
    }

    //KEY PRESSES: https://stackoverflow.com/questions/18037576/how-do-i-check-if-the-user-is-pressing-a-key
    public void keyPressed(KeyEvent ke)
    {
        if(ke.getKeyCode() == KeyEvent.VK_LEFT)
            leftPressed = true;
        else if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
            rightPressed = true;
    }

    //KEY RELEASED: https://www.reddit.com/r/learnprogramming/comments/3s0x14/java_keypressed_and_keyreleased_not_performing_as/
    public void keyReleased(KeyEvent ke)
    {
        if(ke.getKeyCode() == KeyEvent.VK_LEFT)
            leftPressed = false;
        else if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
            rightPressed = false;
    }

    public void keyTyped(KeyEvent ke)
    {
    }


}
