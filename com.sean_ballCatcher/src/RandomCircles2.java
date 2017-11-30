import java.awt.*;
import javax.swing.*;


public class RandomCircles2 extends JFrame{

    public static void main(String args[])

    {
        RandomCircles2 rc = new RandomCircles2();

        rc.getContentPane().setBackground(Color.BLACK);// sets background color of JFrame to black

        rc.setSize(500,500);

        rc.setVisible(true);
    }



    public void paint(Graphics gr)
    {
        super.paint(gr);

        for(int i=1;i<=10;i++)
        {
            Ball ball = new Ball();
            ball.drawBall(gr);
        }
    }
}