package MoneyCollector2;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class CatchEngine
{
    //Setting the width
    public static final int WIDTH = 250;
    //Setting the height
    public static final int HEIGHT = 250;

    //Setting the min Money Delay
    public static final int MIN_MONEY_DELAY = 30;
    //Setting the Max Money Delay
    public static final int MAX_MONEY_DELAY = 100;
    //Setting the speed up Delay
    public static final int SPEED_UP_DELAY = 20;


    //VECTORS: https://docs.oracle.com/javase/7/docs/api/java/util/Vector.html
    //VECTORS; http://www.geeksforgeeks.org/java-util-vector-class-java/
    private Vector<Money> money;
    private MoneyBag moneybag;
    //Setting Points as 0
    public static int points = 0;
    //Setting lives as 3
    public static int lives = 3;
    //setting speedDelay as 0
    private int speedDelay = 0;
    //Letting addMoneyDelay = MAX_MONEY_DELAY
    private int addMoneyDelay = MAX_MONEY_DELAY;
    //Setting moneyDelay as 0
    private int moneyDelay = 0;

    public CatchEngine()
    {
        //Creating a new vector
        //VECTORS: https://docs.oracle.com/javase/7/docs/api/java/util/Vector.html
        //VECTORS; http://www.geeksforgeeks.org/java-util-vector-class-java/
        money = new Vector();
        moneybag = new MoneyBag(WIDTH / 2, HEIGHT - MoneyBag.HEIGHT/2);
    }

    //If lives are greater than 0 it allows the moneyBag to move left
    public void moveLeft()
    {
        if(lives > 0)
        {
            moneybag = moneybag.moveLeft();
            if(moneybag.getLocation().getX() < - MoneyBag.WIDTH / 2)
                moneybag = moneybag.moveTo(WIDTH + MoneyBag.WIDTH / 2, (int)moneybag.getLocation().getY());
        }
    }

    //If the lives are greater than 0 it allows the moneyBag move right
    public void moveRight()
    {
        if(lives > 0)
        {
            moneybag = moneybag.moveRight();
            if(moneybag.getLocation().getX() > WIDTH+MoneyBag.WIDTH / 2)
                moneybag = moneybag.moveTo(- MoneyBag.WIDTH / 2, (int)moneybag.getLocation().getY());
        }
    }

    //CAdding a new ball on the y axis at a random position on the x axis
    public void addBall()
    {
        money.add(new Money((int)(Math.random() * WIDTH), 0, Math.random() > .5));
    }

    //This is allowing the balls to move
    public void moveBalls()
    {
        for(int i = 0; i < money.size(); i++)
        {
            money.add(i, money.get(i).moveDown());
            money.remove(i + 1);
        }
    }

    //Method tyo check if the ball caught is green or black
    public void testBallCatch()
    {
        for(int i = 0; i < money.size(); i++)
        {
            if(moneybag.contains(money.get(i)))
            {
                if(money.get(i).isGood())
                    points++;
                else
                    lives--;
                money.remove(i);
                i--;
            }
            else if(money.get(i).getLocation().getY() >= HEIGHT + Money.randomRadius)
            {
                if(money.get(i).isGood())
                    lives--;
                money.remove(i);
                i--;
            }
        }
    }


    //UPDATE METHOD; http://ecomputernotes.com/java/awt-and-applets/update-method
    public void update()
    {

        if(lives > 0)
        {
            moneyDelay++;
            speedDelay++;
            if(moneyDelay >= addMoneyDelay)
            {
                moneyDelay = 0;
                addBall();
            }
            if(speedDelay >= SPEED_UP_DELAY)
            {
                speedDelay = 0;
                addMoneyDelay--;
                if(addMoneyDelay < MIN_MONEY_DELAY)
                    addMoneyDelay = MIN_MONEY_DELAY;
            }
            moveBalls();
            testBallCatch();
        }
    }

    //Drawing the points and lives to the screen
    //https://introcs.cs.princeton.edu/java/stdlib/Draw.java.html
    //https://docs.oracle.com/javase/tutorial/2d/geometry/primitives.html
    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawString("Points: " + points, 10, 20);
        g.drawString("Lives: " + lives, 10, 30);
        if(lives == 0)
        {
            System.exit(0);
            PlayMoneyBag.gameOver();
        }

        for(int i = 0; i < money.size(); i++)
            money.get(i).draw(g);

        moneybag.draw(g);
    }
}
