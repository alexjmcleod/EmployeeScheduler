package entities;

import java.io.Serializable;

public class Clinic implements Serializable {
    
    String name = "";

    public Clinic() {}

    public Clinic(String newName) {
        name = newName;
    }


    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

}
