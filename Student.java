/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w17oopassignment1;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Sean
 */
public class Student extends Person {
    private String course;
    private int studentNumber;
    private LocalDate yearEnroled;
    private boolean standings;
    private LocalDate birthday;
    
    public Student(String fName, String lName, String stAddress, String town, String state, String zipCode, LocalDate dob, String course, int studentNumber, LocalDate yearEnroled) {
        super(fName, lName, stAddress, town, state, zipCode, dob);
        this.standings = true;
        setBirthday(dob);
        setCourse(course);
        setStudentNumber(studentNumber);
        setYearEnroled(yearEnroled);
        
        
    } 

    public void setCourse(String course) {
        this.course = course;
    }
    
    /**
     * sets and validates student number is greater then 0
     * @param studentNumber 
     */
    public void setStudentNumber(int studentNumber) {
        if (studentNumber > 0){
            this.studentNumber = studentNumber;
        }
        else{
            throw new IllegalArgumentException(" " + studentNumber + " is not a valid student number ");
        }
    }

    public void setYearEnroled(LocalDate yearEnroled) {
        this.yearEnroled = yearEnroled;
    }
    
    /**
     * overrides super class set(dateOfBirth) and validates that the student is older then 14
     * and younger then 90 because old people should not go to school
     * @param dateOfBirth 
     */
    @Override
    public void setBirthday(LocalDate dateOfBirth) {
          if (Period.between(dateOfBirth,LocalDate.now()).getYears() > 14){
              if (Period.between(dateOfBirth,LocalDate.now()).getYears() < 90){
                  this.birthday = dateOfBirth;
              }
              else{
                  throw new IllegalArgumentException("Student is too old must be younger then 90, date of birth =" + dateOfBirth);
                  
              }
          }
          else{
                  throw new IllegalArgumentException("Student is not old enough, be older then 14, date of birth =" + dateOfBirth);
          }
          
    }
    

    public String getCourse() {
        return course;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public boolean inGoodStanding() {
        return standings;
    }

    public int getYearEnrolled(){
        return yearEnroled.getYear();
    }
    public int getYearsAtCollege(){
        return Period.between(yearEnroled,LocalDate.now()).getYears();
    }

    /**
     * overrides super class getBirthday
     * @return LocalDate
     */
    @Override
    public LocalDate getBirthday() {
        return birthday;
    }    
    
    public void suspendStudent(){
        standings = false;
    }
    
    public void reinstateStudent(){
        standings = true;
    }

    
    /**
     * overrides super toString and returns full name and student number
     * @return String
     */
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + ", student number is " + studentNumber;
    }
    
    
        
    
}
