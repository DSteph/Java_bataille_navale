
public class Terrain {

	private char[][] tabTerrain;
	private final int XMAX;
	private final int YMAX;
	private Flotte F;

	public Terrain(int taille, int nbBateau) {

		assert (taille != 0);
		tabTerrain = new char[taille][taille/3];
		XMAX = taille;
		YMAX = taille/3;
		F = new Flotte(nbBateau, this);

	}

	public Terrain() {

		tabTerrain = new char[25][10];
		XMAX = 25;
		YMAX = 10;
	}

	public int getXMAX() {

		return XMAX;
	}
	public int getYMAX() {

		return YMAX;
	}

	public char getCase(int ligne, int colonne) {

		assert (ligne >= 0 && colonne >= 0);

		return tabTerrain[colonne][ligne];
	}

	public void setCase(int ligne, int colonne, char obj) {

		assert (ligne >= 0 && colonne >= 0);

		tabTerrain[colonne][ligne] = obj;
	}

	public void dessiner() {

		for (int i = 0; i < YMAX; ++i)
			for (int j = 0; j < XMAX; ++j)
				tabTerrain[j][i] = ' ';
		
		F.dessiner(this);
	}
	
	public Flotte getF() {
		return F;
	}

	public char[][] getTerrain(){
		
		return tabTerrain;
	}
	
	public void placer(){
		
		F.placer(XMAX, YMAX);
	}

	public String toString() {

		String S = "|";

		for (int i = 1; i <= XMAX; ++i)
			S += '=';

		S += '|' + System.getProperty("line.separator");

		for (int j = 0; j < YMAX; ++j) {
			S += '|';
			for (int i = 0; i < XMAX; ++i)
				S += tabTerrain[i][j];

			S += '|' + System.getProperty("line.separator");
		}

		S += '|';
		for (int i = 1; i <= XMAX; ++i)
			S += '=';

		S += '|' + System.getProperty("line.separator");

		return S;
	}
	
	public void cibleTouchéesParBateau( int x , int y,Terrain t, BateauAttaquant A) {
		for (int i = 0 ; i < t.getF().getArmada().length;i++) {
			t.getF().getArmada()[i].setPV(t.getF().getArmada()[i].getPV() - A.getDégats());
		}
	}
	
}
