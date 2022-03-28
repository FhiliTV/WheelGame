package view;

import java.awt.GridLayout;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


import model.GameEngine;
import model.Player;
import model.wheel.Slot;


@SuppressWarnings("serial")
public class StatusBar extends JPanel{
	
	private GameEngine engine;
	private JLabel s1;
	private JLabel s2;
	
	public StatusBar(GameEngine engine) {
		this.engine = engine;
		setLayout(new GridLayout(1,0));
		s1 = new JLabel("Welcome to Roulette");
		s1.setHorizontalAlignment(SwingConstants.CENTER);
		add(s1);
		
	}

	public void renderAdvanceSlot(Slot slot) {
		removeAll();
		
		s1 = new JLabel("Currently Slot: ");
		s1.setHorizontalAlignment(SwingConstants.CENTER);
		add(s1);
		
		
		s2 = new JLabel(String.format("Slot Position: %s | Slot  Number: %s | Slot Color: %s", slot.getPosition(), slot.getColor(), slot.getNumber()));
		s2.setHorizontalAlignment(SwingConstants.CENTER);
		
		add(s2);
		revalidate();
		
	}
	
	public void WinningSlot(Slot slot) {
		removeAll();
		
		s1 = new JLabel(String.format("Winning  Slot: Slot Position: %s | Slot  Number: %s | Slot Color: %s", slot.getPosition(), slot.getColor(), slot.getNumber()));
		s1.setHorizontalAlignment(SwingConstants.CENTER);
		add(s1);
		
		String result = "Results \n";
		for (Player p : engine.getAllPlayers()) {
			int outcome = p.getBet().getOutcome(slot);
			
			if(0 < outcome) {
				result += String.format(" %s = WON $%s \n", p.getName(), outcome);
			}else {
				result += String.format(" %s = LOST $%s \n", p.getName(), Math.abs(outcome));
			}
		}
		s2 = new JLabel(result);
		s2.setHorizontalAlignment(SwingConstants.CENTER);
		
		add(s2);
		revalidate();
	}
		

}
