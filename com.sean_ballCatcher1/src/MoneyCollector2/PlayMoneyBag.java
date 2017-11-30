package MoneyCollector2;

import javax.swing.*;
import java.awt.*;


public class PlayMoneyBag extends JFrame
{
   // public PlayMoneyBag()
   // {

    //}

    public static void main(String[] args)
    {
        //new PlayMoneyBag();
        JFrame MoneyBagFrame = new JFrame("MONEY BAG");
        //MoneyBagFrame.setBackground(new ImageIcon("fallingMoney.png"));
        MoneyBagFrame.add(new CatchComponent());
        MoneyBagFrame.setSize(600, 500);
        MoneyBagFrame.setResizable(false);
        //MoneyBagFrame.getContentPane().setLayout(new FlowLayout());
        //MoneyBagFrame.add(new CatchComponent());
        //MoneyBagFrame.pack();
        MoneyBagFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        MoneyBagFrame.setLocationRelativeTo(null);
        MoneyBagFrame.setVisible(true);
        JLabel Background = new JLabel(new ImageIcon("fallingMoney.png"));
        MoneyBagFrame.add(Background).setVisible(true);


    }
}