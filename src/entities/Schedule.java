package entities;
import java.util.*;

import entities.employee.ShiftLocationPref;
import entities.employee.ShiftTimePref;

import java.io.*;
import java.time.DayOfWeek;

public class Schedule {
    
    List<Employee> employees = new ArrayList<Employee>();
    List<Clinic> clinics = new ArrayList<Clinic>();

    Map<DayOfWeek, LinkedHashMap<Clinic, LinkedHashMap<String, List<String>>>> schedule = new LinkedHashMap<DayOfWeek, LinkedHashMap<Clinic, LinkedHashMap<String, List<String>>>>();

    public Schedule() {

        this.loadEmployees();
        this.loadClinics();

    }


    public Map<DayOfWeek, LinkedHashMap<Clinic, LinkedHashMap<String, List<String>>>> generateSchedule() {

        // DS:
        // DayOfWeek: {
        //      "CLINIC": {
        //           "SHIFT": ["NAME1", "NAME2", ... , "NAMEN"]
        //      }
        // }
        
        
        // Reset the shifts scheduled so we can track for this new schedule
        for (Employee employee : employees) {
            employee.clearShiftsScheduled();
        }

        this.createEmptySchedule();


        // Loop through each day of week
        for (Map.Entry<DayOfWeek, LinkedHashMap<Clinic, LinkedHashMap<String, List<String>>>> dayOfWeek : schedule.entrySet()) {
            
            // Loop through each clinic
            for (Map.Entry<Clinic, LinkedHashMap<String, List<String>>> clinic : dayOfWeek.getValue().entrySet()) {

                // Loop through each shift
                for (Map.Entry<String, List<String>> shift : clinic.getValue().entrySet()) {

                    Integer numEmployeesRequired = clinic.getKey().getNumEmployeesRequired(dayOfWeek.getKey(), shift.getKey());
                    Integer numEmployeesScheduled = 0;
              
                    // Generate list of possible employees 
                    List<Employee> candidates = new ArrayList<>();
                    for (Employee employee : employees) {
                        
                        if (employee.is_available(dayOfWeek.getKey(), clinic.getKey(), shift.getKey())) {
                            candidates.add(employee);
                        }
                    }

                    // While scheduled < required
                    while (numEmployeesScheduled < numEmployeesRequired) {
                        // Pick employee
                        if (candidates.size() > 0) {
                            
                            Map<Employee, Integer> preferences = new LinkedHashMap<>();
                            // Calculate preferene for time/location for each candidate
                            for (Employee employee : candidates) {
                                
                                Integer shiftTimePreference = employee.getShiftTimePrefs().getShiftTimePreference(dayOfWeek.getKey(), shift.getKey());
                                
                                Integer shiftLocationPreference = employee.getShiftLocationPref().getShiftLocationPreference(clinic.getKey().getIdName());
                                

                                Integer preference = (shiftTimePreference + shiftLocationPreference) / 2;

                                preferences.put(employee, preference);

                            }

                            // Find max preference
                            Integer max = 0;
                            for (Employee employee : preferences.keySet()) {
                                if (preferences.get(employee) > max) {
                                    max = preferences.get(employee);
                                }
                            }

                            // Create list of employee with max preference
                            List<Employee> candidates_narrowed = new ArrayList<>();
                            for (Employee employee : preferences.keySet()) {
                                if (preferences.get(employee) == max) {
                                    candidates_narrowed.add(employee);
                                }
                            }

                            // Pick random employee from candidates_narrowed
                            Random rand = new Random();
                            Integer upperbound = candidates_narrowed.size();
                            Integer rand_index = rand.nextInt(upperbound);

                            // Get employee info
                            Employee employeePicked = candidates_narrowed.get(rand_index);
                            String employeeName = employeePicked.getName();
                            
                            // Add employee to schedule
                            schedule.get(dayOfWeek.getKey()).get(clinic.getKey()).get(shift.getKey()).add(employeeName);

                            // Add this shift to employee's shifts
                            employeePicked.scheduleForShift(dayOfWeek.getKey(), shift.getKey());

                            // Remove employee from candidates
                            candidates.remove(employeePicked);
                        } else {
                            System.out.println("Not enough employees to complete schedule.");
                        }
                        numEmployeesScheduled = numEmployeesScheduled + 1;
                    }

                }

                    
            }

        }






        return schedule;
    }


    // Map<DayOfWeek, LinkedHashMap<String, LinkedHashMap<String, List<String>>>> 

    void createEmptySchedule() {

        // Loop through all DayOfWeek values (MON-SUN)
        for (DayOfWeek day : DayOfWeek.values()) {

            schedule.put(day, new LinkedHashMap<Clinic, LinkedHashMap<String, List<String>>>());
            
            // Loop through all clinics
            for (Clinic clinic : clinics) {

                schedule.get(day).put(clinic, new LinkedHashMap<String, List<String>>());

                // Loop through all shifts
                List<String> shifts = new ArrayList<String>();
                shifts.add("DAY");
                shifts.add("SWING");
                shifts.add("NIGHT");

                for (String shift : shifts) {

                    schedule.get(day).get(clinic).put(shift, new ArrayList<String>());

                }
                




            }


        }


        
    }






    void loadEmployees() {
        try {
            FileInputStream inputStream = new FileInputStream("data/EmployeeData.ser");
            ObjectInputStream objectStream = new ObjectInputStream(inputStream);

            Object m = objectStream.readObject();

            @SuppressWarnings("unchecked")
            List<Employee> e = (ArrayList<Employee>) m;

            employees = e;

            objectStream.close();


        } catch (FileNotFoundException err) {
            System.out.println("EmployeeData.ser not found. Cannot generate schedule.");
        } catch (IOException err) {
            err.printStackTrace();
        } catch (ClassNotFoundException err) {
            err.printStackTrace();
        }
        
    }

    void loadClinics() {

        try {
            FileInputStream inputStream = new FileInputStream("data/ClinicData.ser");
            ObjectInputStream objectStream = new ObjectInputStream(inputStream);

            Object m = objectStream.readObject();

            @SuppressWarnings("unchecked")
            List<Clinic> e = (ArrayList<Clinic>) m;

            clinics = e;

            objectStream.close();
        
        } catch (FileNotFoundException err) {
            System.out.println("ClinicData.ser not found. Cannot generate schedule.");
        } catch (IOException err) {
            err.printStackTrace();
        } catch (ClassNotFoundException err) {
            err.printStackTrace();
        }

    }





}
