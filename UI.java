import javax.swing.*;
import java.awt.*;
import pages.*;
import javax.swing.border.Border;

public class UI {

    int mainWindowPadding = 25;

    public void startup() {
        
        // Set up window
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BoxLayout(mainFrame, BoxLayout.Y_AXIS));

        JPanel mainWindow = new JPanel();
        mainFrame.setContentPane(mainWindow);
        mainWindow.setLayout(new BoxLayout(mainWindow, BoxLayout.Y_AXIS));
        // TODO: add color settings (and mainWindowPadding?) to a separate UISettings class
        Color mainBg = new Color(250, 248, 237);
        mainWindow.setBackground(mainBg);
        
        // Add padding
        Border padding = BorderFactory.createEmptyBorder(mainWindowPadding, mainWindowPadding, mainWindowPadding, mainWindowPadding);
        mainWindow.setBorder(padding);

        
        // Get menu and add to North of mainWindow
        JPanel menuPanel = new MainMenu().generateMenu();
        mainWindow.add(menuPanel);

        // Generate pages
        // Welcome
        Page welcome = new Page(
            "Welcome to the Employee Scheduler app.",
            "Use the menu at the top of the screen to complete tasks.\n\nFor help, visit the Help page."
        );
        mainWindow.add(welcome.generatePage());



        // These should be called last, lest nothing be visible
        mainFrame.setSize(1080, 720);
        mainFrame.setVisible(true);

        
        
    }


}
