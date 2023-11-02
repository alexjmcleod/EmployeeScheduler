package ui.pages;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import app.*;
import ui.*;
import entities.*;

// TODO: Verification prompt on clinic delete
// TODO: refactor common row items (edit, delete, etc.)
// TODO: refactor could involve making a table generator class (there is a lot of repeated code between ClinicsPage and EmployeesPage)

public class ClinicsPage extends Page {

    ClinicManager cManager;
    
    // Configure page contents
    public ClinicsPage(UI newUI, ClinicManager newcManager) {
        super(newUI);
        
        this.setPageTitle("Clinics");
        
        List<String> pageBodyStrings = new ArrayList<String>();
        pageBodyStrings.add("Add or edit clinics here.");
        this.setPageBodyStrings(pageBodyStrings);

        cManager = newcManager;
        this.generateClinicsPage();
    }

    public JPanel generateClinicsPage() {

        JPanel thisPage = super.generatePage();

        // Add Add Clinic button
        JButton addClinicButton = new JButton("Add Clinic");
        addClinicButton.setBackground(Theme.getAddButtonColor());
        addClinicButton.setFont(Theme.getAddButtonFont());
        addClinicButton.addActionListener(new AddClinicAction());

        thisPage.add(addClinicButton, Layout.getAddClinicButtonConstraints());

        this.drawClinicsTable(thisPage);

        // Save page as instance variable
        this.setPagePanel(thisPage);
        return thisPage;

    }

    private void drawClinicsTable(JPanel thisPage) {

        // Save the "current" clinic row, so a custom border can be added
        // to the last row
        JPanel curClinicRow = new JPanel();

        // Get the clinic list
        ArrayList<Clinic> cList = cManager.getClinicList();
        if (!cList.isEmpty()) {
            for (Clinic clinic : cList) {

                JPanel clinicRow = new JPanel();
                curClinicRow = clinicRow; // Saving for custom border on last row
                clinicRow.setLayout(new GridBagLayout());
                clinicRow.setBorder(Theme.getTableRowBorder());
                clinicRow.setBackground(Theme.getTableRowBackground());

                JLabel thisClinic = new JLabel(clinic.getName());
                thisClinic.setBackground(Theme.getPrimaryBG());
                thisClinic.setFont(Theme.getPageBodyFont());

                JButton thisEditBtn = new JButton("Edit");
                thisEditBtn.setFont(Theme.getPageBodyFont());
                thisEditBtn.setContentAreaFilled(false);
                thisEditBtn.setOpaque(false);
                thisEditBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                thisEditBtn.addActionListener(new EditClinicAction(clinic));

                JButton thisDeleteBtn = new JButton("Delete");
                thisDeleteBtn.setFont(Theme.getPageBodyFont());
                thisDeleteBtn.setForeground(Theme.getDeleteButtonColor());
                thisDeleteBtn.setContentAreaFilled(false);
                thisDeleteBtn.setOpaque(false);
                thisDeleteBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                thisDeleteBtn.addActionListener(new DeleteClinicAction(clinic));

                clinicRow.add(thisClinic, Layout.getClinicTableNameCellConstraints());
                clinicRow.add(thisEditBtn, Layout.getClinicTableEditCellConstraints());
                clinicRow.add(thisDeleteBtn, Layout.getClinicTableDeleteCellConstraints());

                thisPage.add(clinicRow, Layout.getClinicTableRowConstraints());

            }

        }

        // Modify border of last row
        curClinicRow.setBorder(Theme.getTableLastRowBorder());

    }

    // Event handlers

    class EditClinicAction implements ActionListener {
        
        Clinic clinicToEdit;

        public EditClinicAction(Clinic clinic) {
            clinicToEdit = clinic;
        }

        public void actionPerformed(ActionEvent event) {
            ClinicsPage.this.getUI().displayEditClinicPage(clinicToEdit);
        }

    }

    class DeleteClinicAction implements ActionListener {

        Clinic clinicToDelete;

        public DeleteClinicAction(Clinic clinic) {
            clinicToDelete = clinic;
        }

        public void actionPerformed(ActionEvent event) {
            cManager.deleteClinic(clinicToDelete);
            ClinicsPage.this.getUI().displayClinicsPage();
        }

    }

    class AddClinicAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ClinicsPage.this.getUI().displayAddClinicPage();
        }
    }


}
