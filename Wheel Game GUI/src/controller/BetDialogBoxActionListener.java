package controller;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.GameEngine;
import model.Player;
import model.PlayerImpl;
import model.bet.BetType;
import model.wheel.Wheel;
import view.PlayerPanel;

public class BetDialogBoxActionListener implements ActionListener{
	
	GameEngine engine;
	PlayerPanel panel;
	Player player;
	String[] numbers;
	String[] colors;
	JComboBox betButton;
	
	
	
	public BetDialogBoxActionListener(GameEngine engine, Player player, PlayerPanel panel, JComboBox betButton) {
		this.engine = engine;
		this.panel = panel;
		this.player = player;
		this.betButton = betButton;
		
		int[] slotNumbers = Arrays.copyOf(Wheel.SLOT_NUMBERS, Wheel.NUMBER_OF_SLOTS);
		 Arrays.sort(slotNumbers);
		 
		 this.numbers = new String[Wheel.NUMBER_OF_SLOTS];
		 
		 for(int i = 0; i < slotNumbers.length; i++) {
			 this.numbers[i] = Integer.toString(slotNumbers[i]);
		 }
		 
		 this.colors = new String[BetType.values().length-1];
		 
		 for(int i = 0; i < BetType.values().length; i++) {
			 BetType type = BetType.values()[i];
			 if(type != BetType.NUMBER) {
				 this.colors[i] = BetType.values()[i].toString();
			 } 
		 }
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
		switch(betButton.getSelectedIndex()) {
		case 1: 
			System.out.println("Option Number Bet");
			
			JDialog numberBet = new JDialog(new JFrame(), "Make a Bet");
			numberBet.setLayout(new FlowLayout());
			
			
			final JTextField betAmountText = new JTextField("Bet Amount", 20);
			final JComboBox theNumberBeingBet = new JComboBox(this.numbers);
			JButton confirm = new JButton("Confirm");
			confirm.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					int betAmount = Integer.parseInt(betAmountText.getText());
					int theBetNumber = Integer.parseInt((String) theNumberBeingBet.getSelectedItem());
					if(player.getTotalPoints()-betAmount < 0) {
						JOptionPane.showMessageDialog(null, "Not enough points, try again");
					}else {
					engine.placeBet(player.getId(), betAmount, theBetNumber);
					}
					numberBet.setVisible(false);
					
				}
				
			});
			JButton cancel = new JButton("Cancel");
			cancel.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					numberBet.setVisible(false);
				}
				
			});
			numberBet.setSize(300,200);
			numberBet.add(betAmountText);
			numberBet.add(theNumberBeingBet);
			numberBet.add(confirm);
			numberBet.add(cancel);
			numberBet.setVisible(true);
			
			
			betButton.setSelectedIndex(0);
			break;
		case 2: 
			
			
			System.out.println("Option Color Bet");
			
			JDialog colorBet = new JDialog(new JFrame(), "Make a Bet");
			colorBet.setLayout(new FlowLayout());
			
			
			final JTextField betAmountText2 = new JTextField("Bet Amount", 20);
			final JComboBox theNumberBeingBet2 = new JComboBox(this.colors);
			JButton confirm2 = new JButton("Confirm");
			confirm2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					int betAmount2 = Integer.parseInt(betAmountText2.getText());
					BetType theBetNumber2 = BetType.valueOf((String) theNumberBeingBet2.getSelectedItem());
					
					if(player.getTotalPoints()-betAmount2 < 0) {
						JOptionPane.showMessageDialog(null, "Not enough points, try again");
					}else {
					engine.placeBet(player.getId(), betAmount2, theBetNumber2);
					}
					colorBet.setVisible(false);
					
				}
				
			});
			JButton cancel2 = new JButton("Cancel");
			cancel2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					colorBet.setVisible(false);
				}
				
			});
			colorBet.setSize(300,200);
			colorBet.add(betAmountText2);
			colorBet.add(theNumberBeingBet2);
			colorBet.add(confirm2);
			colorBet.add(cancel2);
			colorBet.setVisible(true);
			betButton.setSelectedIndex(0);
			break;
	}
		
	}

}
