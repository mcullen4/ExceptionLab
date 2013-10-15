/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michele
 */
public class IllegalLastNameException extends Exception {
   private Logger log =
            Logger.getLogger("lab3.IllegalLastNameArgument"); 
   
   
   public IllegalLastNameException(){
       
       super( "Illegal Last Name Entry" );
       log.log(Level.INFO, "Illegal Last Name Entry");
   }
   
   public IllegalLastNameException(String message){
       super(message);
   }
   
   
}
