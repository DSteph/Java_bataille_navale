import g�om�trie.Direction;

public abstract class BateauAl�atoire extends Bateau {

	public BateauAl�atoire(int x, int y, Sonar s) {

		super(x, y, s);
		setCap(Direction.EST);
	}

	public BateauAl�atoire(int x, int y, Direction cap, Sonar s) {

		super(x, y, s);
		setCap(cap);
	}

	public void d�placer(int xMax, int yMax) {

		while (getX() + getCap().getDx() * getPM() < 0 || getX() + getCap().getDx() * getPM() >= xMax
				|| getY() + getCap().getDy() * getPM() < 0 || getY() + getCap().getDy() * getPM() >= yMax) {
			setCap(getCap().inverser());
			setCap(getCap().d�river(1));
		}
		placer(getX() + getCap().getDx() * getPM(), getY() + getCap().getDy() * getPM());
	}
}