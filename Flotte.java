import java.util.Random;

public class Flotte {

	private Bateau[] Armada;
	private int nbBateau;

	public Flotte() {

		Armada = new Bateau[10];
	}

	public Flotte(int nbBateau, Terrain t) {
		Sonar generateurSonar[] = new Sonar[nbBateau];

		this.nbBateau = nbBateau;
		Armada = new Bateau[nbBateau];

		for (int i = 0; i < nbBateau; ++i) {
			generateurSonar[i] = new Sonar(3, t);
			if (i % 3 == 0)
				Armada[i] = new BateauHopital(randomGenerator(0, t.getXMAX() - 1), randomGenerator(0, t.getYMAX() - 1),
						generateurSonar[i]);
			else if (i % 3 == 1)
				Armada[i] = new BateauCible(randomGenerator(0, t.getXMAX() - 1), randomGenerator(0, t.getYMAX() - 1),
						generateurSonar[i]);
			else
				Armada[i] = new BateauAttaquant(randomGenerator(0, t.getXMAX() - 1),
						randomGenerator(0, t.getYMAX() - 1), generateurSonar[i]);
		}
	}

	public Bateau[] getArmada() {

		return Armada;
	}

	public int getNbBateau() {

		return nbBateau;
	}

	public void setNbBateau(int newVal) {

		nbBateau = newVal;
	}

	public int randomGenerator(int Min, int Max) {

		Random r = new Random();
		int Result = r.nextInt(Max - Min) + Min;
		return Result;
	}

	public void dessiner(Terrain t) {

		for (int i = 0; i < nbBateau; ++i)
			Armada[i].dessiner(t);
	}

	public void placer(int xMAX, int yMAX) {

		for (int i = 0; i < nbBateau; ++i) {
			if (Armada[i].isVivant())
				Armada[i].déplacer(xMAX, yMAX);
			else
				;
		}
	}

	public void conditionFlotte() {
		for (int i = 0; i < nbBateau; ++i) {
			if (!Armada[i].isVivant()) {
				Armada[i].setVivant(false);
				Armada[i].setSymbole('X');
			} else
				;
		}
	}
	public void actionFlotte(Terrain t){
		
		for (int i = 0; i < nbBateau; ++i) {
			if (!Armada[i].isVivant()) {
				Armada[i].action()}
			}
	}
}
