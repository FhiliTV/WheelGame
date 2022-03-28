package view;

import model.Player;
import model.bet.Bet;
import model.wheel.Slot;

/**
 * The callback interface in <b>Further Programming Assignment</b>
 * <p>
 * The methods is this interface are called upon as specified in the GameEngine interface
 * 
 * @author Ross Nye
 * 
 * @see model.GameEngine
 */
public interface GameCallback
{
	/**
	 * Updates the view about a player added to the game engine.
	 * @param player the player that was added
	 */
	public void addPlayer(Player player);
	
	/**
	 * Updates the view about a player removed from the game engine.
	 * @param player the player that was added
	 */
	public void removePlayer(Player player);
	
	
	/**
	 * Updates the view about changes to a player's bet and points balance.
	 * @param player the player who's bet and points have been updated
	 * @param bet the updated bet
	 */
	public void updateBet(Player player, Bet bet);
	
	
	/**
	 * Updates the view about the initial slot of a wheel spin.
	 * @param slot the initial slot
	 */
	public void initialSlot(Slot slot);
	
	
	/**
	 * Updates the view, notifying it that the wheel has advanced a slot during a spin.
	 * @param slot the slot the wheel advanced to
	 */
	public void advanceSlot(Slot slot);
	
	
	/**
	 * Updates the view, notifying it of the winning slot from a wheel spin.
	 * @param slot the winning slot
	 */
	public void winningSlot(Slot slot);
}
