import java.util.List;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class MainMenu {

    List<String> menuItems = new ArrayList<String>(Arrays.asList(
        "Generate",
        "Schedules",
        "Clinics",
        "Employees",
        "Shift Rules",
        "Help"
    ));

    public JPanel generateMenu() {
        
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridBagLayout());
        
        Color mainBg = new Color(250, 248, 237);
        menuPanel.setBackground(mainBg);

        for (String label : menuItems) {
            JButton button = new JButton(label);
            menuPanel.add(button);
        }

        return menuPanel;

    };
    
    
    
    
    


    

}
