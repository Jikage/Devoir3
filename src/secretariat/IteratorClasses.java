package secretariat;

import java.util.Iterator;

public class IteratorClasses implements Iterator<Inscription> {
	
	private Inscription inscription;
	
	public IteratorClasses(Inscription inscription) {
		// TODO Auto-generated constructor stub
		this.inscription = inscription;
	}

	@Override
	public boolean hasNext() {
		if(inscription.getProchainCours() == null)
			return false;
		else
			return true;
	}
	

	@Override
	public Inscription next() {
		if(hasNext())
			return inscription.getProchainCours();
		else
			return null;
	
	}

}
