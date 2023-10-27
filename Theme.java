import java.awt.*;
import javax.swing.border.EmptyBorder;

public class Theme {
    
    public static Color primaryBG = new Color(250, 248, 237);

    public static Font pageTitleFont = new Font("SansSerif", Font.BOLD, 24);
    public static Font pageBodyFont = new Font("SansSerif", Font.PLAIN, 16);

    public static EmptyBorder pageEmptyBorder = new EmptyBorder(100, 100, 100, 100);




    public static Color getPrimaryBG() {
        return primaryBG;
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




}
