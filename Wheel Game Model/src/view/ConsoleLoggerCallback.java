package view;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.GameEngine;
import model.Player;
import model.bet.Bet;
import model.wheel.Slot;

/**
 * An implementation of GameCallback which uses a Logger to log game events to
 * the console.
 * <p>
 * <b>Important!</b> DO NOT EDIT THE STATIC BLOCK THAT SETS UP THE LOGGER OR
 * IT'S DECLARATION!
 * <p>
 * <b>Note:</b> Logging message format should be consistent with the output
 * trace.
 * 
 * @author Ross Nye
 * 
 * @see view.GameCallback
 * @see view.GameCallbackCollection
 *
 */
public class ConsoleLoggerCallback implements GameCallback {
	public static final Logger LOGGER;

	static {
		// DO NOT EDIT THIS STATIC BLOCK!!

		// Creating consoleHandler, add it and set the log levels.
		LOGGER = Logger.getLogger(ConsoleLoggerCallback.class.getName());
		LOGGER.setLevel(Level.FINER);
		ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(Level.FINER);
		LOGGER.addHandler(handler);
		LOGGER.setUseParentHandlers(false);
	}

	public ConsoleLoggerCallback(GameEngine engine) {

	}

	@Override
	public void addPlayer(Player player) {
		LOGGER.info("Added Player " + player.toString());

	}

	@Override
	public void removePlayer(Player player) {

		LOGGER.info("Removed Player " + player.toString());
	}

	@Override
	public void updateBet(Player player, Bet bet) {

		LOGGER.info("Bet updated for " + player.toString());

	}

	@Override
	public void initialSlot(Slot slot) {

		LOGGER.info("Initial Slot is " + slot.toString());
	}

	@Override
	public void advanceSlot(Slot slot) {

		LOGGER.info("Advance slot to " + slot.toString());
	}

	@Override
	public void winningSlot(Slot slot) {

		LOGGER.info("Winning slot is " + slot.toString());
//		LOGGER.info();

	}

}
