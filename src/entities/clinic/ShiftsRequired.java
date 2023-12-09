package entities.clinic;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.awt.event.*;


import ui.Layout;
import ui.Theme;

public class ShiftsRequired implements Serializable {

    Map<DayOfWeek, LinkedHashMap<String, Integer>> shiftRequirements = new LinkedHashMap<DayOfWeek, LinkedHashMap<String, Integer>>();

    // Used to store a reference to each field that holds a shift requirement
    List<JTextField> shiftRequirementFields = new ArrayList<JTextField>();

    // For reuse of shift labels
    Map<String, String> shiftLabels;

    public ShiftsRequired() {

        // Initialize map of shift keys and pretty format
        shiftLabels = new LinkedHashMap();
        shiftLabels.put("DAY", "Day Shift");
        shiftLabels.put("SWING", "Swing Shift");
        shiftLabels.put("NIGHT", "Night Shift");

        // Create map with default values for each shift key
        Map<String, Integer> shiftTimes = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, String> shiftLabel : shiftLabels.entrySet()) {
            shiftTimes.put(shiftLabel.getKey(), 2);
        }

        // Loop through all DayOfWeek values (MON-SUN)
        for (DayOfWeek day : DayOfWeek.values()) {
            // For each KEY as day, add a copy of the shiftTimes map
            shiftRequirements.put(day, new LinkedHashMap<String, Integer>(shiftTimes));
        }

    }

    public JPanel getShiftRequirementsPanel() {

        // Create container for heading and grid
        JPanel shiftRequirementsPanel = new JPanel();
        shiftRequirementsPanel.setLayout(new GridBagLayout());

        // Create heading and add to container
        JPanel shiftRequirementsPanelHeading = new JPanel();
        shiftRequirementsPanelHeading.setLayout(new GridBagLayout());
        shiftRequirementsPanelHeading.setBackground(Theme.getPrimaryBG());
        JLabel reqTitle = new JLabel("Shift Requirements");
        reqTitle.setFont(Theme.getTableSectionTitleFont());

        shiftRequirementsPanelHeading.add(reqTitle, Layout.getShiftReqPanelHeadingLabelConstraints());
        shiftRequirementsPanel.add(shiftRequirementsPanelHeading, Layout.getShiftReqPanelHeadingPanelConstraints());

        // Create grid
        JPanel shiftReqGrid = new JPanel();
        shiftReqGrid.setLayout(new GridLayout(8, 4, 4, 4));
        shiftReqGrid.setBackground(Theme.getPrimaryBG());

        // Add an empty cell to grid
        JLabel emptyCell = new JLabel("");
        shiftReqGrid.add(emptyCell);

        // Add each shift label to grid
        for (Map.Entry<String, String> shiftLabel : shiftLabels.entrySet()) {
            JLabel label = new JLabel(shiftLabel.getValue());
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setFont(Theme.getFormFieldLabelFont());
            shiftReqGrid.add(label);
        }

        // Example
        // MONDAY: {"DAY": 2}
        // DayOfWeek: {String: Integer}
        // Here we loop through each DayOfWeek
        for (Map.Entry<DayOfWeek, LinkedHashMap<String, Integer>> dayOfWeekEntry : shiftRequirements.entrySet()) {

            // Get the pretty string for this DayOfWeek
            String dayString = dayOfWeekEntry.getKey().getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH);

            // Add dow as jlabel to the display
            JLabel dayLabel = new JLabel(dayString);
            dayLabel.setFont(Theme.getFormFieldLabelFont());
            shiftReqGrid.add(dayLabel, Layout.getClinicProfileFieldLabelConstraints());

            // Here we loop through each unique shift
            for (Map.Entry<String, Integer> uniqueShift : dayOfWeekEntry.getValue().entrySet()) {

                // For each shift label, generate a JTextField and add it to the display
                JTextField reqField = new JTextField(4);
                
                // Custom property: Track which unique entry in the 2D map reqField
                // refers to by storing the keys for each map as custom properties
                reqField.putClientProperty("dowKey", dayOfWeekEntry.getKey()); // day of week key
                reqField.putClientProperty("shiftKey", uniqueShift.getKey()); // shift key

                // Add this field to the list of fields for use when updating values
                shiftRequirementFields.add(reqField);

                // Add to display
                reqField.setText(Integer.toString(uniqueShift.getValue()));
                reqField.setHorizontalAlignment(SwingConstants.CENTER);
                shiftReqGrid.add(reqField, Layout.getClinicProfileFieldConstraints());

                // reqField.getDocument().addDocumentListener(new InputListener());

            }
        }

        shiftRequirementsPanel.add(shiftReqGrid, Layout.getShiftReqPanelGridConstraints());
        return shiftRequirementsPanel;

    }

    public void updateShiftRequirements() {
        // Loop through all the fields and update according to preferences
        for (JTextField field : shiftRequirementFields) {

            // Get the keys for both entries in the 2D array to find a unique entry
            // that this field refers to
            DayOfWeek entryToUpdateDOWKey = (DayOfWeek) field.getClientProperty("dowKey");
            String entryToUpdateShiftKey = (String) field.getClientProperty("shiftKey");

            // Get the updated form value
            Integer updatedValue = Integer.parseInt(field.getText());

            // Find and update the entry to update
            shiftRequirements
                .get(entryToUpdateDOWKey)
                .put(entryToUpdateShiftKey, updatedValue);
                
        }
    }

    public Integer getNumEmployeesRequired(DayOfWeek dow, String shift) {

        return shiftRequirements.get(dow).get(shift);
        

    }

    // class InputListener implements DocumentListener {
        
    //     void inputModified(DocumentEvent e) {
    //         System.out.println("Input modified");
    //         Document doc = e.getDocument();
    //         String value = "";
    //         try {
    //             value = doc.getText(0, doc.getLength());
    //         } catch (BadLocationException err) {
    //             err.printStackTrace();
    //         }

    //         Integer updatedValue = Integer.parseInt(value);
    //         if (updatedValue < 0 || updatedValue > 3) {
    //             System.out.println("Invalid input");
    //             try {
    //                 doc.insertString(doc.getLength() - 1, "no", null);
    //             } catch (BadLocationException err) {
    //                 err.printStackTrace();
    //             }
    //         }


    //     }

    //     public void insertUpdate(DocumentEvent e) {
    //         inputModified(e);
    //     }

    //     public void removeUpdate(DocumentEvent e) {
    //         inputModified(e);
    //     }

    //     public void changedUpdate(DocumentEvent e) {
    //         inputModified(e);
    //     }



    // }


}
