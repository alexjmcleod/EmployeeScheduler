import java.util.ArrayList;
import java.util.List;

public class PageManager {
    
    List<Page> pagesInMainMenu = new ArrayList<Page>();
    Page homePage;
    UI ui;

    // Constructor
    public PageManager(UI newUI) {
        ui = newUI;
        this.generatePages();

    }

    public void generatePages() {

        // Generate Pages
        // Home page
        Page home = new Page(
            "Welcome to the Employee Scheduler app.", 
            "Use the menu at the top of the screen to complete tasks.\n\nFor help, visit the Help page.", 
            "Home");
        homePage = home;
        pagesInMainMenu.add(home);
        

        // Generate page
        Page generatePage = new Page(
            "Generate a Schedule", 
            "Use this page to generate a schedule.", 
            "Generate");
        pagesInMainMenu.add(generatePage);

        // Schedules page
        Page schedulesPage = new Page(
            "Schedules", 
            "Historic schedules are shown below.", 
            "Schedules");
        pagesInMainMenu.add(schedulesPage);

        // Clinics page
        Page clinicsPage = new Page(
            "Clinics", 
            "Add or edit clinics here.", 
            "Clinics");
        pagesInMainMenu.add(clinicsPage);

        // Employees page
        EmployeesPage employeesPage = new EmployeesPage(
            "Employees", 
            "Add or edit employees here.", 
            "Employees");
        employeesPage.ui = ui;
        pagesInMainMenu.add(employeesPage);


        // Get Shift Rules page
        Page shiftRules = new Page(
            "Shift Rules", 
            "These are the shift rules.", 
            "Shift Rules");
        pagesInMainMenu.add(shiftRules);


        // Get the Help page
        Page help = new Page(
            "Help",
            "A page for help resources.",
            "Help");
        pagesInMainMenu.add(help);


        // Get the Add Employee page
        AddEmployeePage addEmployee = new AddEmployeePage(
            "Add an Employee", 
            "Use this page to add an employee.", 
        "Add Employee");
        // pagesInMainMenu.add(addEmployee);
        employeesPage.addEmployeesPage = addEmployee; // Pass this page so employees page can request add employess page
        addEmployee.employeesPage = employeesPage;
        addEmployee.ui = ui;

    }

    public List<Page> getPagesInMainMenu() {
        return pagesInMainMenu;
    }

    public Page getHomePage() {
        return homePage;
    }
        

}
