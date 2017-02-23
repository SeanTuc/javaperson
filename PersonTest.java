/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w17oopassignment1;

/**
 *
 * @author Sean
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.time.LocalDate;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JWright
 */
public class PersonTest {
    
    Person validPerson;
    
    public PersonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        validPerson = new Person("Anita", "Job", "31 Employment Ave", "Happivale", "ON","T3T2B2", LocalDate.of(2000, Month.MAY, 10));
    }
    
    @After
    public void tearDown() {
    }

    
  
    /**
     * Test of getYearBorn method, of class Person.
     */
    @Test
    public void testInvalidPerson() {
        System.out.println("Test creation of invalid Person");
        try
        {
            Person invalidPerson = new Person("Anita", "Job", "31 Employment Ave", "Happivale", "ON","T32B2", LocalDate.of(2000, Month.MAY, 10));    
            fail("the invalid postal code should have thrown an exception");
        }
        catch (IllegalArgumentException e)
        {            
        }
    }
  
    /**
     * Test of getYearBorn method, of class Person.
     */
    @Test
    public void testGetYearBorn() {
        System.out.println("getYearBorn");
        int expResult = 2000;
        int result = validPerson.getYearBorn();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAge method, of class Person.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        int expResult = 16;
        int result = validPerson.getAge();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPostalCode method, of class Person.
     */
    @Test
    public void testSetPostalCodeValid() {
        System.out.println("setPostalCode");
        String postal = "B3B7H7";
        validPerson.setPostalCode(postal);
        assertEquals(postal, validPerson.getPostalCode());
    }
    
/**
     * Test of setPostalCode method, of class Person with invalid inputs.
     */
    @Test
    public void testSetPostalCodeInvalid() {
        System.out.println("setPostalCode");
        String postal = "B3B7H";
        try
        {
            validPerson.setPostalCode(postal);
            fail("setPostalCode should have thrown an exception");
        }
        catch (IllegalArgumentException e)
        {
             
        }
    }
    

    /**
     * Test of changeAddress method, of class Person.
     */
    @Test
    public void testChangeAddress() {
        System.out.println("changeAddress");
        String street = "86 Kingsman Way";
        String city = "Edenvale";
        String province = "ON";
        String postalCode = "K9LW2S";
        validPerson.changeAddress(street, city, province, postalCode);
        assertEquals(validPerson.getFullAddress(), "86 Kingsman Way, Edenvale, ON, K9LW2S");
    }

    /**
     * Test of getFirstName method, of class Person.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "Anita";
        String result = validPerson.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class Person.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "Job";
        String result = validPerson.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStreetAddress method, of class Person.
     */
    @Test
    public void testGetStreetAddress() {
        System.out.println("getStreetAddress");
        String expResult = "31 Employment Ave";
        String result = validPerson.getStreetAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCity method, of class Person.
     */
    @Test
    public void testGetCity() {
        System.out.println("getCity");
        String expResult = "Happivale";
        String result = validPerson.getCity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProvince method, of class Person.
     */
    @Test
    public void testGetProvince() {
        System.out.println("getProvince");
        String expResult = "ON";
        String result = validPerson.getProvince();
        assertEquals(expResult, result);
    }

    
    /**
     * Test of getPostalCode method, of class Person.
     */
    @Test
    public void testGetPostalCode() {
        System.out.println("getPostalCode");
        String expResult = "T3T2B2";
        String result = validPerson.getPostalCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBirthdate method, of class Person.
     */
    @Test
    public void testGetBirthdate() {
        System.out.println("getBirthdate");
        LocalDate expResult = LocalDate.of(2000, Month.MAY, 10);
        LocalDate result = validPerson.getBirthdate();
        assertEquals(expResult, result);
    }
    
}