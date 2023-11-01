package entities.employee;

import javax.swing.*;
import java.awt.*;

import ui.Layout;
import ui.Theme;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

// TODO: refactor this class
// TODO: input validation on preference fields

public class ShiftPref implements Serializable {

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

    public ShiftPref() {
        
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


    public JPanel getShiftPrefPanel() {

        JPanel shiftPrefPanel = new JPanel();
        shiftPrefPanel.setLayout(new GridLayout(8, 4, 4, 4));
        shiftPrefPanel.setBackground(Theme.getPrimaryBG());

        
        // Add an empty cell to the grid
        JLabel emptyCell = new JLabel("");
        shiftPrefPanel.add(emptyCell);

        // Add each shift label to the grid
        for (Map.Entry<String, String> shiftLabel : shiftLabels.entrySet()) {
            JLabel label = new JLabel(shiftLabel.getValue());
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setFont(Theme.getFormFieldLabelFont());
            shiftPrefPanel.add(label);
        }


        // Example
        // MONDAY: {"DAY": 2}
        // DayOfWeek: {String: Integer}
        // Here we loop through each DayOfWeek
        for (Map.Entry<DayOfWeek, LinkedHashMap<String, Integer>> dayOfWeekKey : shiftTimePreferences.entrySet()) {

            // Get the pretty string for this DayOfWeek
            String dayString = dayOfWeekKey.getKey().getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH);

            // Add dow as jlabel to the display
            JLabel dayLabel = new JLabel(dayString);
            dayLabel.setFont(Theme.getFormFieldLabelFont());
            shiftPrefPanel.add(dayLabel, Layout.getEmployeeProfileFieldLabelConstraints());

            // Here we loop through each unique shift
            for (Map.Entry<String, Integer> uniqueShift : dayOfWeekKey.getValue().entrySet()) {
                
                // For each shift label, generate a JTextField and add to the display
                JTextField prefField = new JTextField(4);

                // Custom property: Track which unique entry in the 2D array prefField
                // refers to by attaching the entry to a client property
                prefField.putClientProperty("uniqueMapEntry", uniqueShift);

                // Add this field to the list of fields for use when updating values
                shiftTimePreferenceFields.add(prefField);

                // Add to display
                prefField.setText(Integer.toString(uniqueShift.getValue()));
                prefField.setHorizontalAlignment(SwingConstants.CENTER);
                shiftPrefPanel.add(prefField, Layout.getEmployeeProfileFieldConstraints());

            }

        }

        return shiftPrefPanel;
    }


    public void updateShiftPreferences() {
        // Loop through all of the fields and update according to preferences
        for (JTextField field : shiftTimePreferenceFields) {

            // Returns the unique entry that this field was referring to
            @SuppressWarnings("unchecked")
            Map.Entry<String, Integer> entryToUpdate = (Map.Entry<String, Integer>) field.getClientProperty("uniqueMapEntry"); 

            // Get the updated form value
            Integer updatedValue = Integer.parseInt(field.getText());

            entryToUpdate.setValue(updatedValue);

        }
    }


    // Getters and setters
    public List<JTextField> getShiftTimePreferenceFields() {
        return shiftTimePreferenceFields;
    }


}
