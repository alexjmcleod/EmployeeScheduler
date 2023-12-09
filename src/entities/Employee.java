package entities;

import entities.employee.*;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Employee implements Serializable {
    
    String name = "";
    ShiftTimePref shiftTimePref = new ShiftTimePref();
    ShiftLocationPref shiftLocationPref = new ShiftLocationPref();

    Map<DayOfWeek, LinkedHashMap<String, Boolean>> shiftsScheduled = new LinkedHashMap<DayOfWeek, LinkedHashMap<String, Boolean>>();
    
    // Constructors
    public Employee() {}

    public Employee(String newName) {
        name = newName;
    }

    public Boolean is_available(DayOfWeek dow, Clinic clinic, String shift) {

        
        // Check if working either of previous 2 shifts
        Map<String, String> previous_shift = new LinkedHashMap<>();
        previous_shift.put("DAY", "NIGHT");
        previous_shift.put("SWING", "DAY");
        previous_shift.put("NIGHT", "SWING");

        String one_shift_back = previous_shift.get(shift);
        DayOfWeek one_shift_back_dow = dow;
        if (one_shift_back.equals("NIGHT")) {
            one_shift_back_dow = one_shift_back_dow.minus(1);
        }

        String two_shifts_back = previous_shift.get(one_shift_back);
        DayOfWeek two_shifts_back_dow = dow;
        if (two_shifts_back.equals("SWING") || two_shifts_back.equals("NIGHT")) {
            two_shifts_back_dow = two_shifts_back_dow.minus(1);
        }
        
        if (shiftsScheduled.get(dow).get(shift) == true) {
            return false;
        }
        if (shiftsScheduled.get(one_shift_back_dow).get(one_shift_back) == true) {
            return false;
        }
        if (shiftsScheduled.get(two_shifts_back_dow).get(two_shifts_back) == true) {
            return false;
        }


        // Check if working either of next two shifts (possibly scheduled at another clinic)
        Map<String, String> next_shift = new LinkedHashMap<>();
        next_shift.put("DAY", "SWING");
        next_shift.put("SWING", "NIGHT");
        next_shift.put("NIGHT", "DAY");

        String one_shift_later = next_shift.get(shift);
        DayOfWeek one_shift_later_dow = dow;
        if (one_shift_later.equals("DAY")) {
            one_shift_later_dow = one_shift_later_dow.plus(1);
        }

        String two_shifts_later = next_shift.get(one_shift_later);
        DayOfWeek two_shifts_later_dow = dow;
        if (two_shifts_later.equals("DAY") || two_shifts_later.equals("SWING")) {
            two_shifts_later_dow = two_shifts_back_dow.plus(1);
        }

        if (shiftsScheduled.get(one_shift_later_dow).get(one_shift_later) == true) {
            return false;
        }
        if (shiftsScheduled.get(two_shifts_later_dow).get(two_shifts_later) == true) {
            return false;
        }


        // Check if restrictions on time
        if (shiftTimePref.getShiftTimePreference(dow, shift) == 0) {
            return false;
        }

        // Check if restrictions on location
        if (shiftLocationPref.getShiftLocationPreference(clinic.getIdName()) == 0) {
            return false;
        }

        return true;
    }

    
    
        // Map<DayOfWeek, LinkedHashMap<String, Boolean>> shiftsScheduled = new LinkedHashMap<DayOfWeek, LinkedHashMap<String, Boolean>>();
    
    public void clearShiftsScheduled() {

        // Loop over each day of week
        for (DayOfWeek day : DayOfWeek.values()) {

            shiftsScheduled.put(day, new LinkedHashMap<String, Boolean>());
            
            // Loop through all shifts
            List<String> shifts = new ArrayList<String>();
            shifts.add("DAY");
            shifts.add("SWING");
            shifts.add("NIGHT");
            
            for (String shift : shifts) {
                shiftsScheduled.get(day).put(shift, false);
            }
        
        }
    }

    public void scheduleForShift(DayOfWeek dow, String shift) {
        shiftsScheduled.get(dow).put(shift, true);
    }


    // Getters n setters
    public String getName() {
        return name;
    }

    public ShiftTimePref getShiftTimePrefs() {
        return shiftTimePref;
    }

    public ShiftLocationPref getShiftLocationPref() {
        return shiftLocationPref;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setShiftTimePreferences(ShiftTimePref newShiftTimePref) {
        shiftTimePref = newShiftTimePref;
    }

    public void setShiftLocationPreferences(ShiftLocationPref newShiftLocationPref) {
        shiftLocationPref = newShiftLocationPref;
    }


}
