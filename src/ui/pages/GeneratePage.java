package ui.pages;
import java.util.List;
import java.util.*;
import entities.Schedule;
import entities.Clinic;

import startup.UI;
import ui.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.DayOfWeek;
import java.time.format.TextStyle;

public class GeneratePage extends Page {
    
    // Configure page contents
    public GeneratePage(UI newUI) {
        super(newUI);
        this.setPageTitle("Generate");
        
        List<String> pageBodyStrings = new ArrayList<String>();
        pageBodyStrings.add("This page generates a schedule for one week. A new schedule is generated each time the page is opened.\n\nThe algorithm prioritizes employees for a particular shift and location based on the preferences in their profile.\n\nIn the case of a tie in preferences, a random employee is chosen from the list of tied employees.\n\nSince there is an element of randomness, you will see differences in each schedule generated.");
        this.setPageBodyStrings(pageBodyStrings);

        this.generateGeneratePage();
        this.generateSchedule();

    }


    Map<DayOfWeek, LinkedHashMap<Clinic, LinkedHashMap<String, List<String>>>> generateSchedule() {

        Schedule scheduleGenerator = new Schedule();

        Map<DayOfWeek, LinkedHashMap<Clinic, LinkedHashMap<String, List<String>>>> schedule = scheduleGenerator.generateSchedule();

        return schedule;
        
    
    }


    public JPanel generateGeneratePage() {

        JPanel thisPage = super.generatePage();

        // Add Generate button
        JButton generateScheduleButton = new JButton("Generate Schedule");
        generateScheduleButton.setBackground(Theme.getAddButtonColor());
        generateScheduleButton.setFont(Theme.getAddButtonFont());
        generateScheduleButton.addActionListener(new GenerateScheduleAction());

        thisPage.add(generateScheduleButton, Layout.getAddClinicButtonConstraints());

        JPanel calendarPanel = new JPanel();

        calendarPanel.setLayout(new GridBagLayout());
        calendarPanel.setBackground(Color.WHITE);


        Map<DayOfWeek, LinkedHashMap<Clinic, LinkedHashMap<String, List<String>>>> schedule = this.generateSchedule();

        // Save the "current" schedule row, so a custom border can be added
        // to the last row
        JPanel curCalendarCell = new JPanel();

        // Loop through all days of week
        for (Map.Entry<DayOfWeek, LinkedHashMap<Clinic, LinkedHashMap<String, List<String>>>> dayOfWeek : schedule.entrySet()) {

            JPanel calendarCell = new JPanel();
            curCalendarCell = calendarCell;
            calendarCell.setBackground(Color.CYAN);
            calendarCell.setLayout(new GridBagLayout());
            calendarCell.setBorder(Theme.getTableRowBorder());
            calendarCell.setBackground(Theme.getTableRowBackground());

            
            JPanel dowPanel = new JPanel();
            dowPanel.setLayout(new GridBagLayout());
            dowPanel.setBackground(Color.WHITE);
            GridBagConstraints dowLayout = new GridBagConstraints();
            dowLayout.weightx = 1;
            dowLayout.weighty = 0;
            dowLayout.gridwidth = 12;
            dowLayout.gridx = 0;
            dowLayout.anchor = GridBagConstraints.FIRST_LINE_START;
            dowLayout.insets = new Insets(5, 10, 0, 10);
            // dowLayout.fill = GridBagConstraints.HORIZONTAL;

            JLabel dowLabel = new JLabel(dayOfWeek.getKey().getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH));
            dowLabel.setFont(Theme.getScheduleDOWFont());
            
            dowPanel.add(dowLabel);
            calendarCell.add(dowPanel, dowLayout);

            for (Map.Entry<Clinic, LinkedHashMap<String, List<String>>> clinic : dayOfWeek.getValue().entrySet()) {

                JPanel clinicPanel = new JPanel();
                clinicPanel.setLayout(new GridBagLayout());
                clinicPanel.setBackground(Color.WHITE);

                GridBagConstraints clinicLayout = new GridBagConstraints();
                clinicLayout.weightx = 0;
                clinicLayout.gridwidth = 1;
                clinicLayout.gridy = 1;
                clinicLayout.anchor = GridBagConstraints.LINE_START;
                clinicLayout.insets = new Insets(20, 10, 10, 10);
                // clinicLayout.fill = GridBagConstraints.HORIZONTAL;

                JLabel clinicLabel = new JLabel(clinic.getKey().getName());
                clinicLabel.setFont(Theme.getScheduleClinicFont());
                clinicLabel.setBorder(new EmptyBorder(0, 0, 10, 0));
                clinicPanel.add(clinicLabel);
                calendarCell.add(clinicPanel, clinicLayout);


                for (Map.Entry<String, List<String>> shift : clinic.getValue().entrySet()) {

                    JPanel shiftPanel = new JPanel();
                    shiftPanel.setLayout(new GridBagLayout());
                    shiftPanel.setBackground(Color.WHITE);

                    GridBagConstraints shiftLayout = new GridBagConstraints();
                    shiftLayout.weightx = 1;
                    shiftLayout.gridwidth = 2;
                    shiftLayout.gridx = 0;
                    shiftLayout.anchor = GridBagConstraints.LINE_START;

                    StringBuilder shiftLabelString = new StringBuilder();
                    shiftLabelString.append(shift.getKey());
                    shiftLabelString.append(": ");

                    JLabel shiftLabel = new JLabel(shiftLabelString.toString());
                    shiftLabel.setBorder(new EmptyBorder(0, 0, 10, 0));
                    shiftPanel.add(shiftLabel);

                    StringBuilder employeesString = new StringBuilder();

                    for (String employee : shift.getValue()) {
                        employeesString.append(employee);
                        employeesString.append(", ");                        
                    }
                    if (employeesString.length() > 0) {
                        employeesString.deleteCharAt(employeesString.length() - 1);
                    }
                    if (employeesString.length() > 0) {
                        employeesString.deleteCharAt(employeesString.length() - 1);
                    }   

                    JLabel employeesLabel = new JLabel(employeesString.toString());
                    shiftPanel.add(employeesLabel);
                    employeesLabel.setBorder(new EmptyBorder(0, 0, 10, 0));

                    clinicPanel.add(shiftPanel, shiftLayout);

                }

            }
            
            
            calendarPanel.add(calendarCell, Layout.getGenerateCalenderCellConstraints());

        }

