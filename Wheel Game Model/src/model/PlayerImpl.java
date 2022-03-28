package model;

import model.bet.Bet;
import model.wheel.Slot;

public class PlayerImpl implements Player {
	


	private int points;
	private String name;
	private String id;
	private Bet currentBet;
	private int win;

	public PlayerImpl(java.lang.String id, java.lang.String name, int points) throws java.lang.NullPointerException, java.lang.IllegalArgumentException {
		super();
		this.points = points;
		this.name = name;
		this.id = id;
		this.currentBet = Bet.NO_BET;

	}

	@Override
	public String getId() {

		return id;
	}

	@Override
	public String getName() {

		return name;
	}

	@Override
	public int getPoints() {

		return points;
	}

	@Override
	public int getTotalPoints() {

		return points + currentBet.getAmount();

	}

	@Override
	public void assignBet(Bet bet) {
		currentBet = bet;
		points = points - bet.getAmount();
	}

	@Override
	public Bet getBet() {

		return currentBet;
	}

	@Override
	public void finaliseBet(Slot slot) {
		win = currentBet.getOutcome(slot);
		points = win + points;
	}

	@Override
	public void resetBet() {
		assignBet(Bet.NO_BET);
	}

	@Override
	public String toString() {

		return "id = " + id + ", name = " + name + ", points = " + points + ", " + currentBet.toString();

	}


}
