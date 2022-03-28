package model;

import model.bet.Bet;
import model.wheel.Slot;

/**
 * Represents a single player in the GameEngine in <b>Further Programming Assignment</b>.
 * <p>
 * Is to be implemented as {@link model.PlayerImpl}.
 * <p>
 * Each player has a unique id (the unique id is enforced elsewhere) and a name, both of which
 * cannot be changed once assigned. The player has a <em>points</em> balance which is used in
 * placing bets within the game.
 * 
 * @author Ross Nye
 * 
 * @see model.GameEngine
 * @see model.bet.Bet
 */
public interface Player
{
	/**
	 * Simple getter for player's id
	 * 
	 * @return the player's id
	 */
	public String getId();
	
	
	
	/**
	 * Simple getter for player's name
	 * 
	 * @return the player's name
	 */
	public String getName();
	
	
	
	/**
	 * Simple getter for player's current points (excluding any amount currently bet)
	 * 
	 * @return the player's current points
	 */
	public int getPoints();
	
	
	
	/**
	 * Returns the current total points for a player, which includes any amount currently bet.
	 * <p>
	 * <b>Hint:</b> If the player doesn't have a current bet this method should return the current
	 * points, otherwise add the bet's value to it.
	 * 
	 * @return the player's current total points.
	 */
	public int getTotalPoints();
	
	
	
	/**
	 * Assigns the supplied bet placed for the player via the GameEngine.
	 * <p>
	 * The players points should be adjusted accordingly and the supplied bet parameter assigned to
	 * an appropriate instance variable.
	 * <p>
	 * Take care when replacing a bet as the original bet amount has already been deducted from the
	 * current points.
	 * <p>
	 * <b>Hint:</b> Try to ensure you don't duplicate code between the Game Engine, Bet and Player
	 * when dealing with bets.
	 * 
	 * 
	 * @param bet
	 *            a valid {@link Bet} object
	 * 
	 */
	public void assignBet(Bet bet);
	
	
	
	/**
	 * Simple getter method for the currently assigned {@link Bet}
	 * 
	 * @return the {@link Bet} object
	 */
	public Bet getBet();
	
	
	
	/**
	 * Finalises the bet based on the supplied winning slot. Using the assigned bet and its betType
	 * adjust the players points based on the outcome of the spin (as indicated by the slot
	 * parameter)
	 * 
	 * @param slot
	 *            the winning slot on which the bets win or loss will be determined.
	 * 
	 * @see model.wheel.Slot
	 * @see model.bet.Bet
	 * @see model.bet.BetType
	 */
	public void finaliseBet(Slot slot);
	
	
	
	/**
	 * Sets the appropriate instance variable to {@link Bet#NO_BET}
	 */
	public void resetBet();
	
	
	
	/**
	 * Override {@link java.lang.Object#toString()}
	 * 
	 * @return a string representing the player as seen in the output trace
	 */
	@Override
	public String toString();
}
