package Utils;

public enum PieceType {
	PAWN,
	KING,
	QUEEN,
	KNIGHT,
	ROOK,
	BISHOP;
	
	public static PieceType typeFromInt(int i) {
		if (i==-1) {
			return null;
		}
		return PieceType.values()[i];
	}
}










//WHITE_PAWN,
//WHITE_KING,
//WHITE_QUEEN,
//WHITE_KNIGHT,
//WHITE_ROOK,
//WHITE_BISHOP,
//BLACK_PAWN,
//BLACK_KING,
//BLACK_QUEEN,
//BLACK_KNIGHT,
//BLACK_ROOK,
//BLACK_BISHOP;
