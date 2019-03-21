
public class Partie {

	int nombreDePas;

	public Partie(int nombreUtil) {

		nombreDePas = nombreUtil;
	}

	public Partie() {

		this(200);

	}

	public int getNombreDePas() {
		return nombreDePas;
	}

	public static void pause() {
		try {
			Thread.sleep(200);
		} catch (Exception e) {
		}
	}

}
