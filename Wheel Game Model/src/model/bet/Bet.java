package model.bet;

import model.wheel.Slot;
import model.wheel.SlotColor;

/**
 * Represents a bet in the Game Engine in <b>Further Programming Assignment</b>.
 * 
 * This interface is extended by {@link model.bet.ColorBet} and {@link model.bet.NumberBet}. You're
 * encouraged to think about the common functionality that exists between them.
 * <p>
 * This interface extends {@link java.lang.Comparable} to allow Bets (specifically their amounts) to
 * be compared.
 * 
 * @author Ross Nye
 * 
 * @see model.bet.BetType
 * @see model.bet.ColorBet
 * @see model.bet.NumberBet
 * @see java.lang.Comparable
 */
public interface Bet extends Comparable<Bet>
{
	
	/**
	 * A simple getter
	 * 
	 * @return the bet amount
	 */
	public int getAmount();
	
	
	/**
	 * A simple getter
	 * 
	 * @return the betType
	 */
	public BetType getBetType();
	
	
	/**
	 * Returns a boolean true or false if the bet is a winning bet or not based on the supplied slot
	 * parameter.
	 * <p>
	 * eg. True if the betType is {@link BetType#BLACK} and the slots color is
	 * {@link SlotColor#BLACK}
	 * 
	 * @param slot
	 *            the winning (final) slot
	 * 
	 * @return true if the bet wins WRT the supplied slot; otherwise false.
	 * 
	 * @see model.bet.BetType
	 * @see model.bet.BetType#isWinningBet(Slot)
	 * @see model.wheel.SlotColor
	 */
	public boolean isWinningBet(Slot slot);
	
	
	/**
	 * Returns the outcome of the bet based on the supplied slot parameter.
	 * <p>
	 * If the bet is a winning bet then the outcome will be a positive number based on the bet
	 * amount and the odds appropriate for the bet type. Otherwise the outcome will be a negative of
	 * the magnitude of the bet amount. <b>Only</b> {@link Bet#NO_BET} (declared below) should
	 * return an outcome of 0.
	 * 
	 * @param slot
	 *            the winning slot
	 * @return the outcome of the bet
	 * 
	 * @see Bet#isWinningBet(Slot)
	 * @see BetType
	 * @see BetType#getMultiplier()
	 */
	public int getOutcome(Slot slot);
	
	
	
	/**
	 * Override {@link java.lang.Object#toString()}
	 * 
	 * @return a string representing the bet as seen in the output trace
	 */
	@Override
	public String toString();
	
	
	
	/**
	 * Override {@link java.lang.Comparable#compareTo(Object)}
	 * Compares this Bet with the supplied Bet for order. 
	 * Returns a negative integer, zero, or a positive integer as this Bet value is less than, 
	 * equal to, or greater than the supplied Bet.
	 * <p>
	 * <b>Hint:</b> It's just some very simple maths to get the return value.</p> 
	 * 
	 * @return a negative integer, zero, or a positive integer as this Bet value is less than, 
	 * equal to, or greater than the Bet value.
	 * 
	 */
	@Override
	public int compareTo(Bet bet);
	
	
	/**
	 * A static Bet object used for indication of no bet.
	 */
	static final Bet NO_BET = new Bet()
	{
		
		@Override
		public int getAmount()
		{
			return 0;
		}
		
		@Override
		public BetType getBetType()
		{
			return null;
		}
		
		@Override
		public boolean isWinningBet(Slot slot)
		{
			return false;
		}
		
		@Override
		public int getOutcome(Slot slot)
		{
			return 0;
		}
		
		@Override
		public String toString()
		{
			return "No Bet";
		}
		
		@Override
		public int compareTo(Bet bet)
		{
			return bet == this ? 0 : -bet.getAmount();
		}
	};
}
