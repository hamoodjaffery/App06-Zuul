/**
 * Representations for all the valid command words for the game
 * along with a string in a particular language.
 * 
 * by Hamood Jaffery
 * date 20-01-21
 */
public enum CommandWord
{
    GO("go"), 

    QUIT("quit"), 

    HELP("help"), 

    PEEK("peek"),

    TAKE("take"), 

    SEARCH("search"), 

    UNKNOWN("?");

    
    private String commandString;

    /**
     * Initialise with the corresponding command string.
     *
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }

    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
}
