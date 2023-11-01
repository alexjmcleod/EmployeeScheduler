package ui.pages;
import java.util.ArrayList;
import java.util.List;

import app.UI;
import ui.*;

public class GeneratePage extends Page {
    
    // Configure page contents
    public GeneratePage(UI newUI) {
        super(newUI);
        this.setPageTitle("Generate");
        
        List<String> pageBodyStrings = new ArrayList<String>();
        pageBodyStrings.add("...");
        this.setPageBodyStrings(pageBodyStrings);

        this.generatePage();
    }

}
