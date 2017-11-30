package MoneyCollector2;

import java.awt.*;

public class MoneyBag
{
    //Setting the width of the MoneyBag
    public static final int WIDTH = 30;
    //Setting the height of the MoneyBag
    public static final int HEIGHT = 18;
    //Setting the speed of the MoneyBag
    public static int SPEED = 8;

    //x and y axis
    private int x,y;

    //2 argument constructor
    public MoneyBag(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    //Method to allow the MoneyBag to move
    public MoneyBag moveTo(int x, int y)
    {
        return new MoneyBag(x, y);
    }

    public MoneyBag move(int dx, int dy)
    {
        return new MoneyBag(x + dx, y + dy);
    }

    public MoneyBag moveLeft()
    {
        return move( - SPEED, 0);
    }

    public MoneyBag moveRight()
    {
        return move(SPEED, 0);
    }

    public Point getLocation()
    {
        return new Point(x,y);
    }

    public Rectangle getBounds()
    {
        return new Rectangle(x-WIDTH / 2, y - HEIGHT / 2, WIDTH, HEIGHT);
    }

    public boolean contains(Money b)
    {
        return getBounds().contains(b.getBounds());
    }

    //Setting the colour of the MoneyBag
    public void draw(Graphics g)
    {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x - WIDTH / 2, y - HEIGHT / 2, WIDTH, HEIGHT);
    }
}