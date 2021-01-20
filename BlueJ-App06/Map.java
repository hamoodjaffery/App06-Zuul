
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
        Room outside, theater, pub, lab, office, hidden, cafeteria, gym;
      
        // create the rooms
        outside = new Room("Outside", "outside the main entrance of the university", false);
        theater = new Room("Theater", "in the lecture theater", false);
        pub = new Room("Pub", "in the campus pub", false);
        lab = new Room("Lab", "in the computing lab", false);
        office = new Room("Office", "in the security office", true);
        hidden = new Room("Treasure", "in the hidden treasure room", false);
        cafeteria = new Room("Cafeteria", "in the cafteria", false);
        gym = new Room("Gym", "in the gym", false);
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub) ;
        
        theater.setExit("west",outside);
        theater.setExit("south",office);
        theater.addItem(Items.FOOD);

        pub.setExit("east", outside);
        pub.setExit("south", gym);
        pub.addItem(Items.WATER);
        
        lab.setExit("north", outside);
        lab.setExit("east", office);
        lab.setExit("south",hidden);
        lab.setExit("west",cafeteria);
        lab.addItem(Items.KEY);       

        office.setExit("west", lab);
        
        hidden.setExit("north", lab);
        hidden.addItem(Items.TREASURE);
        
        cafeteria.setExit("north", gym);
        cafeteria.setExit("east", lab);
        cafeteria.setExit("south", hidden);
        
        gym.setExit("north", pub);
        gym.setExit("south", cafeteria);
        

        startRoom = outside;
   }

   public Room getStart()
   {
       return startRoom;
   }
}
