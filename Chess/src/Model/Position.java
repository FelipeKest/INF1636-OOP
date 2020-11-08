package Model;

final class Position {
	
	public Coordinate coordinate;
	public Color color;
	protected Piece occupiedBy;
	
	protected Position(int x, int y) {
		this.coordinate = new Coordinate(x,y);
		this.color = this.getColorByCoordinate(this.coordinate);
	}
	
	protected Position(int x, int y, Piece p) {
		this.coordinate = new Coordinate(x,y);
		this.color = this.getColorByCoordinate(this.coordinate);
		this.occupiedBy = p;
	}
	
	private Color getColorByCoordinate(Coordinate c) {
		if ((c.x+c.y)%2==0) {
			return Color.PRETO;
		} else {
			return Color.BRANCO;
		}
	}
	
	protected static boolean checkEqualCoordinate(Position p1, Position p2) {
		return p1.coordinate.x == p2.coordinate.x && p1.coordinate.y == p2.coordinate.y;
	}
}
