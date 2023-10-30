import java.util.List;
import java.awt.*;
import javax.swing.*;
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

    public MainMenu(UI newUI, List<Page> menuPages) {
        // This is the UI that call MainMenu and 
        // whose pages are changed when a menu button is clicked
        ui = newUI;
        menuPanel = this.generateMenu(menuPages);
    }


    public JPanel generateMenu(List<Page> menuPages) {
        
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridBagLayout());
        
        menuPanel.setBackground(Theme.getPrimaryBG());

        for (Page page : menuPages) {

            String label = page.getPageMenuLabel();

            JButton button = new JButton(label);
            button.setBackground(Theme.getMenuButtonBG());
            button.setFont(Theme.getMenuButtonFont());

            GridBagConstraints buttonConstraints = new GridBagConstraints();
            buttonConstraints.insets = new Insets(0, 0, 0, 10);
            buttonConstraints.ipadx = 20;
            buttonConstraints.ipady = 20;
        
            menuPanel.add(button, buttonConstraints);

            button.addActionListener(new ChangePage(page));


        }
        return menuPanel;
    };


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

    class ChangePage implements ActionListener {

        Page pageToDisplay;

        public ChangePage() {
            
        }

        public ChangePage(Page page) {
            pageToDisplay = page;
        }

        public void actionPerformed(ActionEvent event) {
            // System.out.println(pageToSet.getPageTitle());
            ui.changeMainPage(pageToDisplay);
        }   

    }

}
