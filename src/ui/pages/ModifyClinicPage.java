package ui.pages;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

import entities.*;
import startup.*;
import ui.*;


public class ModifyClinicPage extends Page{
    
    ClinicManager cManager;
    JTextField nameField;
    Clinic clinic;
    List<String> pageBodyStrings = new ArrayList<String>();

    // Constructors
    public ModifyClinicPage(UI newUI, ClinicManager cManager, Clinic clinic, String pageTitle) {
        super(newUI);
        this.setPageTitle(pageTitle);
        this.setPageBodyStrings(pageBodyStrings);
        this.clinic = clinic;
        this.cManager = cManager;
        this.generateModifyClinicPage();
    }

    public JPanel generateModifyClinicPage() {

        JPanel thisPage = super.generatePage();

        JLabel nameFieldLabel = new JLabel("Name: ");
        nameField = new JTextField(20);

        thisPage.add(nameFieldLabel, Layout.getAddEmployeeFieldConstraints());
        thisPage.add(nameField, Layout.getAddEmployeeFieldConstraints());

        // Insert common elements here

        // Add required shifts fields
        JPanel shiftReqPanel = clinic.getShiftsRequired().getShiftRequirementsPanel();
        thisPage.add(shiftReqPanel, Layout.getEmployeePreferencesPanelConstraints());

        return thisPage;

    }


    // Getters and setters
    public Clinic getClinic() {
        return clinic;
    }

}
