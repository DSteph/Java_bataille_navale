
public class BateauAttaquant extends Bateau implements Armement {
	private int port�eTir;
	private int d�gats;
	private Bateau cible;

	public BateauAttaquant(int x, int y, Sonar s) {
		super(x, y, s);
		cible = null;
		d�gats = 1;
		this.setSymbole('A');
	}

	public BateauAttaquant(int x, int y, Sonar s, int d�gats) {
		super(x, y, s);
		cible = null;
		this.d�gats = d�gats;
		this.setSymbole('A');
	}

	public void chercheCible(Bateau[] rapport) {

		this.getSonar().rapportD�tection(getX(), getY());

		double distance = this.getSonar().getDistanceD�tection();
		double distance2 = 0;

		cible = null;

		for (int i = 0; i < rapport.length; i++) {
			if (rapport[i] != null)
				distance2 = rapport[i].distance(this);

			if (rapport[i] != this && distance > distance2 && distance2 != 0) {
				cible = rapport[i];
				distance = distance2;
			}
		}
	}

	public void traque(Bateau cible) {

		// Cas d'�galit� d'une des coordonn�es
		if (this.getX() == cible.getX()) {
			if (this.getY() < cible.getY())
				setY(getY() + 1);
			if (this.getY() > cible.getY())
				setY(getY() - 1);
		}

		if (this.getY() == cible.getY()) {
			if (this.getX() < cible.getX())
				this.setX(getX() + 1);
			if (this.getX() > cible.getX())
				setX(getX() - 1);

		}

		// Les 2 coordonn�es sont diff�rentes
		if (this.getX() > cible.getX() && this.getY() > cible.getY()) { // coin
																		// gauche
			this.setX(getX() - 1);
			this.setY(getY() - 1);
			;
		}
		if (this.getX() < cible.getX() && this.getY() > cible.getY()) {
			this.setX(getX() + 1);
			this.setY(getY() - 1);
		}
		if (this.getX() > cible.getX() && this.getY() < cible.getY()) {
			setX(getX() - 1);
			this.setY(getY() + 1);
			;
		}
		if (this.getX() < cible.getX() && this.getY() < cible.getY()) {
			this.setX(getX() + 1);
			;
			this.setY(getY() + 1);
			;
		}

	}

	@Override
	public void d�placer(int xMax, int yMax) {

		Bateau[] rapportTemporaire = this.getSonar().rapportD�tection(getX(), getY());
		this.chercheCible(rapportTemporaire);
		if (cible != null)
			traque(cible);
		else {
			while (getX() + getCap().getDx() * getPM() < 0 || getX() + getCap().getDx() * getPM() >= xMax
					|| getY() + getCap().getDy() * getPM() < 0 || getY() + getCap().getDy() * getPM() >= yMax)
				setCap(getCap().d�river(1));

			placer(getX() + getCap().getDx() * getPM(), getY() + getCap().getDy() * getPM());
		}
	}

	@Override
	public void tirer(Terrain t, Bateau cible) {
		if (this.port�eTir >= this.distance(this.cible)) {
			t.cibleTouch�esParBateau(cible.getX(), cible.getY(), t, this);
		} else
			;

	}

	public int getD�gats() {
		return d�gats;
	}

	public void actionSurCible(Terrain t, Bateau cible) {

		tirer(t, cible);

	}
}
