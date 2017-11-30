package MoneyCollector2;

import java.awt.*;

public class MoneyBag
{
    public static final int WIDTH = 30;
    public static final int HEIGHT = 18;
    public static final int SPEED = 8;

    private int x,y;

    public MoneyBag(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

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

    public void draw(Graphics g)
    {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x - WIDTH / 2, y - HEIGHT / 2, WIDTH, HEIGHT);
    }
}