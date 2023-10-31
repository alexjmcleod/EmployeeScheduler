package ui.pages;
import javax.swing.*;

import app.*;
import ui.*;
import entities.*;

import java.awt.event.*;

public class AddEmployeePage extends Page {

    // List<Employee> employeesList;
    Page employeesPage;
    // UI ui;

    JTextField nameField;
    
    // Constructors

    public AddEmployeePage(UI newUI) {
        super(newUI);
        this.setPageTitle("Add a New Employee");
        this.setPageBody("Add a new employee with the form.");
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

        String name;

        private Employee generateEmployee() {
            Employee newEmployee = new Employee(name);
            return newEmployee;
        }
        
        public void actionPerformed(ActionEvent event) {
            EmployeesPage ep = (EmployeesPage) employeesPage;

            // Get form fields
            name = nameField.getText().strip();

            // Clear form fields
            nameField.setText("");
            
            ep.employeesList.add(generateEmployee());
            
            AddEmployeePage.this.getUI().displayEmployeesPage();;
        }


    }



}
