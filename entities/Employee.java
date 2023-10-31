package entities;

import java.io.Serializable;

public class Employee implements Serializable {
    
    String name;
    

    // Constructors
    public Employee(String newName) {
        name = newName;
    }


    // Getters n setters
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }


}
