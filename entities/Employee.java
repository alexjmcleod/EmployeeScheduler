package entities;

import entities.employee.*;
import java.io.Serializable;


public class Employee implements Serializable {
    
    String name = "";
    ShiftPref shiftPref = new ShiftPref();
    
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

    public ShiftPref getShiftPrefs() {
        return shiftPref;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setShiftTimePreferences(ShiftPref newShiftPref) {
        shiftPref = newShiftPref;
    }


}
