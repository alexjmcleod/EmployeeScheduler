import javax.swing.*;
import java.awt.*;
import pages.*;
import javax.swing.border.EmptyBorder;

public class UI {

    public void startup() {

        Color mainBg = new Color(250, 248, 237);
        int windowPadding = 25;
        
        // Set up window
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        //mainFrame.setLayout(new GridBagLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(new EmptyBorder(windowPadding, windowPadding, windowPadding, windowPadding));

        // GridBagConstraints mainPanelConstraints = new GridBagConstraints();
        // mainPanelConstraints.weightx = 100;
        // mainPanelConstraints.weighty = 100;
        // mainPanelConstraints.gridx = 0;
        // mainPanelConstraints.gridy = 0;
        // mainPanelConstraints.gridwidth = 1;
        // mainPanelConstraints.gridheight = 1;

        mainPanel.setBackground(mainBg);
        mainFrame.add(mainPanel);

        
        // Get menu and add to mainPanel
        JPanel mainMenu = new MainMenu().generateMenu();
        GridBagConstraints menuConstraints = new GridBagConstraints();
        menuConstraints.weightx = 0;
        menuConstraints.weighty = 0;
        menuConstraints.gridx = 3;
        menuConstraints.gridy = 0;
        menuConstraints.gridwidth = 9;
        menuConstraints.gridheight = 1;
        menuConstraints.anchor = GridBagConstraints.NORTHEAST;
        mainPanel.add(mainMenu, menuConstraints);


        // Get the welcome page and display it
        Page welcome = new Page(
            "Welcome to the Employee Scheduler app.\n\n",
             "Use the buttons...");
        
        GridBagConstraints pageConstraints = new GridBagConstraints();
        pageConstraints.weightx = 100;
        pageConstraints.weighty = 100;
        pageConstraints.gridx = 0;
        pageConstraints.gridy = 1;
        pageConstraints.gridwidth = 12;
        pageConstraints.gridheight = 11;
        pageConstraints.insets = new Insets(35, 25, 50, 50);
        pageConstraints.anchor = GridBagConstraints.NORTHWEST;
        
        mainPanel.add(welcome.generatePage(), pageConstraints);





        // These should be called last, lest nothing be visible
        mainFrame.setSize(1080, 720);
        mainFrame.setVisible(true);

        
        
    }


}