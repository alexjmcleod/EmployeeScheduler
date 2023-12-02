package ui;
import javax.swing.*;
import java.awt.*;
import javax.swing.text.BadLocationException;

import startup.*;

import java.util.*;
import java.util.List;


public class Page {
    
    private static String pageTitle = "Default";
    // private static String pageBody = "Default";
    private List<String> pageBodyStrings = new ArrayList<String>();
    private static String pageMenuLabel = "Default";
    JPanel pagePanel;
    UI ui;

    // Constructors

    public Page(UI newUI) {
        ui = newUI;
    }

    // Generate page elements
    public JPanel generatePage() {

        JPanel thisPage = new JPanel(); 
        thisPage.setLayout(new GridBagLayout());
        thisPage.setBackground(Theme.getPrimaryBG());
        thisPage.setBorder(Theme.getPageEmptyBorder());

        // Configure page title
        JTextPane thisTitle = new JTextPane();
        thisTitle.setEditable(false);
        thisTitle.setFocusable(false);
        thisTitle.setBackground(Theme.getPrimaryBG());
        thisTitle.setFont(Theme.getPageTitleFont());
        try {
            thisTitle.getStyledDocument().insertString(0, pageTitle, null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        thisPage.add(thisTitle, Layout.getPageTitleConstraints());

        
        // Configure page body
        for (String bodyPar : pageBodyStrings) {
            JTextPane thisBody = new JTextPane();
            thisBody.setEditable(false);
            thisBody.setFocusable(false);
            thisBody.setBackground(Theme.getPrimaryBG());
            thisBody.setFont(Theme.getPageBodyFont());
            try {
                thisBody.getStyledDocument().insertString(0, bodyPar, null);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
            thisPage.add(thisBody, Layout.getPageBodyConstraints());
        }
       

        pagePanel = thisPage;
        return thisPage;

    }

    public GridBagConstraints getConstraints() {

        return Layout.getPageconstraints();

    }


    // Getters n Setters
    public String getPageTitle() {
        return pageTitle;
    }

    // public String getPageBody() {
    //     return pageBody;
    // }

    public String getPageMenuLabel() {
        return pageMenuLabel;
    }

    public JPanel getPagePanel() {
        return pagePanel;
    }

    public UI getUI() {
        return ui;
    }

    public void setPageTitle(String newPageTitle) {
        pageTitle = newPageTitle;
    }

    // public void setPageBody(String newPageBody) {
    //     pageBody = newPageBody;
    // }

    public void setPageMenuLabel(String newPageMenuLabel) {
        pageMenuLabel = newPageMenuLabel;
    }

    public void setPagePanel(JPanel newPanel) {
        pagePanel = newPanel;
    }

    public void setPageBodyStrings(List<String> newPageBodyStrings) {
        pageBodyStrings = newPageBodyStrings;
    }


}
