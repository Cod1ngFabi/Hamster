import java.util.Arrays;
import java.util.Random;

public class Field {

	private String[][] field;

	public Field() {
		this.field = new String[10][10];
	}

	public String[][] getField() {
		return field;
	}

	public void setField(String[][] field) {
		this.field = field;
	}

	public String toString() {
		return "Field [field=" + Arrays.deepToString(field) + "]";
	}

	public String[][] createRandomField(String[][] field) {
		Random rand = new Random();
		int count = 0;
		boolean loopCondition = true;

		// Erste Zeile als Mauer von oben
		for (int i = 0; i < field.length; i++) {
			field[0][i] = "#";
		}

		// Spielfeld innerhalb erstmal mit Leerzeichen füllen
		for (int i = 1; i < field.length; i++) {
			for (int x = 0; x < field.length; x++) {
				field[i][x] = " ";
			}
		}

		// Spielfeld nun mit jeweils 3 Hindernissen pro Zeile füllen
		for (int i = 2; i < field.length; i++) {
			count = 0;
			for (int x = 0; x < field.length; x++) {
				if (count < 3) {
					int obstacle = rand.nextInt(10);
					field[i][obstacle] = "#";
					count++;
				}
			}
		}

		// Spielfeld nun mit jeweils 1 Korn pro Zeile füllen
		// Die 2 Zeile ist frei und dient als StartZeile des Hamsters
		for (int i = 2; i < field.length; i++) {
			loopCondition = true;

			while (loopCondition) {
				int corn = rand.nextInt(10);
				if (field[i][corn].equals(" ")) {
					field[i][corn] = "*";
					loopCondition = false;
				}
			}
		}
		// Letzte Zeile als Mauer von unten
		for (int i = 0; i < field.length; i++) {
			field[9][i] = "#";
		}
		
		return field;
	}

	public void printField(String[][] field) {
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				System.out.print(field[i][j]);
			}
			System.out.println();
		}
	}
	

}
