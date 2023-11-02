package entities.employee;

import java.util.*;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

import ui.Layout;
import ui.Theme;

public class ShiftLocationPref implements Serializable {
    
    // Stores shift location preferences
    Map<String, Integer> shiftLocationPreferences = new LinkedHashMap<String, Integer>();

    // Used to store each field that holds a shift location preference
    List<JTextField> shiftLocationPreferenceFields = new ArrayList<JTextField>();

    // For pretty format of location labels
    Map<String, String> locationLabels;

    public ShiftLocationPref() {
        // TODO: This will probably take a list of clinics at some point

        // Initialize map of location keys and pretty format
        locationLabels = new LinkedHashMap<>();
        locationLabels.put("ARVADA", "Arvada");
        locationLabels.put("BRIGHTON", "Brighton");
        locationLabels.put("PARKHILL", "Park Hill");

        // Fill map with default values for each location
        for (Map.Entry<String, String> locationLabel : locationLabels.entrySet()) {
            shiftLocationPreferences.put(locationLabel.getKey(), 2);
        }
    }

    public JPanel getShiftLocationPrefPanel() {

        // Create container for heading and grid
        JPanel shiftLocationPrefPanel = new JPanel();
        shiftLocationPrefPanel.setLayout(new GridBagLayout());

        // Create heading and add to container
        JPanel shiftLocationPrefPanelHeading = new JPanel();
        shiftLocationPrefPanelHeading.setLayout(new GridBagLayout());
        shiftLocationPrefPanelHeading.setBackground(Theme.getPrimaryBG());
        JLabel prefTitle = new JLabel("Shift Location Preferences");
        prefTitle.setFont(Theme.getTableSectionTitleFont());

        shiftLocationPrefPanelHeading.add(prefTitle, Layout.getShiftPrefPanelHeadingLabelConstraints());
        shiftLocationPrefPanel.add(shiftLocationPrefPanelHeading, Layout.getShiftPrefPanelHeadingPanelConstraints());

        // Create grid
        JPanel shiftLocationPrefGrid = new JPanel();
        // TODO: update row quantity based on length of Clinics list
        shiftLocationPrefGrid.setLayout(new GridLayout(4, 2, 4, 4));
        shiftLocationPrefGrid.setBackground(Theme.getPrimaryBG());


        // Add each shift location to the grid
        for (Map.Entry<String, Integer> location : shiftLocationPreferences.entrySet()) {

            // Create the location label for the row and add to grid
            // Map the row key to the pretty format of the location label
            JLabel locationLabel = new JLabel(locationLabels.get(location.getKey()));
            locationLabel.setFont(Theme.getFormFieldLabelFont());
            shiftLocationPrefGrid.add(locationLabel, Layout.getEmployeeProfileFieldLabelConstraints());

            JTextField prefField = new JTextField(4);

            // TODO: update this comment
            // Custom property: Track which unique entry in the map prefField
            // refers to by attaching the entry to a client property
            prefField.putClientProperty("locationKey", location.getKey()); // location key

            // Add this field to the list of fields for use when updating values
            shiftLocationPreferenceFields.add(prefField);

            // Add to display
            prefField.setText(Integer.toString(location.getValue()));
            prefField.setHorizontalAlignment(SwingConstants.CENTER);
            shiftLocationPrefGrid.add(prefField, Layout.getEmployeeProfileFieldConstraints());

        }

        shiftLocationPrefPanel.add(shiftLocationPrefGrid, Layout.getShiftPrefPanelGridConstraints());
        return shiftLocationPrefPanel;

       
    }


    public void updateShiftLocationPreferences() {
        // Loop through all the fields and update according to preferences
        for (JTextField field : shiftLocationPreferenceFields) {

            // Returns the unique entry that this field was referring to
            @SuppressWarnings("unchecked")
            String entryToUpdateLocationKey = (String) field.getClientProperty("locationKey");

            // Get the updated form value
            Integer updatedValue = Integer.parseInt(field.getText());

            // Find and update the entry to update
            shiftLocationPreferences.put(entryToUpdateLocationKey, updatedValue);
        }
    }

    // Getters and setters
    public List<JTextField> getShiftLocationPreferenceFields() {
        return shiftLocationPreferenceFields;
    }
    
}
