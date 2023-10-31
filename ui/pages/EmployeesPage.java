package ui.pages;
import java.util.ArrayList;
import javax.swing.*;

import app.*;
import entities.*;
import ui.*;

import java.awt.*;
import java.awt.event.*;

// TODO: Verification prompt on employee delete

public class EmployeesPage extends Page {

    EmployeeManager eManager;

    // Constructors

    public EmployeesPage(UI newUI, EmployeeManager newEmployeeManager) {
        super(newUI);
        this.setPageTitle("Employees");
        this.setPageBody("Add or edit employees here.");
        eManager = newEmployeeManager;
        this.generateEmployeesPage();

    }
    
    public JPanel generateEmployeesPage() {   

        JPanel thisPage = super.generatePage();

        // Add Add Employee button
        JButton addEmployeeButton = new JButton("Add Employee");
        addEmployeeButton.setBackground(Theme.getAddButtonColor());
        addEmployeeButton.setFont(Theme.getAddButtonFont());
        addEmployeeButton.addActionListener(new AddEmployeeAction());
        
        thisPage.add(addEmployeeButton, Layout.getAddEmployeeButtonConstraints());

        this.drawEmployeesTable(thisPage);        

        // Save page as instance variable
        this.setPagePanel(thisPage);
        return thisPage;

    }

    private void drawEmployeesTable(JPanel thisPage) {

        // Save the "current" employee row, so a custom border can be added
        // to the last row
        JPanel curEmployeeRow = new JPanel();

        // Get the employee list
        ArrayList<Employee> eList = eManager.getEmployeeList();
        if (!eList.isEmpty()) {
            for (Employee employee : eList) {

                JPanel employeeRow = new JPanel();
                curEmployeeRow = employeeRow; // Saving for custom border on last row
                employeeRow.setLayout(new GridBagLayout());
                employeeRow.setBorder(Theme.getTableRowBorder());
                employeeRow.setBackground(Theme.getTableRowBackground());

                JLabel thisEmployee = new JLabel(employee.getName());
                thisEmployee.setBackground(Theme.getPrimaryBG());
                thisEmployee.setFont(Theme.getPageBodyFont());

                JButton thisEditBtn = new JButton("Edit");
                thisEditBtn.setFont(Theme.getPageBodyFont());
                thisEditBtn.setContentAreaFilled(false);
                thisEditBtn.setOpaque(false);
                thisEditBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                thisEditBtn.addActionListener(new EditEmployeeAction(employee));

                JButton thisDeleteBtn = new JButton("Delete");
                thisDeleteBtn.setFont(Theme.getPageBodyFont());
                thisDeleteBtn.setForeground(Theme.getDeleteButtonColor());
                thisDeleteBtn.setContentAreaFilled(false);
                thisDeleteBtn.setOpaque(false);
                thisDeleteBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                thisDeleteBtn.addActionListener(new DeleteEmployeeAction(employee));


                employeeRow.add(thisEmployee, Layout.getEmployeeTableNameCellConstraints());
                employeeRow.add(thisEditBtn, Layout.getEmployeeTableEditCellConstraints());
                employeeRow.add(thisDeleteBtn, Layout.getEmployeeTableDeleteCellConstraints());

                thisPage.add(employeeRow, Layout.getEmployeeTableRowConstraints());

            }
        }

        // Modify border of last row
        curEmployeeRow.setBorder(Theme.getTableLastRowBorder());

    }


    // Event handlers

    class EditEmployeeAction implements ActionListener {

        Employee employeeToEdit;

        public EditEmployeeAction(Employee employee) {
            employeeToEdit = employee;
        }

        public void actionPerformed(ActionEvent event) {
            System.out.println(String.format("Edit: %s", employeeToEdit.getName()));
            EmployeesPage.this.getUI().displayEditEmployeePage(employeeToEdit);
        }

    }


    class DeleteEmployeeAction implements ActionListener {

        Employee employeeToDelete;

        public DeleteEmployeeAction(Employee employee) {
            employeeToDelete = employee;
        } 

        public void actionPerformed(ActionEvent event) {
            System.out.println(String.format("Delete: %s", employeeToDelete.getName()));
            eManager.deleteEmployee(employeeToDelete);
            EmployeesPage.this.getUI().displayEmployeesPage();
        }
    }


    class AddEmployeeAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            EmployeesPage.this.getUI().displayAddEmployeePage();
        }   
    }





}
