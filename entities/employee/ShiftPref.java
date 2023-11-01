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

    List<JTextField> shiftTimePreferenceFields = new ArrayList<JTextField>();

    public ShiftPref() {
        
        Map<String, Integer> shiftTimes = new LinkedHashMap<String, Integer>();
        shiftTimes.put("DAY", 2);
        shiftTimes.put("SWING", 2);
        shiftTimes.put("NIGHT", 2);

        ArrayList<DayOfWeek> daysOfWeek = new ArrayList<DayOfWeek>();
        daysOfWeek.add(DayOfWeek.MONDAY);
        daysOfWeek.add(DayOfWeek.TUESDAY);
        daysOfWeek.add(DayOfWeek.WEDNESDAY);
        daysOfWeek.add(DayOfWeek.THURSDAY);
        daysOfWeek.add(DayOfWeek.FRIDAY);
        daysOfWeek.add(DayOfWeek.SATURDAY);
        daysOfWeek.add(DayOfWeek.SUNDAY);

        for (DayOfWeek day : daysOfWeek) {
            shiftTimePreferences.put(day, new LinkedHashMap<String, Integer>(shiftTimes));
        }

    }


    public JPanel getPreferencesPanel() {

        JPanel preferencesPanel = new JPanel();
        preferencesPanel.setLayout(new GridLayout(8, 4, 4, 4));
        preferencesPanel.setBackground(Theme.getPrimaryBG());

        JLabel empty = new JLabel("");
        JLabel day = new JLabel("Day Shift");
        JLabel swing = new JLabel("Swing Shift");
        JLabel night = new JLabel("Night Shift");

        day.setHorizontalAlignment(SwingConstants.CENTER);
        day.setFont(Theme.getFormFieldLabelFont());
        swing.setHorizontalAlignment(SwingConstants.CENTER);
        swing.setFont(Theme.getFormFieldLabelFont());
        night.setHorizontalAlignment(SwingConstants.CENTER);
        night.setFont(Theme.getFormFieldLabelFont());

        preferencesPanel.add(empty);
        preferencesPanel.add(day);
        preferencesPanel.add(swing);
        preferencesPanel.add(night);



        for (Map.Entry<DayOfWeek, LinkedHashMap<String, Integer>> dayOfWeekKey : shiftTimePreferences.entrySet()) {

            // JPanel prefRow = new JPanel();
            // prefRow.setLayout(new GridBagLayout());

            // Generate days of the week on screen
            String dayString = dayOfWeekKey.getKey().getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH);
            JLabel dayLabel = new JLabel(dayString);
            dayLabel.setFont(Theme.getFormFieldLabelFont());
            preferencesPanel.add(dayLabel, Layout.getEmployeeProfileFieldLabelConstraints());

            for (Map.Entry<String, Integer> shiftKey : dayOfWeekKey.getValue().entrySet()) {
                // Generate shift fields on screen
                JTextField prefField = new JTextField(4);
                prefField.putClientProperty("mapEntry", shiftKey);
                prefField.setText(Integer.toString(shiftKey.getValue()));
                prefField.setHorizontalAlignment(SwingConstants.CENTER);
                shiftTimePreferenceFields.add(prefField);
                preferencesPanel.add(prefField, Layout.getEmployeeProfileFieldConstraints());

            }

            // preferencesPanel.add(preferencesPanel, Layout.getEmployeeProfileRowConstraints());

        }

        return preferencesPanel;
    }


    public void updateShiftPreferences() {
        // Loop through all of the fields and update according preferences
        for (JTextField field : shiftTimePreferenceFields) {
            @SuppressWarnings("unchecked")
            Map.Entry<String, Integer> entryToUpdate = (Map.Entry<String, Integer>) field.getClientProperty("mapEntry"); // Returns the entry in form "SHIFT":int

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
