package MoneyCollector2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MoneyBagMenu extends JFrame /*implements ActionListener*/ {
    public static void main(String args[]) {
        //JFrame
        JFrame MainMenuFrame = new JFrame("Main Menu");
        MainMenuFrame.setSize(600, 600);
        MainMenuFrame.setLocationRelativeTo(null); //Center JFrame in the middle
        //MainMenuFrame.revalidate();

        //JPanel
        JPanel MainMenuPanel = new JPanel();
        MainMenuPanel.setBackground(Color.GRAY);
        //MainMenuPanel.setVisible(true);

        //JButton
        JButton StartGameButton = new JButton("START");
        StartGameButton.setVisible(true);

        //Adding
        MainMenuFrame.add(MainMenuPanel);
        MainMenuPanel.add(StartGameButton);
        MainMenuFrame.setVisible(true);

    }
}
