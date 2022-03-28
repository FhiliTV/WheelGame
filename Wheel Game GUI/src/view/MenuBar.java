package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.GameEngine;
import model.Player;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar implements ActionListener{
	
	private JMenuBar menuBar;
	private JMenu file;
	private JMenu edit;
	private JMenu exit;
	private JMenuItem addPlayer;
	private JMenuItem blue;
	private JMenuItem nightMode;
	private ToolBar toolBar;
	private GameEngine engine;
	
	public MenuBar(GameEngine engine, ToolBar toolBar) {
		this.engine = engine;
		this.toolBar = toolBar;
		menuBar = new JMenuBar();
		
		file = new JMenu("file");
		edit = new JMenu("edit");
		exit = new JMenu("exit");
		exit.addMouseListener(new MouseAdapter() {
			
		    public void mousePressed(MouseEvent arg0) {
		       System.exit(0);
		    }

		
		});
		addPlayer = new JMenuItem("Add Player");
		nightMode = new JMenuItem("Night Mode");
		blue = new JMenuItem("Blue");
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(exit);
		file.add(addPlayer);
		addPlayer.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent arg0) {
					
			       toolBar.dialogAddPlayer();
			    }
			
		});
		file.add(nightMode);
		file.add(blue);
		add(menuBar);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		
	}

}
