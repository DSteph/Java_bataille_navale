import géométrie.Direction;

public class BateauCible extends BateauBoustrophédon {

	public BateauCible(int x, int y,Sonar s) {

		super(x, y,s);
		setPM(1);
		setPV(2);
		setPVMAX(2);
		setSymbole('C');
	}

	public BateauCible(int x, int y, Direction cap, Sonar s) {

		super(x, y,s);
		setCap(cap);
		setPM(1);
		setPV(2);
		setPVMAX(2);
		setSymbole('C');
	}

	@Override
	public void actionSurCible(Terrain t, Bateau cible) {
		// TODO Auto-generated method stub
		
	}
}
