package entities;

import entities.employee.*;
import java.io.Serializable;


public class Employee implements Serializable {
    
    String name = "";
    ShiftTimePref shiftTimePref = new ShiftTimePref();
    ShiftLocationPref shiftLocationPref = new ShiftLocationPref();
    
    // Constructors
    public Employee() {}

    public Employee(String newName) {
        name = newName;
    }

    // public Employee(String newName, ShiftPref newShiftPref) {
    //     name = newName;
    //     shiftPref = newShiftPref;
    // }


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
