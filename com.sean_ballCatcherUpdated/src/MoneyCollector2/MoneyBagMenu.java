package MoneyCollector2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
//john walsh notes
import java.io.IOException;

// Extends from JFrame class
public class MoneyBagMenu extends JFrame /*implements ActionListener*/ {
    public static void main(String args[]) {

        //This JFrame is the Main Menu
        //JFrame
        JFrame MainMenuFrame = new JFrame("Main Menu");
        MainMenuFrame.setSize(600, 600);
        MainMenuFrame.setResizable(false);
        MainMenuFrame.setLocationRelativeTo(null); //Center JFrame in the middle
        //MainMenuFrame.revalidate();

        //JPanel
        JPanel MainMenuPanel = new JPanel();
        //John Brosnan
        MainMenuPanel.setPreferredSize(new Dimension(600,600));
        //MainMenuFrame.setContentPane(MainMenuPanel);

        //I learnt how to implement an image into the background using the website referenced below
        //https://docs.oracle.com/javase/tutorial/uiswing/components/icon.html
        //Background Image
        ImageIcon i = new ImageIcon("bground1.jpg");

        //JLabel
        JLabel l = new JLabel();
        l.setIcon(i);
        l.setVisible(true);

        MainMenuPanel.setLayout(new BorderLayout());
        MainMenuPanel.add(l,BorderLayout.NORTH);


        //I used John Walsh Notes to learn how to create a menu bar
        //Creating the Menu Bar
        JMenuBar menuBar = new JMenuBar();

        //Create a menu
        JMenu menu = new JMenu("Instructions");
        menuBar.add(menu);

        //I used John Walsh Notes to learn how to create a menu Item for the menu bar
        //Create a menu item
        JMenuItem item = new JMenuItem(new AbstractAction("How To Play") {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null,"Control the Money Basket using the Left and Right arrow Keys\n" +
                        "Catch as many coins (GREEN) as you can\n" +
                        "Avoid the Bombs (BLACK) at all cost\n" +
                        "You have 3 lives and a selection of 3 difficulties\n\n\n" +
                        "HAVE FUN!!!","How To Play",JOptionPane.INFORMATION_MESSAGE);

            }
        });
        menu.add(item);

        JMenu menu2 = new JMenu("Exit");
        menuBar.add(menu2);


        //john walsh notes
        //Create a menu item
        JMenuItem item2 = new JMenuItem(new AbstractAction("Close the Program") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });

        //I used John Walsh Notes to learn how to add a saving feature
        JMenuItem item3 = new JMenuItem(new AbstractAction("Save") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PlayMoneyBag.saveData();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
        menu2.add(item2);
        menu2.add(item3);

        //JButton
        JButton StartGameButton = new JButton("START");


        //Adding
        MainMenuFrame.add(MainMenuPanel);
        MainMenuPanel.add(StartGameButton);
        MainMenuFrame.setVisible(true);



        MainMenuPanel.add(StartGameButton,BorderLayout.SOUTH);
        //john Brosnan
        StartGameButton.setPreferredSize(new Dimension(50, 50));
        StartGameButton.setBackground(Color.YELLOW);

        //This is an action listener when the start button is pressed it will open the PlayMoneyBag.java class
        //John Brosnan helped with the button action listener
        StartGameButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e)
            {
                MainMenuFrame.setVisible(false);
                PlayMoneyBag.main(null);
            }
        });

        //joh walsh notes
        // putting the menu bar in the frame
        MainMenuFrame.setJMenuBar(menuBar);

        //john brosnan
        MainMenuFrame.pack();

        MainMenuPanel.setVisible(true);

        StartGameButton.setVisible(true);

        menuBar.setVisible(true);
        menu.setVisible(true);
        MainMenuFrame.validate();


    }
}
