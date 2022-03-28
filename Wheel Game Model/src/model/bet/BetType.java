package model.bet;

import model.wheel.Slot;

/**
 * An enum in the <b>Further Programming Assignment</b>
 * <p>
 * The {@link model.bet.BetType} enum should define the four (4) values: RED, BLACK, GREEN and
 * NUMBER
 * <p>
 * <b>Hint:</b> Enum values are like an instance of a class of which there is only a single shared
 * instance created by the JVM, which makes them behave like primitives in certain situations.
 * Enums can have constructors, instance variables and methods in Java. Methods can be overridden 
 * in enum <em>values</em> and parameters can be used to pass arguments to the (shared) constructor.
 * 
 * <pre>
 *    RED(2)
 *    {
 *       ...
 *    },
 * </pre>
 *
 * <p>
 * <b>Hint:</b> The constructor, instance variables and abstract methods must be supplied after all
 * the values have been declared.
 * 
 * <p>
 * The following methods are supplied by the API and do not need to be written and cannot be
 * overridden despite them appearing in the Javadoc
 * 
 * <pre>
 * public static BetType[] values()
 * public static BetType valueOf(java.lang.String name)
 * </pre>
 * 
 * <table>
 * <tr>
 * <th>Value</th>
 * <th>Multiplier (odds)</th>
 * </tr>
 * <tr>
 * <td>RED</td>
 * <td>2</td>
 * </tr>
 * <tr>
 * <td>BLACK</td>
 * <td>2</td>
 * </tr>
 * <tr>
 * <td>GREEN</td>
 * <td>19</td>
 * </tr>
 * <tr>
 * <td>NUMBER</td>
 * <td>36</td>
 * </tr>
 * <caption>Odds for each BetType value</caption>
 * </table>
 * 
 * @author Ross Nye
 * @see java.lang.Enum
 */
public enum BetType
{
	
	RED(2) {
		@Override
		public boolean isWinningBet(Slot slot) {
			if (slot.getColor().equals(RED)) {
				return true;
			}
			return false;
		}
	},
	BLACK(2) {
		@Override
		public boolean isWinningBet(Slot slot) {
			if (slot.getColor().equals(BLACK)) {
				return true;
			}
			return false;
		}
	},
	GREEN(19) {
		@Override
		public boolean isWinningBet(Slot slot) {
			if (slot.getColor().equals(GREEN)) {
				return true;
				}
				return false;
		}
	},
	NUMBER(36) {
		@Override
		public boolean isWinningBet(Slot slot) {
			if (slot.getColor().equals(NUMBER)) {
				return true;
				}
				return false;
		}
	} ;
	
	int multiplier;
	
	BetType(int multi){
		multiplier = multi;
	}
	
	/**
	 * Returns the odds for a BetType value.
	 * @return the odds for the BetType value
	 */
	public int getMultiplier()
	{
	
		return multiplier;
	}
	
	/**
	 * For each BetType value compares supplied slot to determine slot has won for the particular
	 * BetType.
	 * <p>
	 * <b>Note:</b> More information is required to determine this information for BetType.NUMBER
	 * @param slot winning slot to determine if BetType is win or loss
	 * @return true is win, otherwise false
	 */
	
	public abstract boolean isWinningBet(Slot slot);
	


	

}
