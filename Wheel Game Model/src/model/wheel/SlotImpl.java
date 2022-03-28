package model.wheel;


public class SlotImpl implements Slot {

	private int position;
	private int number;
	private SlotColor color;

	public SlotImpl(int position, SlotColor color, int number) {
		super();
		this.position = position;
		this.color = color;
		this.number = number;
	}

	@Override
	public int getPosition() {

		return position;
	}

	@Override
	public int getNumber() {

		return number;
	}

	@Override
	public SlotColor getColor() {

		return color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + number;
		result = prime * result + position;
		return result;
	}

	@Override
	public String toString() {

		return "Slot position = " + position + " color = " + color + ", number = " + number;

	}
	
}
