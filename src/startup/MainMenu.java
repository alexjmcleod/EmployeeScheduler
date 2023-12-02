package startup;
import java.awt.*;
import javax.swing.*;

import ui.Theme;

import java.awt.event.*;

public class MainMenu {

    // List<String> menuItems = new ArrayList<String>(Arrays.asList(
    //     "Generate",
    //     "Schedules",
    //     "Clinics",
    //     "Employees",
    //     "Shift Rules",
    //     "Help"
    // ));

    UI ui;
    JPanel menuPanel;

    public MainMenu(UI newUI) {
        // This is the UI that call MainMenu and 
        // whose pages are changed when a menu button is clicked
        ui = newUI;
        menuPanel = this.generateMenu();
    }


    public JPanel generateMenu() {
        
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridBagLayout());
        menuPanel.setBackground(Theme.getPrimaryBG());

        // Button constraints
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.insets = new Insets(0, 0, 0, 10);
        buttonConstraints.ipadx = 20;
        buttonConstraints.ipady = 20;

        // Home button
        JButton homeButton = this.generateMenuButton("Home");
        menuPanel.add(homeButton, buttonConstraints);
        homeButton.addActionListener(new displayHomeAction());

        // Generate page
        JButton generateButton = this.generateMenuButton("Generate");
        menuPanel.add(generateButton, buttonConstraints);
        generateButton.addActionListener(new displayGenerateAction());

        // Schedules page
        JButton schedulesButton = this.generateMenuButton("Schedules");
        menuPanel.add(schedulesButton, buttonConstraints);
        schedulesButton.addActionListener(new displaySchedulesAction());

        // Clinics page
        JButton clinicsButton = this.generateMenuButton("Clinics");
        menuPanel.add(clinicsButton, buttonConstraints);
        clinicsButton.addActionListener(new displayClinicsAction());

        // Employees page
        JButton employeesButton = this.generateMenuButton("Employees");
        menuPanel.add(employeesButton, buttonConstraints);
        employeesButton.addActionListener(new displayEmployeesAction());


        // Shift Rules page
        JButton shiftRulesButton = this.generateMenuButton("Shift Rules");
        menuPanel.add(shiftRulesButton, buttonConstraints);
        shiftRulesButton.addActionListener(new shiftRulesAction());


        // Help page
        JButton helpButton = this.generateMenuButton("Help");
        menuPanel.add(helpButton, buttonConstraints);
        helpButton.addActionListener(new displayHelpAction());
        
        return menuPanel;
    };

    private JButton generateMenuButton(String buttonLabel) {
        JButton button = new JButton(buttonLabel);
        button.setBackground(Theme.getMenuButtonBG());
        button.setFont(Theme.getMenuButtonFont());

        return button;
    }


    public GridBagConstraints generateConstraints() {
        
        GridBagConstraints menuConstraints = new GridBagConstraints();
        menuConstraints.weightx = 0;
        menuConstraints.weighty = 0;
        menuConstraints.gridx = 3;
        menuConstraints.gridy = 0;
        menuConstraints.gridwidth = 9;
        menuConstraints.gridheight = 1;
        menuConstraints.anchor = GridBagConstraints.FIRST_LINE_END;

        return menuConstraints;
    }


    // Getters n setters
    public JPanel getMenuPanel() {
        return menuPanel;
    }


    // Event handlers

    class displayHomeAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ui.displayHomePage();
        }
    }

    class displayGenerateAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ui.displayGeneratePage();
        }
    }

    class displaySchedulesAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ui.displaySchedulesPage();
        }
    }

    class displayClinicsAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ui.displayClinicsPage();
        }
    }

    class displayEmployeesAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ui.displayEmployeesPage();
        }
    }

    class shiftRulesAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ui.displayShiftRulesPage();
        }
    }

    class displayHelpAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ui.displayHelpPage();
        }
    }




    // Event handlers

    // class ChangePage implements ActionListener {

    //     Page pageToDisplay;

    //     public ChangePage() {
            
    //     }

    //     public ChangePage(Page page) {
    //         pageToDisplay = page;
    //     }

    //     // public void actionPerformed(ActionEvent event) {
    //     //     // System.out.println(pageToSet.getPageTitle());
    //     //     ui.changeMainPage(pageToDisplay);
    //     // }   

    // }

}
