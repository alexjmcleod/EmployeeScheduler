import javax.swing.*;
import javax.swing.text.BadLocationException;

public class Page {
    
    String pageTitle;
    String pageBody;

    // Constructors
    public Page() {
        // default constructor
    }

    public Page(String newPageTitle) {
        pageTitle = newPageTitle;
    }

    public Page(String newPageTitle, String newPageBody) {
        pageTitle = newPageTitle;
        pageBody = newPageBody;
    }

    // Generate page elements
    public JPanel generatePage() {

        JPanel thisPage = new JPanel(); 
        thisPage.setLayout(new BoxLayout(thisPage, BoxLayout.Y_AXIS));
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

        thisPage.add(thisTitle);
        thisPage.add(thisBody);

        return thisPage;

    }



    // Getters n Setters
    public String getPageTitle() {
        return pageTitle;
    }

    public String getPageBody() {
        return pageBody;
    }

    public void setPageTitle(String newPageTitle) {
        pageTitle = newPageTitle;
    }

    public void setMainContent(String newPageBody) {
        pageBody = newPageBody;
    }


}
