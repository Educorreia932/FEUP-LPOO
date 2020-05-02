package lpoo.pokemonascii.rules.state;

public class GameState {
    private State gamemode;

    public GameState(){ }

    public void setState(State state){
        gamemode = state;
    }

    public State getGamemode() { return gamemode; }
}
