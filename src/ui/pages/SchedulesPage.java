package ui.pages;
import java.util.ArrayList;
import java.util.List;

import startup.UI;
import ui.*;

public class SchedulesPage extends Page {
    
    // Configure page contents
    public SchedulesPage(UI newUI) {
        super(newUI);
        this.setPageTitle("Schedules");
        
        List<String> pageBodyStrings = new ArrayList<String>();
        pageBodyStrings.add("...");
        this.setPageBodyStrings(pageBodyStrings);

        this.generatePage();
    }

}
