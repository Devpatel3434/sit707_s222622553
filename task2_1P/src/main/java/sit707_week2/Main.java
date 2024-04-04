package sit707_week2;

import java.io.IOException;

/**
 * Hello world!
 * @author DEV PATEL
 */
public class Main 
{
    public static void main( String[] args )
    {
        /*try {
         
			SeleniumOperations.officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
    	try {
            // Choose which operation to execute
            int choice = 2; // Change this to 1 or 2 based on your preference
            
            if (choice == 1) {
                // Execute operation for Officeworks registration page
                SeleniumOperations.officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");
            } else if (choice == 2) {
                // Execute operation for Parabank registration page
                SeleniumOperations.Parabank_registration_page("https://parabank.parasoft.com/parabank/register.htm");
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (IOException e) {
            // Print stack trace if an IOException occurs
            e.printStackTrace();
        }
        
    }
    
    
}
