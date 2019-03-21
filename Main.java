
public class Main {

	public static void main(String[] args) {
		
		Partie P = new Partie();
		Terrain Ocean = new Terrain(50, 10);
		
		int i = 0;
		
		while (i != P.getNombreDePas()){

		Ocean.dessiner();
	    System.out.println(Ocean.toString());
	    P.pause();
	    Ocean.placer();
	    
	    //F.placer(Ocean);
		++i;
		}

	}

}
