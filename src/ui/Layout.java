package ui;
import java.awt.*;

// Example
// c.weightx = 0;
// c.weighty = 1;
// c.gridx = 1;
// c.gridy = 2;
// c.gridwidth = 4;
// c.gridheight = 1;
// c.anchor = GridBagConstraints.LINE_START;
// c.fill = GridBagConstraints.HORIZONTAL;
// c.ipadx = 20;
// c.ipady = 15;
// c.insets = new Insets(10, 10, 10, 10);


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
        c.weighty = 1;
        c.gridx = 0;
        //c.gridy = 1;
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

        return c;

    }

    public static GridBagConstraints getAddEmployeeFieldConstraints() {

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 0;
        c.gridwidth = 4;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.FIRST_LINE_START;

        return c;

    }

    public static GridBagConstraints getShiftPrefPanelHeadingPanelConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 12;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 15;

        return c;
    }

    public static GridBagConstraints getShiftPrefPanelHeadingLabelConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_START;

        return c;
    }

    public static GridBagConstraints getShiftPrefPanelGridConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 12;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 20;
        c.ipady = 15;

        return c;
    }

    public static GridBagConstraints getEmployeeProfileRowConstraints() {
        
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0;
        c.gridx = 0;
        c.gridwidth = 12;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 20;
        c.ipady = 15;

        return c;
    }

    public static GridBagConstraints getEmployeeProfileFieldLabelConstraints() {
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridwidth = 4;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.ipadx = 20;

        return c;
    }

        public static GridBagConstraints getEmployeeProfileFieldConstraints() {
        
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0;
        c.weighty = 1;
        c.gridwidth = 4;
        c.gridheight = 1;
        c.ipadx = 20;
        c.ipady = 15;
        c.insets = new Insets(10, 10, 10, 10);

        return c;
    }

    public static GridBagConstraints getEmployeePreferencesPanelConstraints() {
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(20, 0, 15, 0);

        return c;
    }

    public static GridBagConstraints getSaveEmployeeButtonConstraints() {

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 0;
        c.gridwidth = 12;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.ipadx = 20;
        c.ipady = 10;
        c.insets = new Insets(40, 0, 15, 0);

        return c;

    }


    public static GridBagConstraints getHomePageVersionUpdatesPanelConstraints() {
        
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.gridx = 0;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.ipadx = 50;
        c.ipady = 30;
        c.insets = new Insets(40, 0, 15, 0);

        return c;
    }

    public static GridBagConstraints getVersionUpdatesTitleLabelConstraints() {

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.gridx = 0;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.PAGE_START;

        return c;

    }

    public static GridBagConstraints getVersionUpdatesBodyPanelConstraints() {
        
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.gridx = 0;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.ipadx = 20;
        c.insets = new Insets(20, 10, 10, 10);

        return c;
    }

        public static GridBagConstraints getSaveClinicButtonConstraints() {

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 0;
        c.gridwidth = 12;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.ipadx = 20;
        c.ipady = 10;
        c.insets = new Insets(40, 0, 15, 0);

        return c;

    }


    public static GridBagConstraints getAddClinicButtonConstraints() {

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 0;
        // c.gridy = 2;
        c.gridwidth = 12;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.ipadx = 20;
        c.ipady = 30;
        c.insets = new Insets(0, 0, 15, 0);

        return c;

    }
    
    public static GridBagConstraints getClinicTableNameCellConstraints() {
        
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 8;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(15, 15, 15, 15);

        return c;

    }
    
    public static GridBagConstraints getClinicTableEditCellConstraints() {

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 9;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets = new Insets(15, 15, 15, 15);

        return c;

    }

    public static GridBagConstraints getClinicTableDeleteCellConstraints() {

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 11;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets = new Insets(15, 15, 15, 15);

        return c;

    }

    public static GridBagConstraints getClinicTableRowConstraints() {

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridwidth = 12;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;

        return c;

    }


    public static GridBagConstraints getShiftReqPanelHeadingPanelConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 12;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 15;

        return c;
    }

    public static GridBagConstraints getShiftReqPanelHeadingLabelConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_START;

        return c;
    }


    public static GridBagConstraints getClinicProfileRowConstraints() {
        
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0;
        c.gridx = 0;
        c.gridwidth = 12;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 20;
        c.ipady = 15;

        return c;
    }

    public static GridBagConstraints getClinicProfileFieldLabelConstraints() {
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridwidth = 4;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.ipadx = 20;

        return c;
    }

        public static GridBagConstraints getClinicProfileFieldConstraints() {
        
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0;
        c.weighty = 1;
        c.gridwidth = 4;
        c.gridheight = 1;
        c.ipadx = 20;
        c.ipady = 15;
        c.insets = new Insets(10, 10, 10, 10);

        return c;
    }

    public static GridBagConstraints getShiftReqPanelGridConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 12;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 20;
        c.ipady = 15;

        return c;
    }

    public static GridBagConstraints getGenerateCalenderConstraints() {

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridwidth = 12;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;

        return c;

    }

    public static GridBagConstraints getGenerateCalenderCellConstraints() {

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridwidth = 4;
        c.gridheight = 1;
        // c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 20;

        return c;

    }

}


