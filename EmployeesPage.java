import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeesPage extends Page {

    List<Employee> employeesList = new ArrayList<Employee>();
    AddEmployeePage addEmployeesPage;
    ArrayList<JPanel> rows = new ArrayList<JPanel>(); // Will track references to table rows for table refresh

    // Constructors

    public EmployeesPage(String newPageTitle, String newPageBody, String newPageMenuLabel) {
        super(newPageTitle, newPageBody, newPageMenuLabel);
        this.generateEmployeesPage();
    }
    
    public JPanel generateEmployeesPage() {

        this.getEmployees();
        if (addEmployeesPage != null) {
            addEmployeesPage.employeesList = employeesList;
        }
        

        JPanel thisPage = super.generatePage();


        // Add Add Employee button
        JButton addEmployeeButton = new JButton("Add Employee");
        addEmployeeButton.setBackground(Theme.getAddButtonColor());
        addEmployeeButton.setFont(Theme.getAddButtonFont());
        addEmployeeButton.addActionListener(new AddEmployeeAction());
        
        thisPage.add(addEmployeeButton, Layout.getAddEmployeeButtonConstraints());

        this.drawEmployeesTable(thisPage);        

        // Save page as instance variable
        pagePanel = thisPage;
        return thisPage;

    }

    private void drawEmployeesTable(JPanel thisPage) {

        // Save the "current" employee row, so a custom border can be added
        // to the last row
        JPanel curEmployeeRow = new JPanel();

        if (!employeesList.isEmpty()) {
            for (Employee employee : employeesList) {

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
                rows.add(employeeRow);

            }
        }

        // Modify border of last row
        curEmployeeRow.setBorder(Theme.getTableLastRowBorder());

    }


    public void refreshEmployeesTable(JPanel thisPage) {

        // Delete all rows
        for (JPanel row : rows) {
            thisPage.remove(row);
        }
        this.drawEmployeesTable(thisPage);
    }


    private void getEmployees() {
        // Temporary method implementation for testing

        // Create a new employee and add it to list
        Employee employee1 = new Employee("Alice");
        Employee employee2 = new Employee("Quentin");
        employeesList.add(employee1);
        employeesList.add(employee2);

    }



    // Event handlers

    class EditEmployeeAction implements ActionListener {

        Employee employeeToEdit;

        public EditEmployeeAction(Employee employee) {
            employeeToEdit = employee;
        }

        public void actionPerformed(ActionEvent event) {
            System.out.println(String.format("Edit: %s", employeeToEdit.getName()));
        }

    }


    class DeleteEmployeeAction implements ActionListener {

        Employee employeeToDelete;

        public DeleteEmployeeAction(Employee employee) {
            employeeToDelete = employee;
        } 

        public void actionPerformed(ActionEvent event) {
            System.out.println(String.format("Delete: %s", employeeToDelete.getName()));
        }
    }


    class AddEmployeeAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            // System.out.println(pageToSet.getPageTitle());
            ui.showAddEmployeePage(addEmployeesPage);
        }   

    }





}
