package MoneyCollector2;

import javax.swing.*;
import java.awt.*;


public class PlayMoneyBag extends JFrame
{

   // public PlayMoneyBag()
   // {

    //}
    public static void main(String[] args) {


        String decision = "";


        JOptionPane.showInputDialog(null, "Please enter your name:", "Player Registration", JOptionPane.INFORMATION_MESSAGE);
        decision = JOptionPane.showInputDialog(null, "Please enter a Difficulty \n" +
                "Easy \n" +
                "Normal \n" +
                "Hard", "Difficulty", JOptionPane.INFORMATION_MESSAGE);



        if (decision.equals("Hard") || decision.equals("hard"))
        {
            Money.SPEED = (Money.SPEED + 10);
            //MoneyBag.SPEED = (MoneyBag.SPEED + 18);
            playMoney();
        }

        else if (decision.equals("easy") || decision.equals("Easy"))
        {
            Money.SPEED = (Money.SPEED - 5);
            playMoney();
        }

        else if (decision.equals("normal") || decision.equals("Normal"))
        {
            Money.SPEED = (Money.SPEED + 0);
            playMoney();
        }

        else if (!decision.equals("normal") || !decision.equals("Normal") || !decision.equals("easy") || !decision.equals("Easy") || !decision.equals("Hard") || decision.equals("hard")) {
            JOptionPane.showMessageDialog(null, "You did not enter a correct difficulty - \nPlease Re-Enter", "Error", JOptionPane.ERROR_MESSAGE);
            decision = JOptionPane.showInputDialog(null, "Please enter a Difficulty \n" +
                    "Easy \n" +
                    "Normal \n" +
                    "Hard", "Difficulty", JOptionPane.INFORMATION_MESSAGE);

            if (decision.equals("Hard") || decision.equals("hard"))
            {
                Money.SPEED = (Money.SPEED + 10);
                //MoneyBag.SPEED = (MoneyBag.SPEED + 18);
                playMoney();
            }

            else if (decision.equals("easy") || decision.equals("Easy"))
            {
                Money.SPEED = (Money.SPEED - 5);
                playMoney();
            }

            else if (decision.equals("normal") || decision.equals("Normal"))
            {
                Money.SPEED = (Money.SPEED + 0);
                playMoney();
            }

            else if (!decision.equals("normal") || !decision.equals("Normal") || !decision.equals("easy") || !decision.equals("Easy") || !decision.equals("Hard") || decision.equals("hard"))
            {
                JOptionPane.showMessageDialog(null, "You did not enter a correct difficulty - \nExiting System", "Error", JOptionPane.ERROR_MESSAGE);
                decision = JOptionPane.showInputDialog(null, "Please enter a Difficulty \n" +
                        "Easy \n" +
                        "Normal \n" +
                        "Hard", "Difficulty", JOptionPane.INFORMATION_MESSAGE);

                if (decision.equals("Hard") || decision.equals("hard"))
                {
                    Money.SPEED = (Money.SPEED + 10);
                    //MoneyBag.SPEED = (MoneyBag.SPEED + 18);
                    playMoney();
                }

                else if (decision.equals("easy") || decision.equals("Easy"))
                {
                    Money.SPEED = (Money.SPEED - 5);
                    playMoney();

                }

                else if (decision.equals("normal") || decision.equals("Normal"))
                {
                    Money.SPEED = (Money.SPEED + 0);
                    playMoney();
                }

                else if (!decision.equals("normal") || !decision.equals("Normal") || !decision.equals("easy") || !decision.equals("Easy") || !decision.equals("Hard") || decision.equals("hard"))
                {
                    JOptionPane.showMessageDialog(null, "You entered the option incorrectly too many times. \n Exiting the System...", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            }

        }}

    public static void playMoney(){

        String name = "";

    //new PlayMoneyBag();
    JFrame MoneyBagFrame = new JFrame("MoneyBag-" + name);
    //MoneyBagFrame.setBackground(new ImageIcon("fallingMoney.png"));
    MoneyBagFrame.add(new CatchComponent());
    MoneyBagFrame.setSize(270, 300);
    MoneyBagFrame.setResizable(false);
    //MoneyBagFrame.getContentPane().setLayout(new FlowLayout());
    //MoneyBagFrame.add(new CatchComponent());
    //MoneyBagFrame.pack();
    MoneyBagFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    MoneyBagFrame.setLocationRelativeTo(null);
    MoneyBagFrame.setVisible(true);
    //JLabel Background = new JLabel(new ImageIcon("fallingMoney.png"));
    //MoneyBagFrame.add(Background).setVisible(true);
        }


    }