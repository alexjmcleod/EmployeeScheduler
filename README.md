# EmployeeScheduler

This application can be used to populate an employee schedule based on a user-selected set of parameters. 

### Clinics
**Name:** The name of the clinic.
**Shift Requirements:** A grid of text fields, where each field represents a shift (day, swing, or night) for a particular day of the week (Mon - Sun). The integer within a field represents the number of doctors that are required for that shift.


### Employees
**Name:** The name of the employee.
**Shift Time Preferences:** A grid of text fields, where each field represents a shift (day, swing, or night) for a particular day of the week (Mon - Sun). The integer within a field represents the employee's availability and preference for being scheduled for that shift. A value of 0 indicates the employee is not available. Remaining valid values are 1, 2 or 3 where 1 represents low preference and 3 represents high preference.
**Shift Location Preferences:** A list of text fields, where each field represents a clinic that needs to be staffed. The integer within a field represents the employee's availability and preference for being scheduled at that location. A value of 0 indicates the employee is not available. Remaining valid values are 1, 2 or 3 where 1 represents low preference and 3 represents high preference.


### Generate
The generate page is where the schedule is generated and displayed. Click the "Generate Schedule" button to generate a new schedule.

The scheduling algorithm works as follows:
- A list of available employees is generated. An employee is available if they:
    - Are not scheduled to work either of the two previous shifts.
    - Are not scheduled to work either of the next two shifts.
    - Do not have a 0 set for the Shift Time Preference.
    - Do not have a 0 set for the Shift Location Preference.
- The list of available employees is sorted based on preference. Preference is calculated using the average of the Shift Time Preference and Shift Location Preference that the employee has set in their profile. 
- The employee with the highest preference for the shift is scheduled. In the case that there are multiple employees with equal preference for the shift, a random employee from the pool of employees with highest preference is picked. 
- If there are no employees available to fill a slot based on the rules above, the application labels the slot as "No Employee Available". 