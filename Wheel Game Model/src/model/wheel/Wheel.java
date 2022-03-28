package model.wheel;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Represents a wheel in the <b>Further Programming Assignment</b>
 * <p>
 * This interface should be implemented as {@link model.wheel.WheelImpl}.
 * <p>
 * Maintains a collection of {@link Slot} and using the methods described in this interface provides
 * functionality of turning wheel from one slot to the next.
 * 
 * @author Ross Nye
 * 
 * @see model.wheel.WheelImpl
 * @see model.wheel.Slot
 */
public interface Wheel
{
	/**
	 * An array populated with the slot numbers of the wheel, in order starting from slot position 1
	 */
	public static final int[] SLOT_NUMBERS = new int[] { 0, 27, 10, 25, 29, 12, 8, 19, 31, 18, 6,
			21, 33, 16, 4, 23, 35, 14, 2, 0, 28, 9, 26, 30, 11, 7, 20, 32, 17, 5, 22, 34, 15, 3, 24,
			36, 13, 1 };
	
	/**
	 * A constant that defines the number of slots in the wheel
	 */
	public static final int NUMBER_OF_SLOTS = SLOT_NUMBERS.length;
	
	/**
	 * A constant the defines the maximum slot number in the wheel's slots
	 */
	public static final int LARGEST_SLOT_NUMBER = Collections
			.max(Arrays.stream(SLOT_NUMBERS).boxed().collect(Collectors.toList()));
	
	
	/**
	 * Generates a random slot position. Returned number is between 1 and {@link #NUMBER_OF_SLOTS}
	 * inclusive.
	 * 
	 * @return a valid random slot position
	 */
	public int generateRandomPosition();
	
	
	/**
	 * Moves wheel the supplied position and returns the slot at / with that position
	 * 
	 * @param position
	 *            the slot position to move to
	 * @return the slot at / with the specified position
	 * 
	 * @throws IllegalArgumentException
	 *             if the supplied position is not a valid position for the wheel
	 * 
	 * @see model.wheel.Slot
	 */
	public Slot moveToPosition(int position) throws IllegalArgumentException;
	
	/**
	 * Advances the wheel to the next slot and returns the slot at that position.
	 * 
	 * @return the slot at the current wheel position
	 * 
	 * @see model.wheel.Slot
	 */
	public Slot nextSlot();
	
	/**
	 * Helper method that generates a collection of all the slot objects that populate the wheel.
	 * <p>
	 * This public method aides in automated testing of your code.
	 * 
	 * @return a collection of slot representing the complete wheel
	 * 
	 * @see model.wheel.Slot
	 * @see java.util.Collection
	 */
	public Collection<Slot> generateWheel();
}
