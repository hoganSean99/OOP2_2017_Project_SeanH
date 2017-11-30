package MoneyCollector2;

import java.awt.*;
import java.util.*;

public class CatchEngine
{
    public static final int WIDTH = 250;
    public static final int HEIGHT = 250;

    public static final int MIN_MONEY_DELAY = 30;
    public static final int MAX_MONEY_DELAY = 100;
    public static final int SPEED_UP_DELAY = 20;

    private Vector<Money> money;
    private MoneyBag moneybag;
    private int points = 0;
    private int lives = 3;
    private int speedDelay = 0;
    private int addMoneyDelay = MAX_MONEY_DELAY;
    private int moneyDelay = 0;

    public CatchEngine()
    {
        money = new Vector();
        moneybag = new MoneyBag(WIDTH / 2, HEIGHT-MoneyBag.HEIGHT/2);
    }

    public void moveLeft()
    {
        if(lives > 0)
        {
            moneybag = moneybag.moveLeft();
            if(moneybag.getLocation().getX() < -MoneyBag.WIDTH / 2)
                moneybag = moneybag.moveTo(WIDTH + MoneyBag.WIDTH / 2, (int)moneybag.getLocation().getY());
        }
    }

    public void moveRight()
    {
        if(lives > 0)
        {
            moneybag = moneybag.moveRight();
            if(moneybag.getLocation().getX() > WIDTH+MoneyBag.WIDTH / 2)
                moneybag = moneybag.moveTo(-MoneyBag.WIDTH / 2, (int)moneybag.getLocation().getY());
        }
    }

    public void addBall()
    {
        money.add(new Money((int)(Math.random() * WIDTH), 0, Math.random() > .5));
    }

    public void moveBalls()
    {
        for(int i = 0; i < money.size(); i++)
        {
            money.add(i, money.get(i).moveDown());
            money.remove(i + 1);
        }
    }

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
            else if(money.get(i).getLocation().getY() >= HEIGHT+Money.randomRadius)
            {
                if(money.get(i).isGood())
                    lives--;
                money.remove(i);
                i--;
            }
        }
    }

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

    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawString("Points: " + points, 10, 20);
        g.drawString("Lives: " + lives, 10, 30);
        if(lives <= 0)
        {
            g.setColor(Color.RED);
            g.drawString("You Lose", WIDTH/2-20, HEIGHT/2);
        }
        for(int i = 0; i < money.size(); i++)
            money.get(i).draw(g);

        moneybag.draw(g);
    }
}
