package MoneyCollector2;

import javax.swing.*;
import java.awt.*;
//John walsh notes
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class PlayMoneyBag extends JFrame
{

    public static void main(String[] args) {



        String decision = "";


         String name = JOptionPane.showInputDialog(null, "Please enter your name:", "Player Registration", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, "Welcome to the Game " + name, "Player", JOptionPane.INFORMATION_MESSAGE);


        decision = JOptionPane.showInputDialog(null, "Please enter a Difficulty \n" +
                "Easy \n" +
                "Normal \n" +
                "Hard", "Difficulty", JOptionPane.INFORMATION_MESSAGE);



        if (decision.equals("Hard") || decision.equals("hard"))
        {
            if(CatchEngine.lives > 0) {
                Money.SPEED = (Money.SPEED + 10);
                MoneyBag.SPEED = (MoneyBag.SPEED + 10);
                playMoney();
            }

        }

        else if (decision.equals("easy") || decision.equals("Easy"))
        {
            Money.SPEED = (Money.SPEED - 5);
            playMoney();

            if(CatchEngine.points >= 5)
            {
                Money.SPEED = (Money.SPEED + 5);
            }
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

        }



    }

    //John Walsh Notes
    //Save data
    public static void saveData() throws IOException {
        ObjectOutputStream os;
        os = new ObjectOutputStream(new FileOutputStream
                ("MoneyCatcher.dat"));
        os.writeObject(CatchEngine.points);
        os.close();
    }

    public static void gameOver()
    {
       JFrame gameOver = new JFrame("Game Over");
       gameOver.setSize(200,200);
       gameOver.setResizable(false);
       gameOver.setVisible(true);
       gameOver.setLocationRelativeTo(null);
       gameOver.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public static void playMoney()
    {
    //new PlayMoneyBag();
    JFrame MoneyBagFrame = new JFrame("MoneyBag");
    //https://docs.oracle.com/javase/tutorial/uiswing/components/icon.html
    JLabel img = new JLabel(new ImageIcon("bground3.jpg"));
    MoneyBagFrame.add(img);
    //MoneyBagFrame.setBackground(new ImageIcon("fallingMoney.png"));
    MoneyBagFrame.add(new CatchComponent());
    MoneyBagFrame.setSize(270, 300);
    MoneyBagFrame.setResizable(false);
    //MoneyBagFrame.add(new CatchComponent());
    //MoneyBagFrame.pack();
    MoneyBagFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    MoneyBagFrame.setLocationRelativeTo(null);

    MoneyBagFrame.setVisible(true);
    MoneyBagFrame.add(img);
    }


    }