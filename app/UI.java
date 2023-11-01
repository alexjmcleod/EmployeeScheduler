package app;

import javax.swing.*;

import ui.*;
import ui.pages.*;
import entities.*;

import java.awt.*;


public class UI {

    private JPanel mainWindow;
    private Page currentPage;
    private EmployeeManager employeeManager;

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


        // Get menu and add to mainPanel
        MainMenu mainMenu = new MainMenu(this);
        mainPanel.add(mainMenu.getMenuPanel(), mainMenu.generateConstraints());


        // Get the welcome page and display it
        currentPage = new HomePage(this);
        mainPanel.add(currentPage.getPagePanel(), currentPage.getConstraints());


        // These should be called last, lest nothing be visible
        mainFrame.setSize(1200, 800);
        mainFrame.setMinimumSize(new Dimension(1200, 800));
        mainFrame.setVisible(true);


        // Populate Employees list
        employeeManager = new EmployeeManager();

        
    }
    

    // Methods to update display
    private void displayNewPage(Page page) {

        mainWindow.remove(currentPage.getPagePanel());

        currentPage = page;
        mainWindow.add(currentPage.getPagePanel(), currentPage.getConstraints());

        mainWindow.revalidate();
        mainWindow.repaint();

    }

    public void displayHomePage() {
        this.displayNewPage(new HomePage(this));
    }

    public void displayGeneratePage() {
        this.displayNewPage(new GeneratePage(this));
    }

    public void displaySchedulesPage() {
        this.displayNewPage(new SchedulesPage(this));
    }

    public void displayClinicsPage() {
        this.displayNewPage(new ClinicsPage(this));
    }

    public void displayEmployeesPage() {
        this.displayNewPage(new EmployeesPage(this, employeeManager));
    }

    public void displayShiftRulesPage() {
        this.displayNewPage(new ShiftRulesPage(this));
    }

    public void displayHelpPage() {
        this.displayNewPage(new HelpPage(this));
    }

    public void displayAddEmployeePage() {
        this.displayNewPage(new AddEmployeePage(this, employeeManager));
    }

    public void displayEditEmployeePage(Employee employee) {
        this.displayNewPage(new EditEmployeePage(this, employeeManager, employee));
    }



} 
