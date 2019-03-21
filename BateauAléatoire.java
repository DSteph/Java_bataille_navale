import géométrie.Direction;

public abstract class BateauAléatoire extends Bateau {

	public BateauAléatoire(int x, int y, Sonar s) {

		super(x, y, s);
		setCap(Direction.EST);
	}

	public BateauAléatoire(int x, int y, Direction cap, Sonar s) {

		super(x, y, s);
		setCap(cap);
	}

	public void déplacer(int xMax, int yMax) {

		while (getX() + getCap().getDx() * getPM() < 0 || getX() + getCap().getDx() * getPM() >= xMax
				|| getY() + getCap().getDy() * getPM() < 0 || getY() + getCap().getDy() * getPM() >= yMax) {
			setCap(getCap().inverser());
			setCap(getCap().dériver(1));
		}
		placer(getX() + getCap().getDx() * getPM(), getY() + getCap().getDy() * getPM());
	}
}