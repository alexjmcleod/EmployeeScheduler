import javax.swing.*;
import java.awt.*;
import javax.swing.text.BadLocationException;

public class Page {
    
    String pageTitle = "Default";
    String pageBody = "Default";
    String pageMenuLabel = "Default";
    JPanel pagePanel;

    // Constructors
    public Page() {
        // default constructor
        this.generatePage();
    }

    public Page(String newPageTitle) {
        pageTitle = newPageTitle;
        this.generatePage();
    }

    public Page(String newPageTitle, String newPageBody) {
        pageTitle = newPageTitle;
        pageBody = newPageBody;
        this.generatePage();
    }

    public Page(String newPageTitle, String newPageBody, String newPageMenuLabel) {
        pageTitle = newPageTitle;
        pageBody = newPageBody;
        pageMenuLabel = newPageMenuLabel;
        this.generatePage();
    }


    // Generate page elements
    public JPanel generatePage() {

        JPanel thisPage = new JPanel(); 
        thisPage.setLayout(new BoxLayout(thisPage, BoxLayout.Y_AXIS));
        thisPage.setBackground(Color.BLACK);
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

        pagePanel = thisPage;
        return thisPage;

    }

    public GridBagConstraints generateConstraints() {

        GridBagConstraints pageConstraints = new GridBagConstraints();
        pageConstraints.weightx = 1;
        pageConstraints.weighty = 1;
        pageConstraints.gridx = 0;
        pageConstraints.gridy = 1;
        pageConstraints.gridwidth = 12;
        pageConstraints.gridheight = GridBagConstraints.REMAINDER;
        pageConstraints.insets = new Insets(50, 25, 50, 25);
        pageConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        pageConstraints.fill = GridBagConstraints.HORIZONTAL;

        return pageConstraints;        
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
