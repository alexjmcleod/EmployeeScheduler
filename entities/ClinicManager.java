package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.*;

public class ClinicManager implements Serializable  {
    
    ArrayList<Clinic> clinicList = new ArrayList<Clinic>();

    public ClinicManager() {
        this.loadClinics();
    }

    public void loadClinics() {

        try {
            FileInputStream inputStream = new FileInputStream("data/ClinicData.ser");
            ObjectInputStream objectStream = new ObjectInputStream(inputStream);

            Object m = objectStream.readObject();

            @SuppressWarnings("unchecked")
            ArrayList<Clinic> e = (ArrayList<Clinic>) m;

            clinicList = e;

            objectStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("ClinicData.ser not found. Initializing empty list.");
            clinicList = new ArrayList<Clinic>();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void saveClinicList() {
        try {
            FileOutputStream outputStream = new FileOutputStream("data/EmployeeData.ser");
            ObjectOutputStream objectStream = new ObjectOutputStream(outputStream);

            objectStream.writeObject(clinicList);

            objectStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Clinic> getClinicList() {
        return clinicList;
    }

    public void saveClinic(Clinic clinic) {
        clinicList.add(clinic);
        this.saveClinicList();
    }

    public void deleteClinic(Clinic clinic) {
        clinicList.remove(clinic);
        this.saveClinicList();
    }

    public void updateClinic(Clinic clinic) {
        this.saveClinicList();
    }


}
