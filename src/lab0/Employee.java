package lab0;

import java.util.Date;

/**
 * In this challenge you need to address the probability that at some
 * point the arguments to method parameters may not be valid. 
 * <p>
 * For example, String arguments may be null or empty; other objects may be 
 * null; or primitive numbers may be out of acceptable range.
 * <p>
 * You need to validate ALL method parameters to make sure any and all 
 * arguments are valid. The only exception is when any argument is acceptable 
 * based on requirements. Fix the code below using if logic to validate
 * method arguments and throw IllegalArgumentException or a custom
 * exception if the validation fails.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Employee {
    public static final int MAX_VACATION_DAYS = 28;
    private final String VAC_ERR = "Vacation Days Not Within Allowable Range";
    private final String FIRST_NAME_ERR = "Invalid First Name Entry";
    private final String LAST_NAME_ERR = "Invalid Last Name Entry";
    private final String SSN_ERR = "Invalid Social Security Number";
    private final String DATE_ERR = "Invalid Date";
    private String firstName;
    private String lastName;
    private String ssn;
    private Date hireDate;
    private int daysVacation;

    public Employee() {
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        hireDate = new Date();
        daysVacation = 0;
    }

    public Employee(String firstName, String lastName, String ssn, Date hireDate, int daysVacation) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setSsn(ssn);
        this.setHireDate(hireDate);
        this.setDaysVacation(daysVacation);
        
        
        
    }
    
    /**
     * getter method for daysVacation
     * @return integer representing number of days of vacation
     */
    public int getDaysVacation() {
        return daysVacation;
    }

    
    
    /**
     * Setter method for days vacation.  Will throw exception for negative
     * number or number greater than the specified maximum days
     * @param daysVacation
     */
    public void setDaysVacation(int daysVacation) {
        if (daysVacation < 0 || daysVacation > MAX_VACATION_DAYS){
            throw new IllegalArgumentException(VAC_ERR);
        }
        this.daysVacation = daysVacation;
    }

    /**
     * Getter method for the first name of the employee
     * @return String representing the first name of the employee
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter method for first name of employee.  Requires a String.  Will
     * throw exception for null value, length of 0 or if a character is not
     * a letter or a space
     * @param firstName
     */
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length()==0){
            throw new IllegalArgumentException(FIRST_NAME_ERR);
        }
        char [] letters = firstName.toCharArray();
        for (Character c : letters){
        if (!Character.isLetter(c) && !Character.isSpaceChar(c)){
            throw new IllegalArgumentException( FIRST_NAME_ERR);
        }
               
        }
        
        this.firstName = firstName;
    }

    /**
     * Getter method for hire date of employee
     * @return Date representing the hire date
     */
    public Date getHireDate() {
        return hireDate;
    }

    /**
     * Setter method for hire date of employee.  Will throw an exception if the 
     * date is over 50 years ago or more than 1 year in the future
     * @param hireDate
     */
    public void setHireDate(Date hireDate) {
        if (hireDate == null){
            throw new IllegalArgumentException(DATE_ERR);
        }
        Date currentDate = new Date();
        if (hireDate.getYear() < (currentDate.getYear()-50) || 
                hireDate.getYear() > (currentDate.getYear()+1)){
            throw new IllegalArgumentException(DATE_ERR);
    }
        this.hireDate = hireDate;
    }

    /**
     *Getter method for last name of employee
     * @return string representing last name of employee
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *Setter method for last name of employee.  Will throw an exception if 
     * parameter is null, has a length of 0 or if a character within the string
     * is not a letter or space character
     * @param lastName
     */
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length()==0){
            throw new IllegalArgumentException(LAST_NAME_ERR);
        }
        char [] letters = lastName.toCharArray();
        for (Character c : letters){
        if (!Character.isLetter(c) && !Character.isSpaceChar(c)){
            throw new IllegalArgumentException(LAST_NAME_ERR);
        }
        }
            
        this.lastName = lastName;
    }

    /**
     *Getter method for social security number
     * @return employee's social security number
     */
    public final String getSsn() {
        return ssn;
    }

    /**
     * Setter method for employee social security number.  Will throw an 
     * exception if length is not equal to 11, or if the format entered is 
     * not equal to NNN-NN-NNNN where N represents a digit between 0 and 9.
     * @param ssn
     */
    public void setSsn(String ssn) {
        if (ssn==null || ssn.length()!=11){
            throw new IllegalArgumentException(SSN_ERR);
        }
        char [] ssnArray = ssn.toCharArray();
        for(int i=0;i<3;i++){
        if(!Character.isDigit(ssnArray[i])) {
            throw new IllegalArgumentException(SSN_ERR);
        }
        }
        if (ssnArray[3] !='-' || ssnArray[6] != '-'){
            throw new IllegalArgumentException(SSN_ERR);
        }
        for(int j=0;j>3 && j<6;j++){
        if (!Character.isDigit(ssnArray[j])){
            throw new IllegalArgumentException(SSN_ERR);
        }
        }
        for(int k=0;k>6 && k<11;k++){
        if (!Character.isDigit(ssnArray[k])){
            throw new IllegalArgumentException(SSN_ERR);
        }
        }
        this.ssn = ssn;
    }
    
    public static void main(String[] args)  {
        
        Date hireDate = new Date();
        //hireDate.setYear(1940);
        
        Employee employee;
        employee = new Employee("Michele", "Mc Cullen", "999-99-9999",hireDate,20);
        //System.out.println(employee.getFirstName());
    }
}
