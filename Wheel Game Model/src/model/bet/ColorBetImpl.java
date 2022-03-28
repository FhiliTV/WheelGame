package model.bet;

import model.wheel.Slot;
import model.wheel.SlotColor;

public class ColorBetImpl implements ColorBet {

	private int betAmount;
	private BetType betType;

	public ColorBetImpl(int betAmount, BetType betType) throws NullPointerException, IllegalArgumentException {
		super();
		this.betAmount = betAmount;
		this.betType = betType;
	}

	@Override
	public int getAmount() {

		return betAmount;
	}

	@Override
	public BetType getBetType() {

		return betType;
	}

	@Override
	public boolean isWinningBet(Slot slot) {

		if (slot.getColor() == SlotColor.RED) {
			if (betType == BetType.RED) {
				return true;
			}
		}

		if (slot.getColor() == SlotColor.BLACK) {
			if (betType == BetType.BLACK) {
				return true;
			}
		}

		if (slot.getColor() == SlotColor.GREEN0) {
			if (betType == BetType.GREEN) {
				return true;
			}
		}

		if (slot.getColor() == SlotColor.GREEN00) {
			if (betType == BetType.GREEN) {
				return true;
			}
		}

		return false;

	}

	@Override
	public int getOutcome(Slot slot) {

		int payout = 0;

		if (isWinningBet(slot)) {

			payout = betType.getMultiplier() * betAmount;

		} else {
			payout = 0 - betAmount;
		}

		if (Bet.NO_BET.equals(this)) {
			payout = 0;
		}

		return payout;
	}

	@Override
	public int compareTo(Bet bet) {

		int getBetAmount = bet.getAmount();

		int thisGetAmount = this.getAmount();

		int compare1 = getBetAmount - thisGetAmount;

		return compare1;
	}

	@Override
	public String toString() {

		return "Bet " + betAmount + " on " + betType;

	}

}
