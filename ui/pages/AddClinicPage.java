package ui.pages;

import javax.swing.*;
import java.awt.event.*;

import app.*;
import ui.*;
import entities.*;

public class AddClinicPage extends ModifyClinicPage {

    private static String pageTitle = "Add a New Clinic";

    // Constructors
    public AddClinicPage(UI newUI, ClinicManager newcManager) {
        super(newUI, newcManager, new Clinic(), pageTitle);

        pageBodyStrings.add("Use this page to add a new clinic.");
        
        this.setPageBodyStrings(pageBodyStrings);
        this.generateAddClinicPage();
    }

    private void generateAddClinicPage() {

        JPanel thisPage = super.generateModifyClinicPage();

        JButton saveButton = new JButton("Save");
        saveButton.setBackground(Theme.getSaveButtonColor());
        saveButton.setFont(Theme.getSaveButtonFont());
        saveButton.addActionListener(new SaveButtonAction());

        thisPage.add(saveButton, Layout.getSaveClinicButtonConstraints());

    }

    // Event listeners
    class SaveButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            // Update shift requirements
            // TODO: continue modeling this page after the employe page

            // clinic.getShiftRequirements().updateShiftRequirements();

            // Get form fields
            String name = nameField.getText().strip();
            clinic.setName(name);

            // Save the new clinic
            cManager.saveClinic(clinic);

            // Tricky syntax because the UI is stored in the Page superclass
            AddClinicPage.this.getUI().displayClinicsPage();

        }
    }

    
}
