package MoneyCollector2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CatchComponent extends JComponent implements KeyListener, Runnable
{
    private CatchEngine game;
    //https://stackoverflow.com/questions/18173083/keylistener-and-boolean-not-working
    private boolean leftPressed = false;
    private boolean rightPressed = false;

    public CatchComponent()
    {
       /* super();*/
        game = new CatchEngine();
        //i learnt what the set preferred size function did in the referenced website
        //http://www.java2s.com/Code/JavaAPI/javax.swing/JPanelsetPreferredSizeDimensionpreferredSize.htm
        setPreferredSize(new Dimension(game.WIDTH, game.HEIGHT));

        //https://stackoverflow.com/questions/24110034/trying-to-move-object-with-keylistener-in-simple-game
        addKeyListener(this);
        //I learnt what threading did in the referenced website
        //It allows 2 or more processes to execute at the same time
        //THREAD: https://www.journaldev.com/1020/thread-sleep-java
        Thread run = new Thread(this);
        run.start();
    }

    //I learnt what the try-catch statement was in the referenced website
    //TRY: http://www.dummies.com/programming/java/try-statements-in-java/
    //https://codereview.stackexchange.com/questions/73959/multiple-random-falling-objects-animation-in-java
    public void run()
    {
        while(true)
        {
            try
            {
                //Referencing my threading to allow 2 or more processes to execute at the same time
                //THREAD: https://www.journaldev.com/1020/thread-sleep-java
                Thread.sleep(50);
            }
            catch(Exception ex)
            {
            }
            //I Learnt what the method requestFocus() does in the referenced
            /*The moneyBag would not move and i could not understand why so when i included
            requestFocus() method the moneyBag was able to move when the keys were pressed*/
            //https://stackoverflow.com/questions/22386477/how-does-addnotify-and-requestfocus-work-in-java-with-jpanel
            requestFocus();
            updateState();
            repaint();
        }
    }

    //Drawing the objects onto the game
    public void paint(Graphics g)
    {
        game.draw(g);
    }

    //I learnt i needed an update method from this website: https://stackoverflow.com/questions/40024878/keylistener-and-game-thread
    // https://stackoverflow.com/questions/24110034/trying-to-move-object-with-keylistener-in-simple-game
    public void updateState()
    {
        if(leftPressed)
            game.moveLeft();
        if(rightPressed)
            game.moveRight();
        game.update();
    }

    //This code is allowing the moneyBag to mve while the key is being pressed
    //https://stackoverflow.com/questions/24110034/trying-to-move-object-with-keylistener-in-simple-game
    //KEY PRESSES: https://stackoverflow.com/questions/18037576/how-do-i-check-if-the-user-is-pressing-a-key
    public void keyPressed(KeyEvent ke)
    {
        if(ke.getKeyCode() == KeyEvent.VK_LEFT)
            leftPressed = true;
        else if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
            rightPressed = true;
    }

    //This code is stopping the moneyBag from moving when the key is released
    //https://stackoverflow.com/questions/24110034/trying-to-move-object-with-keylistener-in-simple-game
    //KEY RELEASED: https://www.reddit.com/r/learnprogramming/comments/3s0x14/java_keypressed_and_keyreleased_not_performing_as/
    public void keyReleased(KeyEvent ke)
    {
        if(ke.getKeyCode() == KeyEvent.VK_LEFT)
            leftPressed = false;
        else if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
            rightPressed = false;
    }

    //The keyTyped checks if the key is just typed
    //https://stackoverflow.com/questions/24110034/trying-to-move-object-with-keylistener-in-simple-game
    public void keyTyped(KeyEvent ke)
    {
    }


}
