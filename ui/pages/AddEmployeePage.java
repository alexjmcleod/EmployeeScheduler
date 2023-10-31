package ui.pages;
import javax.swing.*;
import java.awt.event.*;

import app.*;
import ui.*;
import entities.*;



public class AddEmployeePage extends Page {

    EmployeeManager eManager;
    JTextField nameField;
    
    // Constructors

    public AddEmployeePage(UI newUI, EmployeeManager neweManager) {
        super(newUI);
        this.setPageTitle("Add a New Employee");
        this.setPageBody("Add a new employee with the form.");
        eManager = neweManager;
        this.generateAddEmployeePage();
    }

    private void generateAddEmployeePage() {

        JPanel thisPage = super.generatePage();

        JLabel nameFieldLabel = new JLabel("Name: ");
        nameField = new JTextField(20);

        thisPage.add(nameFieldLabel, Layout.getAddEmployeeFieldConstraints());
        thisPage.add(nameField, Layout.getAddEmployeeFieldConstraints());

        JButton saveButton = new JButton("Save");
        saveButton.setBackground(Theme.getSaveButtonColor());
        saveButton.setFont(Theme.getSaveButtonFont());
        saveButton.addActionListener(new SaveButtonAction());
        
        thisPage.add(saveButton, Layout.getSaveEmployeeButtonConstraints());

    }


    // Event listeners
    class SaveButtonAction implements ActionListener {
        
        public void actionPerformed(ActionEvent event) {
        
            // Get form fields
            String name = nameField.getText().strip();
            
            // Save the new employee
            eManager.saveEmployee(new Employee(name));
            
            // Tricky syntax because the UI is stored in the Page superclass
            AddEmployeePage.this.getUI().displayEmployeesPage();;
        }


    }



}