package ui.pages;

import javax.swing.*;
import java.awt.event.*;

import app.*;
import ui.*;
import entities.*;



public class AddEmployeePage extends ModifyEmployeePage {

    private static String pageTitle = "Add a New Employee";

    // Constructors

    public AddEmployeePage(UI newUI, EmployeeManager neweManager) {
        super(newUI, neweManager, new Employee(), pageTitle);
        
        pageBodyStrings.add("Use this page to add a new employee.");
        
        this.setPageBodyStrings(pageBodyStrings);
        this.generateAddEmployeePage();
    }

    private void generateAddEmployeePage() {

        JPanel thisPage = super.generateModifyEmployeePage();

        JButton saveButton = new JButton("Save");
        saveButton.setBackground(Theme.getSaveButtonColor());
        saveButton.setFont(Theme.getSaveButtonFont());
        saveButton.addActionListener(new SaveButtonAction());
        
        thisPage.add(saveButton, Layout.getSaveEmployeeButtonConstraints());

    }

    // Event listeners
    class SaveButtonAction implements ActionListener {
        
        public void actionPerformed(ActionEvent event) {

            // TODO: add the location preferences to the save
        
            // Update Shift Time Preferences
            employee.getShiftTimePrefs().updateShiftTimePreferences();

            // Update Shift Location Preferences
            employee.getShiftLocationPref().updateShiftLocationPreferences();
            

            // Get form fields
            String name = nameField.getText().strip();
            employee.setName(name);

            // Save the new employee
            eManager.saveEmployee(employee);
            
            // Tricky syntax because the UI is stored in the Page superclass
            AddEmployeePage.this.getUI().displayEmployeesPage();;
        }


    }



}
