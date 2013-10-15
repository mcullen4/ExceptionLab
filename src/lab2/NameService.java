package lab2;

import javax.swing.JOptionPane;

/**
 * This class provides various services relating to name manipulation.
 * No output should be performed here.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class NameService {
    private static final int FIRST_NAME_IDX = 0;
    private static final int LAST_NAME_IDX = 1;
    private static String LAST_NAME_ERR;
    private static final String PARAM_ERR = "Entry cannot be null or zero length";
    
    /**
     * Finds and returns the last name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the last name
     */
       public String extractLastName(String fullName) throws Exception {
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
        //if more than two words in array, asks the user to confirm the last name
        
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
        
        //if there is an error message in LAST_NAME_ERR, returns a null value so
        //that the loop continues for proper entry
        if (LAST_NAME_ERR != null){
                
        return null;
        
        //if there is no error message, returns extracted last name
        }else{
        
        return extractedLastName;
        }
       }
    /**
     * Finds and returns the first name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the first name
     */
    public String extractFirstName(String fullName) throws Exception {
        String[] nameParts = fullName.split(" ");
        return nameParts[FIRST_NAME_IDX];
    }

    /**
     * Gets the length of a name.
     * 
     * @param name - any full name or part of a name.
     * @return the length of the name or part.
     */
    public int getNameLength(String name) throws Exception{
        return name.length();
    }
    
}
