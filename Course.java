/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w17oopassignment1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Sean
 */
public class Course {
    LocalTime startTime;
    String courseCode, courseName, description, room;
    DayOfWeek dayOfClass;
    int duration, maxNumberOfStudents, counter;
    Instructor prof;
    ArrayList<Student> students;

    public Course(String courseCode, String title, String description, String room, Instructor prof, DayOfWeek day, LocalTime time, int duration, int studentsNum) {
        setStartTime(time);
        setDayOfClass(day);

        setCourseName(title);
        setCourseCode(courseCode);
        setDescription(description);
        setRoom(room);
        setDuration(duration);
        setMaxNumberOfStudents(studentsNum);
        this.students = new ArrayList<>();
        counter = 0;
        setProf(prof);
}

    /**
     * adds student to the course
     * @param newStudent 
     */
    void addStudent(Student newStudent) {
  
        if (counter < maxNumberOfStudents){
            
            if(newStudent.inGoodStanding() == true){
                try{
                    students.add(newStudent);
                    counter ++;
                }
                catch (IllegalArgumentException e){}
            }
            else {
                throw new IllegalArgumentException("Student is in bad standings");
            }
        
        }
        else{
            throw new IllegalArgumentException("To many students");
        }
    }


       
    /**
     * checks to make sure start time of class is between 0800 and 1800
     * @param startTime 
     */
    
    void setStartTime(LocalTime startTime) {
     
        if( startTime.isAfter(LocalTime.of(7, 59))){
            if ( startTime.isBefore(LocalTime.of(18, 1))){
                this.startTime = startTime;
            }
            else{
                throw new IllegalArgumentException("Course start time must be no later than 6 pm");
            }
                
        } 
        else{
            throw new IllegalArgumentException("Class start time must be 8 at the earliest not: " + startTime);
        }
    }

    /**
     * check to make sure it is not a weekend then sets dayOfClass to day
     * @param dayOfClass 
     */
    public void setDayOfClass(DayOfWeek dayOfClass) {
        
        if (dayOfClass != DayOfWeek.SUNDAY & dayOfClass != DayOfWeek.SATURDAY){ 
            this.dayOfClass = dayOfClass;
        }
        else{
            throw new IllegalArgumentException("Day must not be on the weekend: " + dayOfClass);
        }
    }

    
    /**
     * set prof for course and checks if the prof can teach the course
     * @param prof 
     */
    public void setProf(Instructor prof) {
     
        if (prof.canTeach(this.courseCode)){
                this.prof = prof;
           }
        else {
            throw new IllegalArgumentException("course must be on teacher able to teach list");
        }
    }
    

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * verifies that the max number of students is not out of parameters of 0-50
     * @param maxNumberOfStudents 
     */
    public void setMaxNumberOfStudents(int maxNumberOfStudents) {
        if (maxNumberOfStudents > 0 & maxNumberOfStudents <= 50){
            this.maxNumberOfStudents = maxNumberOfStudents;
        }
        else{
            throw new IllegalArgumentException("Course start time must be no later than 6 pm");
        }
    }

    
    
    ///////////////////// GETTER /////////////////////////

    public LocalTime getStartTime() {
        return startTime;
    }

    public DayOfWeek getDayOfClass() {
        return dayOfClass;
    }

    public Instructor getProf() {
        return prof;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public String getRoom() {
        return room;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public int getDuration() {
        return duration;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }
    
    /**
     * Gets the number of students in course 
     * @return  
     */
    public int getNumberOfStudentsEnrolled(){
        return students.size();
    }
    
    
    
    /**
     * returns a class list of all students names and student numbers
     * @return 
     */
    
    public String showClassList(){
        String list = "";
        
       for (int i = 0; i < students.size(); i ++){
        list = (list + students.get(i).toString() + "%n");
        }
       return String.format(list);
        
    }
    
    /**
     * returns the average years the students in a course spent at the college
     * @return 
     */
    public double averageStudentTimeAtCollege(){
        if (students.size() != 0){
        double average = 0;
        for (int i = 0; i < students.size(); i ++){
        average = (average + students.get(i).getYearsAtCollege());
        }
        return average/(students.size());
        }
        else 
            return 0.0;
    }

    /**
     * returns course name and course code;
     * @return 
     */
    public String toString(){
        return courseName + " " + courseCode;
    }
}
    


