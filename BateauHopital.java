import géométrie.Direction;

public class BateauHopital extends BateauAléatoire implements KitSoin{
	
	
	public BateauHopital(int x, int y,Sonar s){
		
		super(x,y,s);
		setPM(1);
		setPV(3);
		setPVMAX(3);
		setSymbole('H');
	}
	
public BateauHopital(int x, int y, Direction cap, Sonar s){
		
		super(x,y,s);
		setPM(1);
		setPV(3);
		setPVMAX(3);
		setSymbole('H');
		setCap(cap);
	}

	@Override
	public void soigner(Flotte F) {
		
		
		for (int i = 0; i < F.getArmada().length; ++i)
			if(F.getArmada()[i].getX() == this.getX() && F.getArmada()[i].getY() == this.getY()) // METTRE UN SCANNER A 0;
				F.getArmada()[i].setPV(F.getArmada()[i].getPVMAX());
	}
	
	

}
