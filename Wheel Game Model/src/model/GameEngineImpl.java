package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import model.bet.Bet;
import model.bet.BetType;
import model.bet.ColorBetImpl;
import model.bet.NumberBetImpl;
import model.wheel.Slot;
import model.wheel.Wheel;
import model.wheel.WheelImpl;
import view.GameCallback;

public class GameEngineImpl implements GameEngine {

	private Collection<Player> players;
	private Slot slot;
	private Wheel wheel;
	private Collection<GameCallback> callbacks;

	public GameEngineImpl() {
		this.players = new ArrayList<Player>();
		this.wheel = new WheelImpl();
		this.callbacks = new ArrayList<GameCallback>();

	}

	@Override
	public void registerCallback(GameCallback callback) {

		callbacks.add(callback);
	}

	@Override
	public void removeCallback(GameCallback callback) {

		callbacks.remove(callback);

	}

	@Override
	public void addPlayer(Player player) throws NullPointerException, IllegalArgumentException {
		players.add(player);
		for (GameCallback callback : callbacks) {
			callback.addPlayer(player);
		}
	}

	@Override
	public void removePlayer(String playerId) throws NullPointerException, IllegalArgumentException {

		Player[] newArray = players.toArray(new Player[0]);

		for (int i = 0; i < newArray.length; i++) {

			Player player = newArray[i];

			if (player.getId() == playerId) {
				players.remove(player);
				for (GameCallback callback : callbacks) {
					callback.removePlayer(player);
				}
			}
		}

	}

	@Override
	public Collection<Player> getAllPlayers() {

		Collection<Player> theCollection = new ArrayList<Player>();
		theCollection.addAll(players);
		return theCollection;

	}

	@Override
	public void placeBet(String playerId, int betAmount, BetType betType)
			throws NullPointerException, IllegalArgumentException {

		Player[] newArray = players.toArray(new Player[0]);

		Bet bet = new ColorBetImpl(betAmount, betType);

		for (int i = 0; i < newArray.length; i++) {

			Player player = newArray[i];

			if (player.getId() == playerId) {
				player.assignBet(bet);
				for (GameCallback callback : callbacks) {
					callback.updateBet(player, bet);
				}
			}
		}

	}

	@Override
	public void placeBet(String playerId, int betAmount, int number)
			throws NullPointerException, IllegalArgumentException {

		Player[] newArray = players.toArray(new Player[0]);

		Bet bet = new NumberBetImpl(betAmount, number);

		for (int i = 0; i < newArray.length; i++) {

			Player player = newArray[i];

			if (player.getId() == playerId) {
				player.assignBet(bet);
				for (GameCallback callback : callbacks) {
					callback.updateBet(player, bet);
				}
			}
		}

	}

	@Override
	public void resetAllBets() {

		Player[] newArray = players.toArray(new Player[0]);

		for (int i = 0; i < newArray.length; i++) {
			Player player = newArray[i];
			player.resetBet();
			for (GameCallback callback : callbacks) {
				callback.updateBet(player, Bet.NO_BET);
				;
			}
		}

	}

	@Override
	public Slot selectStartingSlot() {
		int rand = wheel.generateRandomPosition();
		slot = wheel.moveToPosition(rand);
		for (GameCallback callback : callbacks) {
			callback.initialSlot(slot);
		}
		return slot;
	}

	@Override
	public Slot spinWheel() {

		return spinWheel(GameEngine.DEFAULT_INITIAL_DELAY, GameEngine.DEFAULT_FINAL_DELAY, GameEngine.DEFAULT_DELAY_INCREMENT);

	}

	@Override
	public Slot spinWheel(int initialDelay, int finalDelay, int delayIncrement) throws IllegalArgumentException {

		selectStartingSlot();

		while (initialDelay <= finalDelay) {

			// create the delay
			try {
				TimeUnit.MILLISECONDS.sleep(initialDelay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			slot = wheel.nextSlot();
			for (GameCallback callback : callbacks) {
				callback.advanceSlot(slot);
			}
			initialDelay = initialDelay + delayIncrement;

		}

		finaliseSpin(slot);

		return slot;
	}

	@Override
	public void finaliseSpin(Slot slot) {

		for (GameCallback callback : callbacks) {
			callback.winningSlot(slot);
		}
		for (Player player : players) {
			player.finaliseBet(slot);

			for (GameCallback callback : callbacks) {
				callback.updateBet(player, player.getBet());
			}
		}

	}

}
