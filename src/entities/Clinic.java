package entities;

import java.io.Serializable;
import entities.clinic.*;
import java.time.DayOfWeek;

public class Clinic implements Serializable {
    
    String name = "";
    ShiftsRequired shiftsRequired = new ShiftsRequired();


    public Clinic() {}

    public Clinic(String newName) {
        name = newName;
    }


    public Integer getNumEmployeesRequired(DayOfWeek dow, String shift) {

        return shiftsRequired.getNumEmployeesRequired(dow, shift);
    }



    // Getters and setters
    public String getName() {
        return name;
    }

    public String getIdName() {
        String idName = name.replaceAll("\\s", "");
        return idName.toUpperCase();
    }

    public void setName(String newName) {
        name = newName;
    }

    public ShiftsRequired getShiftsRequired() {
        return shiftsRequired;
    }

}
