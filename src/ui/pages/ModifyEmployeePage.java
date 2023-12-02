package ui.pages;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

import entities.*;
import startup.*;
import ui.*;

public class ModifyEmployeePage extends Page {

    EmployeeManager eManager;
    JTextField nameField;
    Employee employee;
    List<String> pageBodyStrings = new ArrayList<String>();
    
    // Constructors

    public ModifyEmployeePage(UI newUI, EmployeeManager neweManager, Employee newEmployee, String pageTitle, ClinicManager newClinicManager) {
        super(newUI);
        this.setPageTitle(pageTitle);
        this.setPageBodyStrings(pageBodyStrings);
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
        thisPage.add(shiftLocationPreferencesPanel, Layout.getEmployeePreferencesPanelConstraints());

        return thisPage;

    }

    // Getters n setters
    public Employee getEmployee() {
        return employee;
    }


}
