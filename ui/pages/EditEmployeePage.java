package ui.pages;
import javax.swing.*;
import java.awt.event.*;

import app.*;
import ui.*;
import entities.*;

// TODO: Refactor this so it and addemployeepage extend a common class?

public class EditEmployeePage extends Page {

    EmployeeManager eManager;
    JTextField nameField;
    Employee employeeToEdit;
    
    // Constructors

    public EditEmployeePage(UI newUI, EmployeeManager neweManager, Employee employee) {
        super(newUI);
        this.setPageTitle("Edit an Existing Employee");
        this.setPageBody("Edit an employee with the form.");
        eManager = neweManager;
        employeeToEdit = employee;
        this.generateEditEmployeePage();
    }

    private void generateEditEmployeePage() {

        JPanel thisPage = super.generatePage();

        JLabel nameFieldLabel = new JLabel("Name: ");
        nameField = new JTextField(employeeToEdit.getName(), 20);

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
            employeeToEdit.setName(name);
            
            // Save the updates
            eManager.updateEmployee(employeeToEdit);
            
            // Tricky syntax because the UI is stored in the Page superclass
            EditEmployeePage.this.getUI().displayEmployeesPage();;
        }


    }



}
