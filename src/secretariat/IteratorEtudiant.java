package secretariat;

import java.util.Iterator;

public class IteratorEtudiant implements Iterator<Inscription>{

	private Inscription inscription;
	
	public IteratorEtudiant(Inscription inscription) {
		// TODO Auto-generated constructor stub
		this.inscription = inscription;
	}

	@Override
	public boolean hasNext() {
		if(inscription.getProchainEtudiant() == null)
			return false;
		else
			return true;
	}

	@Override
	public Inscription next() {
		if(hasNext())
			return inscription.getProchainEtudiant();
		else
			return null;
	}

}
