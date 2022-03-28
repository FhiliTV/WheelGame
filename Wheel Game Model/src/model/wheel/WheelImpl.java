package model.wheel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class WheelImpl implements Wheel {

	private Collection<Slot> wheelGenerated;
	private int currentPosition;

	public WheelImpl() {
		this.wheelGenerated = generateWheel();
	}

	@Override
	public int generateRandomPosition() {
		Random rand = new Random();
		int position = rand.nextInt(NUMBER_OF_SLOTS);

		return position;
	}

	@Override
	public Slot moveToPosition(int position) throws IllegalArgumentException {

		Slot[] newArray = wheelGenerated.toArray(new Slot[0]);
		currentPosition = position;
		Slot moveToNext = newArray[position];

		return moveToNext;
	}

	@Override
	public Slot nextSlot() {

		if (currentPosition == NUMBER_OF_SLOTS - 1) {
			currentPosition = -1;
		}

		Slot nextPosition = moveToPosition(currentPosition + 1);

		return nextPosition;
	}

	@Override
	public Collection<Slot> generateWheel() {

		Collection<Slot> wheelGeneration = new ArrayList<>();

		for (int i = 0; i < Wheel.NUMBER_OF_SLOTS; i++) {

			int number = Wheel.SLOT_NUMBERS[i];

			SlotColor color;

			if (i == 0 && number == 0) {
				color = SlotColor.GREEN00;
			} else if (number == 0) {
				color = SlotColor.GREEN0;
			} else if (i % 2 == 0) {
				color = SlotColor.BLACK;
			} else {
				color = SlotColor.RED;
			}

			Slot newSlot = new SlotImpl(i, color, number);
			wheelGeneration.add(newSlot);
		}

		wheelGenerated = wheelGeneration;

		return wheelGenerated;

	}

}
