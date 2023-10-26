package pages;
import javax.swing.*;
import java.awt.*;
import javax.swing.text.BadLocationException;

public class Page {
    
    String pageTitle;
    String mainContent;

    int titleFontSize = 24;

    // Constructors
    public Page() {
        // default constructor
    }

    public Page(String newPageTitle) {
        pageTitle = newPageTitle;
    }

    public Page(String newPageTitle, String newMainContent) {
        pageTitle = newPageTitle;
        mainContent = newMainContent;
    }

    // Generate page elements
    public JPanel generatePage() {
        
        Color mainBg = new Color(250, 248, 237);

        // Page container
        JPanel thisPage = new JPanel();
        thisPage.setLayout(new BoxLayout(thisPage, BoxLayout.Y_AXIS));
        thisPage.setBackground(mainBg);
        
        // Page title
        JTextArea title = new JTextArea();
        Font titleFont = new Font("serif", Font.BOLD, titleFontSize);
        title.setFont(titleFont);
        title.setBackground(mainBg);

        // Main content
        JTextArea content = new JTextArea();
        content.setBackground(mainBg);

        try {
            content.getDocument().insertString(0, mainContent, null);
            title.getDocument().insertString(0, pageTitle, null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        } 

        thisPage.add(title);
        thisPage.add(content);

        return thisPage;

    }



    // Getters n Setters
    public String getPageTitle() {
        return pageTitle;
    }

    public String mainContent() {
        return mainContent;
    }

    public void setPageTitle(String newPageTitle) {
        pageTitle = newPageTitle;
    }

    public void setMainContent(String newMainContent) {
        mainContent = newMainContent;
    }


}
