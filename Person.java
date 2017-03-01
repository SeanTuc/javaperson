/*
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
 **/
public class Person {

    /**
     * @param args the command line arguments
     **/
    private String firstName, lastName, streetAddress, city, province, postalCode;
    private LocalDate birthDate;


    
    
    
    public Person(String fName, String lName, String stAddress, String town, String state,String zipCode, LocalDate dob) {
        
        setFirstName(fName);
        setLastName(lName);
        setStreetAddress(stAddress);
        setCity(town);
        setProvince(state);
        setPostalCode(zipCode);
        setBirthday(dob);
        
    }
    
    public void setFirstName(String firstName) {
        
        this.firstName = firstName;
    
    }
    /**
     * set and validate last name 
     * @param lastName 
     */
    public void setLastName(String lastName) {
        if(lastName.length()< 1)
            throw new IllegalArgumentException("Postal code must be 6 characters long");
        else
        this.lastName = lastName;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setBirthday(LocalDate dateOfBirth) {
        this.birthDate = dateOfBirth;
    }
    
            public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public LocalDate getBirthday() {
        return birthDate;
    }
    
    public int getYearBorn(){
        return birthDate.getYear();
    }
    
    /**
     * Changing the address to a new address
     * @param streets
     * @param citys
     * @param provinces
     * @param postalCodes 
     */
    public void changeAddress(String streets,String citys, String provinces, String postalCodes){
        setStreetAddress(streets);
        setCity(citys);
        setProvince(provinces);
        setPostalCode(postalCodes);
        
    }
    /*
    takes string and tests to see if it is 6 charcters long and that every odd one is a letter 
    and even is a number
    **/
    public void setPostalCode (String postal){
        if (postal.length() == 6)
        {
            String alphabit = "POIUYTREWQLKJHGFDSAMNBVCXZ";
            String numbers ="1234567890";
            int validate = 0;
            for(int i = 0; i < 5; i = i + 2){       
                if(alphabit.contains(postal.substring((i), (i+1)).toUpperCase()) & (numbers.contains(postal.substring((i+1), (i+2)).toUpperCase()))){
                    validate ++;
                }
                else{
                    throw new IllegalArgumentException("Postal code must be letter number letter number letter number");
                }       
            }
            if (validate == 3) {
                postalCode = postal.toUpperCase() ;
            }
        }
        else{
                    throw new IllegalArgumentException("Postal code must be 6 characters long");
                }    

    }//ends of setPostalCode
    
    
    
    /** 
    takes the global dob and calculates current age and returns that age
    */
    public int getAge (){
        int age = Period.between(birthDate,LocalDate.now()).getYears();
        
        return age;
    }
            
    /**
    combines 4 strings streetAddress city province postalCode" into one string and returns that string
    */
    public String getFullAddress(){
        return streetAddress + ", " + city + ", " + province + ", " + postalCode;  
    }
    
    /**
    Takes the class and returns the person's full name
    */

    public String toString(){
        return (getFirstName() +" "+getLastName());
    }

} //end of all
