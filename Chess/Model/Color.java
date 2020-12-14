package Model;

public enum Color {
	BLACK, WHITE;
	
	public static Color typeFromInt(int i) {
		if (i==-1) {
			return null;
		}
		return Color.values()[i];
	}
}
