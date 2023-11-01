package ui.pages;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.text.BadLocationException;

import app.UI;
import ui.*;

public class HomePage extends Page {
    
    // Configure page contents
    public HomePage(UI newUI) {
        super(newUI);

        List<String> pageBodyStrings = new ArrayList<String>();
        pageBodyStrings.add("Use the menu at the top of the screen to complete tasks.");
        pageBodyStrings.add("For help, visit the Help page.");
        this.setPageTitle("Welcome to the Employee Scheduler app.");
        this.setPageBodyStrings(pageBodyStrings);

        this.generateHomePage();

    }

    private JPanel generateHomePage() {

        JPanel thisPage = super.generatePage();

        
        JPanel versionUpdates = new JPanel();
        versionUpdates.setLayout(new GridBagLayout());
        versionUpdates.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        versionUpdates.setBackground(Theme.getPrimaryBG());

        JLabel vUpdatesTitle = new JLabel("Version 1.0.0 Beta 1");
        vUpdatesTitle.setFont(Theme.getTableSectionTitleFont());
        versionUpdates.add(vUpdatesTitle, Layout.getVersionUpdatesTitleLabelConstraints());

        JTextPane updates = new JTextPane();
        updates.setBackground(Theme.getPrimaryBG());
        updates.setFont(Theme.getPageBodyFont());
        String updateS1 = "Beta release for Employee Scheduler app.";
        try {
            // Add each update here
            updates.getStyledDocument().insertString(0, updateS1, null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        

        versionUpdates.add(updates, Layout.getVersionUpdatesBodyPanelConstraints());
        thisPage.add(versionUpdates, Layout.getHomePageVersionUpdatesPanelConstraints());


        return thisPage;
    }

}
