package view;

import model.Player;
import model.bet.Bet;
import model.wheel.Slot;
import view.GameCallback;

public class GuiCallback implements GameCallback {
	
	
	PlayerPanel playerPanel;
	StatusBar statusBar;
	WheelPanel wheelPanel;
	ToolBar toolBar;
	
	public void setPlayerPanel(PlayerPanel playerPanel) {
		this.playerPanel = playerPanel;
	}
	
	public void setStatusBarPanel(StatusBar statusBar) {
		this.statusBar = statusBar;
	}
	
	public void setWheelPanel(WheelPanel wheelPanel) {
		this.wheelPanel = wheelPanel;
	}
	
	public void setToolBar(ToolBar toolBar) {
		this.toolBar = toolBar;
	}

	@Override
	public void addPlayer(Player player) {
		playerPanel.renderPlayers();
		

	}

	@Override
	public void removePlayer(Player player) {
		playerPanel.renderPlayers();

	}

	@Override
	public void updateBet(Player player, Bet bet) {
		playerPanel.renderPlayers();
		toolBar.betUpdated();
	}

	@Override
	public void initialSlot(Slot slot) {
	}

	@Override
	public void advanceSlot(Slot slot) {
		statusBar.renderAdvanceSlot(slot);
		wheelPanel.circlePosition(slot);
		
	}

	@Override
	public void winningSlot(Slot slot) {
		statusBar.WinningSlot(slot);
		toolBar.WinningSlot(slot);
		

	}

}
