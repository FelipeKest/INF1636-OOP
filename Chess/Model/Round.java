package Model;

final class Round {
	private int roundNumber;
	
	public Round() {
		this.roundNumber = 0;		
	}
	
	protected void increaseRoundNumber() {
		this.roundNumber++;
	}
	
	protected int getPlayerRoundNumber() {
		return this.roundNumber%2;
	}
}
