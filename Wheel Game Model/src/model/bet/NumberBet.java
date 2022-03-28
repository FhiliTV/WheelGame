package model.bet;

/**
 * Represents a number bet in the Game Engine in <b>Further Programming Assignment</b>
 * <p>
 * Is to be implemented as {@link model.bet.NumberBetImpl}.
 * 
 * @author Ross Nye
 * 
 * @see model.bet.Bet
 * @see model.bet.NumberBet
 * @see model.bet.NumberBetImpl
 * @see model.bet.ColorBetImpl
 * 
 */
public interface NumberBet extends Bet
{
	
	/**
	 * @return the slot number the bet has been placed on
	 */
	public int getNumber();
}
