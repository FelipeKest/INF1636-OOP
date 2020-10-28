package Model;

public class Table {
	
	public Position positions[];

	protected Table() {
		this.positions = fillTable();
	}
	
	
	private Position[] fillTable() {
		Position allPositions[] = new Position[64];
		int pos = 0;
		for (int i = 1; i<9;i++) {
			for (int j = 1; j<9; j++) {
				allPositions[pos] = new Position(i,j);
				pos++;
			}
		}
		return allPositions;
	}
}