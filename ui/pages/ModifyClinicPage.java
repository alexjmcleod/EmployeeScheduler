package ui.pages;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

import app.*;
import ui.*;
import entities.*;


public class ModifyClinicPage extends Page{
    
    ClinicManager cManager;
    JTextField nameField;
    Clinic clinic;
    List<String> pageBodyStrings = new ArrayList<String>();

    // Constructors
    public ModifyClinicPage(UI newUI, ClinicManager newcManager, Clinic newClinic, String pageTitle) {
        super(newUI);
        this.setPageTitle(pageTitle);
        this.setPageBodyStrings(pageBodyStrings);
        clinic = newClinic;
        cManager = newcManager;
        this.generateModifyClinicPage();
    }

    public JPanel generateModifyClinicPage() {

        JPanel thisPage = super.generatePage();

        JLabel nameFieldLabel = new JLabel("Name: ");
        nameField = new JTextField(20);

        thisPage.add(nameFieldLabel, Layout.getAddEmployeeFieldConstraints());
        thisPage.add(nameField, Layout.getAddEmployeeFieldConstraints());

        // Insert common elements here


        return thisPage;

    }


    // Getters and setters
    public Clinic getClinic() {
        return clinic;
    }

}
