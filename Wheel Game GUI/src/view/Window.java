package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import model.GameEngine;





@SuppressWarnings("serial")
public class Window extends JFrame {
	
	public static int width = 800;
	public static int height = 600;
	


	//this will be the frame of our window
	
	public Window(GameEngine engine, GuiCallback guiCallback) {
		PlayerPanel playerPanel = new PlayerPanel(engine);
		StatusBar statusBar = new StatusBar(engine);
		WheelPanel wheelPanel = new WheelPanel();
		ToolBar toolBar = new ToolBar(engine);
		MenuBar menuBar = new MenuBar(engine,toolBar);
		
		setSize(width, height);
		setTitle("Best Roulette Game in the World");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setResizable(true);
		
		add(toolBar, BorderLayout.NORTH);
		guiCallback.setToolBar(toolBar);
		
		add(playerPanel, BorderLayout.WEST);
		guiCallback.setPlayerPanel(playerPanel);
		
		add(wheelPanel, BorderLayout.CENTER);
		guiCallback.setWheelPanel(wheelPanel);
		
		add(statusBar, BorderLayout.SOUTH);
		guiCallback.setStatusBarPanel(statusBar);
		
		setJMenuBar(menuBar);
		
		
		setVisible(true);
		
		
		
	}
	


}