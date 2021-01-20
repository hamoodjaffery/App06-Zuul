/** This is the main class of the game "Hidden Treasure". 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @by Hamood Jaffery
 * @date 20-01-21
 * 
 */

public class Game 
{
    private Map map;
    private Player player;
    private boolean finished = false;
    private Parser parser;
    private Room currentRoom;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        parser = new Parser();
        map = new Map();
        currentRoom = map.getStart();
        player = new Player("Hamood");
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        while (! finished) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) 
        {
            case UNKNOWN:
            System.out.println("I don't know what you mean...");
            break;

            case HELP:
            printHelp();
            break;

            case GO:
            goRoom(command);
            break;

            case SEARCH:
            searchRoom(command);
            break;                

            case TAKE:
            takeItem();
            break;

            case PEEK:
            peekRoom(command);
            break;

            case QUIT:
            wantToQuit = quit(command);
            break;
        }
        return wantToQuit || finished;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * 
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) 
        {
            System.out.println("There is no door!");
        }
        else 
        {
            currentRoom = nextRoom;

            if (player.getHealth() >= 10) {
                player.move();
                player.print();
                System.out.println(currentRoom.getLongDescription());   
                if (nextRoom.hasSecurity()) {
                    System.out.println("Security caught you. Game over.");
                    finished = true;
                }
            } else {
                System.out.println("You died of exhaustion. Game over.");
                finished = true;
            }

            if (player.hasTreasure()) {
                if(currentRoom.getName().equals("Outside")) {
                    System.out.println("You have successfully found treasure and escaped.");
                    finished = true;
                }
            }
        }
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void searchRoom(Command command) 
    {
        System.out.println("Items found: " + currentRoom.getItem());
    } 

    private void takeItem()
    {
        Items item = currentRoom.getItem();
        if (!currentRoom.isItemTaken()) {
            player.addItem(item);
            currentRoom.setItemTaken();
        }
        else {
            System.out.println("No more items to consume.");
        }
    }

    private void peekRoom(Command command) {
        String direction = command.getSecondWord();
        Room roomToPeek = currentRoom.getExit(direction);
        player.peek(roomToPeek);
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
}
