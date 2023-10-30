import javax.swing.*;
import java.awt.*;
import javax.swing.text.BadLocationException;

public class Page {
    
    String pageTitle = "Default";
    String pageBody = "Default";
    String pageMenuLabel = "Default";
    JPanel pagePanel;
    UI ui;

    // Constructors

    public Page(String newPageTitle, String newPageBody, String newPageMenuLabel) {
        pageTitle = newPageTitle;
        pageBody = newPageBody;
        pageMenuLabel = newPageMenuLabel;
        this.generatePage();
    }


    // Generate page elements
    public JPanel generatePage() {

        JPanel thisPage = new JPanel(); 
        thisPage.setLayout(new GridBagLayout());
        thisPage.setBackground(Theme.getPrimaryBG());
        thisPage.setBorder(Theme.getPageEmptyBorder());

        // Configure page title
        JTextPane thisTitle = new JTextPane();
        thisTitle.setBackground(Theme.getPrimaryBG());
        thisTitle.setFont(Theme.getPageTitleFont());
        
        // Configure page body
        JTextPane thisBody = new JTextPane();
        thisBody.setBackground(Theme.getPrimaryBG());
        thisBody.setFont(Theme.getPageBodyFont());

        // Add text to JTextPanes
        try {
            thisTitle.getStyledDocument().insertString(0, pageTitle, null);
            thisBody.getStyledDocument().insertString(0, pageBody, null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        thisPage.add(thisTitle, Layout.getPageTitleConstraints());
        thisPage.add(thisBody, Layout.getPageBodyConstraints());

        pagePanel = thisPage;
        return thisPage;

    }

    public GridBagConstraints generateConstraints() {

        return Layout.getPageconstraints();

    }


    // Getters n Setters
    public String getPageTitle() {
        return pageTitle;
    }

    public String getPageBody() {
        return pageBody;
    }

    public String getPageMenuLabel() {
        return pageMenuLabel;
    }

    public JPanel getPagePanel() {
        return pagePanel;
    }

    public void setPageTitle(String newPageTitle) {
        pageTitle = newPageTitle;
    }

    public void setPageBody(String newPageBody) {
        pageBody = newPageBody;
    }

    public void setPageMenuLabel(String newPageMenuLabel) {
        pageMenuLabel = newPageMenuLabel;
    }


}
