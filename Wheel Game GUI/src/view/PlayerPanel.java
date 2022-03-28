

package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import controller.BetDialogBoxActionListener;
import model.GameEngine;
import model.Player;


@SuppressWarnings("serial")
public class PlayerPanel extends JPanel implements ActionListener {
	
	private GameEngine engine;
	private Collection<Player> players;
	
	
	public PlayerPanel(GameEngine engine) {
		this.engine = engine;
		
		setLayout(new GridLayout(5,0));
		
		renderPlayers();
	}
	
	public void renderPlayers() {
		
		//This gets all the players that have been added
		players = engine.getAllPlayers();
		this.removeAll();
		for(Player p : players) {
			
			String[] betTypes = {"Place Bet...", "Number Bet", "Colour Bet"};
			
			final JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(0,1));
			
			JLabel s1 = new JLabel(String.format("Player name: %s", p.getName()));
			JLabel s2 = new JLabel(String.format("Total Points: %s", p.getTotalPoints()));
			JLabel s3 = new JLabel(String.format("Bet Placed: %s", p.getBet()));
			JComboBox betButton = new JComboBox(betTypes);
			betButton.setSelectedIndex(0);
			betButton.addActionListener(new BetDialogBoxActionListener(engine, p, this, betButton));

			JButton removePlayer = new JButton("Remove Player");
			removePlayer.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					String message = "Are you sure you want to remove this player?";

					int option = JOptionPane.showConfirmDialog(panel, message, "Remove Player?", JOptionPane.YES_NO_OPTION);
					
					if(option == JOptionPane.YES_OPTION) {
						engine.removePlayer(p.getId());
					} 

				}
				
			});
			
			panel.add(s1);
			panel.add(s2);
			panel.add(s3);
			
			panel.add(betButton);
			panel.add(removePlayer);
			add(panel);
		}
		updateUI();
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}