package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.*;

public class EmployeeManager implements Serializable {

    ArrayList<Employee> employeeList = new ArrayList<Employee>();


    public EmployeeManager() {
        
        this.loadEmployees();

    }


    public void loadEmployees() {

        try {
            FileInputStream inputStream = new FileInputStream("data/EmployeeData.ser");
            ObjectInputStream objectStream = new ObjectInputStream(inputStream);
 
            Object m = objectStream.readObject();

            @SuppressWarnings("unchecked")
            ArrayList<Employee> e = (ArrayList<Employee>) m;

            employeeList = e;

            objectStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("EmployeeData.ser not found. Initializing empty list.");
            employeeList = new ArrayList<Employee>();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 

    }


    public void saveEmployeeList() {

        try {
            FileOutputStream outputStream = new FileOutputStream("data/EmployeeData.ser");
            ObjectOutputStream objectStream = new ObjectOutputStream(outputStream);

            objectStream.writeObject(employeeList);

            objectStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void saveEmployee(Employee employee) {
        employeeList.add(employee);
        this.saveEmployeeList();
    }

    public void deleteEmployee(Employee employee) {
        employeeList.remove(employee);
        this.saveEmployeeList();
    }

    public void updateEmployee(Employee employee) {
        this.saveEmployeeList();
    }
    
}
