package MoneyCollector2;

import javax.swing.*;
import java.awt.*;

/** Money Objects*/
public class Money
{
    /**Creating the money Variable to the colour Green*/
    public static final Color MONEY = (Color.GREEN);
    /**Creating the Bomb Variable to the colour Black*/
    public static final Color BOMB = (Color.BLACK);
    /**Creating the radius variable*/
    public static  int randomRadius = 5;
    //public static final int MIN = 1;
    //public static final int MAX = 50;
    //**Creating the speed of the falling objects*/
    public static  int SPEED = 10;

    /**Creating a Boolean Variable to check weather the object caught in the MoneyBag is a Bomb or Money*/
    private boolean money;
    private int x,y;


    public Money(int x, int y)
    {
        this.x = x;
        this.y = y;
        money = true;
    }

    public Money(int x, int y, boolean good)
    {
        this.x = x;
        this.y = y;
        this.money = good;
    }

    /**Getters*/
    public static Color getMONEY() {
        return MONEY;
    }

    public static Color getBOMB() {
        return BOMB;
    }

    public static int getRandomRadius() {
        return randomRadius;
    }

    public static int getSpeed() {
        return SPEED;
    }


    /**Moving the object*/
    public Money moveTo(int x, int y)
    {
        return new Money(x,y,money);
    }

    /**Method to allow the money to move*/
    public Money move(int downX, int downY)
    {
        return new Money(x + downX, y + downY, money);
    }

    /**Method to make the money fall*/
    public Money moveDown()
    {
        return move(0, SPEED);
    }


    /**Getting the location, http://www.javadocexamples.com/java/awt/Component/getLocation().html*/
    public Point getLocation()
    {
        return new Point(x, y);
    }

    /**Settong the Bounds for the MoneyBag, https://stackoverflow.com/questions/23332096/how-to-detect-if-two-images-collide-in-java*/
    public Rectangle getBounds()
    {
        return new Rectangle(x - randomRadius, y - randomRadius, randomRadius * 2, randomRadius * 2);
    }
    /**A Method to check if the object caught is Money or a Bomb*/
    public boolean isGood()
    {
        return money;
    }

    public void changeSpeed()
    {

    }

    /**Setting the color of the shapes*/
    public void draw(Graphics g)
    {
        /**https://stackoverflow.com/questions/12006170/what-does-mean-in-java*/
        g.setColor( money ? MONEY : BOMB);
        g.fillOval(x - randomRadius, y - randomRadius, randomRadius * 2, randomRadius * 2);
    }
}
