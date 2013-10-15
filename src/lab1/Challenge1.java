package lab1;

import javax.swing.JOptionPane;

/**
 * The purpose of this challenge is to give you practice time using
 * Java Exception handling techniques.
 * <p>
 * Your challenge is to consider all the possible things that can go wrong
 * with this program and use exception handling where appropriate to prevent
 * the program from crashing. In addition you must display a friendly error
 * message in a JOptionPane and ask the user to try again. (Yes, this violates 
 * the Single Responsibility Principle, but for this lab, we'll overlook that.)
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Challenge1 {
    private static final int LAST_NAME_IDX = 1;
    private static String LAST_NAME_ERR;
    private static String lastName;
    private static String fullName;
    private static final String getFullNameMessage = "Enter full name";
    private static final String PARAM_ERR = "Entry cannot be null or zero length";

    public static void main(String[] args) {
        Challenge1 app = new Challenge1();
        
        
        fullName = getFullName(getFullNameMessage);
        lastName = app.extractLastName(fullName);
        if (lastName == null){
        do{
            fullName = getFullName(LAST_NAME_ERR);
            lastName = app.extractLastName(fullName);
            
        }while (lastName == null);
        }
        String msg = "Your last name is: " + lastName;
        JOptionPane.showMessageDialog(null, msg);
    }
    
    
    
    /*Gets full name entry from user.  Will throw exception if parameter is
     * null or zero length
     */
    public static String getFullName(String inputMessage){
        if (inputMessage == null || inputMessage.length()==0){
            throw new IllegalArgumentException(PARAM_ERR);
        }
    String name = JOptionPane.showInputDialog(inputMessage);
    return name;
    }
    
    
    
    /*Extracts the last name from the full name parameter that is passed
     * through.  Will throw exception if full name is null or zero length.
     * If the full name is only 1 word, the last name contains characters other
     * than letters, it will re-direct to getFullName method with a specialized
     * error message.  If there are more than 2 words entered, it will prompt 
     * the user to re-enter the last name.  If the re-entered last name does
     * not match the initial entry, it will re-direct to the getFullName 
     * method with a specialized error message.  If it matches, the last name
     * is set to that value.
     */
    public String extractLastName(String fullName) {
        if (fullName == null || fullName.length()==0){
            throw new IllegalArgumentException(PARAM_ERR);
        }
        //resets LAST_NAME_ERR to null
        LAST_NAME_ERR = null;
        
        //splits the fullName parameter into an array of words using the space
        //character.  
        String[] nameParts = fullName.split(" ");
        
        //sets the last name initially to the last word in array
        String extractedLastName = nameParts[nameParts.length-1];
        
        //if only one word in array, sets error message that last name cannot
        //be null or zero length
        if (nameParts.length < 2){
            LAST_NAME_ERR = "Last Name cannot be null or zero length.  "
                    + "Please re-enter full name";
            
        }
        //if two words in array, creates a character array of the last name and
        //confirms that all characters are letters with the exception of a
        //dash that could be used for a hyphenated last name
        if (nameParts.length == LAST_NAME_IDX+1){
        char [] letters = nameParts[LAST_NAME_IDX].toCharArray();
        for (Character c : letters){
        if (!Character.isLetter(c) && c != '-'){
            LAST_NAME_ERR = "Last name cannot contain anything but letters,spaces"
                    + "& hyphens."
                    + "  Please re-enter full name";
            
        }
        }
        }
        if (nameParts.length > LAST_NAME_IDX+1){
            String reEnteredLastName = JOptionPane.showInputDialog("You entered "
                    + fullName+ ".  Please "
                    + "re-enter only the last name to confirm.");
            if (reEnteredLastName.equals(nameParts[nameParts.length-1])){
            extractedLastName = nameParts[nameParts.length-1];
            }
            else if (reEnteredLastName.equals(nameParts[nameParts.length-2]+ " "+
                    nameParts[nameParts.length-1])){
                extractedLastName = nameParts[nameParts.length-2]+ " "+
                    nameParts[nameParts.length-1];
            }
            else{
            LAST_NAME_ERR = "The last name entered did not match initial entry."+
                    "Please re-enter full name";
            
        } }  
        if (LAST_NAME_ERR != null){
                
        return null;
        }else{
        
        return extractedLastName;
        }


    
}
}
