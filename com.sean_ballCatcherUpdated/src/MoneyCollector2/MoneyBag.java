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
    //https://codereview.stackexchange.com/questions/73959/multiple-random-falling-objects-animation-in-java
    //https://www.programcreek.com/java-api-examples/index.php?class=java.awt.geom.GeneralPath&method=moveTo
    public MoneyBag moveTo(int x, int y)
    {
        return new MoneyBag(x, y);
    }

    //https://codereview.stackexchange.com/questions/73959/multiple-random-falling-objects-animation-in-java
    public MoneyBag move(int dx, int dy)
    {
        return new MoneyBag(x + dx, y + dy);
    }

    //https://www.java-forums.org/java-applets/39591-moving-ball-arrow-keys.html
    public MoneyBag moveLeft()
    {
        return move( - SPEED, 0);
    }

    //https://www.java-forums.org/java-applets/39591-moving-ball-arrow-keys.html
    public MoneyBag moveRight()
    {
        return move(SPEED, 0);
    }

    /**Getting the location, http://www.javadocexamples.com/java/awt/Component/getLocation().html*/
    public Point getLocation()
    {
        return new Point(x,y);
    }

    /**Setting the Bounds for the MoneyBag, https://stackoverflow.com/questions/23332096/how-to-detect-if-two-images-collide-in-java*/
    public Rectangle getBounds()
    {
        return new Rectangle(x-WIDTH / 2, y - HEIGHT / 2, WIDTH, HEIGHT);
    }

    //https://www.tutorialspoint.com/java/lang/string_contains.htm
    public boolean contains(Money b)
    {
        return getBounds().contains(b.getBounds());
    }

    //Setting the colour of the MoneyBag
    //https://codereview.stackexchange.com/questions/73959/multiple-random-falling-objects-animation-in-java
    public void draw(Graphics g)
    {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x - WIDTH / 2, y - HEIGHT / 2, WIDTH, HEIGHT);
    }
}