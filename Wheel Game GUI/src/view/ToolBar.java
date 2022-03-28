package view;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import client.GuiWheelGame;
import model.GameEngine;
import model.Player;
import model.PlayerImpl;
import model.bet.Bet;
import model.wheel.Slot;

@SuppressWarnings("serial")
public class ToolBar extends JToolBar implements ActionListener {

	private String[] buttonLabelArray = { "Add Player", "Spin Wheel" };
	private GameEngine engine;
	GuiWheelGame tester;
	private boolean wheelActivated;

	public ToolBar(GameEngine engine) {

		this.engine = engine;

		for (int i = 0; i < buttonLabelArray.length; i++) {
			JButton button = new JButton(String.format("%s", buttonLabelArray[i]));
			button.addActionListener(this);
			add(button);
		}

	}

	public void placeBet() {

	}

	public void dialogAddPlayer() {


		JFrame f = new JFrame();

		JDialog addPlayerDialog = new JDialog(f, "Add Player");
		addPlayerDialog.setLayout(new FlowLayout());
		JTextField playerNameString = new JTextField("Name", 20);

		JTextField playerIdString = new JTextField("ID", 20);
		JTextField playerTotalInt = new JTextField("Total Credits", 20);
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				final String NAME = playerNameString.getText();
				final String ID = playerIdString.getText();
				final int TOTAL_INT = Integer.parseInt(playerTotalInt.getText());

				System.out.println(NAME + ID + TOTAL_INT);
				engine.addPlayer(new PlayerImpl(ID, NAME, TOTAL_INT));
				addPlayerDialog.setVisible(false);

			}

		});
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addPlayerDialog.setVisible(false);
			}

		});
		addPlayerDialog.setSize(300, 200);
		addPlayerDialog.setLocationRelativeTo(null);
		addPlayerDialog.add(playerNameString);
		addPlayerDialog.add(playerIdString);
		addPlayerDialog.add(playerTotalInt);
		addPlayerDialog.add(confirm);
		addPlayerDialog.add(cancel);
		addPlayerDialog.setVisible(true);

	}

	public void spinWheel() {
		wheelActivated = true;

		System.out.println("Working");

		new Thread() {

			@Override
			public void run() {
				engine.spinWheel();
			}

		}.start();

	}

	// need to get this working...

	@Override
	public void actionPerformed(ActionEvent event) {


		switch (event.getActionCommand()) {
		case "Add Player":
			if (wheelActivated == false) {
				dialogAddPlayer();
			} else {
				JOptionPane.showMessageDialog(this, "Unable to add player: Wheel Spinning");
			}
			break;
		case "Spin Wheel":
			spinWheel();
			break;
		}
		;

	}

	public void WinningSlot(Slot slot) {
		String result = "Results \n";
		for (Player p : engine.getAllPlayers()) {
			int outcome = p.getBet().getOutcome(slot);
			
			if(0 < outcome) {
				result += String.format(" %s = WON $%s \n", p.getName(), outcome);
			}else {
				result += String.format(" %s = LOST $%s \n", p.getName(), Math.abs(outcome));
			}
		}
		JOptionPane.showMessageDialog(null, result);
		engine.resetAllBets();
		wheelActivated = false;
		
	}
	
	public void betUpdated() {
		for (Player p : engine.getAllPlayers()) {
			if(p.getBet() == Bet.NO_BET) {
				return;
			}
		}
		spinWheel();
		
	}
}
