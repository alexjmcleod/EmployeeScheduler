import java.util.List;
import javax.swing.*;
import java.awt.event.*;

public class AddEmployeePage extends Page {

    List<Employee> employeesList;
    Page employeesPage;
    UI ui;

    JTextField nameField;
    
    // Constructors

    public AddEmployeePage(String newPageTitle, String newPageBody, String newPageMenuLabel) {
        super(newPageTitle, newPageBody, newPageMenuLabel);
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
            ep.refreshEmployeesTable(ep.pagePanel);
            ui.changeMainPage(employeesPage);
        }


    }



}
