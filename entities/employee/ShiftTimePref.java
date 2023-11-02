package entities.employee;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.format.TextStyle;

import ui.Layout;
import ui.Theme;

// TODO: input validation on preference fields

public class ShiftTimePref implements Serializable {

    // LinkedHashMap to store shift time preferences
    // {MONDAY  : {"DAY": int, "SWING": int, "NIGHT": int}} 
    // {TUESDAY : {"DAY": int, "SWING": int, "NIGHT": int}}
    // ...
    // {SUNDAY  : {"DAY": int, "SWING": int, "NIGHT": int}}
    Map<DayOfWeek, LinkedHashMap<String, Integer>> shiftTimePreferences = new LinkedHashMap<DayOfWeek, LinkedHashMap<String, Integer>>();

    // Used to store each field that holds a shift time preference
    List<JTextField> shiftTimePreferenceFields = new ArrayList<JTextField>();

    // For reuse of shift labels
    Map<String, String> shiftLabels;

    public ShiftTimePref() {
        
        // Initialize map of shift keys and pretty format
        shiftLabels = new LinkedHashMap<>();
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
            shiftTimePreferences.put(day, new LinkedHashMap<String, Integer>(shiftTimes));
        }

    }


    public JPanel getShiftTimePrefPanel() {

        // Create container for heading and grid
        JPanel shiftTimePrefPanel = new JPanel();
        shiftTimePrefPanel.setLayout(new GridBagLayout());

        // Create heading and add to container
        JPanel shiftTimePrefPanelHeading = new JPanel();
        shiftTimePrefPanelHeading.setLayout(new GridBagLayout());
        shiftTimePrefPanelHeading.setBackground(Theme.getPrimaryBG());
        JLabel prefTitle = new JLabel("Shift Time Preferences");
        prefTitle.setFont(Theme.getTableSectionTitleFont());

        shiftTimePrefPanelHeading.add(prefTitle, Layout.getShiftPrefPanelHeadingLabelConstraints());
        shiftTimePrefPanel.add(shiftTimePrefPanelHeading, Layout.getShiftPrefPanelHeadingPanelConstraints());

        // Create grid
        JPanel shiftTimePrefGrid = new JPanel();
        shiftTimePrefGrid.setLayout(new GridLayout(8, 4, 4, 4));
        shiftTimePrefGrid.setBackground(Theme.getPrimaryBG());

        
        // Add an empty cell to the grid
        JLabel emptyCell = new JLabel("");
        shiftTimePrefGrid.add(emptyCell);

        // Add each shift label to the grid
        for (Map.Entry<String, String> shiftLabel : shiftLabels.entrySet()) {
            JLabel label = new JLabel(shiftLabel.getValue());
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setFont(Theme.getFormFieldLabelFont());
            shiftTimePrefGrid.add(label);
        }


        // Example
        // MONDAY: {"DAY": 2}
        // DayOfWeek: {String: Integer}
        // Here we loop through each DayOfWeek
        for (Map.Entry<DayOfWeek, LinkedHashMap<String, Integer>> dayOfWeekEntry : shiftTimePreferences.entrySet()) {

            // Get the pretty string for this DayOfWeek
            String dayString = dayOfWeekEntry.getKey().getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH);

            // Add dow as jlabel to the display
            JLabel dayLabel = new JLabel(dayString);
            dayLabel.setFont(Theme.getFormFieldLabelFont());
            shiftTimePrefGrid.add(dayLabel, Layout.getEmployeeProfileFieldLabelConstraints());

            // Here we loop through each unique shift
            for (Map.Entry<String, Integer> uniqueShift : dayOfWeekEntry.getValue().entrySet()) {
                
                // For each shift label, generate a JTextField and add to the display
                JTextField prefField = new JTextField(4);

                // Custom property: Track which unique entry in the 2D map prefField
                // refers to by storing the keys for each map as custom properties
                prefField.putClientProperty("dowKey", dayOfWeekEntry.getKey()); // day of week key
                prefField.putClientProperty("shiftKey", uniqueShift.getKey()); // shift key

                // Add this field to the list of fields for use when updating values
                shiftTimePreferenceFields.add(prefField);

                // Add to display
                prefField.setText(Integer.toString(uniqueShift.getValue()));
                prefField.setHorizontalAlignment(SwingConstants.CENTER);
                shiftTimePrefGrid.add(prefField, Layout.getEmployeeProfileFieldConstraints());

            }

        }

        shiftTimePrefPanel.add(shiftTimePrefGrid, Layout.getShiftPrefPanelGridConstraints());
        return shiftTimePrefPanel;
    }


    public void updateShiftTimePreferences() {
        // Loop through all of the fields and update according to preferences
        for (JTextField field : shiftTimePreferenceFields) {

            // Get the keys for both entries in the 2D array to find a unique entry
            // that this field refers to
            DayOfWeek entryToUpdateDOWKey = (DayOfWeek) field.getClientProperty("dowKey");
            String entryToUpdateShiftKey = (String) field.getClientProperty("shiftKey");

            // Get the updated form value
            Integer updatedValue = Integer.parseInt(field.getText());

            // Find and update the entry to update
            shiftTimePreferences
                .get(entryToUpdateDOWKey)
                .put(entryToUpdateShiftKey, updatedValue);

        }
    }

}
