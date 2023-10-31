import java.util.List;
import javax.swing.*;
import java.awt.*;


public class UI {

    private JPanel mainWindow;
    private Page currentPage;

    public void startup() {
        
        // Set up window
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       

        // Main panel to be direct child of JFrame
        JPanel mainPanel = new JPanel();
        mainWindow = mainPanel;
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(Theme.getPrimaryWindowEmptyBorder());
        mainPanel.setBackground(Theme.getPrimaryBG());
        mainFrame.add(mainPanel);

        // Get the logo and add to mainPanel
        JPanel logo = Theme.getLogo();
        GridBagConstraints logoConstraints = Theme.getLogoConstraints();
        mainPanel.add(logo, logoConstraints);

        // Get the pages from the PageManager
        PageManager pageManager = new PageManager(this);
        List<Page> pages = pageManager.getPagesInMainMenu();

        // Get menu and add to mainPanel
        MainMenu mainMenu = new MainMenu(this, pages);
        mainPanel.add(mainMenu.getMenuPanel(), mainMenu.generateConstraints());

        // Get the welcome page and display it
        mainPanel.add(pageManager.getHomePage().getPagePanel(), pageManager.getHomePage().generateConstraints());
        currentPage = pageManager.getHomePage();


        // These should be called last, lest nothing be visible
        mainFrame.setSize(1200, 720);
        mainFrame.setVisible(true);
        
    }


    public void changeMainPage(Page pageToDisplay) {

        // Called by MainMenu button event handlers to change the page on click

        mainWindow.remove(currentPage.getPagePanel());

        currentPage = pageToDisplay;

        mainWindow.add(
            pageToDisplay.getPagePanel(), 
            pageToDisplay.generateConstraints());
        mainWindow.revalidate();
        mainWindow.repaint();

    }


    public void showAddEmployeePage(Page addEmployeesPage) {

        // Called when the Add Employee button is pushed
        mainWindow.remove(currentPage.getPagePanel());

        currentPage = addEmployeesPage;

        mainWindow.add(
            addEmployeesPage.getPagePanel(), 
            addEmployeesPage.generateConstraints());
        mainWindow.revalidate();
        mainWindow.repaint();
    }

} 
