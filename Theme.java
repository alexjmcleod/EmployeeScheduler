import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

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
    static Color deleteButtonColor = Color.RED;

    static Color addButtonColor = new Color(249, 181, 114);
    static Font addButtonFont = new Font("SansSerif", Font.BOLD, 14);

    static Color saveButtonColor = new Color(249, 181, 114);
    static Font saveButtonFont = new Font("SansSerif", Font.BOLD, 14);
    


    // Table styles
    static MatteBorder tableRowBorder = new MatteBorder(3, 3, 0, 3, Color.BLACK);
    static MatteBorder tableLastRowBorder = new MatteBorder(3, 3, 3, 3, Color.BLACK);
    static Color tableRowBackground = Color.WHITE;



    public static JPanel getLogo() {
        
        JPanel logo = new JPanel();
        logo.setBackground(logoBG);

        JLabel thisLogo = new JLabel(logoText);
        thisLogo.setBackground(logoBG);
        thisLogo.setFont(logoFont);

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

    public static Font getMenuButtonFont() {
        return menuButtonFont;
    }

    public static MatteBorder getTableRowBorder() {
        return tableRowBorder;
    }

    public static MatteBorder getTableLastRowBorder() {
        return tableLastRowBorder;
    }

    public static Color getTableRowBackground() {
        return tableRowBackground;
    }

    public static Color getDeleteButtonColor() {
        return deleteButtonColor;
    }

    public static Color getAddButtonColor() {
        return addButtonColor;
    }

    public static Font getAddButtonFont() {
        return addButtonFont;
    }

    public static Color getSaveButtonColor() {
        return saveButtonColor;
    }

    public static Font getSaveButtonFont() {
        return saveButtonFont;
    }




}
