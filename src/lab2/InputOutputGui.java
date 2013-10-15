package lab2;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * This class is responsible for all input and output in the program.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class InputOutputGui {
    private NameService nameService;
    private static final String PARAM_ERR = "Entry cannot be null or zero length";

    public InputOutputGui() {
        nameService = new NameService();
    }

    public void startConversation() {
        
        String fullName = getFullName("Enter full name:");
        String lastName = null;
        try {
            lastName = nameService.extractLastName(fullName);
            String msg = "Your last name is: " + lastName;
        JOptionPane.showMessageDialog(null, msg);
        } catch (Exception ex) {
            Logger.getLogger(InputOutputGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        //String msg = "Your last name is: " + lastName;
        //JOptionPane.showMessageDialog(null, msg);
        
    }
  
    
    public static String getFullName(String inputMessage){
        if (inputMessage == null || inputMessage.length()==0){
            throw new IllegalArgumentException(PARAM_ERR);
        }
    String name = JOptionPane.showInputDialog(inputMessage);
        if (name == null || name.length()==0){
            throw new IllegalArgumentException(PARAM_ERR);
        }
    return name;
    }
}
