package ui.pages;
import javax.swing.*;
import java.awt.event.*;

import app.*;
import ui.*;
import entities.*;

public class EditEmployeePage extends ModifyEmployeePage {

    private static String pageTitle = "Edit Employee";
    private static String pageBody = "Use this page to edit an existing employee.";
   
    // Constructors

    public EditEmployeePage(UI newUI, EmployeeManager neweManager, Employee employee) {
        super(newUI, neweManager, employee, pageTitle, pageBody);
        // System.out.println(String.format("In editemployeepage constructor, value of name: %s", employee.getName()));
        // System.out.println(String.format("In editemployeepage constructor, value of name: %s", employeeToEdit.getName()));
        this.generateEditEmployeePage();
    }

    private void generateEditEmployeePage() {

        JPanel thisPage = super.generateModifyEmployeePage();

        // Set the form fields based on employee profile
        nameField.setText(employee.getName());


        JButton saveButton = new JButton("Save");
        saveButton.setBackground(Theme.getSaveButtonColor());
        saveButton.setFont(Theme.getSaveButtonFont());
        saveButton.addActionListener(new SaveButtonAction());
        
        thisPage.add(saveButton, Layout.getSaveEmployeeButtonConstraints());

    }

    // Event listeners
    class SaveButtonAction implements ActionListener {
        
        public void actionPerformed(ActionEvent event) {

            // Update shift preferences
            employee.getShiftTimePrefs().updateShiftPreferences();
        
            // Get form fields
            String name = nameField.getText().strip();
            employee.setName(name);
            
            // Save the updates
            eManager.updateEmployee(employee);
            
            // Tricky syntax because the UI is stored in the Page superclass
            EditEmployeePage.this.getUI().displayEmployeesPage();;
        }


    }



}
