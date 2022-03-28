package model;

import java.util.Collection;

import model.bet.BetType;
import model.wheel.Slot;
import view.GameCallback;
import view.GameCallbackCollection;

/**
 * The main interface in <b>Further Programming Assignment</b>.
 * <p>
 * This interface should be implemented as {@link model.GameEngineImpl} which has a no argument
 * constructor. All the methods in the interface need to be carefully implemented as per the Javadoc
 * below.
 * 
 * @author Ross Nye
 * 
 * @see view.GameCallbackCollection
 * @see model.Player
 * @see model.wheel.Wheel
 * @see model.wheel.Slot
 * @see model.bet.Bet
 */
public interface GameEngine extends GameCallbackCollection
{
	
	/**
	 * Adds supplied player to the Game Engine. The supplied player must be valid player with a
	 * unique ID; if the ID already exists the add should be rejected and an exception thrown (see
	 * below).
	 * <p>
	 * <b>Hint:</b> The unique ID should be enforced here and not in {@link model.PlayerImpl} class
	 * 
	 * @param player
	 *            the player to be added to the Game Engine
	 * 
	 * @throws NullPointerException
	 *             if the player parameter is null
	 * 
	 * @throws IllegalArgumentException
	 *             if a player with the same ID as the player supplied in the parameter already
	 *             exists in the Game Engine
	 * 
	 * @see model.Player
	 */
	public void addPlayer(Player player) throws NullPointerException, IllegalArgumentException;
	
	
	
	/**
	 * Removes the player with the matching supplied ID as a parameter from the Game Engine. If the
	 * supplied ID is not valid an exception is thrown (see below).
	 * 
	 * @param playerId
	 *            the ID of the player that is to be removed
	 * 
	 * @throws NullPointerException
	 *             if the supplied player ID is null
	 * 
	 * @throws IllegalArgumentException
	 *             if there is no player with a matching ID in the Game Engine
	 * 
	 * @see model.Player
	 */
	public void removePlayer(String playerId) throws NullPointerException, IllegalArgumentException;
	
	
	
	/**
	 * @return an unmodifiable collection (shallow copy) of all Players
	 * 
	 * @see model.Player
	 */
	public Collection<Player> getAllPlayers();
	
	
	
	/**
	 * Places a Color based bet for the player with matching ID.
	 * <p>
	 * Number bets should be placed with overloaded placeBet method. Only valid color bets, for
	 * valid players, should be accepted otherwise an exception should be thrown (see below).
	 * <p>
	 * It should be possible to replace an existing bet with a new one if the new bet amount is 
	 * of greater or equal value to that of the current bet.
	 * <p>
	 * Once a valid bet has been assigned to the player all the registered GameCallbacks objects
	 * should be notified of the updated bet using the {@link GameCallback#updateBet(Player, Bet)}
	 * callback method.
	 * <p>
	 * <b>Note:</b> Bets should be reset for all players by the client after a spin.
	 * <p>
	 * <b>Hint:</b> Consider passing appropriate messages to the Exception constructors.
	 * 
	 * @param playerId
	 *            the ID of the player placing the bet.
	 * @param betAmount
	 *            the amount of the bet
	 * @param betType
	 *            the type of color bet to be placed: {@link BetType#BLACK}, {@link BetType#RED},
	 *            {@link BetType#GREEN}
	 * 
	 * @throws NullPointerException
	 *             if supplied playerID or betType is null
	 * 
	 * @throws IllegalArgumentException
	 *             in the following cases
	 *             <ul>
	 *             <li>there is no player with a matching ID in the Game Engine</li>
	 *             <li>supplied bet amount is not a positive integer</li>
	 *             <li>bet cannot be placed as the player does not have enough points</li>
	 *             <li>cannot overwrite existing bet as new bet is of lesser value</li>
	 *             <li>supplied betType parameter is {@link BetType#NUMBER} - use overloaded method
	 *             instead</li>
	 *             </ul>
	 * 
	 * @see model.Player
	 * @see model.bet.Bet
	 * @see model.bet.BetType
	 */
	public void placeBet(String playerId, int betAmount, BetType betType)
			throws NullPointerException, IllegalArgumentException;
	
	
	
	/**
	 * Places a Number based bet for {@link Player} with matching ID. Color bets should be placed
	 * with overloaded placeBet method. Only valid number bets, for valid players, should be
	 * accepted otherwise an exception should be thrown (see below).
	 * <p>
	 * It should be possible to replace an existing bet with a new one if the new bet amount is 
	 * of greater or equal value to that of the current bet.
	 * <p>
	 * Once a valid bet has been assigned to the player all the registered GameCallback objects
	 * should be notified of the updated bet using the {@link GameCallback#updateBet(Player, Bet)}
	 * callback method.
	 * <p>
	 * <b>Note:</b> Bets should be reset for all players by the client after a spin.
	 * <p>
	 * <b>Hint:</b> Consider passing appropriate messages to the Exception constructors.
	 * 
	 * @param playerId
	 *            the ID of the player placing the bet.
	 * @param betAmount
	 *            the amount of the bet
	 * @param number
	 *            the slot number to place the bet for
	 * 
	 * @throws NullPointerException
	 *             if supplied playerID is null
	 * 
	 * @throws IllegalArgumentException
	 *             in the following cases
	 *             <ul>
	 *             <li>there is no player with a matching ID in the Game Engine</li>
	 *             <li>supplied bet amount is not a positive integer</li>
	 *             <li>bet cannot be placed as the player does not have enough points</li>
	 *             <li>cannot overwrite existing bet as new bet is of lesser value</li>
	 *             <li>supplied slot number is not a valid slot number
	 *              (valid numbers <b>do not</b> include 0 or 00)</li>
	 *             </ul>
	 * 
	 * @see model.Player
	 * @see model.bet.Bet
	 * @see model.bet.BetType
	 */
	public void placeBet(String playerId, int betAmount, int number)
			throws NullPointerException, IllegalArgumentException;
	
	
	
