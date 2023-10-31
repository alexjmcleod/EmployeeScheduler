package ui;
import java.awt.GridBagConstraints;
import java.awt.*;

public class Layout {


    // Page Constraints
    public static GridBagConstraints getPageconstraints() {

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 12;
        c.gridheight = GridBagConstraints.REMAINDER;
        c.insets = new Insets(50, 25, 50, 25);
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;

        return c;

    }


    // Page Title Constraints
    public static GridBagConstraints getPageTitleConstraints() {
        
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 12;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;

        return c;
    }

    // Page Body Constraints
    public static GridBagConstraints getPageBodyConstraints() {
        
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 12;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, 40, 0);
        
        return c;

    }

    public static GridBagConstraints getAddEmployeeButtonConstraints() {

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 0;
        // c.gridy = 2;
        c.gridwidth = 12;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 20;
        c.ipady = 30;
        c.insets = new Insets(0, 0, 15, 0);

        return c;

    }

    public static GridBagConstraints getEmployeeTableRowConstraints() {

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        // c.gridy = 2;
        c.gridwidth = 12;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;

        return c;

    }

    public static GridBagConstraints getEmployeeTableNameCellConstraints() {
        
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 8;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        // c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(15, 15, 15, 15);

        return c;

    }

    public static GridBagConstraints getEmployeeTableEditCellConstraints() {

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 9;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets = new Insets(15, 15, 15, 15);
        // c.fill;

        return c;

    }

    public static GridBagConstraints getEmployeeTableDeleteCellConstraints() {

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 11;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets = new Insets(15, 15, 15, 15);
        // c.fill;

        return c;

    }

    public static GridBagConstraints getAddEmployeeFieldConstraints() {

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 0;
        // c.gridy = 2;
        c.gridwidth = 4;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        //c.fill = GridBagConstraints.HORIZONTAL;
        // c.ipadx = 20;
        // c.ipady = 30;
        //c.insets = new Insets(40, 0, 15, 0);

        return c;


    }

    public static GridBagConstraints getSaveEmployeeButtonConstraints() {

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 0;
        // c.gridy = 2;
        c.gridwidth = 12;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 20;
        c.ipady = 10;
        c.insets = new Insets(40, 0, 15, 0);

        return c;

    }
    
    
    
}


