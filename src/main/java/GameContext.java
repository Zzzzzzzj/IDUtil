
public class GameContext {

    private int serverId;

    private static GameContext Instance = new GameContext();

    private GameContext(){

    }

    public static GameContext getInstance() {
        return Instance;
    }


    public int getServerId() {
        return serverId;
    }
}