	/**
	 * Resets all bets for all the players in the Game Engine.
	 * <p>
	 * As each player's bet is reset all the registered GameCallback objects should be notified of
	 * the updated bet using the {@link GameCallback#updateBet(Player, Bet)} callback method.
	 * <p>
	 * <b>Note:</b> Bets should be reset for all players by the client after a spin.
	 * 
	 * @see Player#resetBet()
	 */
	public void resetAllBets();
	
	
	
	/**
	 * Returns a random starting slot from the wheel.
	 * <p>
	 * Once the random slot is determined all GameCallback objects registered with the Game Engine
	 * should be notified of the random slot using the {@link GameCallback#initialSlot(Slot)}
	 * method.
	 * <p>
	 * All callbacks should be notified of the same slot, which should be the same slot returned
	 * from this method.
	 * <p>
	 * <b>Note:</b> This method should be called as a part of the spin process and exists as a
	 * separate public method to facilitate automatic testing.
	 * 
	 * @return random starting slot
	 * 
	 * @see model.wheel.Slot
	 * @see model.wheel.Wheel
	 * @see model.wheel.Wheel#generateRandomPosition()
	 * @see model.wheel.Wheel#moveToPosition(int)
	 * @see view.GameCallback
	 * @see view.GameCallback#initialSlot(Slot)
	 */
	public Slot selectStartingSlot();
	
	
	
	/**
	 * The default initial delay is {@value} in ms
	 */
	public static final int DEFAULT_INITIAL_DELAY = 50;
	
	/**
	 * The default final delay is {@value} in ms
	 */
	public static final int DEFAULT_FINAL_DELAY = 500;
	
	/**
	 * The default delay increment is {@value} in ms
	 */
	public static final int DEFAULT_DELAY_INCREMENT = 10;
	
	
	/**
	 * Overloaded method that uses the default delay parameters to spin the wheel
	 * 
	 * @return winning slot
	 * 
	 * @see GameEngine#DEFAULT_DELAY_INCREMENT
	 * @see GameEngine#DEFAULT_FINAL_DELAY
	 * @see GameEngine#DEFAULT_DELAY_INCREMENT
	 * @see #spinWheel(int, int, int)
	 * @see model.wheel.Wheel
	 * @see model.wheel.Slot
	 * 
	 */
	public Slot spinWheel();
	
	
	/**
	 * Spins the wheel.
	 * <p>
	 * Spinning the wheel can be broken down into the following steps
	 * <ol>
	 * <li>Select a random starting slot and notify all registered GameCallback
	 * <li>Using the three delay parameters appropriately
	 * <ol>
	 * <li>Delay for current delay ms, starting initially with initial delay value
	 * <li>Advance the wheel to the next slot
	 * <li>Notify all of the new registered GameCallback via {@link GameCallback#advanceSlot(Slot)}
	 * <li>Increment the delay
	 * <li>Repeat as long as the final delay has not been reached
	 * </ol>
	 * <li>Finalise the spin; apply betting results and notify all registered GameCallback
	 * </ol>
	 * 
	 * @param initialDelay
	 *            the initial delay in ms
	 * @param finalDelay
	 *            the final delay in ms
	 * @param delayIncrement
	 *            the delay increment in ms
	 * @return the winning slot
	 * 
	 * @throws IllegalArgumentException
	 *             in the following cases based on the three delay parameters
	 *             <ul>
	 *             <li>initialDelay is zero or less
	 *             <li>finalDelay is zero or less
	 *             <li>delayIncrement is one or less
	 *             <li>initalDelay is NOT less than finalDelay
	 *             <li>based on all three parameters the spin loop would happen only once (or less)
	 *             </ul>
	 * 
	 * @see model.wheel.Wheel
	 * @see model.wheel.Slot
	 * @see view.GameCallback
	 * @see view.GameCallback#advanceSlot(Slot)
	 * @see java.lang.Thread#sleep(long)
	 */
	public Slot spinWheel(int initialDelay, int finalDelay, int delayIncrement)
			throws IllegalArgumentException;
	
	
	
	/**
	 * This methods is run at the completion of a spin to finalise the results.
	 * <p>
	 * It applies the betting results based on the supplied winning slot parameter.
	 * <p>
	 * Firstly all the GameCallback objects registered with the Game Engine should be notified of
	 * the winning slot via the {@link GameCallback#winningSlot(Slot)} method. All the callbacks
	 * should be notified of the same slot, which should be the same as to slot returned from this
	 * method.
	 * <p>
	 * After notifying all the callbacks of the winning slot all the player bets should then be
	 * finalised, notifying all the registered GameCallback of each update via the
	 * {@link GameCallback#updateBet(Player, Bet)} method while doing so.
	 * <p>
	 * <b>Note:</b> This method should be called as a part of the spin process and exists as a
	 * separate public method to facilitate testing.
	 * 
	 * @param slot
	 *            the winning slot
	 * 
	 * @see model.wheel.Slot
	 * 
	 * @see view.GameCallback
	 * @see view.GameCallback#winningSlot(Slot)
	 * @see view.GameCallback#updateBet(Player, Bet)
	 * @see model.Player
	 * @see model.bet.Bet
	 * 
	 */
	public void finaliseSpin(Slot slot);
}
