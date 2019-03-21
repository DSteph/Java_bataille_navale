import géométrie.Direction;

public abstract class BateauBoustrophédon extends Bateau {

	private boolean Descend;

	public BateauBoustrophédon(int x, int y, Sonar s) {

		super(x, y, s);
		setCap(Direction.EST);
	}

	public BateauBoustrophédon(int x, int y, Direction cap, Sonar s) {

		super(x, y, s);
		setCap(cap);
	}

	public void déplacer(int xMax, int yMax) {

		if (Descend && getCap() == Direction.EST) {
			if (getX() == xMax - 1 && getY() == yMax - 1) {
				Descend = false;
				setCap(getCap().inverser());
				placer(getX() + getCap().getDx() * getPM(), getY() + getCap().getDy() * getPM());
			} else if (getX() == xMax - 1) {

				setY(getY() + 1);
				setCap(getCap().inverser());
			} else
				placer(getX() + getCap().getDx() * getPM(), getY() + getCap().getDy() * getPM());
		} else if (Descend && getCap() == Direction.OUEST) {
			if (getX() == 0 && getY() == yMax - 1) {
				Descend = false;
				setCap(getCap().inverser());
				placer(getX() + getCap().getDx() * getPM(), getY() + getCap().getDy() * getPM());
			} else if (getX() == 0) {
				setY(getY() + 1);
				setCap(getCap().inverser());
			} else
				placer(getX() + getCap().getDx() * getPM(), getY() + getCap().getDy() * getPM());
		} else if (!Descend && getCap() == Direction.EST) {
			if (getX() == xMax - 1 && getY() == 0) {
				Descend = true;
				setCap(getCap().inverser());
				placer(getX() + getCap().getDx() * getPM(), getY() + getCap().getDy() * getPM());
			} else if (getX() == xMax - 1) {
				setY(getY() - 1);
				setCap(getCap().inverser());
			} else
				placer(getX() + getCap().getDx() * getPM(), getY() + getCap().getDy() * getPM());
		} else if (!Descend && getCap() == Direction.OUEST) {
			if (getX() == 0 && getY() == 0) {
				Descend = true;
				setCap(getCap().inverser());
				placer(getX() + getCap().getDx() * getPM(), getY() + getCap().getDy() * getPM());
			} else if (getX() == 0) {
				setY(getY() - 1);
				setCap(getCap().inverser());
			} else
				placer(getX() + getCap().getDx() * getPM(), getY() + getCap().getDy() * getPM());
		}
	}

}
