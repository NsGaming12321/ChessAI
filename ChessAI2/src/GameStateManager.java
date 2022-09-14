import java.util.Stack;

public class GameStateManager {
	public static Stack<GameState> states;
	
	public GameStateManager() {
		states = new Stack<GameState>();
		//states.push(new MenuState(this));
	}
}
