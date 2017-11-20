package MoneyCollector2;

import javax.swing.*;
import java.awt.*;

public class Money
{

    public static final Color MONEY = (Color.GREEN); //Creating the money Variable to the colour Green
    public static final Color BOMB = (Color.BLACK); //Creating the Bomb Variable to the colour Black
    public static  int randomRadius = 5; //Creating the radius variable
    //public static final int MIN = 1;
    //public static final int MAX = 50;
    public static final int SPEED = 10; //Creating the speed of the falling objects

    private boolean money; //Creating a Boolean Variable to check weather the object caught in the MoneyBag is a Bomb or Money
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



    public Money moveTo(int x, int y)
    {
        return new Money(x,y,money);
    }

    public Money move(int downX, int downY)
    {
        return new Money(x + downX, y + downY, money);
    }

    public Money moveDown()
    {
        return move(0, SPEED);
    }

    public Point getLocation()
    {
        return new Point(x, y);
    }

    public Rectangle getBounds()
    {
        return new Rectangle(x - randomRadius, y - randomRadius, randomRadius * 2, randomRadius * 2);
    }

    public boolean isGood() //A Method to check if the object caught is Money or a Bom
    {
        return money;
    }

    //randomRadius(int MIN, int MAX)
    //{
    //    int radius = (MAX - MIN) + 1;
    //    return (int)(Math.random() * radius) + MIN;
   // }

    public void draw(Graphics g)
    {
        g.setColor( money ? MONEY : BOMB); //https://stackoverflow.com/questions/12006170/what-does-mean-in-java
        g.fillOval(x - randomRadius, y - randomRadius, randomRadius * 2, randomRadius * 2);
    }
}
