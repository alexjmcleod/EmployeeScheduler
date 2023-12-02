package ui.pages;
import java.util.ArrayList;
import java.util.List;

import startup.UI;
import ui.*;

public class HelpPage extends Page {
    
    // Configure page contents
    public HelpPage(UI newUI) {
        super(newUI);
        this.setPageTitle("Help");
        
        List<String> pageBodyStrings = new ArrayList<String>();
        pageBodyStrings.add("...");
        this.setPageBodyStrings(pageBodyStrings);

        this.generatePage();
    }

}
