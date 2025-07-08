package th.co.ais.ipfm.util;

public class ValueTypeHelper 
{
    public static boolean isEmptyValue (Object input) // DMAP Comment : Dead Code Detected - The Following Method has no reference isEmptyValue
    {
        boolean result = false;
        
        if (input == null)
        {
            result = true;
        }
        else if (input.getClass () == String.class)
        {
            String strInput = (String) input;
            
            if (strInput.trim ().length () == 0)
            {
                result = true;
            }
        }
        
        return result;
    }
}

