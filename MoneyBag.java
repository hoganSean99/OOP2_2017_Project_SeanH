package MoneyCollector2;

import java.awt.*;

public class MoneyBag
{
    public static final int WIDTH = 30; //Setting the width of the MoneyBag
    public static final int HEIGHT = 18; //Setting the height of the MoneyBag
    public static final int SPEED = 8; //Setting the speed of the MoneyBag

    private int x,y; //x and y axis

    public MoneyBag(int x, int y) //2 argument constructor
    {
        this.x = x;
        this.y = y;
    }

    public MoneyBag moveTo(int x, int y) //Method to allow the MoneyBag to move
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

    public void draw(Graphics g)
    {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x - WIDTH / 2, y - HEIGHT / 2, WIDTH, HEIGHT);
    }
}