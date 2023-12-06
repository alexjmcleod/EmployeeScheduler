package ui.pages;
import javax.swing.*;
import java.awt.event.*;
import java.time.DayOfWeek;
import java.util.LinkedHashMap;
import java.util.Map;

import entities.*;
import startup.*;
import ui.*;
import utilities.JSONExport.*;

public class EditEmployeePage extends ModifyEmployeePage {

    private static String pageTitle = "Edit Employee";
   
    // Constructors

    public EditEmployeePage(UI newUI, EmployeeManager neweManager, Employee employee, ClinicManager newClinicManager) {
        super(newUI, neweManager, employee, pageTitle, newClinicManager);

        pageBodyStrings.add("Use this page to edit an existing employee.");
        this.setPageBodyStrings(pageBodyStrings);
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

        JButton exportButton = new JButton("Export Location Preferences to JSON");
        exportButton.setBackground(Theme.getSaveButtonColor());
        exportButton.setFont(Theme.getSaveButtonFont());
        exportButton.addActionListener(new ExportButtonAction());
        
        thisPage.add(exportButton, Layout.getSaveEmployeeButtonConstraints());

    }

    // Event listeners
    class SaveButtonAction implements ActionListener {
        
        public void actionPerformed(ActionEvent event) {

            // Update shift preferences
            employee.getShiftTimePrefs().updateShiftTimePreferences();

            // Update Shift Location Preferences
            employee.getShiftLocationPref().updateShiftLocationPreferences();
        
            // Update name
            String name = nameField.getText().strip();
            employee.setName(name);
            
            // Save the updates
            eManager.updateEmployee(employee);
            
            // Tricky syntax because the UI is stored in the Page superclass
            EditEmployeePage.this.getUI().displayEmployeesPage();;
        }

    }

    class ExportButtonAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            // Generate JSON string
            // Get shift preferences

            Map<String, Integer> shiftLocationPreferences = employee.getShiftLocationPref().getShiftLocationPreferences();

            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("{ \"shiftLocationPreferences\": { \"Arvada\": \"");
            stringBuilder.append(Integer.toString(shiftLocationPreferences.get("ARVADA")));
            stringBuilder.append("\",\"Brighton\":\"");
            stringBuilder.append(Integer.toString(shiftLocationPreferences.get("BRIGHTON")));
            stringBuilder.append("\",\"Park Hill\":\"");
            stringBuilder.append(Integer.toString(shiftLocationPreferences.get("PARKHILL")));
            stringBuilder.append("\"}}");
            
            new JSONExport(stringBuilder.toString());

        }

    }



}
