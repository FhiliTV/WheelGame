package model.bet;

import model.wheel.Slot;

public class NumberBetImpl implements NumberBet {

	private int number;
	private int betAmount;

	public NumberBetImpl(int betAmount, int number) throws IllegalArgumentException {
		super();
		this.number = number;
		this.betAmount = betAmount;
	}

	@Override
	public int getAmount() {

		return betAmount;
	}

	@Override
	public BetType getBetType() {

		return BetType.NUMBER;
	}

	@Override
	public boolean isWinningBet(Slot slot) {

		if (slot.getNumber() == number) {
			return true;
		}
		return false;
	}

	@Override
	public int getOutcome(Slot slot) {

		int payout = 0;

		if (isWinningBet(slot)) {

			payout = getBetType().getMultiplier() * betAmount;

		} else {
			payout = 0;
		}

		if (Bet.NO_BET.equals(this)) {
			payout = 0;
		}

		return payout;
	}

	@Override
	public int compareTo(Bet bet) {

		int compare1 = bet.getAmount() - this.betAmount;

		return compare1;
	}

	@Override
	public int getNumber() {

		return number;
	}

	@Override
	public String toString() {

		return "Bet " + betAmount + " on Number " + number;

	}

}
