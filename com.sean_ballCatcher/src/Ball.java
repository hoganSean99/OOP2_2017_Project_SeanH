import java.awt.*;

public class Ball
{
    private int x;
    private int y;
    private int radius;
    private Color colour;

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getRadius()
    {
        return radius;
    }

    public void setRadius(int radius)
    {
        this.radius = radius;
    }

    public Color getColour()
    {
        return colour;
    }

    public void setColour(Color colour)
    {
        this.colour = colour;
    }

    public Ball()
    {
        //setX(30);
        //setY(30);
        int r = (int)(Math.random( )*256);
        int g = (int)(Math.random( )*256);
        int b = (int)(Math.random( )*256);

        Color randomColor = new Color(r, g, b);

        setColour(randomColor);
        setRadius((int)(Math.random()*50));
        setX((int)(Math.random()*440+25));
        setY((int)(Math.random()*440+25));
    }



    public void drawBall(Graphics g) {
        //super.paint(g);
        //int radius = 20;
        //int radius = (int)(Math.random()*50);
        //int x = (int)Math.random()*440;
        //int y = (int)Math.random()*440;

        g.setColor(getColour());
        g.fillOval(getX(), getY(), getRadius(), getRadius());
        //g.fillOval(50,50,25,25);
        System.out.println(getX() + " " + getY() + " " + radius);

    }
     	
     	/*public Dimension getPreferredSize(){
     	
     		return new Dimension(50,50);
     	}*/
}
 