        // JPanel calendarCell = new JPanel();
        // calendarCell.setLayout(new GridBagLayout());
        // calendarCell.setBackground(Color.CYAN);
        // JLabel test = new JLabel("test");
        // calendarCell.add(test);


        // JPanel calendarCell2 = new JPanel();
        // calendarCell2.setLayout(new GridBagLayout());
        // calendarCell2.setBackground(Color.CYAN);
        // JLabel test2 = new JLabel("test");
        // calendarCell2.add(test2);


        // JPanel calendarCell3 = new JPanel();
        // calendarCell3.setLayout(new GridBagLayout());
        // calendarCell3.setBackground(Color.CYAN);
        // JLabel test3 = new JLabel("test");
        // calendarCell3.add(test3);

        // calendarPanel.add(calendarCell, Layout.getGenerateCalenderCellConstraints());
        // calendarPanel.add(calendarCell2, Layout.getGenerateCalenderCellConstraints());
        // calendarPanel.add(calendarCell3, Layout.getGenerateCalenderCellConstraints());
        
        // calendarPanel.add(calendarGrid, Layout.getGenerateCalenderCellConstraints());
        
        
        // Modify border of last row
        curCalendarCell.setBorder(Theme.getTableLastRowBorder());
        
        thisPage.add(calendarPanel, Layout.getGenerateCalenderConstraints());

        return thisPage;



    }


    class GenerateScheduleAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // Generate the schedule
            GeneratePage.this.generateSchedule();
            // Regenerate this page
            GeneratePage.this.generateGeneratePage();
        }
    }


}
