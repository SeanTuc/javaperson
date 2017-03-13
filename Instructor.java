/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w17oopassignment1;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;


/**
 *
 * @author Sean
 */
public class Instructor extends Person {
    private int employeeNum;
    private LocalDate hireDate;
    private LocalDate birthday;
    private ArrayList<String> teachableCourse;
    private String courseCode;
    
    
    public Instructor(String fName, String lName, String stAddress, String town, String state, String zipCode, LocalDate dob, int employeeNum, LocalDate hireDate) {
        super(fName, lName, stAddress, town, state, zipCode, dob);
        this.teachableCourse = new ArrayList<>();  
        setBirthday(dob);
        setCourseCode(courseCode);
        setHireDate(hireDate);
        setEmployeeNum(employeeNum);
        
        
    }  
    
    ////////////////// Set Methods////////////////////////////

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    
    /**
     * validates that the hire date is within 80 years because we don't like 90 year olds teaching
     * and also that they are not hired in the future
     * @param hireDate 
     */
    public void setHireDate(LocalDate hireDate) {
    if (hireDate.isBefore(LocalDate.now())){
                  if (Period.between(hireDate,LocalDate.now()).getYears() < 80){
                      this.hireDate = hireDate;
                  }
                  else{
                      throw new IllegalArgumentException("Instructor must be retired before 80 years, hire date= " + hireDate);

                  }
    }
    else{
        throw new IllegalArgumentException("Instructor can not be hired in the future, hire =" + hireDate);
    }        
}
    
    /**
     * overrides the super date of birth and validates that the instructor is older then 14 
     * but younger then 110  
     * @param dateOfBirth 
     */    
    @Override
    public void setBirthday(LocalDate dateOfBirth) {
          if (Period.between(dateOfBirth,LocalDate.now()).getYears() > 14){
              if (Period.between(dateOfBirth,LocalDate.now()).getYears() < 110){
                  this.birthday = dateOfBirth;
              }
              else{
                  throw new IllegalArgumentException("Instructor is too old must be younger then 110, date of birth =" + dateOfBirth);
                  
              }
          }
          else{
                  throw new IllegalArgumentException("Instructor is not old enough, be older then 18, date of birth =" + dateOfBirth);
          }
    }
    
    
    public void addTeachableCourse(String courseCode){
        teachableCourse.add(courseCode.toUpperCase());
    }
    
 
    public void setEmployeeNum(int employeeNumber) {
        this.employeeNum = employeeNumber;
    }
    
    

///////////////////////////////////  Get Methods/////////////////////////

    
    public String getCourseCode() {
        return courseCode;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public ArrayList<String> getTeachableCourses() {
        return teachableCourse;
    }

    public int getEmployeeNum() {
        return employeeNum;
    }
    
    
    
///////////////////// Other /////////////////////////////
    /**
     * gets the years at the college
     * @return int 
     */
    public int getYearsAtCollege(){
        int years = Period.between(hireDate,LocalDate.now()).getYears();
        
        return years;
    }    
    
    /**
     * checks to see if inputted string is contained within teachable array
     * @param courseCode
     * @return boolean 
     */
    public boolean canTeach(String courseCode){
        if (teachableCourse.contains(courseCode.toUpperCase()))
            return true;
        else
            return false;
    }
    /**
     * returns the contents of the array in a String with out the square brackets
     * @return String 
     */
    public String listOfSubjectsCertifiedToTeach(){
        return teachableCourse.toString().replace("[", "").replace("]", "");
    }
    
    
}
