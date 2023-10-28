import javax.swing.UIManager;
import javax.swing.UIManager.*;

class EmployeeScheduler {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Set LookAndFeel to Nimbus (Copied from Oracle Docs)
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        

        UI ui = new UI(); 
        ui.startup();


    }

}