package unit_11_flyweight;

class Gazillion {
	private int row;

	public Gazillion(int row) {
		this.row = row;
		System.out.println("ctor: " + this.row);
	}

	void report(int col) {
		System.out.print(" " + row + col);
	}
}

class Flyweight {
	private Gazillion[] pool;

	public Flyweight(int maxRows) {
		pool = new Gazillion[maxRows];
	}

	public Gazillion getFlyweight(int row) {
		if (pool[row] == null) {
			pool[row] = new Gazillion(row);
		}
		
		return pool[row];
	}
}

public class FlyweightExample {
	public static final int ROWS = 6, COLS = 10;

	public static void main(String[] args) {
		Flyweight flyWeight = new Flyweight(ROWS);
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				flyWeight.getFlyweight(i).report(j);
			}
			
			System.out.println();
		}
	}
}