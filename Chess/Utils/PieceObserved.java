package Utils;

abstract public interface PieceObserved {
	
	abstract public void add(PieceObserver observer);

	abstract public void remove(PieceObserver observer);
	
	abstract public int[][] getVisualPositions();
}