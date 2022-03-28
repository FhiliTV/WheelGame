package client;

import view.Window;

import javax.swing.SwingUtilities;

import model.GameEngine;
import model.GameEngineImpl;
import model.PlayerImpl;
import view.GuiCallback;

public class GuiWheelGame extends Thread {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameEngine engine = new GameEngineImpl();
		GuiCallback guiCallback = new GuiCallback();
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				engine.selectStartingSlot();
				engine.registerCallback(guiCallback);
				new Window(engine, guiCallback);
				engine.addPlayer(new PlayerImpl("P1", "Player One", 1000));
				engine.addPlayer(new PlayerImpl("P2", "Player Two", 2000));
			}
		
		});
		
		
		
	}

}
