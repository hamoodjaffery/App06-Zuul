
/**
 * This is map class creates an instance of the Game class.
 *
 * @by Hamood Jaffery
 * @date 20-01-21
 */

public class Map
{
    private Room startRoom;
    
    public Map()
    {
        createRooms();
        
    }
    
    /**
    * Create all the rooms and link their exits together.
    */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office, hidden;
      
        // create the rooms
        outside = new Room("Outside", "outside the main entrance of the university", false);
        theater = new Room("Theater", "in a lecture theater", false);
        pub = new Room("Pub", "in the campus pub", false);
        lab = new Room("Lab", "in a computing lab", false);
        office = new Room("Office", "in the computing admin office", true);
        hidden = new Room("Treasure", "in the hidden treasure room", false);
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);
        theater.addItem(Items.FOOD);

        pub.setExit("east", outside);
        pub.addItem(Items.WATER);
        
        lab.setExit("north", outside);
        lab.setExit("east", office);
        lab.setExit("south",hidden);
        lab.addItem(Items.KEY);       

        office.setExit("west", lab);
        
        hidden.setExit("north", lab);
        hidden.addItem(Items.TREASURE);

        startRoom = outside;  // start game outside
   }

   public Room getStart()
   {
       return startRoom;
   }
}
