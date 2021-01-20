
/**
 * This class creates creates an instance of the Game class.
 * Call this class to play the game.
 * 
 *
 * @by Hamood Jaffery
 * @Date 20-01-21
 */
public class Program
{
    private static Game game;

    /**
     * This class creates and runs an instance of
     * the Game class
     */
    public static void main()
    {
        game = new Game();
        game.play();
    }
}
