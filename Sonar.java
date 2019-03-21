import java.util.Random;

public class Sonar {

	//private int port�eSonar;
	private double distanceD�tection;
	private Terrain ocean;
	private int pr�cision;

	public Sonar(int port�e, Terrain ocean) {
		//port�eSonar = port�e;
		distanceD�tection = Math.sqrt(Math.pow(port�e - 0, 2) + Math.pow(port�e - 0, 2));
		this.ocean = ocean;
		pr�cision = 95;
	}

	public Bateau[] rapportD�tection(int x, int y) {

		
		//COORDONNEE DES BATEAUX DETECTES PEUVENT ETRES FAUSSEES, CLONER UN BATEAU ET LUI DONNER DE FAUSSES COORDOONNEES ??
		Bateau[] rapportTronqu� = new Bateau[ocean.getF().getArmada().length];
		
		for (int i = 0; i < ocean.getF().getArmada().length; i++) {
			double distanceEntreBateau = Math.sqrt(Math.pow(ocean.getF().getArmada()[i].getX() - x, 2)
					+ Math.pow(ocean.getF().getArmada()[i].getY() - y, 2));
			if (this.distanceD�tection > distanceEntreBateau && distanceEntreBateau != 0 /*&& ocean.getF().getArmada()[i].isVivant()*/) {
				rapportTronqu�[i] = ocean.getF().getArmada()[i];
			}
		}
		for (int i = 0; i < rapportTronqu�.length; i++){
			if (randomGenerator(0,100) > pr�cision)
				rapportTronqu�[i] = null;
		}		
		return rapportTronqu�;
	}

	public double getDistanceD�tection() {
		return distanceD�tection;
	}

	public int randomGenerator(int Min, int Max) {

		Random r = new Random();
		int Result = r.nextInt(Max - Min) + Min;
		return Result;
	}
}
