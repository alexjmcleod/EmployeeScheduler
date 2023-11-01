package ui.pages;
import java.util.ArrayList;
import java.util.List;

import app.UI;
import ui.*;

public class ShiftRulesPage extends Page {
    
    // Configure page contents
    public ShiftRulesPage(UI newUI) {
        super(newUI);
        this.setPageTitle("Shift Rules");
        
        List<String> pageBodyStrings = new ArrayList<String>();
        pageBodyStrings.add("...");
        this.setPageBodyStrings(pageBodyStrings);

        this.generatePage();
    }

}
