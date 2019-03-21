import java.util.Random;

public class Sonar {

	//private int portéeSonar;
	private double distanceDétection;
	private Terrain ocean;
	private int précision;

	public Sonar(int portée, Terrain ocean) {
		//portéeSonar = portée;
		distanceDétection = Math.sqrt(Math.pow(portée - 0, 2) + Math.pow(portée - 0, 2));
		this.ocean = ocean;
		précision = 95;
	}

	public Bateau[] rapportDétection(int x, int y) {

		
		//COORDONNEE DES BATEAUX DETECTES PEUVENT ETRES FAUSSEES, CLONER UN BATEAU ET LUI DONNER DE FAUSSES COORDOONNEES ??
		Bateau[] rapportTronqué = new Bateau[ocean.getF().getArmada().length];
		
		for (int i = 0; i < ocean.getF().getArmada().length; i++) {
			double distanceEntreBateau = Math.sqrt(Math.pow(ocean.getF().getArmada()[i].getX() - x, 2)
					+ Math.pow(ocean.getF().getArmada()[i].getY() - y, 2));
			if (this.distanceDétection > distanceEntreBateau && distanceEntreBateau != 0 /*&& ocean.getF().getArmada()[i].isVivant()*/) {
				rapportTronqué[i] = ocean.getF().getArmada()[i];
			}
		}
		for (int i = 0; i < rapportTronqué.length; i++){
			if (randomGenerator(0,100) > précision)
				rapportTronqué[i] = null;
		}		
		return rapportTronqué;
	}

	public double getDistanceDétection() {
		return distanceDétection;
	}

	public int randomGenerator(int Min, int Max) {

		Random r = new Random();
		int Result = r.nextInt(Max - Min) + Min;
		return Result;
	}
}
