import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Room - create different rooms for the game.
 *
 * This class is part of the "Hidden Treasure" game. 
 * "Hidden Treasure" is a very basic, CLI & text based adventure game.  
 * A "Room" represents one location for the game, that is 
 * connected to other rooms via exits. For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @by Hamood Jaffery
 * @date 20-01-21
 */

public class Room 
{
    private String name;
    private String description;
    private HashMap<String, Room> exits;
    private Items item;
    private boolean hasSecurity = false;
    boolean isItemTaken = false;
    
    /**
     * Provides a room description."Description" is something like "a kitchen" or
     * "a computing lab".
     * 
     */
    public Room(String name, String description, boolean hasSecurity) 
    {
        this.name = name;
        this.description = description;
        exits = new HashMap<>();
        item = Items.NONE;
        this.hasSecurity = hasSecurity;
    }

    /**
     * Define an exit for each room.
     * 
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * The short description of the room
     *
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west east
     */
    public String getLongDescription()
    {
         return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Return a string that describs room's exit, for instance
     * "Exits: north west".
     * 
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        
        for(String exit : keys) 
        {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the name of room that is reached.
     * If there is no room in that direction, it will return null.
     *
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    public void addItem(Items item)
    {
        this.item = item;
    }
    
    public Items getItem()
    {
        return item;
    }
    
    public boolean isItemTaken() {
        return isItemTaken;
    }
    
    public void setItemTaken() {
        isItemTaken = true;
        item = Items.NONE;
    }
    
    public boolean hasSecurity() {
        return hasSecurity;
    }
    
    public String getName() {
        return name;
    }
}

