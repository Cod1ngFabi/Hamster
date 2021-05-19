
public class Hamster {

	private String direction;
	private int eatenCorns;
	private int xAxis;
	private int yAxis;

	public int getxAxis() {
		return xAxis;
	}

	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}

	public int getyAxis() {
		return yAxis;
	}

	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}

	public Hamster() {
		this.direction = "v";
		this.eatenCorns = 0;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getEatenCorns() {
		return eatenCorns;
	}

	public void setEatenCorns(int eatenCorns) {
		this.eatenCorns = eatenCorns;
	}

	public String[][] setHamsterOnField(String[][] field) {
		field[1][0] = direction;
		setxAxis(1);
		setyAxis(0);

		return field;
	}

	public void printEatenCorns() {
		System.out.println("The hamster has eaten " + getEatenCorns() + " Corns.\n");
	}

	public void turnLeft(Field field) {

		switch (getDirection()) {
		case "<":
			setDirection("v");
			break;
		case "v":
			setDirection(">");
			break;
		case ">":
			setDirection("^");
			break;
		case "^":
			setDirection("<");
			break;
		default:
			System.out.println("There is an error!");
			break;
		}
		String[][] temp = field.getField();
		temp[getxAxis()][getyAxis()] = getDirection();
		field.setField(temp);
		field.printField(field.getField());
	}

	public void turnRight(Field field) {

		switch (getDirection()) {
		case "<":
			setDirection("^");
			break;
		case "v":
			setDirection("<");
			break;
		case ">":
			setDirection("v");
			break;
		case "^":
			setDirection(">");
			break;
		default:
			System.out.println("There is an error!");
			break;
		}
		String[][] temp = field.getField();
		temp[getxAxis()][getyAxis()] = getDirection();
		field.setField(temp);
		field.printField(field.getField());
	}

	public void goStraight(Field level) {
		String[][] field = level.getField();

		// nach rechts gehen
		if (checkRight(getyAxis())) {
			if (getDirection().equals(">") && !(field[getxAxis()][getyAxis() + 1].equals("#"))) {
				field[getxAxis()][getyAxis()] = " ";
				if (field[getxAxis()][getyAxis() + 1].equals("*")) {
					eatenCorns++;
				}
				field[getxAxis()][getyAxis() + 1] = getDirection();
				setyAxis(getyAxis() + 1);
			}
		}

		// nach links gehen
		if (checkLeft(getyAxis())) {
			if (getDirection().equals("<") && (!field[getxAxis()][getyAxis() - 1].equals("#"))) {
				field[getxAxis()][getyAxis()] = " ";
				if (field[getxAxis()][getyAxis() - 1].equals("*")) {
					eatenCorns++;
				}
				field[getxAxis()][getyAxis() - 1] = getDirection();
				setyAxis(getyAxis() - 1);
			}
		}

		// nach oben gehen
		if (getDirection().equals("^") && (!field[getxAxis() - 1][getyAxis()].equals("#"))) {
			field[getxAxis()][getyAxis()] = " ";
			if (field[getxAxis() - 1][getyAxis()].equals("*")) {
				eatenCorns++;
			}
			field[getxAxis() - 1][getyAxis()] = getDirection();
			setxAxis(getxAxis() - 1);
		}

		// nach unten gehen
		if (getDirection().equals("v") && (!field[getxAxis() + 1][getyAxis()].equals("#"))) {
			field[getxAxis()][getyAxis()] = " ";
			if (field[getxAxis() + 1][getyAxis()].equals("*")) {
				eatenCorns++;
			}
			field[getxAxis() + 1][getyAxis()] = getDirection();
			setxAxis(getxAxis() + 1);
		}

		level.setField(field);
		level.printField(level.getField());
	}

	public boolean checkLeft(int position) {
		int outsideLeft = position - 1;
		if (outsideLeft == -1) {
			return false;
		}
		return true;
	}

	public boolean checkRight(int position) {
		int outsideRight = position + 1;
		if (outsideRight == 10) {
			return false;
		}
		return true;
	}

}
