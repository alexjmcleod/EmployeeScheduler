package ui.pages;
import app.UI;
import ui.*;

public class HomePage extends Page {
    
    // Configure page contents
    public HomePage(UI newUI) {
        super(newUI);
        this.setPageTitle("Welcome to the Employee Scheduler app.");
        this.setPageBody("Use the menu at the top of the screen to complete tasks.\n\nFor help, visit the Help page.");
        this.generatePage();
    }

}
