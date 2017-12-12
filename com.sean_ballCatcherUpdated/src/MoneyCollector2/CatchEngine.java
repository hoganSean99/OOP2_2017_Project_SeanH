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
    //https://stackoverflow.com/questions/7141445/get-or-elementat-in-java
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
    //This code is allowing the moneyBag to mve while the key is being pressed
    //https://stackoverflow.com/questions/24110034/trying-to-move-object-with-keylistener-in-simple-game
    //KEY PRESSES: https://stackoverflow.com/questions/18037576/how-do-i-check-if-the-user-is-pressing-a-key
    public void moveLeft()
    {
        if(lives > 0)
        {
            moneybag = moneybag.moveLeft();
        }
    }

    //If the lives are greater than 0 it allows the moneyBag move right
    //This code is allowing the moneyBag to mve while the key is being pressed
    //https://stackoverflow.com/questions/24110034/trying-to-move-object-with-keylistener-in-simple-game
    //KEY PRESSES: https://stackoverflow.com/questions/18037576/how-do-i-check-if-the-user-is-pressing-a-key
    public void moveRight()
    {
        if(lives > 0)
        {
            moneybag = moneybag.moveRight();
        }
    }


    //Adding a new ball on the y axis at a random position on the x axis
    //https://stackoverflow.com/questions/32911947/i-would-like-the-balls-to-know-that-theyre-inside-a-rectangle-in-a-jpanel
    public void addBall()
    {
        money.add(new Money((int)(Math.random() * WIDTH), 0, Math.random() > .5));
    }

    //This is allowing the balls to move
    public void moveBalls()
    {
        //https://stackoverflow.com/questions/30170735/how-to-move-my-bullet-slowly-in-java
        for(int i = 0; i < money.size(); i++)
        {
            //https://stackoverflow.com/questions/30170735/how-to-move-my-bullet-slowly-in-java
            money.add(i, money.get(i).moveDown());
            money.remove(i + 1);
        }
    }

    //Method to check if the ball caught is green or black
    //https://stackoverflow.com/questions/22948234/checking-classes-with-if-statement-in-java
    //https://stackoverflow.com/questions/15172367/ifnull-check-else-vs-try-catchnullpointerexception-which-is-more-efficient
    public void testBallCatch()
    {
        for(int i = 0; i < money.size(); i++)
        {
            //https://stackoverflow.com/questions/18852059/java-list-containsobject-with-field-value-equal-to-x
            if(moneybag.contains(money.get(i)))
            {
                if(money.get(i).isGood())
                    points++;
                else
                    lives--;
                money.remove(i);
                i--;
            }
            //this is checking if the good balls are not caught and if not to minus lives
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
    //https://answers.unity.com/questions/829566/how-to-make-objects-falling-down-from-the-top-of-t.html
    public void update()
    {
        //https://stackoverflow.com/questions/8062123/how-to-apply-gravity-when-an-object-fall
        //https://www.reddit.com/r/codereview/comments/2phnzn/java_simple_random_falling_object_animation/
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
        //http://www.java2s.com/Code/Java/2D-Graphics-GUI/Drawstring.htm
        g.setColor(Color.BLACK);
        g.drawString("Points: " + points, 10, 20);
        g.drawString("Lives: " + lives, 10, 30);
        if(lives == 0)
        {
            System.exit(0);
            PlayMoneyBag.gameOver();
        }

        //drawing the money objects and moneybag to the screen
        //https://stackoverflow.com/questions/30170735/how-to-move-my-bullet-slowly-in-java
        for(int i = 0; i < money.size(); i++)
            money.get(i).draw(g);

        moneybag.draw(g);
    }
}
