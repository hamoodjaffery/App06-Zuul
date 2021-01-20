import java.util.HashMap;
/**  
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * by Hamood Jaffery
 * date 20-01-21
 */

public class CommandWords
{
   
    private HashMap<String, CommandWord> validCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        validCommands = new HashMap<>();
        
        for(CommandWord command : CommandWord.values()) 
        {
            if(command != CommandWord.UNKNOWN) 
            {
                validCommands.put(command.toString(), command);
            }
        }
    }

    /**
     * Find the CommandWord associated with a command word.
     * 
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        
        if(command != null) 
        {
            return command;
        }
        else 
        {
            return CommandWord.UNKNOWN;
        }
    }
    
    /**
     * Check whether a given String is a valid command word. 
     *
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }

    /**
     * Print all valid commands to System.out.
     */
    public void showAll() 
    {
        for(String command : validCommands.keySet()) 
        {
            System.out.print(command + "  ");
        }
        
        System.out.println();
    }
}
