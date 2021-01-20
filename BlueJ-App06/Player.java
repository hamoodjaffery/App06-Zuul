import java.util.ArrayList;

/**
 * This player class creates a player for the game.
 *
 * by Hamood Jaffery
 * date 20-01-21
 */
public class Player
{
    private String name;

    private int health;
    private int score;
    private int moves;
    private int peekingPower;
    private boolean hasKey;
    private boolean hasFoundTreasure;

    private ArrayList<Items> items;

    public Player(String name)
    {
        this.name = name;
        items = new ArrayList<Items>();

        health = 100;
        moves = 0;
        score = 0;
        peekingPower = 2;
    }

    public int getScore()
    {
        return score;
    }

    public void increaseScore(int amount)
    {
        score = score + amount;
    }
    
    public boolean hasKey() {
        return this.hasKey;
    }
    
    public boolean hasTreasure() {
        return this.hasFoundTreasure;
    }

    public void move()
    {
        moves++;
        health -= 10;
        score += 10;
    }
    
    public int getHealth () {
        return health;
    }

    public String getName()
    {
        return name;
    }

    public void addItem(Items item)
    {
        items.add(item);
        score += 10;

        if(item == Items.FOOD)
            health += 10;
        if(item == Items.KEY)
            this.hasKey = true;
        if(item == Items.BANDAGE)
            health += 20;
        if(item == Items.WATER)
            health += 30;
        if(item == Items.TREASURE) {
            if (this.hasKey == true) {
                System.out.println("You have unlocked treasure. Escape house to win game.");
                this.hasFoundTreasure = true;
            } else {
                System.out.println("You have found treasure chest. Find key to get treasure");    
            }
        }
    }

    public void peek(Room room) {
        if(room!=null) {
            peekingPower--;
            System.out.println("This room has security: " + room.hasSecurity());
            return;
        }
        System.out.println("Sorry you do not have enough power to peek.");
    }

    public void print()
    {
        System.out.println("\n Move: " + moves + ": " +  name + 
            " Health: " + health + " Score: " + score + "\n");
    }
}
