package ui.pages;

import javax.swing.*;
import java.awt.*;

import app.*;
import ui.*;
import entities.*;

public class ModifyEmployeePage extends Page {

    EmployeeManager eManager;
    JTextField nameField;
    Employee employee;
    
    // Constructors

    public ModifyEmployeePage(UI newUI, EmployeeManager neweManager, Employee newEmployee, String pageTitle, String pageBody) {
        super(newUI);
        this.setPageTitle(pageTitle);
        this.setPageBody(pageBody);
        employee = newEmployee;
        eManager = neweManager;
        this.generateModifyEmployeePage();
    }

    public JPanel generateModifyEmployeePage() {

        JPanel thisPage = super.generatePage();

        JLabel nameFieldLabel = new JLabel("Name: ");
        nameField = new JTextField(20);

        thisPage.add(nameFieldLabel, Layout.getAddEmployeeFieldConstraints());
        thisPage.add(nameField, Layout.getAddEmployeeFieldConstraints());
        
        JPanel shiftTimePreferencesPanel = employee.getShiftTimePrefs().getShiftTimePrefPanel();
        thisPage.add(shiftTimePreferencesPanel, Layout.getEmployeePreferencesPanelConstraints());

        JPanel shiftLocationPreferencesPanel = employee.getShiftLocationPref().getShiftLocationPrefPanel();
        shiftLocationPreferencesPanel.setBackground(Color.BLACK);
        thisPage.add(shiftLocationPreferencesPanel, Layout.getEmployeePreferencesPanelConstraints());

        return thisPage;

    }

    // Getters n setters
    public Employee getEmployee() {
        return employee;
    }


}
