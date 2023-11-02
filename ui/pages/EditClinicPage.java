package ui.pages;
import javax.swing.*;
import java.awt.event.*;

import app.*;
import ui.*;
import entities.*;

public class EditClinicPage extends ModifyClinicPage {

    private static String pageTitle = "Edit Clinic";

    // Constructors
    public EditClinicPage(UI newUI, ClinicManager newcManager, Clinic clinic) {

        super(newUI, newcManager, clinic, pageTitle);

        pageBodyStrings.add("Use this page to edit an existing clinic.");
        this.setPageBodyStrings(pageBodyStrings);
        this.generateEditClinicPage();
    }

    private void generateEditClinicPage() {

        JPanel thisPage = super.generateModifyClinicPage();

        // Set the form fields based on clinic profile
        nameField.setText(clinic.getName());

        JButton saveButton = new JButton("Save");
        saveButton.setBackground(Theme.getSaveButtonColor());
        saveButton.setFont(Theme.getSaveButtonFont());
        saveButton.addActionListener(new SaveButtonAction());
        
        thisPage.add(saveButton, Layout.getSaveEmployeeButtonConstraints());

    }

    // Event listeners
    class SaveButtonAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            // Update shift requirements

            // Update name
            String name = nameField.getText().strip();
            clinic.setName(name);

            // Save the updates
            cManager.updateClinic(clinic);

            // Tricky syntax because the UI is stored in the Page superclass
            EditClinicPage.this.getUI().displayClinicsPage();
        }
    }
    


}
