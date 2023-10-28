import java.awt.*;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;

public class Theme {
    
    // Primary styles
    static Color primaryBG = new Color(250, 248, 237);
    static int primaryWindowPadding = 25;
    static EmptyBorder primaryWindowEmptyBorder = new EmptyBorder(primaryWindowPadding, primaryWindowPadding, primaryWindowPadding, primaryWindowPadding);

    // Logo
    static String logoText = "Employee Scheduler";
    static Color logoBG = new Color(250, 248, 237);
    static Font logoFont = new Font("Monospaced", Font.BOLD, 24);

    // Page styles
    static Font pageTitleFont = new Font("SansSerif", Font.BOLD, 24);
    static Font pageBodyFont = new Font("SansSerif", Font.PLAIN, 16);
    static EmptyBorder pageEmptyBorder = new EmptyBorder(0, 0, 0, 0);


    // Button styles
    static Color menuButtonBG = new Color(153, 176, 128);
    static Font menuButtonFont = new Font("SansSerif", Font.BOLD, 14);



    public static JPanel getLogo() {
        
        JPanel logo = new JPanel();
        logo.setBackground(logoBG);

        JTextPane thisLogo = new JTextPane();
        thisLogo.setBackground(logoBG);
        thisLogo.setFont(logoFont);
        try {
            thisLogo.getStyledDocument().insertString(0, logoText, null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        logo.add(thisLogo);

        return logo;
    }

    public static GridBagConstraints getLogoConstraints() {
        
        GridBagConstraints logoConstraints = new GridBagConstraints();
        logoConstraints.weightx = 00;
        logoConstraints.weighty = 00;
        logoConstraints.gridx = 0;
        logoConstraints.gridy = 0;
        logoConstraints.gridwidth = 2;
        logoConstraints.gridheight = 1;
        logoConstraints.anchor = GridBagConstraints.FIRST_LINE_START;

        return logoConstraints;
    }
    


    public static Color getPrimaryBG() {
        return primaryBG;
    }

    public static EmptyBorder getPrimaryWindowEmptyBorder() {
        return primaryWindowEmptyBorder;
    }

    public static Font getPageTitleFont() {
        return pageTitleFont;
    }

    public static Font getPageBodyFont() {
        return pageBodyFont;
    }

    public static EmptyBorder getPageEmptyBorder() {
        return pageEmptyBorder;
    }

    // Button methods
    public static Color getMenuButtonBG() {
        return menuButtonBG;
    }

    public static Font getmenuButtonFont() {
        return menuButtonFont;
    }




}
