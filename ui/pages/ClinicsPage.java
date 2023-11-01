package ui.pages;
import java.util.ArrayList;
import java.util.List;

import app.UI;
import ui.*;

public class ClinicsPage extends Page {
    
    // Configure page contents
    public ClinicsPage(UI newUI) {
        super(newUI);
        
        this.setPageTitle("Clinics");
        
        List<String> pageBodyStrings = new ArrayList<String>();
        pageBodyStrings.add("...");
        this.setPageBodyStrings(pageBodyStrings);
        
        this.generatePage();
    }

}
