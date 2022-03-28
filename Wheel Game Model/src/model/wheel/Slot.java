package model.wheel;

/**
 * Represents a slot in the <b>Further Programming Assignment</b>
 * <p>
 * This interface should be implemented as {@link model.wheel.SlotImpl}
 * <p>
 * <b>Note:</b> Slot positions increment clockwise around the wheel, whereas slot numbers follow the
 * order as defined in {@link model.wheel.Wheel#SLOT_NUMBERS}
 * 
 * @author Ross Nye
 * 
 * @see model.wheel.SlotImpl
 * @see model.wheel.Wheel
 */
public interface Slot
{
	/**
	 * A simple getter
	 * 
	 * @return the slot position
	 */
	public int getPosition();
	
	
	
	/**
	 * A simple getter
	 * 
	 * @return the slot color
	 * 
	 * @see model.wheel.SlotColor
	 */
	public SlotColor getColor();
	
	
	
	/**
	 * A simple getter
	 * 
	 * @return the slot number
	 */
	public int getNumber();
	
	
	
	/**
	 * Override {@link java.lang.Object#equals(Object)}
	 * <p>
	 * Equality should be tested based on the slots position, color and number of two Slot objects
	 *
	 * @return true if the two slots are equal, otherwise false
	 * 
	 * @see java.lang.Object#equals(Object)
	 */
	@Override
	public boolean equals(Object obj);
	
	
	/**
	 * Override {@link java.lang.Object#hashCode()}
	 * 
	 * @return a hash code value for this object
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode();
	
	
	/**
	 * Override {@link java.lang.Object#toString()}
	 * 
	 * @return a string representing the slot as seen in the output trace
	 */
	@Override
	public String toString();
}
