import géométrie.Direction;

public abstract class Bateau {

	private int identifiant;
	private int x, y;
	private int PVMAX;
	private int PV;
	private int PM;
	private Direction cap;
	private boolean vivant;
	private char symbole;
	private Sonar sonar;
	
	
	public Bateau(int x, int y,Sonar s){
		
		setX(x);
		setY(y);
		cap = Direction.EST;
		this.sonar = s;
		vivant = true;
	}
	public Bateau(int x, int y, Direction cap, Sonar s){
		
		setX(x);
		setY(y);
		this.cap = cap;
		this.sonar = s;
		vivant = true;
	}
	
	public double distance(Bateau b) {

        double distance = Math.sqrt(Math.pow(b.x - this.x, 2) + Math.pow(b.y - this.y, 2));
        return distance;
    }
	public Sonar getSonar() {
		return sonar;
	}
	
	public void setSonar(Sonar sonar) {
		this.sonar = sonar;
	}
	public boolean isVivant() {
		return vivant;
	}
	public void setVivant(boolean vivant) {
		this.vivant = vivant;
	}
	public char getSymbole() {
		return symbole;
	}
	public void setSymbole(char symbole) {
		this.symbole = symbole;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getPV() {
		return PV;
	}
	public void setPV(int pV) {
		PV = pV;
	}
	public Direction getCap() {
		return cap;
	}
	public void setCap(Direction cap) {
		this.cap = cap;
	}
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	public int getPVMAX() {
		return PVMAX;
	}
	public void setPVMAX(int pVMAX) {
		PVMAX = pVMAX;
	}
	public int getPM() {
		return PM;
	}
	public void setPM(int pM) {
		PM = pM;
	}
	public void placer(int x, int y){
		this.x = x;
		this.y = y;
	}
	public abstract void déplacer(int xMax, int yMax);
	public abstract void actionSurCible(Terrain t, Bateau cible);
	public void dessiner(Terrain t) {
		t.getTerrain()[x][y] = symbole;
	}	
	
}
